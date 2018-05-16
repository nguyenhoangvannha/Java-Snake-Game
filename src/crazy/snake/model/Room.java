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
    Player owner;
    ArrayList<Player> players;
    boolean playing;

    public Room() {
        ID = -1;
        owner = null;
        players = new ArrayList<>();
        playing = false;
    }

    public Room(int ID, Player owner, ArrayList<Player> players, boolean playing) {
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

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public boolean isPlaying() {
        return playing;
    }

    public void setPlaying(boolean playing) {
        this.playing = playing;
    }
    
}
