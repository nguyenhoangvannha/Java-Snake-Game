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
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author naco
 */
public class CrazySnakeClient {

    public static String server = "localhost";
    public static int port = 3204;

    public String[] connect(Player player) throws IOException, UserNameAlreadyExistException {
        Socket s;
        s = new Socket(player.getServer(), player.getPort());
        System.out.println("Client connected to :" + s.getPort());
        try {
            InputStream is = s.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            OutputStream os = s.getOutputStream();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));

            player.setBr(br);
            player.setBw(bw);

            bw.write(CrazySnakeServer.MSG_CONNECT + "|" + player.getUserName());
            bw.newLine();
            bw.flush();
            String receivedMessage = br.readLine();
            player.setSocket(s);
            if (receivedMessage.contains(CrazySnakeServer.MSG_ERROR)) {
                throw new UserNameAlreadyExistException();
            } else {
                System.out.println("Received : " + receivedMessage);
                receivedMessage = receivedMessage.replace("[", "");
                receivedMessage = receivedMessage.replace("]", "");
                String[] players = receivedMessage.split(",");
                return players;
            }
            //bw.close();
        } catch (IOException ex) {
        }

        return null;
    }

    public void disConnect(Player player) {
        try {
            BufferedReader br = player.getBr();
            BufferedWriter bw = player.getBw();
            bw.write(CrazySnakeServer.MSG_DISCONNECT + "|" + player.getUserName());
            bw.newLine();
            bw.flush();
            String receivedMessage = br.readLine();
            if (receivedMessage.contains(CrazySnakeServer.MSG_ERROR)) {
                System.out.println(CrazySnakeServer.MSG_ERROR);
            } else {
                System.out.println("Received : " + receivedMessage);
            }
            //bw.close();
        } catch (Exception ex) {
        }
    }

    public int createNewRoom(Player player) {
        try {
            BufferedReader br = player.getBr();
            BufferedWriter bw = player.getBw();

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
            //bw.close();
            //br.close();
        } catch (IOException ex) {
            Logger.getLogger(CrazySnakeClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    public int joinRoom(Player player) {
        try {
            BufferedReader br = player.getBr();
            BufferedWriter bw = player.getBw();

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
            //bw.close();
            //br.close();
        } catch (IOException ex) {
            Logger.getLogger(CrazySnakeClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    public int removeRoom(Player player) {
        try {
            BufferedReader br = player.getBr();
            BufferedWriter bw = player.getBw();

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
            //bw.close();
            //br.close();
        } catch (IOException ex) {
            Logger.getLogger(CrazySnakeClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
}
