package game.food;

import game.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class Food_bullet extends Food {

    public Food_bullet() {
        super();
        BufferedImage image = SpriteUtils.loadImage("assets/images/pixel-fruit-cherry-16x16.png");
        this.renderer = new SingleImageRenderer(image);
        this.position.set(100, 150);
    }

}



