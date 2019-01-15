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
    int damage;

    public EnemyBullet(){
        super();
        BufferedImage image = SpriteUtils.loadImage("assets/images/enemies/bullets/blue.png");
        this.renderer = new SingleImageRenderer(image);
        this.velocity.set(0,10);
        this.boxColider = new BoxColider(this, 30,30);
        this.damage = 1;
    }

    @Override
    public void run() {
        super.run();
        Player player = GameObject.findIntersect(Player.class, this.boxColider);
            if(player != null){
                player.takeDamage(this.damage);
                this.deActive();
        }
        this.deactiveIdNeeded();
    }

    private void deactiveIdNeeded() {
        if(this.position.y > 900){
            this.deActive();
        }
    }

    public BoxColider getBoxColider(){
        return this.boxColider;
    }
}