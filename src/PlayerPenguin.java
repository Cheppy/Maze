//package pgdp.oop;

public class PlayerPenguin extends Penguin {
    public PlayerPenguin(int x, int y) {
        super(x, y);
    }
    public boolean move(int newX, int newY) {
        super.move();
        if (antarktis[newX][newY].canEat(this)||antarktis[newX][newY]==null)//lostPenguin
        {
            return false;
        }

        return false;
    }

    public boolean canEat(Animal animal) {
        return animal.eatenBy(this);
    }
}
