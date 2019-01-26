package game;




import game.food.Food_bullet;
import game.food.Food_fire;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {


    public GamePanel() {
        GameObject.recycle(BackGround.class);
        GameObject.recycle(Pacman.class);
        GameObject.recycle(Food_bullet.class);
        GameObject.recycle(Food_fire.class);
    }

    public void gameLoop() {
        long lastLoop = 0;
        long delay = 1000 / 60;
        while (true) {
            long currentTime = System.currentTimeMillis();
            if (currentTime - lastLoop > delay) {
                this.runAll();//logic
                this.renderAll();//render/hienthi
                lastLoop = currentTime;
            }
        }
    }

    public void runAll() {
        GameObject.runAll();
    }

    public void renderAll() {
        this.repaint();//goi lai ham paint
    }

    @Override
    public void paint(Graphics g) {
        GameObject.renderAll(g);
    }
}
