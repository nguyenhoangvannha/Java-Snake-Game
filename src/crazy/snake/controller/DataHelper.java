/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crazy.snake.controller;

import crazy.snake.model.Snake;
import crazy.snake.view.GameScreen;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 *
 * @author naco
 */
public class DataHelper extends JFrame{

    public static Image snakeHead;

    public static Image loadIcon() {
        try {
            Image icon = ImageIO.read(new File("res/icon.jpg"));
            return icon;
        } catch (IOException ex) {
            System.out.println("Head not found");
            return null;
        }
    }

    public void loadHead2(int direction) {
        URL url = null;
        try {
            switch (direction) {
                case Snake.DOWN:
                    url = getClass().getResource("../res/head_down.jpg");
                    break;
                case Snake.UP:
                    url = getClass().getResource("../res/head_up.jpg");
                    break;
                case Snake.LEFT:
                    url = getClass().getResource("../res/head_left.jpg");
                    break;
                case Snake.RIGHT:
                    url = getClass().getResource("../res/head_right.jpg");
                    break;
            }
            Toolkit kit = Toolkit.getDefaultToolkit();
            snakeHead = kit.createImage(url);
            System.out.println("Ohn o " + url.toString());
        } catch (Exception ex) {
            System.out.println("Head not found");
        }
    }
    public static void loadHead(int direction) {
        URL url = null;
        try {
            switch (direction) {
                case Snake.DOWN:
                    url = ClassLoader.getSystemResource("./crazy/snake/res/head_down.jpg");
                    break;
                case Snake.UP:
                    url = ClassLoader.getSystemResource("./crazy/snake/res/head_up.jpg");
                    break;
                case Snake.LEFT:
                    url = ClassLoader.getSystemResource("./crazy/snake/res/head_left.jpg");
                    break;
                case Snake.RIGHT:
                    url = ClassLoader.getSystemResource("./crazy/snake/res/head_right.jpg");
                    break;
            }
            
            Toolkit kit = Toolkit.getDefaultToolkit();
            snakeHead = kit.createImage(url);
            System.out.println(url.toString());
        } catch (Exception ex) {
            System.out.println("Head not found");
        }
//        try {
//            switch(direction){
//                case Snake.DOWN:
//                    snakeHead = ImageIO.read(new File("res/head_down.png"));
//                    break;
//                    case Snake.UP:
//                    snakeHead = ImageIO.read(new File("res/head_up.png"));
//                    break;
//                    case Snake.LEFT:
//                    snakeHead = ImageIO.read(new File("res/head_left.png"));
//                    break;
//                    case Snake.RIGHT:
//                    snakeHead = ImageIO.read(new File("res/head_right.png"));
//                    break;
//            }
//        } catch (IOException ex) {
//            System.out.println("Head not found");
//        }
    }
}
