package game.food;

import game.GameObject;
import game.Pacman;
import game.renderer.SingleImageRenderer;
import physics.BoxColider;
import physics.Physics;
import tklibs.SpriteUtils;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class Shield extends GameObject implements Physics {
    BoxColider boxColider;
    public Pacman pacman;

    public Shield(){
        BufferedImage image = SpriteUtils.loadImage("assets/images/shield/shield.png");
        this.renderer = new SingleImageRenderer(image);
        pacman = null;
    }

    @Override
    public void run() {
        super.run();
        this.position.set(pacman.position);
    }

    @Override
    public BoxColider getBoxColider() {
        return this.boxColider;
    }

}
