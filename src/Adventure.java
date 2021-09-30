import java.util.Scanner;
public class Adventure {
    private int currentRoomNumber = 1;    // starts us in room 1
    private final int GRID_SIZE = 3;    // 3x3 map grid

    FluffyDescriptions desc2 = new FluffyDescriptions();            // provides random descriptions for the rooms from the fluffy desc class
    FluffyDescriptions desc3 = new FluffyDescriptions();
    FluffyDescriptions desc4 = new FluffyDescriptions();
    FluffyDescriptions desc5 = new FluffyDescriptions();
    FluffyDescriptions desc6 = new FluffyDescriptions();
    FluffyDescriptions desc7 = new FluffyDescriptions();
    FluffyDescriptions desc8 = new FluffyDescriptions();
    FluffyDescriptions desc9 = new FluffyDescriptions();

    Room actualCurrentRoom = new Room();                            // long name is leftover from currentRoom being taken by currentRoomNumber

    Room roomOne = new Room("Cozy cave entrance", "Fresh air flows around you. Its really comfortable and safe here.",      // still needs name class to make fun names, or manually giving them names
            false, true, false, true, 1);
    Room roomTwo = new Room("r2 Boring pool area", desc2.toString(),
            false, false, true, true, 2);
    Room roomThree = new Room("r3", desc3.toString(),
            false, true, true, false, 3);
    Room roomFour = new Room("r4", desc4.toString(),
            true, true, false, false, 4);
    Room roomFive = new Room("r5", desc5.toString(),
            false, true, false, false, 5);
    Room roomSix = new Room("r6", desc6.toString(),
            true, true, false, false, 6);
    Room roomSeven = new Room("r7", desc7.toString(),
            true, false, false, true, 7);
    Room roomEight = new Room("r8", desc8.toString(),
            true, false, true, true, 8);
    Room roomNine = new Room("r9", desc9.toString(),
            true, false, true, false, 9);

      public void start(){
          String playerName = playerInput("Welcome, what is your name?");               // gets name and starts the game out on a positive note
        System.out.println(playerName + " your adventure begins here!");
      }

    public String playerInput(String gameOutput){        // player free text and return value
        Scanner scanner = new Scanner(System.in);

        System.out.println(gameOutput);
        String playerInput = scanner.nextLine();
        return playerInput;
    }
    public void playerCommand(String gameOutput){        // prompt player for commands only and runs them
        Scanner scanner = new Scanner(System.in);
        boolean check;
        String playerCommand;

        do{
        System.out.println(gameOutput);
        playerCommand = scanner.nextLine();
        check = command(playerCommand);
        }
        while(!check);

        if(playerCommand.equals("help") || playerCommand.equals("Help")){
            help();
        }
        if(playerCommand.equals("exit")){
            exit();
        }
        if(playerCommand.equals("look")){
            look(currentRoomNumber);
        }
        if(playerCommand.equals("go north") || playerCommand.equals("n")){              // more commands with same function can be added easily
            goNorth(currentRoomNumber, actualCurrentRoom.getNorthPassage());
        }
        if(playerCommand.equals("go south") || playerCommand.equals("s")){
            goSouth(currentRoomNumber, actualCurrentRoom.getSouthPassage());
        }
        if(playerCommand.equals("go west") || playerCommand.equals("w")){
            goWest(currentRoomNumber, actualCurrentRoom.getWestPassage());
        }
        if(playerCommand.equals("go east") || playerCommand.equals("e")){
            goEast(currentRoomNumber, actualCurrentRoom.getEastPassage());
        }
    }

    public void goNorth(int currentRoom, boolean currentRoomNorthPassage){              // go up basically
          if(currentRoomNorthPassage){
              this.currentRoomNumber = this.currentRoomNumber - GRID_SIZE;
              setActualCurrentRoom(this.currentRoomNumber);
              look(this.currentRoomNumber);
          }
          else{
              System.out.println("There is no passage that way");
              playerCommand("What would you like to do instead?");
          }
    }
    public void goSouth(int currentRoom, boolean currentRoomSouthPassage){              // down
        if(currentRoomSouthPassage){
            this.currentRoomNumber = this.currentRoomNumber + GRID_SIZE;
            setActualCurrentRoom(this.currentRoomNumber);
            look(this.currentRoomNumber);
        }
        else{
            System.out.println("There is no passage that way");
            playerCommand("What would you like to do instead?");
        }

    }
    public void goWest(int currentRoom, boolean currentRoomWestPassage){                // left
        if(currentRoomWestPassage){
            this.currentRoomNumber = this.currentRoomNumber - 1;
            setActualCurrentRoom(this.currentRoomNumber);
            look(this.currentRoomNumber);
        }
        else{
            System.out.println("There is no passage that way");
            playerCommand("What would you like to do instead?");
        }

    }
    public void goEast(int currentRoom, boolean currentRoomEastPassage){                // right
        if(currentRoomEastPassage){
            this.currentRoomNumber = this.currentRoomNumber + 1;
            setActualCurrentRoom(this.currentRoomNumber);
            look(this.currentRoomNumber);
        }
        else{
            System.out.println("There is no passage that way");
            playerCommand("What would you like to do instead?");
        }

    }

    public boolean command(String command){                  // boolean for checking if playerCommand is a legal command
        boolean isCommand;

        if (command.equals("exit")){
            isCommand = true;
        }
        else if (command.equals("help") || command.equals("Help")){
            isCommand = true;
        }
        else if (command.equals("look")){
            isCommand = true;
        }
        else if (command.equals("go north") || command.equals("n")){
            isCommand = true;
        }
        else if (command.equals("go south") || command.equals("s")){
            isCommand = true;
        }
        else if (command.equals("go west") || command.equals("w")){
            isCommand = true;
        }
        else if (command.equals("go east") || command.equals("e")){
            isCommand = true;
        }
        else{
            isCommand = false;
        }
        return isCommand;
    }

    public void help(){                              // list player commands and runs new playerCommand
        System.out.println("You can use the following commands in the game; exit, help, look, go north, go south, go west and go east.");
        playerCommand("What would you like to do");
    }
    public void help(boolean start){                              // overload 1, list player commands and runs new playerCommand
        System.out.println("You can use the following commands in the game; exit, help, look, go north, go south, go west and go east.");
      }

    public void exit(){                          // exits game
        Scanner scanner = new Scanner(System.in);
        System.out.println("You are exiting the game, press enter :)");
        scanner.nextLine();
        System.exit(0);
    }

    public void look(int currentRoomNumber){                                  // refreshes current room description, and prompts for next action from player

        switch (currentRoomNumber){
            case 1 :
                System.out.println(roomOne.getName());
                System.out.println(roomOne.getDescription());
                break;
            case 2 :
                System.out.println(roomTwo.getName());
                System.out.println(roomTwo.getDescription());
                break;
            case 3 :
                System.out.println(roomThree.getName());
                System.out.println(roomThree.getDescription());
                break;
            case 4 :
                System.out.println(roomFour.getName());
                System.out.println(roomFour.getDescription());
                break;
            case 5 :
                System.out.println(roomFive.getName());
                System.out.println(roomFive.getDescription());
                break;
            case 6 :
                System.out.println(roomSix.getName());
                System.out.println(roomSix.getDescription());
                break;
            case 7 :
                System.out.println(roomSeven.getName());
                System.out.println(roomSeven.getDescription());
                break;
            case 8 :
                System.out.println(roomEight.getName());
                System.out.println(roomEight.getDescription());
                break;
            case 9 :
                System.out.println(roomNine.getName());
                System.out.println(roomNine.getDescription());
                break;
        }
        playerCommand("What would you like to do next?");
    }

    public void setActualCurrentRoom(int currentRoom){              // updates us to the current room player is in
        switch(currentRoom){
            case 1 :
                actualCurrentRoom = roomOne;
                break;
            case 2 :
                actualCurrentRoom = roomTwo;
                break;
            case 3 :
                actualCurrentRoom = roomThree;
                break;
            case 4 :
                actualCurrentRoom = roomFour;
                break;
            case 5 :
                actualCurrentRoom = roomFive;
                break;
            case 6 :
                actualCurrentRoom = roomSix;
                break;
            case 7 :
                actualCurrentRoom = roomSeven;
                break;
            case 8 :
                actualCurrentRoom = roomEight;
                break;
            case 9 :
                actualCurrentRoom = roomNine;
                break;
        }
    }

}
