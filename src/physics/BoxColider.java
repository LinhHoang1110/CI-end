package physics;

import game.GameObject;
import game.Vector2D;

public class BoxColider {
    Vector2D position;
    Vector2D anchor;
    int width;
    int height;

    public BoxColider(GameObject master, int width, int height) {
        this.position = master.position;
        this.anchor = master.anchor;
        this.width = width;
        this.height = height;
    }

    public float top() {
        return this.position.y - this.anchor.y * this.height;
    }

    public float bot() {
        return this.top() + this.height;
    }

    public float left() {
        return this.position.x - this.anchor.x * this.width;
    }

    public float right() {
        return this.left() + this.width;
    }

    public boolean intersected(BoxColider other) {
        //TODO: kiem tra giao nhau giua hinh "this" vs "other"
//         float distance =(float)Math.sqrt((other.position.x -this.position.x)*(other.position.x -this.position.x) + (other.position.y -this.position.y)*(other.position.y -this.position.y));
//         float s1 =(float)Math.sqrt(this.width * this.width + this.height*this.height);
//         float s2 =(float)Math.sqrt(other.width * other.width + other.height*other.height);
//         if(distance > s1 || distance > s2){
//             return false;
//         }
//         else {
//             return true;
//         }
        return this.top() <= other.bot()
                && this.bot() >= other.top()
                && this.right() >= other.left()
                && this.left() <= other.right();

    }
}
