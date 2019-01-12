package physics;

import game.Vector2D;

public class BoxColider  {
    Vector2D position;
    int width;
    int height;

    public BoxColider(Vector2D position, int width, int height){
        this.position = position;
        this.width = width;
        this.height = height;
    }
    public float top(){
        return this.position.y;
    }

    public float bot(){
        return this.top() + this.height;
    }

    public float left(){
        return this.position.x;
    }

    public float right(){
        return this.left() + this.width;
    }

    public boolean intersected(BoxColider other){
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
        return     this.top() <= other.bot()
                && this.bot() >= other.top()
                && this.right() >= other.left()
                && this.left() <= other.right();

    }

//    public static void main(String[] args) {
//        BoxColider rect1 = new BoxColider(0,0,4,4);
//        BoxColider rect2 = new BoxColider(5,5,4,4);
//        BoxColider rect3 = new BoxColider(2,2,4,4);
//        System.out.println(rect1.intersected(rect2)); //false
//        System.out.println(rect1.intersected(rect3));//true
//        System.out.println(rect2.intersected(rect3));//true
//    }
}
