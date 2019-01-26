package game.food;

import game.GameObject;
import game.renderer.Animation;
import game.renderer.SingleImageRenderer;
import physics.BoxColider;
import physics.Physics;
import tklibs.SpriteUtils;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Food_boom extends Food {
    BoxColider boxColider;

    public Food_boom(){
        BufferedImage image = SpriteUtils.loadImage("");
        this.renderer = new SingleImageRenderer(image);
        this.boxColider = new BoxColider(this, 16,16);
    }

    @Override
    public void run() {
        super.run();
    }
}
