package game;

import game.food.*;
import game.renderer.SingleImageRenderer;
import physics.BoxColider;
import physics.Physics;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class Pacman extends GameObject implements Physics {
    BoxColider boxColider;
    FrameCounter bulleteffectCounter;
    boolean isFiring = false;
    boolean isBurning = false;
    public boolean isShielding = false;
    boolean isBooming = false;
    FrameCounter effectTime;
    FrameCounter boomEffectCounter;
    FrameCounter burnEffectCounter;
    FrameCounter shieldEffectCounter;
    boolean isFacingRight;
    boolean isFacingUp;
    boolean isFacingLeft;
    boolean isFacingDown;
    boolean[] way = new boolean[]{false, false, false, false};//up down left right
    Shield shield;

    public Pacman() {
        super();
        this.renderer = new PacmanRenderer();
        this.position.set(200, 200);
        this.boxColider = new BoxColider(this, 16, 16);
        this.bulleteffectCounter = new FrameCounter(20);
        this.effectTime = new FrameCounter(300);
        this.boomEffectCounter = new FrameCounter(100);
        this.burnEffectCounter = new FrameCounter(50);
        this.shieldEffectCounter = new FrameCounter(300);
    }

    @Override
    public void run() {
        super.run();
        this.fire();
        this.move();
        this.eat();
        this.burn();
        this.boom();
        this.checkShield();
    }

    private void checkShield() {
        if(this.isShielding && this.shieldEffectCounter.run()) {
            this.shield.deActive();
            this.isShielding = false;
        }
    }

    private void fire() {
        if (bulleteffectCounter.run()) {
            if (isFiring && GameWindow.isEffectPress) {
                Bullet bullet = GameObject.recycle(Bullet.class);
                bullet.position.set(this.position);
                bullet.startPosition.set(this.position);
                if (this.way[0]) {
                    bullet.velocity.set(0, -1);
                } else if (this.way[1]) {
                    bullet.velocity.set(0, 1);
                } else if (this.way[2]) {
                    bullet.velocity.set(-1, 0);
                } else if (this.way[3]) {
                    bullet.velocity.set(1, 0);
                }
                bulleteffectCounter.reset();
            }
        }
        if (isFiring) {
            if (effectTime.run()) {
                isFiring = false;
                effectTime.reset();
            }
        }
    }


    private void burn() {
        if (burnEffectCounter.run()) {
            if (isBurning && GameWindow.isEffectPress) {
                Fire fire = GameObject.recycle(Fire.class);
                fire.position.set(this.position);
                fire.startPosition.set(this.position);
                if (this.way[0]) {
                    fire.velocity.set(0, -1);
                } else if (this.way[1]) {
                    fire.velocity.set(0, 1);
                } else if (this.way[2]) {
                    fire.velocity.set(-1, 0);
                } else if (this.way[3]) {
                    fire.velocity.set(1, 0);
                }
                burnEffectCounter.reset();
            }
        }
        if (isBurning) {
            if (effectTime.run()) {
                isBurning = false;
                effectTime.reset();
            }
        }
    }

    private void boom() {
        if (boomEffectCounter.run()) {
            if (isBooming && GameWindow.isEffectPress) {
                Boom boom = GameObject.recycle(Boom.class);
                boom.position.set(this.position);
                boom.startPosition.set(this.position);
                if (this.way[0]) {
                    boom.velocity.set(0, -1);
                } else if (this.way[1]) {
                    boom.velocity.set(0, 1);
                } else if (this.way[2]) {
                    boom.velocity.set(-1, 0);
                } else if (this.way[3]) {
                    boom.velocity.set(1, 0);
                }
                boomEffectCounter.reset();
            }
        }

        if (isBooming) {
            if (effectTime.run()) {
                isBooming = false;
                effectTime.reset();
            }
        }
    }

    private void eat() {
        Food_bullet foodBullet = GameObject.findIntersect(Food_bullet.class, this.boxColider);
        if (foodBullet != null) {
            foodBullet.deActive();
            isFiring = true;
        }
        Food_fire foodFire = GameObject.findIntersect(Food_fire.class, this.boxColider);
        if (foodFire != null) {
            foodFire.deActive();
            isBurning = true;
        }
        Food_boom foodBoom = GameObject.findIntersect(Food_boom.class, this.boxColider);
        if (foodBoom != null) {
            foodBoom.deActive();
            isBooming = true;
        }

        Food_shield foodShield = GameObject.findIntersect(Food_shield.class, this.boxColider);
        if (foodShield != null) {
            foodShield.deActive();
            this.shield = GameObject.recycle(Shield.class);
            shield.pacman = this;
            this.isShielding = true;
            this.shieldEffectCounter.reset();
        }
    }

    private void move() {
        float vX = 0;
        float vY = 0;

        if (GameWindow.isUpPress) {
            vY = -5;
            way = new boolean[]{true, false, false, false};
        }
        if (GameWindow.isDownPress) {
            vY = 5;
            way = new boolean[]{false, true, false, false};
        }
        if (GameWindow.isLeftPress) {
            vX = -5;
            way = new boolean[]{false, false, true, false};
        }
        if (GameWindow.isRightPress) {
            vX = 5;
            way = new boolean[]{false, false, false, true};
        }
        this.velocity.set(vX, vY).setLength(3);
    }


    @Override
    public BoxColider getBoxColider() {
        return this.boxColider;
    }
}
