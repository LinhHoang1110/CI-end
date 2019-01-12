package game.Enemy;

import game.GameObject;
import game.Player;
import game.renderer.SingleImageRenderer;
import physics.BoxColider;
import physics.Physics;
import tklibs.SpriteUtils;
import java.awt.image.BufferedImage;

public class EnemyBullet extends GameObject implements Physics {
    BoxColider boxColider;

    public EnemyBullet(){
        super();
        BufferedImage image = SpriteUtils.loadImage("assets/images/enemies/bullets/blue.png");
        this.renderer = new SingleImageRenderer(image);
        this.velocity.set(0,10);
        this.boxColider = new BoxColider(this.position, 30,30);
    }

    @Override
    public void run() {
        super.run();
        Player player = GameObject.findIntersect(Player.class, this.boxColider);
            if(player != null){
                player.takeDamage(1);
                this.deActive();
        }
    }

    public BoxColider getBoxColider(){
        return this.boxColider;
    }
}