/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crazy.snake.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author naco
 */
public class CrazySnakeServer {

    static int clientCount = 0;
    static HashMap<Integer, ArrayList<String>> rooms = new HashMap<>();
    static HashMap<Integer, String> roomsAdmin = new HashMap<>();
    static ArrayList<String> players = new ArrayList<String>();
    public static final String MSG_GENERATE_ROOM_ID = "MSG_GENERATE_ROOM_ID";
    public static final String QUIT = "QUIT";
    public static final String MSG_CONNECT = "MSG_CONNECT";

    public CrazySnakeServer() {
    }

    static int createNewRoomID() {
        int result = -1;
        if (rooms.size() > 9999) {

        } else {
            Random random = new Random();
            do {
                result = random.nextInt(10000);
            } while (rooms.containsKey(result));
        }
        return result;
    }

    static String getOnlinePlayers() {
        StringBuilder sb = new StringBuilder("");
        Iterator it = rooms.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry m = (Map.Entry) it.next();
            ArrayList<String> members = (ArrayList<String>) m.getValue();
            for (String member : members) {
                sb.append(member + "\n");
            }
        }
        return sb.toString();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(3204);
            do {
                System.out.println("Waiting for client");
                Socket s = ss.accept();
                clientCount++;
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(clientCount + " | Client connected " + s.getPort());
                        InputStream is;
                        try {
                            is = s.getInputStream();
                            BufferedReader br = new BufferedReader(new InputStreamReader(is));

                            OutputStream os = s.getOutputStream();
                            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));

                            String receivedMessage;

                            do {
                                receivedMessage = br.readLine();
                                String userName = "";
                                try {
                                    if (receivedMessage != null) {
                                        System.out.println("Received : " + receivedMessage);
                                        if (receivedMessage.contains(MSG_CONNECT)) {
                                            userName = receivedMessage.substring(receivedMessage.indexOf("|") + 1);
                                            receivedMessage = MSG_CONNECT;
                                        }
                                        if (receivedMessage.contains(MSG_GENERATE_ROOM_ID)) {
                                            userName = receivedMessage.substring(receivedMessage.indexOf("|") + 1);
                                            receivedMessage = MSG_GENERATE_ROOM_ID;
                                        }
                                    }
                                } catch (Exception eb) {

                                }
                                if (receivedMessage != null) {
                                    switch (receivedMessage) {
                                        case MSG_CONNECT:
                                            players.add(userName);
                                            System.out.println("Connected player: " + players.toString());
                                            bw.write(players.toString());
                                            bw.newLine();
                                            bw.flush();
                                            break;
                                        case MSG_GENERATE_ROOM_ID:
                                            int newRoomID = createNewRoomID();
                                            bw.write(newRoomID + "");
                                            bw.newLine();
                                            bw.flush();
                                            ArrayList<String> members = new ArrayList<>();
                                            members.add(userName);
                                            rooms.put(newRoomID, members);
                                            roomsAdmin.put(newRoomID, userName);
                                            break;
                                        case QUIT:
                                            System.out.println("Client has left !");
                                            bw.close();
                                            br.close();
                                            return;
                                    }
                                }
                            } while (true);
                        } catch (IOException ex) {
                            Logger.getLogger(CrazySnakeServer.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
                thread.start();
            } while (true);
        } catch (IOException ex) {
            System.out.println("Eror: " + ex.toString());
        }
    }

}
