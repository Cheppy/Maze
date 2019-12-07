//package pgdp.oop;

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
        setupMaze();
        gameLoop();
// Close the opnend frame
        closeFrame();
    }

    private static void gameLoop() {
       while (true) {
           if (!lostPenguin.isAlive()){
               System.out.println("Lost penguin died");
               return;
           }
           if (!playerPenguin.isAlive()) {
               System.out.println("player penguin died");
               return;
           }
            //TODO listen to keyboard
           if (playerMoved())
            moveAll();

           if (playerPenguin.didFindPenguin())
           {
               System.out.println("Player found the penguin");
               return;
           }
           draw();

       }
// TODO maybe
       }

       private static boolean playerMoved() {
           //may depend from keyboard input currentEvent
           var e = currentEvent;
           currentEvent = NOTHING;
           if (e == DOWN){  playerPenguin.move(playerPenguin.x, playerPenguin.y+1);return true;}
           if (e == UP){  playerPenguin.move(playerPenguin.x, playerPenguin.y-1); return true;}
           if (e == LEFT){  playerPenguin.move(playerPenguin.x-1, playerPenguin.y);return true;}
           if (e == RIGHT){  playerPenguin.move(playerPenguin.x+1, playerPenguin.y);return true;}
           return false;

       }

    private static void moveAll() {
        //may depend from keyboard input currentEvent


        for (Whale wh : whales){
            wh.move();

            //TODO animals are eaten during movement
        }
        for (LeopardSeal ls : leopardSeals){
            ls.move();
        }

        lostPenguin.move();

        for (Fish fish : fishes){ System.out.println("fish moved");
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
        Animal.setAntarktis(antarktis);
    }
}