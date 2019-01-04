import game.Vector2D;

public class Rectangle {
    Vector2D position;
    int width;
    int height;

    public Rectangle(float x, float y, int width, int height){
        this.position = new Vector2D(x,y);
        this.width = width;
        this.height = height;
    }

    public boolean intersected(Rectangle other){
        //TODO: kiem tra giao nhau giua hinh "this" vs "other"
         float distance =(float)Math.sqrt((other.position.x -this.position.x)*(other.position.x -this.position.x) + (other.position.y -this.position.y)*(other.position.y -this.position.y));
         float s1 =(float)Math.sqrt(this.width * this.width + this.height*this.height);
         float s2 =(float)Math.sqrt(other.width * other.width + other.height*other.height);
         if(distance > s1 || distance > s2){
             return false;
         }
         else {
             return true;
         }
    }

    public static void main(String[] args) {
        Rectangle rect1 = new Rectangle(0,0,4,4);
        Rectangle rect2 = new Rectangle(5,5,4,4);
        Rectangle rect3 = new Rectangle(2,2,4,4);
        System.out.println(rect1.intersected(rect2)); //false
        System.out.println(rect1.intersected(rect3));//true
        System.out.println(rect2.intersected(rect3));//true
    }
}
