//package pgdp.oop;

public class PlayerPenguin extends Penguin {
    public PlayerPenguin(int x, int y) {
        super(x, y);
    }
    public boolean move(int newX, int newY) {
        Penguin lostP;
        try {
           lostP = (Penguin) antarktis[newX][newY];
        } catch (ClassCastException e) {

             lostP = null;

        }
        antarktis[x][y] = null;


        if (antarktis[newX][newY].canEat(this)||lostP!=null)
        {    antarktis[newX][newY] = this;
            return true;
        }

        antarktis[newX][newY] = this;
      return false;
    }

    public boolean canEat(Animal animal) {
        return animal.eatenBy(this);
    }
}
