package game;


import tklibs.SpriteUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel {
    BufferedImage backgroundImage;
    int backgroundX;
    int backgroundY;
    BufferedImage playerImage;
    int playerX;
    int playerY;
    public GamePanel(){
//        this.paint(); //vẽ nội dung panel
          this.backgroundImage = SpriteUtils.loadImage("assets/images/background/0.png");//load ảnh trong bộ nhớ
          this.backgroundX = 0;
          this.backgroundY = 600 - this.backgroundImage.getHeight();
          this.playerImage = SpriteUtils.loadImage("assets/images/players/straight/0.png");
          this.playerX = 200;
          this.playerY = 400;
    }


    @Override
    public void paint(Graphics g) {
        //draw game is here
        g.drawImage(this.backgroundImage, this.backgroundX, this.backgroundY,null);
        g.drawImage(this.playerImage, this.playerX, this.playerY,null);
    }

    public void gameLoop() {
        long lastLoop = 0;
        long delay = 1000/60;
        while(true){
            long currentTime = System.currentTimeMillis();
            if(currentTime - lastLoop > delay){
                this.runAll();//logic
                this.renderAll();//render/hienthi
                lastLoop = currentTime;
            }
        }
    }

    public void runAll(){

        if(this.backgroundY < 0){
            this.backgroundY ++;
        }

//        if(this.playerY < 0){
//            GameWindow.isUpPress = false;
//        }

        if(GameWindow.isUpPress && this.playerY > 0){
            this.playerY-=5;

        }
//        if( this.playerX >=(384 - 48)){
//            GameWindow.isRightPress = false ;
//        }
//        if(this.playerX <= 0){
//            GameWindow.isLeftPress = false;
//        }


        if(GameWindow.isDownPress && this.playerY < (600 - 82)){
            this.playerY +=5;
        }

        if(GameWindow.isLeftPress && this.playerX >= 0){
            this.playerX -=5;
        }

        if(GameWindow.isRightPress && this.playerX <= (384 - 32)){
            this.playerX +=5;
        }
    }
    public void renderAll(){
        this.repaint();//goi lai ham paint
    }
}
