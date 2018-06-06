/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crazy.snake.model;

import crazy.snake.controller.DataHelper;
import crazy.snake.view.GameScreen;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Arrays;

/**
 *
 * @author naco
 */
public class Snake {
    String name;
    int length;
    int x[];
    int y[];
    int direction;
    Color color = Color.BLUE;
    public static final int LEFT = 1;
    public static final int RIGHT = -1;
    public static final int UP = 2;
    public static final int DOWN = -2;
    DataHelper dataHelper;
    public Snake(){
        direction = RIGHT;
        name = "Default";
        length = 1;
        x = new int[GameScreen.MAX_COL];
        y = new int[GameScreen.MAX_ROW];
        x[0] = 0;
        y[0] = 0;
        dataHelper = new DataHelper();
    }
    public void drawSnake(Graphics g){
        g.setColor(color);
        //g.fillOval(x[0] * 20 + 1, y[0] * 20 + 1, 19, 19);
        for(int i = 1; i < length; i++){
            //g.fillRect(x[i] * 20 + 1, y[i] * 20 + 1, 19, 19);
            g.fillOval(x[i] * 20 + 1, y[i] * 20 + 1, 19, 19);
        }
        //dataHelper.loadHead2(direction);
        //g.drawImage(DataHelper.snakeHead, x[0] * 20 + 1, y[0] * 20 + 1, null);
        g.fillOval(x[0] * 20 + 1, y[0] * 20 + 1, 17, 17);
    }
    public void update(int direction){
        for(int i = length - 1; i > 0; i--){
            x[i] = x[i-1];
            y[i] = y[i-1];
        }
        switch(direction){
            case UP:
                y[0]--;
                if(y[0] < 0) y[0] = GameScreen.MAX_ROW - 1;
                break;
            case DOWN:
                y[0]++;
                if(y[0] > (GameScreen.MAX_ROW - 1)) y[0] = 0;
                break;
            case LEFT:
                x[0]--;
                if(x[0] < 0) x[0] = GameScreen.MAX_COL - 1;
                break;
            case RIGHT:
                x[0]++;
                if(x[0] > (GameScreen.MAX_COL - 1)) x[0] = 0;
                break;
        }
        this.direction = direction;
    }
    public void update(int direction, int[][] deadSpace){
        for(int i = length - 1; i > 0; i--){
            try{
                //deadSpace[y[i]][x[i]] = GameScreen.LIVE;
            } catch(Exception e){
                
            }
            x[i] = x[i-1];
            y[i] = y[i-1];
            deadSpace[y[i]][x[i]] = GameScreen.DEAD;
        }
        deadSpace[y[0]][x[0]] = GameScreen.LIVE;
        switch(direction){
            case UP:
                y[0]--;
                if(y[0] < 0) y[0] = GameScreen.MAX_ROW - 1;
                break;
            case DOWN:
                y[0]++;
                if(y[0] > (GameScreen.MAX_ROW - 1)) y[0] = 0;
                break;
            case LEFT:
                x[0]--;
                if(x[0] < 0) x[0] = GameScreen.MAX_COL - 1;
                break;
            case RIGHT:
                x[0]++;
                if(x[0] > (GameScreen.MAX_COL - 1)) x[0] = 0;
                break;
        }

        this.direction = direction;
        System.out.println("DeadSpace:");
        for(int k = 0; k < GameScreen.MAX_ROW; k++){
            System.out.println(Arrays.toString(deadSpace[k]));
        }
        if(deadSpace[y[0]][x[0]] == GameScreen.DEAD) System.out.println("DEAD SOME THING");
        deadSpace[y[0]][x[0]] = GameScreen.DEAD;
    }

    public void onEat(){
        length++;
        x[length - 1] = 0;
        y[length - 1] = 0;
    }
    public void onEat(int direction){
        length++;
        switch(direction){
            case UP:
                x[length - 1] = x[length - 2] + 1;
                y[length - 1] = y[length - 2];
                break;
            case DOWN:
                x[length - 1] = x[length - 2] - 1;
                y[length - 1] = y[length - 2];
                break;
            case LEFT:
                x[length - 1] = x[length - 2];
                y[length - 1] = y[length - 2] + 1;
                break;
            case RIGHT:
                x[length - 1] = x[length - 2];
                y[length - 1] = y[length - 2] - 1;
                break;
        }
        
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int[] getX() {
        return x;
    }

    public void setX(int[] x) {
        this.x = x;
    }

    public int[] getY() {
        return y;
    }

    public void setY(int[] y) {
        this.y = y;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }
    
}
