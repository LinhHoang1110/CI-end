package game.food;

import game.GameObject;
import game.Vector2D;
import game.renderer.Animation;
import physics.BoxColider;
import physics.Physics;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Boom extends GameObject {
    public Vector2D startPosition;

    public Boom() {
        super();
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("assets/images/boom/boom1.png"));
        images.add(SpriteUtils.loadImage("assets/images/boom/boom2.png"));
        images.add(SpriteUtils.loadImage("assets/images/boom/boom3.png"));
        images.add(SpriteUtils.loadImage("assets/images/boom/boom4.png"));
        images.add(SpriteUtils.loadImage("assets/images/boom/boom5.png"));
        images.add(SpriteUtils.loadImage("assets/images/boom/boom6.png"));
        this.renderer = new Animation(images);
        this.startPosition = new Vector2D();
        this.velocity.set(0,0);
    }

    @Override
    public void run() {
        super.run();
        float distance = startPosition.clone().substract(this.position.x, this.position.y).getLength();
        if (distance > 100) {
            this.velocity.setBetween();
        }
        if(distance == 0){
            this.deActive();
        }
    }
}

