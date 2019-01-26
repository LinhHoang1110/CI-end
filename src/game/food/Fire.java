package game.food;

import game.GameObject;
import game.renderer.Animation;
import physics.BoxColider;
import physics.Physics;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Fire extends GameObject implements Physics {
    BoxColider boxColider;

    public Fire(){
        ArrayList<BufferedImage> images = new ArrayList<>();
        this.renderer = new Animation(images);
    }

    @Override
    public BoxColider getBoxColider() {
        return this.boxColider;
    }
}
