// pgdp.oop;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.io.File;

public abstract class Animal {
    protected int x, y;
    static String filename;
    protected File f;
    protected Image image;

    protected static Animal[][] antarktis;
    //boolean shouldMove = false;
    public Animal(int x, int y) {
        this.x = x;
        this.y = y;
    }

    boolean alive = true;//added
    void killAnimal() { alive = false;}//added
    public boolean isAlive() {return alive;}

    protected int[][] getMovementPriority() {
        return new int[][]{new int[]{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    }
    //boolean[][]
    //added
    protected int clampCoordX(int x) {
        var a = antarktis;
        int next = x % a[0].length;
        if (next < 0) next = a[0].length + next; //added
        return next;
    }
    //added
    protected int clampCoordY(int y) {
        var a = antarktis;
        int next = y % a.length;
        if (next < 0) next = a.length + next; //added
        return next;

    }

    public void move() {
        if (!isAlive()){return;}
        var a = antarktis;
        // PlayerPenguin player = new PlayerPenguin();
        int[][] movePriority = getMovementPriority();
        boolean shouldMove = false;

        //looking for prey
        for (int[] xy : movePriority) {
            int nextX = clampCoordX(this.x + xy[0]);
            int nextY = clampCoordY(this.y + xy[1]);
            //shouldMove=true;
            if (a[nextX][nextY] != null && this.canEat(a[nextX][nextY])) {
                a[nextX][nextY].killAnimal();
                shouldMove = true;
            }

            if (shouldMove) {
                a[nextX][nextY] = this;
                a[x][y] = null;
                this.x = nextX;
                this.y = nextY;

                // System.out.print(this + " Moved\n");
                return;
            }
           // if (.alive) System.out.println(this+"dead");
        }

        //SUPERMEGANIGGAFIX
        //if (!shouldMove) { return; }

        //looking for some free room at least
        for (int[] xy : movePriority) {
            int nextX = clampCoordX(this.x + xy[0]);
            int nextY = clampCoordY(this.y + xy[1]);

            if (a[nextX][nextY] == null) {
                shouldMove = true;
            }

            if (shouldMove) {
                a[nextX][nextY] = this;
                a[x][y] = null;
                this.x = nextX;
                this.y = nextY;

                // System.out.print(this + " Moved\n");
                return;
            }
          //  if (!this.alive) System.out.println("dead");
        }

    }
    public abstract boolean canEat(Animal animal);

    protected abstract boolean eatenBy(Penguin penguin);

    protected abstract boolean eatenBy(PlayerPenguin playerPenguin);
    protected abstract boolean eatenBy(Whale whale);
    protected abstract boolean eatenBy(LeopardSeal leopardSeal);
    protected abstract boolean eatenBy(Fish fish);

    public static void setAntarktis(Animal[][] antarktis) {
        Animal.antarktis = antarktis;
    }
// Graphics Stuff - You don&#39;t have to do anything here

    private void paintSymbol(Graphics g, Color c, int height, int width) {
        GradientPaint gradient = new GradientPaint(15, 0, c, width, 0, Color.LIGHT_GRAY);
        ((Graphics2D) g).setPaint(gradient);
        ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g.fillOval((int) (width * 0.3), (int) (height * 0.3), (int) (width * 0.5),
                (int) (height * 0.5));
    }

    public void draw(Graphics g, int height, int width) {
        if (image == null) {
            paintSymbol(g, Color.YELLOW, height, width);
            return;
        }
        ((Graphics2D) g).drawImage(image, 0, 0, width, height, 0, 0, image.getWidth(null),
                image.getHeight(null), null);

    }
}