package game.food;

import game.food_renderer.FlameRenderer;
import game.GameObject;
import game.Vector2D;
import physics.BoxColider;

public class Fire extends GameObject {
    BoxColider boxColider;
    public Vector2D startPosition;

    public Fire() {
//        ArrayList<BufferedImage> images = new ArrayList<>();
//        images.add(SpriteUtils.loadImage("assets/images/flame/flame.png"));
//        images.add(SpriteUtils.loadImage("assets/images/flame/flame2.png"));
//        images.add(SpriteUtils.loadImage("assets/images/flame/flame3.png"));
//        this.renderer = new Animation(images);
        this.renderer = new FlameRenderer();
        this.startPosition = new Vector2D();
        this.velocity.set(0, 0);
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


