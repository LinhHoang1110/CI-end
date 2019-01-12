package game;

import game.Enemy.Enemy;
import physics.BoxColider;
import game.renderer.Animation;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class PlayerBullet extends GameObject {
    BoxColider boxColider;

    public PlayerBullet (){
        super(); // this.position = new Vector2D();
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("assets/images/player-bullets/a/0.png"));
        images.add(SpriteUtils.loadImage("assets/images/player-bullets/a/1.png"));
        images.add(SpriteUtils.loadImage("assets/images/player-bullets/a/2.png"));
        images.add(SpriteUtils.loadImage("assets/images/player-bullets/a/3.png"));
        this.renderer = new Animation(images, 0);
        this.velocity.set(0,-7);
        this.boxColider = new BoxColider(this.position, 30,30);
    }

    @Override
    public void run() {
        super.run();
        Enemy enemy = GameObject.findIntersect(Enemy.class, this.boxColider);
        if(enemy != null){
            System.out.println("hit");
            enemy.deActive();
        }
    }

    public BoxColider getBoxColider(){
        return this.boxColider;
    }
}
