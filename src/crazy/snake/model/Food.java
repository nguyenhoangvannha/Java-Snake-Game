/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crazy.snake.model;

import crazy.snake.view.GameScreen;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 *
 * @author naco
 */
public class Food {
    int x;
    int y;
    boolean ate;
    public Food(){
        x = 1;
        y = 1;
        ate = false;
    }
    public void drawFood(Graphics g){
        if(ate == true){
            Random random = new Random();
            x = random.nextInt(GameScreen.MAX_ROW);
            y = random.nextInt(GameScreen.MAX_COL);
            ate = false;
        }
        g.setColor(Color.yellow);
        g.fillRect(x * 20 + 1, y * 20 + 1, 19, 19);
    }
    public void drawFood(Graphics g, Snake snake){
        if(ate == true){
            Random random = new Random();
            x = random.nextInt(GameScreen.MAX_ROW);
            y = random.nextInt(GameScreen.MAX_COL);
            ate = false;
        }
        for(int i = 0; i < snake.length; i++){
                if(snake.getX()[i] == x && snake.getY()[i] == y){
                    drawFood(g, snake);
                    return;
                }
        }
        g.setColor(Color.yellow);
        g.fillRect(x * 20 + 1, y * 20 + 1, 19, 19);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isAte() {
        return ate;
    }

    public void setAte(boolean ate) {
        this.ate = ate;
    }
    
}
