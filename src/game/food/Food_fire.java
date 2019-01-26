package game.food;

import game.GameObject;
import game.renderer.SingleImageRenderer;
import physics.BoxColider;
import physics.Physics;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.nio.Buffer;

public class Food_fire extends Food {

    public Food_fire(){
        super();
        BufferedImage image = SpriteUtils.loadImage("assets/images/3d-pixel-fruit-strawberry-16x16.png");
        this.renderer = new SingleImageRenderer(image);
        this.position.set(150,100);
    }

    @Override
    public BoxColider getBoxColider() {
        return this.boxColider;
    }
}
