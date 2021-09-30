public class Main {
    public static void main(String[] args){
        Adventure game = new Adventure();

        game.help(true);                // true, just to overload and not prompt an action after showing commands.

        game.start();

        game.setActualCurrentRoom(1);       // possible need to change order of things in Adventure to avoid needing the 1

        game.look(1);       // possible need to change order of things in Adventure to avoid needing the 1
    }
}
