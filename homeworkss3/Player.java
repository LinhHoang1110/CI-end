package game;

import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player {
    BufferedImage image;
//    float x;
//    float y;
    Vector2D position;

    public Player(){
        this.image = SpriteUtils.loadImage("assets/images/players/straight/0.png");
        this.position = new Vector2D(200,400);
    }
    public void render(Graphics g){
        g.drawImage(this.image, (int)this.position.x, (int)this.position.y, null);
    }

    public void run(){
        this.move();
        this.limitPosition();
        this.fire();
    }

    private void limitPosition() {
        if(this.position.y < 0){
            this.position.y =0;
        }
        if(this.position.y >600- this.image.getHeight())
        {
            this.position.y =600-this.image.getHeight();
        }
        if(this.position.x <0)
        {
            this.position.x =0;
        }
        if(this.position.x > 384- this.image.getWidth())
        {
            this.position.x = 384 - this.image.getWidth();
        }
    }
    int count;//TODO: continue editing
    private void fire() {
        count++;
        if(count > 20){
            if (GameWindow.isFirePress) {
                PlayerBullet bullet = new PlayerBullet();
//                bullet.position.x = this.position.x;
//                bullet.position.y = this.position.y;
//                bullet.position.set(this.position.x, this.position.y);
                bullet.position = new Vector2D(this.position.x, this.position.y);
                GamePanel.bullets.add(bullet);
                this.count=0;
            }
        }
    }

    private void move() {
        if (GameWindow.isUpPress) {
            this.position.substract(0,5);
        }
        if (GameWindow.isDownPress) {
            this.position.add(0,5);
        }
        if (GameWindow.isLeftPress) {
            this.position.substract(5,0);
        }
        if (GameWindow.isRightPress) {
            this.position.add(5,0);
        }
    }
}
