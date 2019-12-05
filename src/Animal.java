//package pgdp.oop;

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

    public Animal(int x, int y) {
        this.x = x;
        this.y = y;
    }

    protected int[][] getMovementPriority() {
        return new int[][]{new int[]{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    }

    public void move() {
        var a = antarktis;
        int[][] movePriority = getMovementPriority();

        for (int[] xy : movePriority) {
            int nextX = (this.x + xy[0]) % a[0].length;
            int nextY = (this.y + xy[1]) % a.length;
            if (this.canEat(a[nextX][nextY])) {
                a[x][y] = null;
                this.x = nextX;
                this.y = nextY;
            }

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
