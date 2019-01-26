package game.food;

import game.GameObject;
import game.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class Food_shield extends Food {

    public Food_shield() {
        super();
        BufferedImage image = SpriteUtils.loadImage("assets/images/pixel-fruit-apple-16x16.png");
        this.renderer = new SingleImageRenderer(image);
        this.position.set(150, 150);
    }
}
