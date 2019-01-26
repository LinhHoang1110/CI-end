package game;

import game.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class BackGround extends GameObject {
    public BackGround(){
        super();
        BufferedImage image = SpriteUtils.loadImage("assets/images/background_0.png");
        this.renderer = new SingleImageRenderer(image);
        this.position.set(200,200);
    }
}
