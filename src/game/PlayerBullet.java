package game;

import tklibs.SpriteUtils;

public class PlayerBullet extends GameObject {


    public PlayerBullet (){
        super(); // this.position = new Vector2D();
        this.image = SpriteUtils.loadImage("assets/images/player-bullets/a/0.png");
        this.velocity.set(0,-7);
    }

    @Override
    public void run() {
        super.run();
    }
}
