package game;

import game.food.*;
import game.renderer.SingleImageRenderer;
import physics.BoxColider;
import physics.Physics;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class Pacman extends GameObject implements Physics {
    BoxColider boxColider;
    FrameCounter effectCounter;
    boolean isFiring = false;
    boolean isBurning = false;
    boolean isShielding = false;
    boolean isBooming = false;
    FrameCounter effectTime;
    boolean isFacingRight;
    boolean isFacingUp;
    boolean isFacingLeft;
    boolean isFacingDown;
    boolean[] way = new boolean[]{false,false,false,false};//up down left right


    public Pacman() {
        super();
        this.renderer = new PacmanRenderer();
        this.position.set(200, 200);
        this.boxColider = new BoxColider(this, 16, 16);
        this.effectCounter = new FrameCounter(60);
        this.effectTime = new FrameCounter(300);
    }


    @Override
    public void run() {
        super.run();
        this.fire();
        this.move();
        this.eat();
        this.burn();
        this.boom();
        this.shield();
    }


    private void fire() {
        if (effectCounter.run()) {
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
            }
            effectCounter.reset();
        }
        if (isFiring) {
            if (effectTime.run()) {
                isFiring = false;
                effectTime.reset();
            }
        }
    }


    private void burn() {
        if (effectCounter.run()) {
            if (isBurning && GameWindow.isEffectPress) {
                Fire fire = GameObject.recycle(Fire.class);
                fire.position.set(this.position.x, this.position.y);
                this.effectCounter.reset();
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
        if (effectCounter.run()) {
            if (isBooming && GameWindow.isEffectPress) {
                Boom boom = GameObject.recycle(Boom.class);
                boom.position.set(this.position.x, this.position.y);
                this.effectCounter.reset();
            }
        }
        if (isBooming) {
            if (effectTime.run()) {
                isBooming = false;
                effectTime.reset();
            }
        }
    }

    private void shield() {
        if (effectCounter.run()) {
            if (isShielding && GameWindow.isEffectPress) {
                Shield shield = GameObject.recycle(Shield.class);
                shield.position.set(this.position.x, this.position.y);
                this.effectCounter.reset();
            }
        }
        if (isShielding) {
            if (effectTime.run()) {
                isShielding = false;
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
            isShielding = true;
        }
    }


    private void move() {
        float vX = 0;
        float vY = 0;

        if (GameWindow.isUpPress) {
            vY = -5;
            way = new boolean[]{true,false,false,false};
        }
        if (GameWindow.isDownPress) {
            vY = 5;
            way = new boolean[]{false,true,false,false};
        }
        if (GameWindow.isLeftPress) {
            vX = -5;
            way = new boolean[]{false,false,true,false};
        }
        if (GameWindow.isRightPress) {
            vX = 5;
            way = new boolean[]{false,false,false,true};
        }
        this.velocity.set(vX, vY).setLength(3);
    }


    @Override
    public BoxColider getBoxColider() {
        return this.boxColider;
    }
}
