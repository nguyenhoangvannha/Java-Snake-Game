/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crazy.snake.view;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author naco
 */
public class DialogUtils {
    public static void showWarning(Component component, String title, String msg){
        JOptionPane.showMessageDialog(component, msg, title, JOptionPane.WARNING_MESSAGE);
    }
    public static void showMsg(Component component, String title, String msg){
        JOptionPane.showMessageDialog(component, msg, title, JOptionPane.INFORMATION_MESSAGE);
    }
}
