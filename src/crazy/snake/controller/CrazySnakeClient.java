/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crazy.snake.controller;

import crazy.snake.exceptions.UserNameAlreadyExistException;
import crazy.snake.model.Player;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.Pair;

/**
 *
 * @author naco
 */
public class CrazySnakeClient {

    public static String server = "localhost";
    public static int port = 3204;

    private String[] getMemberArray(String strmembers) {
        strmembers = strmembers.replace("[", "");
        strmembers = strmembers.replace("]", "");
        String[] arrMembers = strmembers.split(",");
        for (String member : arrMembers) {
            member = member.trim();
        }
        return arrMembers;
    }

    private ArrayList<String> getMemberList(String strmembers) {
        strmembers = strmembers.replace("[", "");
        strmembers = strmembers.replace("]", "");
        String[] arrMembers = strmembers.split(",");
        ArrayList<String> members = new ArrayList<>();
        for (String member : arrMembers) {
            member = member.trim();
            members.add(member);
        }
        return members;
    }
    
    public String[] connect(Player player) throws IOException, UserNameAlreadyExistException {
        Socket s;
        s = new Socket(player.getServer(), player.getPort());
        System.out.println("Client connected to :" + s.getPort());
        try {
            InputStream is = s.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            OutputStream os = s.getOutputStream();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));

            player.setIs(is);
            player.setOs(os);

            bw.write(CrazySnakeServer.MSG_CONNECT + "|" + player.getUserName());
            bw.newLine();
            bw.flush();
            String receivedMessage = br.readLine();
            player.setSocket(s);
            if (receivedMessage.contains(CrazySnakeServer.MSG_ERROR)) {
                throw new UserNameAlreadyExistException();
            } else {
                System.out.println("Received : " + receivedMessage);
                String[] players = getMemberArray(receivedMessage);
                return players;
            }
        } catch (IOException ex) {
        }
        return null;
    }

    public String[] getPlayers(Player player) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(player.getIs()));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(player.getOs()));

            bw.write(CrazySnakeServer.MSG_GET_PLAYERS);
            bw.newLine();
            bw.flush();
            String receivedMessage = br.readLine();
            System.out.println("LIST" + receivedMessage);
            String[] players = getMemberArray(receivedMessage);
            return players;
        } catch (IOException ex) {
        }
        return null;
    }

    public void disConnect(Player player) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(player.getIs()));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(player.getOs()));
            bw.write(CrazySnakeServer.MSG_DISCONNECT + "|" + player.getUserName());
            bw.newLine();
            bw.flush();
            String receivedMessage = br.readLine();
            if (receivedMessage.contains(CrazySnakeServer.MSG_ERROR)) {
                System.out.println(CrazySnakeServer.MSG_ERROR);
            } else {
                System.out.println("Received : " + receivedMessage);
            }
            player.getIs().close();
            player.getOs().close();
        } catch (Exception ex) {
        }
    }

    public boolean leaveRoom(int ID, Player player){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(player.getIs()));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(player.getOs()));
            bw.write(CrazySnakeServer.MSG_LEAVE_ROOM + "|" + ID + "|" + player.getUserName());
            bw.newLine();
            bw.flush();
        } catch (Exception ex) {
            return false;
        }
        return true;
    }
    
    public int createNewRoom(Player player) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(player.getIs()));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(player.getOs()));

            String receivedMessage;
            System.out.println("Talking to Server");
            bw.write(CrazySnakeServer.MSG_GENERATE_ROOM_ID + "|" + player.getUserName());
            bw.newLine();
            bw.flush();
            receivedMessage = br.readLine();
            System.out.println("Received : " + receivedMessage);
            try {
                int result = Integer.parseInt(receivedMessage);
                return result;
            } catch (Exception e) {
            }
        } catch (IOException ex) {
            Logger.getLogger(CrazySnakeClient.class.getName()).log(Level.SEVERE, null, ex);
        }

        return -1;
    }

    

    public Pair<String, ArrayList<String>> getRoomInfo(Player player) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(player.getIs()));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(player.getOs()));
            System.out.println("Talking to Server");
            bw.write(CrazySnakeServer.MSG_GET_ROOM_INFO + "|" + player.getRoomID());
            bw.newLine();
            bw.flush();
            String roomAdmin = br.readLine();
            System.out.println("RoomAdmin : " + roomAdmin);
            String strmembers = br.readLine();
            System.out.println("Members:" + strmembers);
            ArrayList<String> members = getMemberList(strmembers);
            Pair p = new Pair(roomAdmin, members);
            return p;
        } catch (IOException ex) {
            Logger.getLogger(CrazySnakeClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String joinRoom(Player player) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(player.getIs()));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(player.getOs()));

            String receivedMessage;
            System.out.println("Talking to Server");
            bw.write(CrazySnakeServer.MSG_JOIN_ROOM + "|" + player.getRoomID() + "|" + player.getUserName());
            bw.newLine();
            bw.flush();
            receivedMessage = br.readLine();
            return receivedMessage;
        } catch (IOException ex) {
            Logger.getLogger(CrazySnakeClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    public int removeRoom(Player player) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(player.getIs()));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(player.getOs()));

            String receivedMessage;
            System.out.println("Talking to Server");
            bw.write(CrazySnakeServer.MSG_GENERATE_ROOM_ID + "|" + player.getUserName());
            bw.newLine();
            bw.flush();
            receivedMessage = br.readLine();
            System.out.println("Received : " + receivedMessage);
            try {
                int result = Integer.parseInt(receivedMessage);
                return result;
            } catch (Exception e) {
            }
        } catch (IOException ex) {
            Logger.getLogger(CrazySnakeClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
}
