import java.io.IOException;
import java.util.Scanner;

public class playerInput extends defaultPlacement {
    static int Globalx;
    static char Globaly;
    // Arrays to store ship information
    static String[] shipNames = new String[6];
    static int[] shipXVals = new int[6];
    static char[] shipYVals = new char[6];
    static String[] shipOrientations = new String[6];
    /*
     * static int[] BoardR1 = new int[11];
     * static int[] BoardR2 = new int[11];
     * static int[] BoardR3 = new int[11];
     * static int[] BoardR4 = new int[11];
     * static int[] BoardR5 = new int[11];
     * static int[] Board2R1 = new int[11];
     * static int[] Board2R2 = new int[11];
     * static int[] Board2R3 = new int[11];
     * static int[] Board2R4 = new int[11];
     * static int[] Board2R5 = new int[11];
     */
    static String[] BoardLet = { " ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J" };
    static int sel;

    /*
     * public static void main(String[] args) {
     * playersInputs();
     * battle();
     * }
     */

    public static void playersInputs() {
        String inputY;
        String name;
        int Xval;
        char Yval;
        String Ori;

        // Fill the arrays with "0"
        for (int i = 0; i < BoardR1.length; i++) {
            BoardR1[i] = 0;
            Board2R1[i] = 0;
        }

        for (int i = 0; i < BoardR2.length; i++) {
            BoardR2[i] = 0;
            Board2R2[i] = 0;
        }

        for (int i = 0; i < BoardR3.length; i++) {
            BoardR3[i] = 0;
            Board2R3[i] = 0;
        }

        for (int i = 0; i < BoardR4.length; i++) {
            BoardR4[i] = 0;
            Board2R4[i] = 0;
        }

        for (int i = 0; i < BoardR5.length; i++) {
            BoardR5[i] = 0;
            Board2R5[i] = 0;
        }
        BoardR1[0] = 1;
        BoardR2[0] = 2;
        BoardR3[0] = 3;
        BoardR4[0] = 4;
        BoardR5[0] = 5;
        Board2R1[0] = 1;
        Board2R2[0] = 2;
        Board2R3[0] = 3;
        Board2R4[0] = 4;
        Board2R5[0] = 5;
        try (Scanner info = new Scanner(System.in)) {
            clearConsole();
            System.out.println(
                    "Do you want to place the ships on your own. If so type Yes(Y) or type anything else to set default placement");
            String answer = info.nextLine();
            if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")) {
                clearConsole();

                System.out.println(
                        "Player 1 you need to make three ships in total. (An Aircraft Carrier, Submarine and Battleship)");

                System.out
                        .println("Now Printing Player 1 Board, 0 = No Ship Exists On Spot and 1 = Ship Exists On Spot");
                System.out.println(" ");
                player1Board();

                // Aircraft
                System.out.println(" ");

                System.out.println("You will first make an Aircraft Carrier.");

                System.out.println("What is the name of the Aircraft Carrier");
                name = info.nextLine();
                shipNames[0] = name;

                System.out.println("What is your starting X position (Please use an int 1-5)?");
                while (true) {
                    Xval = info.nextInt();
                    if (Xval >= 1 && Xval <= 5) {
                        shipXVals[0] = Xval;
                        break;
                    } else {
                        System.out.println("Invalid input. Please enter a number between 1 and 5.");
                    }
                }

                System.out.println("What is your Y position attack choice (A-J)? Use capital letters");
                inputY = info.nextLine();
                while (true) {
                    inputY = info.nextLine();
                    Yval = inputY.charAt(0);
                    if (Yval >= 'A' && Yval <= 'J') {
                        shipYVals[0] = Yval;
                        break;
                    } else {
                        System.out.println("Invalid input. Please enter a single Uppercase character (A-J).");
                    }
                }

                while (true) {
                    System.out.println("Do you want it to be Vertical(V) or Horizontal(H)?");
                    Ori = info.nextLine();

                    if (Ori.equalsIgnoreCase("vertical") || Ori.equalsIgnoreCase("horizontal")
                            || Ori.equalsIgnoreCase("v") || Ori.equalsIgnoreCase("h")) {
                        shipOrientations[0] = Ori;
                        break;
                    } else {
                        System.out.println("Invalid input. Please enter Vertical(V) or Horizontal(H)");
                    }
                }

                aircraftCarrier A1 = new aircraftCarrier(name, Xval, Yval, Ori);
                points(Ori, Xval, Yval, A1.size);
                System.out.println("*******************************************");

                System.out
                        .println(
                                "Now Printing Player 1 Board, 0 = No Ship Exists On Spot and 1 = Ship Exists On Spot");
                System.out.println(" ");
                player1Board();

                // Battleship
                System.out.println(" ");

                System.out.println("You will now make a Battleship.");

                System.out.println("What is the name of the Battleship");
                name = info.nextLine();
                shipNames[1] = name;

                System.out.println("What is your starting X position (Please use an int 1-5)?");
                while (true) {
                    Xval = info.nextInt();
                    if (Xval >= 1 && Xval <= 5) {
                        shipXVals[1] = Xval;
                        break;
                    } else {
                        System.out.println("Invalid input. Please enter a number between 1 and 5.");
                    }
                }

                System.out.println("What is your Y position attack choice (A-J)? Use capital letters");
                inputY = info.nextLine();
                while (true) {
                    inputY = info.nextLine();
                    Yval = inputY.charAt(0);
                    if (Yval >= 'A' && Yval <= 'J') {
                        shipYVals[1] = Yval;
                        break;
                    } else {
                        System.out.println("Invalid input. Please enter a single Uppercase character (A-J).");
                    }
                }

                while (true) {
                    System.out.println("Do you want it to be Vertical(V) or Horizontal(H)?");
                    Ori = info.nextLine();

                    if (Ori.equalsIgnoreCase("vertical") || Ori.equalsIgnoreCase("horizontal")
                            || Ori.equalsIgnoreCase("v") || Ori.equalsIgnoreCase("h")) {
                        shipOrientations[1] = Ori;
                        break;
                    } else {
                        System.out.println("Invalid input. Please enter Vertical(V) or Horizontal(H)");
                    }
                }

                battleship B1 = new battleship(name, Xval, Yval, Ori);
                points(Ori, Xval, Yval, B1.size);
                System.out.println("*******************************************");

                System.out.println(
                        "Now Printing Player 1 Board, 0 = No Ship Exists On Spot and 1 = Ship Exists On Spot");
                System.out.println(" ");
                for (int i = 0; i < BoardLet.length; i++) {
                    System.out.print(BoardLet[i] + " ");
                }
                System.out.println(" ");
                player1Board();

                // Submarine
                System.out.println(" ");

                System.out.println("You will now make a Submarine.");

                System.out.println("What is the name of the Submarine");
                name = info.nextLine();
                shipNames[2] = name;

                System.out.println("What is your starting X position (Please use an int 1-5)?");
                while (true) {
                    Xval = info.nextInt();
                    if (Xval >= 1 && Xval <= 5) {
                        shipXVals[2] = Xval;
                        break;
                    } else {
                        System.out.println("Invalid input. Please enter a number between 1 and 5.");
                    }
                }

                System.out.println("What is your Y position attack choice (A-J)? Use capital letters");
                inputY = info.nextLine();
                while (true) {
                    inputY = info.nextLine();
                    Yval = inputY.charAt(0);
                    if (Yval >= 'A' && Yval <= 'J') {
                        shipYVals[2] = Yval;
                        break;
                    } else {
                        System.out.println("Invalid input. Please enter a single Uppercase character (A-J).");
                    }
                }

                while (true) {
                    System.out.println("Do you want it to be Vertical(V) or Horizontal(H)?");
                    Ori = info.nextLine();

                    if (Ori.equalsIgnoreCase("vertical") || Ori.equalsIgnoreCase("horizontal")) {
                        shipOrientations[2] = Ori;
                        break;
                    } else {
                        System.out.println("Invalid input. Please enter Vertical or Horizontal");
                    }
                }

                submarine S1 = new submarine(name, Xval, Yval, Ori);
                points(Ori, Xval, Yval, S1.size);
                System.out.println("*******************************************");

                System.out.println(
                        "Now Printing Final Player 1 Board, 0 = No Ship Exists On Spot and 1 = Ship Exists On Spot");
                System.out.println(" ");
                player1Board();

                // Clear Question
                System.out.println(" ");
                System.out.println("Press Enter to clear console and move to Player 2");

                // Wait for Enter and clear console
                try {
                    System.in.read();
                    clearConsole();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                // Start Player 2
                System.out.println(" ");
                System.out.println(
                        "Player 2 you need to make three ships in total. (An Aircraft Carrier, Submarine and Battleship)");

                System.out
                        .println(
                                "Now Printing Player 2 Board, 0 = No Ship Exists On Spot and 1 = Ship Exists On Spot");
                System.out.println(" ");
                player2Board();

                // Aircraft
                System.out.println(" ");

                System.out.println("You will first make an Aircraft Carrier.");

                System.out.println("What is the name of the Aircraft Carrier");
                name = info.nextLine();
                shipNames[3] = name;

                System.out.println("What is your starting X position (Please use an int 1-5)?");
                while (true) {
                    Xval = info.nextInt();
                    if (Xval >= 1 && Xval <= 5) {
                        shipXVals[3] = Xval;
                        break;
                    } else {
                        System.out.println("Invalid input. Please enter a number between 1 and 5.");
                    }
                }

                System.out.println("What is your Y position attack choice (A-J)? Use capital letters");
                inputY = info.nextLine();
                while (true) {
                    inputY = info.nextLine();
                    Yval = inputY.charAt(0);
                    if (Yval >= 'A' && Yval <= 'J') {
                        shipYVals[3] = Yval;
                        break;
                    } else {
                        System.out.println("Invalid input. Please enter a single Uppercase character (A-J).");
                    }
                }

                while (true) {
                    System.out.println("Do you want it to be Vertical(V) or Horizontal(H)?");
                    Ori = info.nextLine();

                    if (Ori.equalsIgnoreCase("vertical") || Ori.equalsIgnoreCase("horizontal")) {
                        shipOrientations[3] = Ori;
                        break;
                    } else {
                        System.out.println("Invalid input. Please enter Vertical or Horizontal");
                    }
                }

                aircraftCarrier A2 = new aircraftCarrier(name, Xval, Yval, Ori);
                points2(Ori, Xval, Yval, A2.size);
                System.out.println("*******************************************");

                System.out
                        .println(
                                "Now Printing Player 2 Board, 0 = No Ship Exists On Spot and 1 = Ship Exists On Spot");
                System.out.println(" ");
                player2Board();

                // Battleship
                System.out.println(" ");

                System.out.println("You will now make a Battleship.");

                System.out.println("What is the name of the Battleship");
                name = info.nextLine();
                shipNames[4] = name;

                System.out.println("What is your starting X position (Please use an int 1-5)?");
                while (true) {
                    Xval = info.nextInt();
                    if (Xval >= 1 && Xval <= 5) {
                        shipXVals[4] = Xval;
                        break;
                    } else {
                        System.out.println("Invalid input. Please enter a number between 1 and 5.");
                    }
                }

                System.out.println("What is your Y position attack choice (A-J)? Use capital letters");
                inputY = info.nextLine();
                while (true) {
                    inputY = info.nextLine();
                    Yval = inputY.charAt(0);
                    if (Yval >= 'A' && Yval <= 'J') {
                        shipYVals[4] = Yval;
                        break;
                    } else {
                        System.out.println("Invalid input. Please enter a single Uppercase character (A-J).");
                    }
                }

                while (true) {
                    System.out.println("Do you want it to be Vertical(V) or Horizontal(H)?");
                    Ori = info.nextLine();

                    if (Ori.equalsIgnoreCase("vertical") || Ori.equalsIgnoreCase("horizontal")) {
                        shipOrientations[4] = Ori;
                        break;
                    } else {
                        System.out.println("Invalid input. Please enter Vertical or Horizontal");
                    }
                }
                battleship B2 = new battleship(name, Xval, Yval, Ori);
                points2(Ori, Xval, Yval, B2.size);
                System.out.println("*******************************************");

                System.out
                        .println(
                                "Now Printing Player 2 Board, 0 = No Ship Exists On Spot and 1 = Ship Exists On Spot");
                System.out.println(" ");
                player2Board();

                // Submarine
                System.out.println(" ");

                System.out.println("You will now make a Submarine.");

                System.out.println("What is the name of the Submarine");
                name = info.nextLine();
                shipNames[5] = name;

                System.out.println("What is your starting X position (Please use an int 1-5)?");
                while (true) {
                    Xval = info.nextInt();
                    if (Xval >= 1 && Xval <= 5) {
                        shipXVals[5] = Xval;
                        break;
                    } else {
                        System.out.println("Invalid input. Please enter a number between 1 and 5.");
                    }
                }

                System.out.println("What is your Y position attack choice (A-J)? Use capital letters");
                inputY = info.nextLine();
                while (true) {
                    inputY = info.nextLine();
                    Yval = inputY.charAt(0);
                    if (Yval >= 'A' && Yval <= 'J') {
                        shipYVals[5] = Yval;
                        break;
                    } else {
                        System.out.println("Invalid input. Please enter a single Uppercase character (A-J).");
                    }
                }

                while (true) {
                    System.out.println("Do you want it to be Vertical(V) or Horizontal(H)?");
                    Ori = info.nextLine();

                    if (Ori.equalsIgnoreCase("vertical")
                            || Ori.equalsIgnoreCase("horizontal")) {
                        shipOrientations[5] = Ori;
                        break;
                    } else {
                        System.out
                                .println("Invalid input. Please enter Vertical or Horizontal");
                    }
                }

                submarine S2 = new submarine(name, Xval, Yval, Ori);
                points2(Ori, Xval, Yval, S2.size);
                System.out.println("*******************************************");

                System.out.println(
                        "Now Printing Final Player 2 Board, 0 = No Ship Exists On Spot and 1 = Ship Exists On Spot");
                System.out.println(" ");
                player2Board();

                // Clear Question
                System.out.println(" ");
                System.out.println("Press Enter to clear console and move to the game");

                // Wait for Enter and clear console
                try {
                    System.in.read();
                    clearConsole();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } else {
                // Use default Placements
                defaultPlacement();
                System.out.println(
                        "Now Printing Final Player 1 Board, 0 = No Ship Exists On Spot and 1 = Ship Exists On Spot. Press Enter to show Player 2 Board");
                System.out.println(" ");
                player1Board();
                try {
                    System.in.read();
                    clearConsole();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                System.out.println(
                        "Now Printing Final Player 2 Board, 0 = No Ship Exists On Spot and 1 = Ship Exists On Spot");
                System.out.println(" ");
                player2Board();
                System.out.println(" ");
                System.out.println("Game will enter battle in 5 seconds");
                try {
                    // Sleep for 1 second (1000 milliseconds)
                    Thread.sleep(6000);
                } catch (InterruptedException e) {
                    // Handle the InterruptedException (e.g., log or ignore it)
                }
            }
            /*
             * Battle below
             *
             *
             *
             *
             *
             */
            clearConsole();
            String inputY2;
            int Xval2;
            char Yval2;
            boolean hit;
            boolean exit;
            exit = false;
            while (!exit) {
                if (!containsOne(Board2R1) && !containsOne(Board2R2) && !containsOne(Board2R3)
                        && !containsOne(Board2R4) && !containsOne(Board2R5)) {
                    exit = true;
                }
                if (!containsOne(BoardR1) && !containsOne(BoardR2) && !containsOne(BoardR3)
                        && !containsOne(BoardR4) && !containsOne(BoardR5)) {
                    exit = true;
                }
                while (true) {
                    clearConsole();
                    System.out.println(
                            " ");
                    System.out.println(
                            "This is your Board Player 1: 0 - ship doesn't exist, 1 - ship exists, 2 - ship bombed");
                    System.out.println(
                            " ");
                    player1Board();

                    System.out.println("Player 1 choose an attack coordinate");
                    System.out.println("What is your X position attack choice (Please use an int 1-5)?");
                    Xval2 = info.nextInt();

                    if (Xval2 >= 1 && Xval2 <= 5) {
                        info.nextLine(); // Consume the newline character
                        hit = false;
                        System.out.println("What is your Y position attack choice (A-J)? Use capital letters");
                        inputY2 = info.nextLine();
                        Yval2 = inputY2.charAt(0);

                        if (Yval2 >= 'A' && Yval2 <= 'J') {
                            if (Xval2 == 1) {
                                sel = Yval2 - 'A';
                                if (Board2R1[sel + 1] == 1) {
                                    hit = true;
                                }
                                Board2R1[sel + 1] = 2;
                            } else if (Xval2 == 2) {
                                sel = Yval2 - 'A';
                                if (Board2R2[sel + 1] == 1) {
                                    hit = true;
                                }
                                Board2R2[sel + 1] = 2;
                            } else if (Xval2 == 3) {
                                sel = Yval2 - 'A';
                                if (Board2R3[sel + 1] == 1) {
                                    hit = true;
                                }
                                Board2R3[sel + 1] = 2;
                            } else if (Xval2 == 4) {
                                sel = Yval2 - 'A';
                                if (Board2R4[sel + 1] == 1) {
                                    hit = true;
                                }
                                Board2R4[sel + 1] = 2;
                            } else if (Xval2 == 5) {
                                sel = Yval2 - 'A';
                                if (Board2R5[sel + 1] == 1) {
                                    hit = true;
                                }
                                Board2R5[sel + 1] = 2;
                            }

                            // Check if it's a hit
                            if (hit == true) {
                                System.out.println("You hit a Ship");
                                continue;
                            } else {
                                break;
                            }

                        } else {
                            System.out.println("Invalid input. Please enter a single Uppercase character (A-J).");
                        }
                    } else {
                        System.out.println("Invalid input. Please enter a number between 1 and 5.");
                    }
                }

                while (true) {
                    clearConsole();
                    System.out.println(
                            " ");
                    System.out.println(
                            "This is your Board Player 2: 0 - ship doesn't exist, 1 - ship exists, 2 - ship bombed");
                    System.out.println(
                            " ");
                    player2Board();

                    System.out.println("Player 2 choose an attack coordinate");
                    System.out.println("What is your X position attack choice (Please use an int 1-5)?");
                    Xval2 = info.nextInt();

                    if (Xval2 >= 1 && Xval2 <= 5) {
                        info.nextLine(); // Consume the newline character
                        hit = false;
                        System.out.println("What is your Y position attack choice (A-J)? Use capital letters");
                        inputY2 = info.nextLine();
                        Yval2 = inputY2.charAt(0);

                        if (Yval2 >= 'A' && Yval2 <= 'J') {
                            if (Xval2 == 1) {
                                sel = Yval2 - 'A';
                                if (BoardR1[sel + 1] == 1) {
                                    hit = true;
                                }
                                BoardR1[sel + 1] = 2;
                            } else if (Xval2 == 2) {
                                sel = Yval2 - 'A';
                                if (BoardR2[sel + 1] == 1) {
                                    hit = true;
                                }
                                BoardR2[sel + 1] = 2;
                            } else if (Xval2 == 3) {
                                sel = Yval2 - 'A';
                                if (BoardR3[sel + 1] == 1) {
                                    hit = true;
                                }
                                BoardR3[sel + 1] = 2;
                            } else if (Xval2 == 4) {
                                sel = Yval2 - 'A';
                                if (BoardR4[sel + 1] == 1) {
                                    hit = true;
                                }
                                BoardR4[sel + 1] = 2;
                            } else if (Xval2 == 5) {
                                sel = Yval2 - 'A';
                                if (BoardR5[sel + 1] == 1) {
                                    hit = true;
                                }
                                BoardR5[sel + 1] = 2;
                            }

                            // Check if it's a hit
                            if (hit == true) {
                                System.out.println("You hit a Ship");
                                continue;
                            } else {
                                break;
                            }
                        } else {
                            System.out.println("Invalid input. Please enter a single Uppercase character (A-J).");
                        }
                    } else {
                        System.out.println("Invalid input. Please enter a number between 1 and 5.");
                    }
                }

                if (!containsOne(Board2R1) && !containsOne(Board2R2) && !containsOne(Board2R3)
                        && !containsOne(Board2R4) && !containsOne(Board2R5)) {
                    System.out.println("Player 1 has Won!");
                    break;
                }
                if (!containsOne(BoardR1) && !containsOne(BoardR2) && !containsOne(BoardR3)
                        && !containsOne(BoardR4) && !containsOne(BoardR5)) {
                    System.out.println("Player 2 has Won!");
                    break;
                }

            }
        }
    }

    // Player 1 Points Finder
    public static void points(String d, int x, char y, int s) {
        System.out.println("Points starting - ending:");
        if (d.equals("vertical") || d.equals("Vertical") || d.equals("V") || d.equals("v")) {
            for (int i = x; i < x + s; i++) {
                if (i == 1) {
                    if (y == 'A') {
                        sel = 0;
                    } else if (y == 'B') {
                        sel = 1;
                    } else if (y == 'C') {
                        sel = 2;
                    } else if (y == 'D') {
                        sel = 3;
                    } else if (y == 'E') {
                        sel = 4;
                    } else if (y == 'F') {
                        sel = 5;
                    } else if (y == 'G') {
                        sel = 6;
                    } else if (y == 'H') {
                        sel = 7;
                    } else if (y == 'I') {
                        sel = 8;
                    } else if (y == 'J') {
                        sel = 9;
                    }
                    BoardR1[sel + 1] = 1;
                } else if (i == 2) {
                    if (y == 'A') {
                        sel = 0;
                    } else if (y == 'B') {
                        sel = 1;
                    } else if (y == 'C') {
                        sel = 2;
                    } else if (y == 'D') {
                        sel = 3;
                    } else if (y == 'E') {
                        sel = 4;
                    } else if (y == 'F') {
                        sel = 5;
                    } else if (y == 'G') {
                        sel = 6;
                    } else if (y == 'H') {
                        sel = 7;
                    } else if (y == 'I') {
                        sel = 8;
                    } else if (y == 'J') {
                        sel = 9;
                    }
                    BoardR2[sel + 1] = 1;
                } else if (i == 3) {
                    if (y == 'A') {
                        sel = 0;
                    } else if (y == 'B') {
                        sel = 1;
                    } else if (y == 'C') {
                        sel = 2;
                    } else if (y == 'D') {
                        sel = 3;
                    } else if (y == 'E') {
                        sel = 4;
                    } else if (y == 'F') {
                        sel = 5;
                    } else if (y == 'G') {
                        sel = 6;
                    } else if (y == 'H') {
                        sel = 7;
                    } else if (y == 'I') {
                        sel = 8;
                    } else if (y == 'J') {
                        sel = 9;
                    }
                    BoardR3[sel + 1] = 1;
                } else if (i == 4) {
                    if (y == 'A') {
                        sel = 0;
                    } else if (y == 'B') {
                        sel = 1;
                    } else if (y == 'C') {
                        sel = 2;
                    } else if (y == 'D') {
                        sel = 3;
                    } else if (y == 'E') {
                        sel = 4;
                    } else if (y == 'F') {
                        sel = 5;
                    } else if (y == 'G') {
                        sel = 6;
                    } else if (y == 'H') {
                        sel = 7;
                    } else if (y == 'I') {
                        sel = 8;
                    } else if (y == 'J') {
                        sel = 9;
                    }
                    BoardR4[sel + 1] = 1;
                } else if (i == 4) {
                    if (y == 'A') {
                        sel = 0;
                    } else if (y == 'B') {
                        sel = 1;
                    } else if (y == 'C') {
                        sel = 2;
                    } else if (y == 'D') {
                        sel = 3;
                    } else if (y == 'E') {
                        sel = 4;
                    } else if (y == 'F') {
                        sel = 5;
                    } else if (y == 'G') {
                        sel = 6;
                    } else if (y == 'H') {
                        sel = 7;
                    } else if (y == 'I') {
                        sel = 8;
                    } else if (y == 'J') {
                        sel = 9;
                    }
                    BoardR5[sel + 1] = 1;
                }
                // Print Cordinates
                System.out.println(i + "," + y);
            }
        } else if (d.equals("horizontal") || d.equals("Horizontal") || d.equals("H") || d.equals("h")) {
            for (char c = y; c < (char) (y + s); c++) {
                if (x == 1) {
                    if (y == 'A') {
                        sel = 0;
                    } else if (c == 'B') {
                        sel = 1;
                    } else if (c == 'C') {
                        sel = 2;
                    } else if (c == 'D') {
                        sel = 3;
                    } else if (c == 'E') {
                        sel = 4;
                    } else if (c == 'F') {
                        sel = 5;
                    } else if (c == 'G') {
                        sel = 6;
                    } else if (c == 'H') {
                        sel = 7;
                    } else if (c == 'I') {
                        sel = 8;
                    } else if (c == 'J') {
                        sel = 9;
                    }
                    BoardR1[sel + 1] = 1;
                } else if (x == 2) {
                    if (c == 'A') {
                        sel = 0;
                    } else if (c == 'B') {
                        sel = 1;
                    } else if (c == 'C') {
                        sel = 2;
                    } else if (c == 'D') {
                        sel = 3;
                    } else if (c == 'E') {
                        sel = 4;
                    } else if (c == 'F') {
                        sel = 5;
                    } else if (c == 'G') {
                        sel = 6;
                    } else if (c == 'H') {
                        sel = 7;
                    } else if (c == 'I') {
                        sel = 8;
                    } else if (c == 'J') {
                        sel = 9;
                    }
                    BoardR2[sel + 1] = 1;
                } else if (x == 3) {
                    if (c == 'A') {
                        sel = 0;
                    } else if (c == 'B') {
                        sel = 1;
                    } else if (c == 'C') {
                        sel = 2;
                    } else if (c == 'D') {
                        sel = 3;
                    } else if (c == 'E') {
                        sel = 4;
                    } else if (c == 'F') {
                        sel = 5;
                    } else if (c == 'G') {
                        sel = 6;
                    } else if (c == 'H') {
                        sel = 7;
                    } else if (c == 'I') {
                        sel = 8;
                    } else if (c == 'J') {
                        sel = 9;
                    }
                    BoardR3[sel + 1] = 1;
                } else if (x == 4) {
                    if (c == 'A') {
                        sel = 0;
                    } else if (c == 'B') {
                        sel = 1;
                    } else if (c == 'C') {
                        sel = 2;
                    } else if (c == 'D') {
                        sel = 3;
                    } else if (c == 'E') {
                        sel = 4;
                    } else if (c == 'F') {
                        sel = 5;
                    } else if (c == 'G') {
                        sel = 6;
                    } else if (c == 'H') {
                        sel = 7;
                    } else if (c == 'I') {
                        sel = 8;
                    } else if (c == 'J') {
                        sel = 9;
                    }
                    BoardR4[sel + 1] = 1;
                } else if (x == 4) {
                    if (c == 'A') {
                        sel = 0;
                    } else if (c == 'B') {
                        sel = 1;
                    } else if (c == 'C') {
                        sel = 2;
                    } else if (c == 'D') {
                        sel = 3;
                    } else if (c == 'E') {
                        sel = 4;
                    } else if (c == 'F') {
                        sel = 5;
                    } else if (c == 'G') {
                        sel = 6;
                    } else if (c == 'H') {
                        sel = 7;
                    } else if (c == 'I') {
                        sel = 8;
                    } else if (c == 'J') {
                        sel = 9;
                    }
                    BoardR5[sel + 1] = 1;
                }

                System.out.println(x + "," + c);
            }
        } else {
            System.err.println("Invalid orientation: " + d);
        }
    }

    // Player 2 Points Finder
    public static void points2(String d, int x, char y, int s) {
        System.out.println("Points starting - ending:");
        if (d.equals("vertical") || d.equals("Vertical") || d.equals("V") || d.equals("v")) {
            for (int i = x; i < x + s; i++) {
                if (i == 1) {
                    if (y == 'A') {
                        sel = 0;
                    } else if (y == 'B') {
                        sel = 1;
                    } else if (y == 'C') {
                        sel = 2;
                    } else if (y == 'D') {
                        sel = 3;
                    } else if (y == 'E') {
                        sel = 4;
                    } else if (y == 'F') {
                        sel = 5;
                    } else if (y == 'G') {
                        sel = 6;
                    } else if (y == 'H') {
                        sel = 7;
                    } else if (y == 'I') {
                        sel = 8;
                    } else if (y == 'J') {
                        sel = 9;
                    }
                    Board2R1[sel + 1] = 1;
                } else if (i == 2) {
                    if (y == 'A') {
                        sel = 0;
                    } else if (y == 'B') {
                        sel = 1;
                    } else if (y == 'C') {
                        sel = 2;
                    } else if (y == 'D') {
                        sel = 3;
                    } else if (y == 'E') {
                        sel = 4;
                    } else if (y == 'F') {
                        sel = 5;
                    } else if (y == 'G') {
                        sel = 6;
                    } else if (y == 'H') {
                        sel = 7;
                    } else if (y == 'I') {
                        sel = 8;
                    } else if (y == 'J') {
                        sel = 9;
                    }
                    Board2R2[sel + 1] = 1;
                } else if (i == 3) {
                    if (y == 'A') {
                        sel = 0;
                    } else if (y == 'B') {
                        sel = 1;
                    } else if (y == 'C') {
                        sel = 2;
                    } else if (y == 'D') {
                        sel = 3;
                    } else if (y == 'E') {
                        sel = 4;
                    } else if (y == 'F') {
                        sel = 5;
                    } else if (y == 'G') {
                        sel = 6;
                    } else if (y == 'H') {
                        sel = 7;
                    } else if (y == 'I') {
                        sel = 8;
                    } else if (y == 'J') {
                        sel = 9;
                    }
                    Board2R3[sel + 1] = 1;
                } else if (i == 4) {
                    if (y == 'A') {
                        sel = 0;
                    } else if (y == 'B') {
                        sel = 1;
                    } else if (y == 'C') {
                        sel = 2;
                    } else if (y == 'D') {
                        sel = 3;
                    } else if (y == 'E') {
                        sel = 4;
                    } else if (y == 'F') {
                        sel = 5;
                    } else if (y == 'G') {
                        sel = 6;
                    } else if (y == 'H') {
                        sel = 7;
                    } else if (y == 'I') {
                        sel = 8;
                    } else if (y == 'J') {
                        sel = 9;
                    }
                    Board2R4[sel + 1] = 1;
                } else if (i == 4) {
                    if (y == 'A') {
                        sel = 0;
                    } else if (y == 'B') {
                        sel = 1;
                    } else if (y == 'C') {
                        sel = 2;
                    } else if (y == 'D') {
                        sel = 3;
                    } else if (y == 'E') {
                        sel = 4;
                    } else if (y == 'F') {
                        sel = 5;
                    } else if (y == 'G') {
                        sel = 6;
                    } else if (y == 'H') {
                        sel = 7;
                    } else if (y == 'I') {
                        sel = 8;
                    } else if (y == 'J') {
                        sel = 9;
                    }
                    Board2R5[sel + 1] = 1;
                }
                // Print Cordinates
                System.out.println(i + "," + y);
            }
        } else if (d.equals("horizontal") || d.equals("Horizontal") || d.equals("H") || d.equals("h")) {
            for (char c = y; c < (char) (y + s); c++) {
                if (x == 1) {
                    if (y == 'A') {
                        sel = 0;
                    } else if (c == 'B') {
                        sel = 1;
                    } else if (c == 'C') {
                        sel = 2;
                    } else if (c == 'D') {
                        sel = 3;
                    } else if (c == 'E') {
                        sel = 4;
                    } else if (c == 'F') {
                        sel = 5;
                    } else if (c == 'G') {
                        sel = 6;
                    } else if (c == 'H') {
                        sel = 7;
                    } else if (c == 'I') {
                        sel = 8;
                    } else if (c == 'J') {
                        sel = 9;
                    }
                    Board2R1[sel + 1] = 1;
                } else if (x == 2) {
                    if (c == 'A') {
                        sel = 0;
                    } else if (c == 'B') {
                        sel = 1;
                    } else if (c == 'C') {
                        sel = 2;
                    } else if (c == 'D') {
                        sel = 3;
                    } else if (c == 'E') {
                        sel = 4;
                    } else if (c == 'F') {
                        sel = 5;
                    } else if (c == 'G') {
                        sel = 6;
                    } else if (c == 'H') {
                        sel = 7;
                    } else if (c == 'I') {
                        sel = 8;
                    } else if (c == 'J') {
                        sel = 9;
                    }
                    Board2R2[sel + 1] = 1;
                } else if (x == 3) {
                    if (c == 'A') {
                        sel = 0;
                    } else if (c == 'B') {
                        sel = 1;
                    } else if (c == 'C') {
                        sel = 2;
                    } else if (c == 'D') {
                        sel = 3;
                    } else if (c == 'E') {
                        sel = 4;
                    } else if (c == 'F') {
                        sel = 5;
                    } else if (c == 'G') {
                        sel = 6;
                    } else if (c == 'H') {
                        sel = 7;
                    } else if (c == 'I') {
                        sel = 8;
                    } else if (c == 'J') {
                        sel = 9;
                    }
                    Board2R3[sel + 1] = 1;
                } else if (x == 4) {
                    if (c == 'A') {
                        sel = 0;
                    } else if (c == 'B') {
                        sel = 1;
                    } else if (c == 'C') {
                        sel = 2;
                    } else if (c == 'D') {
                        sel = 3;
                    } else if (c == 'E') {
                        sel = 4;
                    } else if (c == 'F') {
                        sel = 5;
                    } else if (c == 'G') {
                        sel = 6;
                    } else if (c == 'H') {
                        sel = 7;
                    } else if (c == 'I') {
                        sel = 8;
                    } else if (c == 'J') {
                        sel = 9;
                    }
                    Board2R4[sel + 1] = 1;
                } else if (x == 4) {
                    if (c == 'A') {
                        sel = 0;
                    } else if (c == 'B') {
                        sel = 1;
                    } else if (c == 'C') {
                        sel = 2;
                    } else if (c == 'D') {
                        sel = 3;
                    } else if (c == 'E') {
                        sel = 4;
                    } else if (c == 'F') {
                        sel = 5;
                    } else if (c == 'G') {
                        sel = 6;
                    } else if (c == 'H') {
                        sel = 7;
                    } else if (c == 'I') {
                        sel = 8;
                    } else if (c == 'J') {
                        sel = 9;
                    }
                    Board2R5[sel + 1] = 1;
                }

                System.out.println(x + "," + c);
            }
        } else {
            System.err.println("Invalid orientation: " + d);
        }
    }

    public static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // to check if all values in an array are equal to 2
    public static boolean containsOne(int[] array) {
        for (int value : array) {
            if (value == 1) {
                return true;
            }
        }
        return false;
    }

    public static void player1Board() {
        for (int i = 0; i < BoardLet.length; i++) {
            System.out.print(BoardLet[i] + " ");
        }
        System.out.println(" ");
        for (int i = 0; i < BoardR1.length; i++) {
            System.out.print(BoardR1[i] + " ");
        }
        System.out.println(" ");
        for (int i = 0; i < BoardR2.length; i++) {
            System.out.print(BoardR2[i] + " ");
        }
        System.out.println(" ");
        for (int i = 0; i < BoardR3.length; i++) {
            System.out.print(BoardR3[i] + " ");
        }
        System.out.println(" ");
        for (int i = 0; i < BoardR4.length; i++) {
            System.out.print(BoardR4[i] + " ");
        }
        System.out.println(" ");
        for (int i = 0; i < BoardR5.length; i++) {
            System.out.print(BoardR5[i] + " ");
        }
    }

    public static void player2Board() {
        for (int i = 0; i < BoardLet.length; i++) {
            System.out.print(BoardLet[i] + " ");
        }
        System.out.println(" ");
        for (int i = 0; i < Board2R1.length; i++) {
            System.out.print(Board2R1[i] + " ");
        }
        System.out.println(" ");
        for (int i = 0; i < Board2R2.length; i++) {
            System.out.print(Board2R2[i] + " ");
        }
        System.out.println(" ");
        for (int i = 0; i < Board2R3.length; i++) {
            System.out.print(Board2R3[i] + " ");
        }
        System.out.println(" ");
        for (int i = 0; i < Board2R4.length; i++) {
            System.out.print(Board2R4[i] + " ");
        }
        System.out.println(" ");
        for (int i = 0; i < Board2R5.length; i++) {
            System.out.print(Board2R5[i] + " ");
        }
    }

}
