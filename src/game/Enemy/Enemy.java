package game.Enemy;

import game.GameObject;
import game.renderer.Animation;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Enemy extends GameObject {
    public Enemy(){
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("assets/images/enemies/level0/pink/0.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/level0/pink/1.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/level0/pink/2.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/level0/pink/3.png"));
        this.renderer = new Animation(images);
        this.velocity.set(0,2);
    }

    @Override
    public void run() {
        super.run();
        this.fire();
    }

    int count; // TODO: continue editing
    private void fire() {
        this.count++;
        if (this.count > 20) {
            float startAngle = (float)Math.PI / 4;
            float endAngle = 3 * (float)Math.PI / 4;
            float offset =(endAngle - startAngle)/4;
            for(int i =0; i<5; i++){
                EnemyBullet bullet = new EnemyBullet();
                bullet.position.set(this.position.x , this.position.y);
                bullet.velocity.setAngle(startAngle + offset*i);
                this.count=0;
            }
        }
    }
}
