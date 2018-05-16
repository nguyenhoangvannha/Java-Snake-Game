/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crazy.snake.model;

import crazy.snake.controller.CrazySnakeClient;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author naco
 */
public class Player {
    String userName;
    String server;
    int port;
    Socket socket;
    InputStream is;
    OutputStream os;
    BufferedWriter bw;
    BufferedReader br;
    int roomID;
    CrazySnakeClient crazySnakeClient;

    public Player() {
        userName = "nhvn";
        server = "localhost";
        port = 3204;
        socket = null;
    }

    public Player(String userName, String server, int port, Socket socket) {
        this.userName = userName;
        this.server = server;
        this.port = port;
        this.socket = socket;
    }

    public InputStream getIs() {
        return is;
    }

    public void setIs(InputStream is) {
        this.is = is;
    }

    public OutputStream getOs() {
        return os;
    }

    public void setOs(OutputStream os) {
        this.os = os;
    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public CrazySnakeClient getCrazySnakeClient() {
        return crazySnakeClient;
    }

    public void setCrazySnakeClient(CrazySnakeClient crazySnakeClient) {
        this.crazySnakeClient = crazySnakeClient;
    }

    public BufferedWriter getBw() {
        return bw;
    }

    public void setBw(BufferedWriter bw) {
        this.bw = bw;
    }

    public BufferedReader getBr() {
        return br;
    }

    public void setBr(BufferedReader br) {
        this.br = br;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
    
}
