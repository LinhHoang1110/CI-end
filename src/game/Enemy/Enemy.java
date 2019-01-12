package game.Enemy;

import game.FrameCounter;
import game.PlayerBullet;
import physics.BoxColider;
import physics.Physics;
import game.GameObject;
import game.renderer.Animation;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Enemy extends GameObject implements Physics {
    BoxColider boxColider;
    FrameCounter fireCounter;
    public Enemy(){
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("assets/images/enemies/level0/pink/0.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/level0/pink/1.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/level0/pink/2.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/level0/pink/3.png"));
        this.renderer = new Animation(images);
        this.velocity.set(0,1);
        this.boxColider = new BoxColider(this.position,30,30);
        this.fireCounter = new FrameCounter(20);
    }

    @Override
    public void run() {
        super.run();
        this.fire();
    }

    private void fire() {
        if (fireCounter.run()) {
//            float startAngle = (float)Math.PI / 4;
//            float endAngle = 3 * (float)Math.PI / 4;
//            float offset =(endAngle - startAngle)/4;
//            for(int i =0; i<5; i++){
                EnemyBullet bullet = new EnemyBullet();
                bullet.position.set(this.position.x , this.position.y);
//                bullet.velocity.setAngle(startAngle + offset*i);
                this.fireCounter.reset();
            }
        }
//    }
    public void takeDamage(int damage){}
    @Override
    public BoxColider getBoxColider() {
        return this.boxColider;
    }
}
