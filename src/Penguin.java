//package pgdp.oop;

import java.awt.*;
import java.io.File;

public class Penguin extends Animal {
  static String filename = "tux.png";

  public boolean isAlive() {
    return alive;
  }

  public Penguin(int x, int y) {
    super(x, y);

    f = new File(filename);
    image = Toolkit.getDefaultToolkit().getImage(f.getAbsolutePath());
  }

  public boolean canEat(Animal animal) {
    return animal.eatenBy(this);
  }


  @Override
  protected Color getColor() {return Color.cyan;}

  @Override
  protected boolean eatenBy(Penguin penguin) {
    return false;
  }

  @Override
  protected boolean eatenBy(PlayerPenguin playerPenguin) {
    return false;
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
