package game.food_renderer;

import game.GameObject;
import game.renderer.Animation;
import game.renderer.Renderer;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class FlameRenderer extends Renderer {
    Renderer xRenderer;
    Renderer yRenderer;

    public FlameRenderer() {
        ArrayList<BufferedImage> xImages = new ArrayList<>();
        xImages.add(SpriteUtils.loadImage("assets/images/flame/flame.png"));
        xImages.add(SpriteUtils.loadImage("assets/images/flame/flame2.png"));
        xImages.add(SpriteUtils.loadImage("assets/images/flame/flame3.png"));
        this.xRenderer = new Animation(xImages);

        ArrayList<BufferedImage> yImages = new ArrayList<>();
        yImages.add(SpriteUtils.loadImage("assets/images/flame/flame2/flame_2.png"));
        yImages.add(SpriteUtils.loadImage("assets/images/flame/flame2/flame_3.png"));
        yImages.add(SpriteUtils.loadImage("assets/images/flame/flame2/flame_4.png"));
        this.yRenderer = new Animation(yImages);
    }


    @Override
    public void render(Graphics g, GameObject master) {
        if (master.velocity.x != 0) {
            this.xRenderer.render(g, master);
        } else {
            this.yRenderer.render(g, master);
        }
    }
}
