/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crazy.snake.model;

import java.util.ArrayList;

/**
 *
 * @author naco
 */
public class Room {
    int ID;
    String owner;
    ArrayList<String> players;
    boolean playing;

    public Room() {
        ID = -1;
        owner = null;
        players = new ArrayList<>();
        playing = false;
    }

    public Room(int ID, String owner, ArrayList<String> players, boolean playing) {
        this.ID = ID;
        this.owner = owner;
        this.players = players;
        this.playing = playing;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public ArrayList<String> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<String> players) {
        this.players = players;
    }

    public boolean isPlaying() {
        return playing;
    }

    public void setPlaying(boolean playing) {
        this.playing = playing;
    }
    
}
