package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.security.Key;

public class GameWindow extends JFrame {
    //thuộc tính
    public GamePanel gamePanel;

    public static boolean isUpPress;
    public static boolean isDownPress;
    public static boolean isRightPress;
    public static boolean isLeftPress;
    public static boolean isFirePress;

    public GameWindow(){
        this.setupWindow();
        this.createGamePanel();
        this.setupListner();
        this.setVisible(true); //cho cửa sổ window hiện hình
    }

    private void setupListner() {
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                //TODO: giữ phím
                if(e.getKeyCode() == KeyEvent.VK_W){
                    isUpPress = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_S){
                    isDownPress = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_A){
                    isLeftPress = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_D){
                    isRightPress = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_SPACE){
                    isFirePress = true;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                //TODO: nhả phím
                if(e.getKeyCode() == KeyEvent.VK_W){
                    isUpPress = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_S){
                    isDownPress = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_A){
                    isLeftPress = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_D){
                    isRightPress = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_SPACE){
                    isFirePress = false;
                }
            }
        });
    }

    private void createGamePanel() {
//        GamePanel panel = new GamePanel();//tạo khung
        this.gamePanel = new GamePanel();
        this.gamePanel.setPreferredSize(new Dimension(800,600));
        this.add(this.gamePanel);
        this.pack();// tự động window nở ra để phù hợp với panel bên trong va
        // muốn pack được thì phải có setPreferredSize
    }

    private void setupWindow() {
//        this.setSize(800,600);
        this.setTitle("Touhou");
        this.setResizable(false);//khong cho user thay doi kich thuoc cua so
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//khi nhan x se thoat het cua so
    }
}
