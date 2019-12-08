//package pgdp.oop;

import java.awt.*;

public class PlayerPenguin extends Penguin {
    public PlayerPenguin(int x, int y) {
        super(x, y);
    }
    boolean foundPinguin = false;

    public boolean didFindPenguin() {
        return foundPinguin;
    }

    public boolean move(int newX, int newY) {
        // added
        newX = clampCoordX(newX);
        newY = clampCoordY(newY);
        // System.out.println("new x " + newX + " new y " + newY);

        Penguin lostP;
        try {
             lostP = (Penguin) antarktis[newX][newY];
        } catch (ClassCastException e) {
             lostP=null;
        }

        if (lostP != null) {
            foundPinguin = true;

        }

        if (antarktis[newX][newY] == null) {

        } else if (canEat(antarktis[newX][newY])) {
            antarktis[newX][newY].killAnimal();
        }

            antarktis[x][y] = null;
            antarktis[newX][newY] = this;
            this.x = newX;
            this.y = newY;

        if (lostP != null && !lostP.isAlive()|| !this.alive || foundPinguin) {return true;}
        return false;
//
//        antarktis[x][y] = null;
//
//
//        if (antarktis[newX][newY].canEat(this)||lostP!=null)
//        {    antarktis[newX][newY] = this;
//            return true;
//        }
//
//        antarktis[newX][newY] = this;
//        return false;
    }

    public boolean canEat(Animal animal) {
        return animal.eatenBy(this);
    }


 //   @Override
   // protected Color getColor() {return Color.black;}
}
