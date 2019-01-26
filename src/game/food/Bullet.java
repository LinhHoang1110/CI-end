package game.food;

import game.GameObject;
import game.GameWindow;
import game.Pacman;
import game.Vector2D;
import game.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class Bullet extends GameObject {
    public Vector2D startPosition;

    public Bullet(){
        super();
        BufferedImage image = SpriteUtils.loadImage("assets/images/iconfinder_bullet-square_19772.png");
        this.renderer = new SingleImageRenderer(image);
        this.startPosition = new Vector2D();
        this.velocity.set(0,0);
    }

    @Override
    public void run() {
        super.run();
        float distance = startPosition.clone().substract(this.position.x,this.position.y).getLength();
        if(distance > 100){
            this.deActive();
        }
    }
}
