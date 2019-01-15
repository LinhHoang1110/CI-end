package game;

import game.renderer.Animation;
import game.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class SphereBullet extends GameObject {
    public SphereBullet(){
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("assets/images/sphere-bullets/0.png"));
        images.add(SpriteUtils.loadImage("assets/images/sphere-bullets/1.png"));
        images.add(SpriteUtils.loadImage("assets/images/sphere-bullets/2.png"));
        images.add(SpriteUtils.loadImage("assets/images/sphere-bullets/3.png"));
        this.renderer = new Animation(images);
        this.velocity.set(0,-7);
    }

    @Override
    public void run() {
        super.run();
        this.deactiveIfNeeded();
    }

    private void deactiveIfNeeded() {
        if(this.position.y < - 100){
            this.deActive();
        }
    }
}
