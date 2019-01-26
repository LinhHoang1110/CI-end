package game.food;

import game.GameObject;
import physics.BoxColider;
import physics.Physics;

import javax.swing.*;

public class Shield extends GameObject implements Physics {
    BoxColider boxColider;

    public Shield(){

    }

    @Override
    public BoxColider getBoxColider() {
        return this.boxColider;
    }
}
