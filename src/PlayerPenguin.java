//package pgdp.oop;

public class PlayerPenguin extends Penguin {
    public PlayerPenguin(int x, int y) {
        super(x, y);
    }
   // protected static Animal[][] antarktis; // ? not sure if this is needed. added so can use a[][]
    public boolean move(int newX, int newY) {
        super.x = newX;
        super.y = newY;
        super.move();
        if (antarktis[newX][newY].canEat(this)||antarktis[newX][newY]==lostPenguin.)
        return false;

    }

    public boolean canEat(Animal animal) {
        return animal.eatenBy(this);
    }
}
