/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crazy.snake.controller;

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

    public void connect(Player player) throws IOException {
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
            System.out.println("Received : " + receivedMessage);
            //bw.close();
        } catch (IOException ex) {
            Logger.getLogger(CrazySnakeClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        player.setSocket(s);
    }

    public int createNewRoom(Player player) {
        //Socket s = player.getSocket();
        try {
            //InputStream is = s.getInputStream();
            //BufferedReader br = new BufferedReader(new InputStreamReader(is));
            BufferedReader br = player.getBr();

//            OutputStream os = s.getOutputStream();
//            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
              BufferedWriter bw = player.getBw();

            String receivedMessage;
            System.out.println("Talking to Server");
            bw.write(CrazySnakeServer.MSG_GENERATE_ROOM_ID + "|" + player.getUserName());
            bw.newLine();
            bw.flush();
            receivedMessage = br.readLine();
            System.out.println("Received : " + receivedMessage);
            try{
                int result = Integer.parseInt(receivedMessage);
                return result;
            } catch(Exception e){
            }
            //bw.close();
            //br.close();
        } catch (IOException ex) {
            Logger.getLogger(CrazySnakeClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) {
//        // TODO code application logic here
//        Socket s;
//        try {
//            s = new Socket("localhost", 3204);
//            System.out.println(s.getPort());
//            InputStream is = s.getInputStream();
//            BufferedReader br = new BufferedReader(new InputStreamReader(is));
//
//            OutputStream os = s.getOutputStream();
//            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
//
//            String sentMessage = "";
//            String receivedMessage;
//
//            System.out.println("Talking to Server");
//
//            do {
//                DataInputStream din = new DataInputStream(System.in);
//                sentMessage = din.readLine();
//                bw.write(sentMessage);
//                bw.newLine();
//                bw.flush();
//
//                if (sentMessage.equalsIgnoreCase("quit")) {
//                    break;
//                } else {
//                    receivedMessage = br.readLine();
//                    System.out.println("Received : " + receivedMessage);
//                }
//
//            } while (true);
//
//            bw.close();
//            br.close();
//        } catch (IOException ex) {
//            Logger.getLogger(CrazySnakeClient.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
}
