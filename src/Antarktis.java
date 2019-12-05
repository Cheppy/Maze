//package pgdp.oop;

import java.awt.event.WindowEvent;

public class Antarktis extends Maze {
    private static int width, height;
    private static Penguin lostPenguin;
    private static Whale[] whales = new Whale[5];
    private static LeopardSeal[] leopardSeals = new LeopardSeal[20];
    private static Fish[] fishes = new Fish[500];
    private static PlayerPenguin playerPenguin;

    public static void main(String[] args) {
        width = 41;
        height = 41;
        antarktis = generateMaze(width, height);
// Close the opnend frame
        closeFrame();
    }

    private static void gameLoop() {
       while (false) {
// TODO maybe
           //TODO reach draw
            draw();
// TODO maybe
            currentEvent = NOTHING;
            //TODO listen to keyboard
            moveAll();
           currentEvent = NOTHING;
            }
// TODO maybe
       }


    private static void moveAll() {
        //may depend from keyboard input currentEvent
        if (currentEvent == UP){  playerPenguin.move(playerPenguin.x, playerPenguin.y+1);}
        if (currentEvent == DOWN){  playerPenguin.move(playerPenguin.x, playerPenguin.y-1);}
        if (currentEvent == LEFT){  playerPenguin.move(playerPenguin.x-1, playerPenguin.y);}
        if (currentEvent == LEFT){  playerPenguin.move(playerPenguin.x+1, playerPenguin.y);}

        for (Whale wh : whales){
            wh.move();
            //TODO animals are eaten during movement
        }
        for (LeopardSeal ls : leopardSeals){
            ls.move();
        }

        lostPenguin.move();

        for (Fish fish : fishes){
            fish.move();
        }
        //Fish fish = new Fish();
        //fish.move();
        //LeopardSeal ls =  new LeopardSeal();
    }
// TODO

        /**
         * Example Setup for e
    }asier Testing during development
     */
    private static void setupMaze(){
        int[] pos;
        playerPenguin = new PlayerPenguin(3, 3);
        antarktis[3][3] = playerPenguin;
        for (int i = 0; i < whales.length; i++) {
            pos = getRandomEmptyField();

            whales[i] = new Whale(pos[0], pos[1]);
            antarktis[pos[0]][pos[1]] = whales[i];
        }
        for (int i = 0; i < leopardSeals.length; i++) {
            pos = getRandomEmptyField();
            leopardSeals[i] = new LeopardSeal(pos[0], pos[1]);
            antarktis[pos[0]][pos[1]] = leopardSeals[i];
        }
        for (int i = 0; i < fishes.length; i++) {
            pos = getRandomEmptyField();
            fishes[i] = new Fish(pos[0], pos[1]);
            antarktis[pos[0]][pos[1]] = fishes[i];
        }
        antarktis[20][20] = new Penguin(20, 20);
        lostPenguin = (Penguin) antarktis[20][20];
    }
}