
//package pgdp.oop;

import java.awt.*;
import java.io.File;

public class Fish extends Animal {
    static String filename = "fish.png";

    public Fish(int x, int y) {
        super(x, y);

        f = new File(filename);
        image = Toolkit.getDefaultToolkit().getImage(f.getAbsolutePath());
    }

    @Override
    protected int[][] getMovementPriority() {
        return new int[][] { new int[] { 0, -1 }, { 1, 0 }, { 0, 1 }, { -1, 0 } };
    }

    @Override
    protected Color getColor() {return Color.blue;}

    public boolean canEat(Animal animal) {
        return animal.eatenBy(this);
    }

    @Override
    protected boolean eatenBy(Penguin penguin) {
        return true;
    }

    @Override
    protected boolean eatenBy(PlayerPenguin playerPenguin) {
        return true;
    }

    @Override
    protected boolean eatenBy(Whale whale) {
        return true;
    }

    @Override
    protected boolean eatenBy(LeopardSeal leopardSeal) {
        return true;
    }

    @Override
    protected boolean eatenBy(Fish fish) {
        return false;
    }
}
