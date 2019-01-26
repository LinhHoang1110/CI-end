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

    public Food_boom(){
        super();
        BufferedImage image = SpriteUtils.loadImage("assets/images/pixel-fruit-orange-16x16.png");
        this.renderer = new SingleImageRenderer(image);
        this.boxColider = new BoxColider(this, 16,16);
        this.position.set(200,150);
    }

}
