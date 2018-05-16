/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crazy.snake.view;

import crazy.snake.controller.DataHelper;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;

/**
 *
 * @author naco
 */
public class FrameScreen extends JFrame {

    public FrameScreen() {
        setTitle("Crazy snake");
        setIconImage(DataHelper.loadIcon());
        setSize(800, 550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        GameScreen gameScreen = new GameScreen();
        add(gameScreen);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e); //To change body of generated methods, choose Tools | Templates.
                gameScreen.onKetPressed(e);
            }
        });
    }
}
