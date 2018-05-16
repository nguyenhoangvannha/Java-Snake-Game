/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crazy.snake.controller;

import crazy.snake.model.Snake;
import crazy.snake.view.GameScreen;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author naco
 */
public class DataHelper {
    public static Image snakeHead;
    public static Image loadIcon(){
        try {
            Image icon = ImageIO.read(new File("res/icon.jpg"));
            return icon;
        } catch (IOException ex) {
            System.out.println("Head not found");
            return null;
        }
    }
    public static void loadHead(){
        try {
            snakeHead = ImageIO.read(new File("res/head_down.png"));
        } catch (IOException ex) {
            System.out.println("Head not found");
        }
    }
    public static void loadHead(int direction){
        try {
            switch(direction){
                case Snake.DOWN:
                    snakeHead = ImageIO.read(new File("res/head_down.png"));
                    break;
                    case Snake.UP:
                    snakeHead = ImageIO.read(new File("res/head_up.png"));
                    break;
                    case Snake.LEFT:
                    snakeHead = ImageIO.read(new File("res/head_left.png"));
                    break;
                    case Snake.RIGHT:
                    snakeHead = ImageIO.read(new File("res/head_right.png"));
                    break;
            }
            
        } catch (IOException ex) {
            System.out.println("Head not found");
        }
    }
}
