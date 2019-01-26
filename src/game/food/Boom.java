package game.food;

import game.GameObject;
import game.renderer.Animation;
import physics.BoxColider;
import physics.Physics;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Boom extends GameObject implements Physics {
    BoxColider boxColider;

    public Boom(){
        ArrayList<BufferedImage> images = new ArrayList<>();

        this.renderer = new Animation(images);
    }

    @Override
    public BoxColider getBoxColider() {
        return this.boxColider;
    }
}
