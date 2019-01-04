package game;

import tklibs.SpriteUtils;

import java.awt.*;

public class BackGround extends GameObject {

    public BackGround(){
        super();//this.position = new Vector2D(); kể cả không gọi thì program cũng đc gọi ngầm
        this.image = SpriteUtils.loadImage("assets/images/background/0.png");
        this.position.set(0, 600 - this.image.getHeight());
        this.velocity.set(0,1);
    }

    @Override
    public void run(){
        super.run();
        // TODO: gioi han di chuyen cho background
        }
    }

