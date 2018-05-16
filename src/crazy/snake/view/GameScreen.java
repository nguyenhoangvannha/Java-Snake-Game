/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crazy.snake.view;

import crazy.snake.model.Food;
import crazy.snake.model.Snake;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author naco
 */
public class GameScreen extends JPanel implements Runnable {
    
    public static final int MAX_COL = 25;
    public static final int MAX_ROW = 25;
    public static final int DEAD = -1;
    public static final int LIVE = 1;
    int currenDirection = Snake.RIGHT;
    int[][] bg = new int[MAX_ROW][MAX_COL];
    int[][] deadSpace = new int[MAX_ROW][MAX_COL];
    Snake snake;
    Food food;
    Thread thread;

    public GameScreen() {
        snake = new Snake();
        food = new Food();
        thread = new Thread(this);
        thread.start();
    }

    private void paintBG(Graphics g) {
        for (int i = 0; i < MAX_ROW; i++) {
            for (int j = 0; j < MAX_COL; j++) {
                if (bg[i][j] == 0) {
                    g.setColor(Color.GRAY);
                } else if (bg[i][j] == 1) {
                    g.setColor(Color.RED);
                } else if (bg[i][j] == 2) {
                    g.setColor(Color.YELLOW);
                }
                g.fillRect(20 * i + 1, 20 * j + 1, 19, 19);
                //g.fillRoundRect(20*i, 20*j, 20, 20, 5,5);
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        g.setColor(Color.GREEN);
        paintBG(g);
        food.drawFood(g);
        snake.drawSnake(g);
        //g.fillRect(count, 10, 100, 100);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(300);
                snake.update(currenDirection);
                repaint();
                if(snake.getX()[0] == food.getX() && snake.getY()[0] == food.getY()){
                    food.setAte(true);
                    snake.onEat(snake.getDirection());
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(GameScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void onKetPressed(KeyEvent e) {
        int direction = Snake.RIGHT;
        switch (e.getKeyCode()) {
            case KeyEvent.VK_DOWN:
                System.out.println("VK_DOWN");
                direction = Snake.DOWN;
                break;
            case KeyEvent.VK_UP:
                System.out.println("VK_UP");
                direction = Snake.UP;
                break;
            case KeyEvent.VK_LEFT:
                System.out.println("VK_LEFT");
                direction = Snake.LEFT;
                break;
            case KeyEvent.VK_RIGHT:
                System.out.println("VK_RIGHT");
                direction = Snake.RIGHT;
                break;
        }
        if(snake.getLength() > 1 && (currenDirection + direction == 0)){
            
        } else {
            currenDirection = direction;
        }
    }
}
