import java.io.IOException;
import java.util.Scanner;

public class battleshipRunner {
    static int Globalx;
    static char Globaly;
    // Arrays to store ship information
    static String[] shipNames = new String[6];
    static int[] shipXVals = new int[6];
    static char[] shipYVals = new char[6];
    static String[] shipOrientations = new String[6];
    static int[] BoardC1 = new int[11];
    static int[] BoardC2 = new int[11];
    static int[] BoardC3 = new int[11];
    static int[] BoardC4 = new int[11];
    static int[] BoardC5 = new int[11];
    static int[] Board2C1 = new int[11];
    static int[] Board2C2 = new int[11];
    static int[] Board2C3 = new int[11];
    static int[] Board2C4 = new int[11];
    static int[] Board2C5 = new int[11];
    static String[] BoardLet = new String[11];
    static int sel;

    public static void main(String[] args) {
        playersInputs();
    }

    public static void battle() {
        clearConsole();

    }

    public static void playersInputs() {
        String inputY;
        String name;
        int Xval;
        char Yval;
        String Ori;

        // Fill the arrays with "0"
        for (int i = 0; i < BoardC1.length; i++) {
            BoardC1[i] = 0;
            Board2C1[i] = 0;
        }

        for (int i = 0; i < BoardC2.length; i++) {
            BoardC2[i] = 0;
            Board2C2[i] = 0;
        }

        for (int i = 0; i < BoardC3.length; i++) {
            BoardC3[i] = 0;
            Board2C3[i] = 0;
        }

        for (int i = 0; i < BoardC4.length; i++) {
            BoardC4[i] = 0;
            Board2C4[i] = 0;
        }

        for (int i = 0; i < BoardC5.length; i++) {
            BoardC5[i] = 0;
            Board2C5[i] = 0;
        }
        BoardC1[0] = 1;
        BoardC2[0] = 2;
        BoardC3[0] = 3;
        BoardC4[0] = 4;
        BoardC5[0] = 5;
        Board2C1[0] = 1;
        Board2C2[0] = 2;
        Board2C3[0] = 3;
        Board2C4[0] = 4;
        Board2C5[0] = 5;
        BoardLet[0] = " ";
        BoardLet[1] = "A";
        BoardLet[2] = "B";
        BoardLet[3] = "C";
        BoardLet[4] = "D";
        BoardLet[5] = "E";
        BoardLet[6] = "F";
        BoardLet[7] = "G";
        BoardLet[8] = "H";
        BoardLet[9] = "I";
        BoardLet[10] = "J";
        try (Scanner info = new Scanner(System.in)) {
            clearConsole();
            System.out.println("Do you want to place the ships on your own. If so type Yes(Y) or type anything else to set default placement");
            String answer = info.nextLine();
            if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")) {
                clearConsole();

                System.out.println("Player 1 you need to make three ships in total. (An Aircraft Carrier, Submarine and Battleship)");

                System.out.println("Now Printing Player 1 Board, 0 = No Ship Exists On Spot and 1 = Ship Exists On Spot");
                System.out.println(" ");
                for (int i = 0; i < BoardLet.length; i++) {
                    System.out.print(BoardLet[i] + " ");
                }
                System.out.println(" ");
                for (int i = 0; i < BoardC1.length; i++) {
                    System.out.print(BoardC1[i] + " ");
                }
                System.out.println(" ");
                for (int i = 0; i < BoardC2.length; i++) {
                    System.out.print(BoardC2[i] + " ");
                }
                System.out.println(" ");
                for (int i = 0; i < BoardC3.length; i++) {
                    System.out.print(BoardC3[i] + " ");
                }
                System.out.println(" ");
                for (int i = 0; i < BoardC4.length; i++) {
                    System.out.print(BoardC4[i] + " ");
                }
                System.out.println(" ");
                for (int i = 0; i < BoardC5.length; i++) {
                    System.out.print(BoardC5[i] + " ");
                }

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

                while (true) {
                    System.out.println("What is your starting Y position (A-J)? Use capital letters");
                    inputY = info.nextLine().toUpperCase();

                    if (inputY.length() != 1) {
                        System.out.println("Invalid input. Please enter a single character (A-J).");
                        continue;
                    }

                    Yval = inputY.charAt(0);

                    if (Yval >= 'A' && Yval <= 'J') {
                        shipYVals[0] = Yval;
                        break;
                    } else {
                        System.out.println("Invalid input. Please enter a single character (A-J)");
                    }

                    while (true) {
                        System.out.println("Do you want it to be Vertical or Horizontal?");
                        Ori = info.nextLine();

                        if (Ori.equalsIgnoreCase("vertical") || Ori.equalsIgnoreCase("horizontal")) {
                            shipOrientations[0] = Ori;
                            break;
                        } else {
                            System.out.println("Invalid input. Please enter Vertical or Horizontal");
                        }
                    }

                    aircraftCarrier A1 = new aircraftCarrier(name, Xval, Yval, Ori);
                    points(Ori, Xval, Yval, A1.size);
                    System.out.println("*******************************************");

                    System.out
                            .println(
                                    "Now Printing Player 1 Board, 0 = No Ship Exists On Spot and 1 = Ship Exists On Spot");
                    System.out.println(" ");
                    for (int i = 0; i < BoardLet.length; i++) {
                        System.out.print(BoardLet[i] + " ");
                    }
                    System.out.println(" ");
                    for (int i = 0; i < BoardC1.length; i++) {
                        System.out.print(BoardC1[i] + " ");
                    }
                    System.out.println(" ");
                    for (int i = 0; i < BoardC2.length; i++) {
                        System.out.print(BoardC2[i] + " ");
                    }
                    System.out.println(" ");
                    for (int i = 0; i < BoardC3.length; i++) {
                        System.out.print(BoardC3[i] + " ");
                    }
                    System.out.println(" ");
                    for (int i = 0; i < BoardC4.length; i++) {
                        System.out.print(BoardC4[i] + " ");
                    }
                    System.out.println(" ");
                    for (int i = 0; i < BoardC5.length; i++) {
                        System.out.print(BoardC5[i] + " ");
                    }

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

                    while (true) {
                        System.out.println("What is your starting Y position (A-J)? Use capital letters");
                        inputY = info.nextLine().toUpperCase();

                        if (inputY.length() != 1) {
                            System.out.println("Invalid input. Please enter a single character (A-J).");
                            continue;
                        }

                        Yval = inputY.charAt(0);

                        if (Yval >= 'A' && Yval <= 'J') {
                            shipYVals[1] = Yval;
                            break;
                        } else {
                            System.out.println("Invalid input. Please enter a single character (A-J)");
                        }

                        while (true) {
                            System.out.println("Do you want it to be Vertical or Horizontal?");
                            Ori = info.nextLine();

                            if (Ori.equalsIgnoreCase("vertical") || Ori.equalsIgnoreCase("horizontal")) {
                                shipOrientations[1] = Ori;
                                break;
                            } else {
                                System.out.println("Invalid input. Please enter Vertical or Horizontal");
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
                        for (int i = 0; i < BoardC1.length; i++) {
                            System.out.print(BoardC1[i] + " ");
                        }
                        System.out.println(" ");
                        for (int i = 0; i < BoardC2.length; i++) {
                            System.out.print(BoardC2[i] + " ");
                        }
                        System.out.println(" ");
                        for (int i = 0; i < BoardC3.length; i++) {
                            System.out.print(BoardC3[i] + " ");
                        }
                        System.out.println(" ");
                        for (int i = 0; i < BoardC4.length; i++) {
                            System.out.print(BoardC4[i] + " ");
                        }
                        System.out.println(" ");
                        for (int i = 0; i < BoardC5.length; i++) {
                            System.out.print(BoardC5[i] + " ");
                        }

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

                        while (true) {
                            System.out.println("What is your starting Y position (A-J)? Use capital letters");
                            inputY = info.nextLine().toUpperCase();

                            if (inputY.length() != 1) {
                                System.out.println("Invalid input. Please enter a single character (A-J).");
                                continue;
                            }

                            Yval = inputY.charAt(0);

                            if (Yval >= 'A' && Yval <= 'J') {
                                shipYVals[2] = Yval;
                                break;
                            } else {
                                System.out.println("Invalid input. Please enter a single character (A-J)");
                            }

                            while (true) {
                                System.out.println("Do you want it to be Vertical or Horizontal?");
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
                            for (int i = 0; i < BoardLet.length; i++) {
                                System.out.print(BoardLet[i] + " ");
                            }
                            System.out.println(" ");
                            for (int i = 0; i < BoardC1.length; i++) {
                                System.out.print(BoardC1[i] + " ");
                            }
                            System.out.println(" ");
                            for (int i = 0; i < BoardC2.length; i++) {
                                System.out.print(BoardC2[i] + " ");
                            }
                            System.out.println(" ");
                            for (int i = 0; i < BoardC3.length; i++) {
                                System.out.print(BoardC3[i] + " ");
                            }
                            System.out.println(" ");
                            for (int i = 0; i < BoardC4.length; i++) {
                                System.out.print(BoardC4[i] + " ");
                            }
                            System.out.println(" ");
                            for (int i = 0; i < BoardC5.length; i++) {
                                System.out.print(BoardC5[i] + " ");
                            }

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
                            for (int i = 0; i < BoardLet.length; i++) {
                                System.out.print(BoardLet[i] + " ");
                            }
                            System.out.println(" ");
                            for (int i = 0; i < Board2C1.length; i++) {
                                System.out.print(Board2C1[i] + " ");
                            }
                            System.out.println(" ");
                            for (int i = 0; i < Board2C2.length; i++) {
                                System.out.print(Board2C2[i] + " ");
                            }
                            System.out.println(" ");
                            for (int i = 0; i < Board2C3.length; i++) {
                                System.out.print(Board2C3[i] + " ");
                            }
                            System.out.println(" ");
                            for (int i = 0; i < Board2C4.length; i++) {
                                System.out.print(Board2C4[i] + " ");
                            }
                            System.out.println(" ");
                            for (int i = 0; i < Board2C5.length; i++) {
                                System.out.print(Board2C5[i] + " ");
                            }

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

                            while (true) {
                                System.out.println("What is your starting Y position (A-J)? Use capital letters");
                                inputY = info.nextLine().toUpperCase();

                                if (inputY.length() != 1) {
                                    System.out.println("Invalid input. Please enter a single character (A-J).");
                                    continue;
                                }

                                Yval = inputY.charAt(0);

                                if (Yval >= 'A' && Yval <= 'J') {
                                    shipYVals[3] = Yval;
                                    break;
                                } else {
                                    System.out.println("Invalid input. Please enter a single character (A-J)");
                                }

                                while (true) {
                                    System.out.println("Do you want it to be Vertical or Horizontal?");
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
                                for (int i = 0; i < BoardLet.length; i++) {
                                    System.out.print(BoardLet[i] + " ");
                                }
                                System.out.println(" ");
                                for (int i = 0; i < Board2C1.length; i++) {
                                    System.out.print(Board2C1[i] + " ");
                                }
                                System.out.println(" ");
                                for (int i = 0; i < Board2C2.length; i++) {
                                    System.out.print(Board2C2[i] + " ");
                                }
                                System.out.println(" ");
                                for (int i = 0; i < Board2C3.length; i++) {
                                    System.out.print(Board2C3[i] + " ");
                                }
                                System.out.println(" ");
                                for (int i = 0; i < Board2C4.length; i++) {
                                    System.out.print(Board2C4[i] + " ");
                                }
                                System.out.println(" ");
                                for (int i = 0; i < Board2C5.length; i++) {
                                    System.out.print(Board2C5[i] + " ");
                                }

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

                                while (true) {
                                    System.out.println("What is your starting Y position (A-J)? Use capital letters");
                                    inputY = info.nextLine().toUpperCase();

                                    if (inputY.length() != 1) {
                                        System.out.println("Invalid input. Please enter a single character (A-J).");
                                        continue;
                                    }

                                    Yval = inputY.charAt(0);

                                    if (Yval >= 'A' && Yval <= 'J') {
                                        shipYVals[4] = Yval;
                                        break;
                                    } else {
                                        System.out.println("Invalid input. Please enter a single character (A-J)");
                                    }

                                    while (true) {
                                        System.out.println("Do you want it to be Vertical or Horizontal?");
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
                                    for (int i = 0; i < BoardLet.length; i++) {
                                        System.out.print(BoardLet[i] + " ");
                                    }
                                    System.out.println(" ");
                                    for (int i = 0; i < Board2C1.length; i++) {
                                        System.out.print(Board2C1[i] + " ");
                                    }
                                    System.out.println(" ");
                                    for (int i = 0; i < Board2C2.length; i++) {
                                        System.out.print(Board2C2[i] + " ");
                                    }
                                    System.out.println(" ");
                                    for (int i = 0; i < Board2C3.length; i++) {
                                        System.out.print(Board2C3[i] + " ");
                                    }
                                    System.out.println(" ");
                                    for (int i = 0; i < Board2C4.length; i++) {
                                        System.out.print(Board2C4[i] + " ");
                                    }
                                    System.out.println(" ");
                                    for (int i = 0; i < Board2C5.length; i++) {
                                        System.out.print(Board2C5[i] + " ");
                                    }

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

                                    while (true) {
                                        System.out
                                                .println("What is your starting Y position (A-J)? Use capital letters");
                                        inputY = info.nextLine().toUpperCase();

                                        if (inputY.length() != 1) {
                                            System.out.println("Invalid input. Please enter a single character (A-J).");
                                            continue;
                                        }

                                        Yval = inputY.charAt(0);

                                        if (Yval >= 'A' && Yval <= 'J') {
                                            shipYVals[5] = Yval;
                                            break;
                                        } else {
                                            System.out.println("Invalid input. Please enter a single character (A-J)");
                                        }

                                        while (true) {
                                            System.out.println("Do you want it to be Vertical or Horizontal?");
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
                                        for (int i = 0; i < BoardLet.length; i++) {
                                            System.out.print(BoardLet[i] + " ");
                                        }
                                        System.out.println(" ");
                                        for (int i = 0; i < Board2C1.length; i++) {
                                            System.out.print(Board2C1[i] + " ");
                                        }
                                        System.out.println(" ");
                                        for (int i = 0; i < Board2C2.length; i++) {
                                            System.out.print(Board2C2[i] + " ");
                                        }
                                        System.out.println(" ");
                                        for (int i = 0; i < Board2C3.length; i++) {
                                            System.out.print(Board2C3[i] + " ");
                                        }
                                        System.out.println(" ");
                                        for (int i = 0; i < Board2C4.length; i++) {
                                            System.out.print(Board2C4[i] + " ");
                                        }
                                        System.out.println(" ");
                                        for (int i = 0; i < Board2C5.length; i++) {
                                            System.out.print(Board2C5[i] + " ");
                                        }

                                        // Clear Question
                                        System.out.println(" ");
                                        System.out.println("Press Enter to clear console and move to the game");
                                    }

                                    // Wait for Enter and clear console
                                    try {
                                        System.in.read();
                                        clearConsole();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        }
                    }
                }
            } else {
                // Pull default file for ships
                System.out.println("Default placement was used!");
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
                    BoardC1[sel + 1] = 1;
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
                    BoardC2[sel + 1] = 1;
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
                    BoardC3[sel + 1] = 1;
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
                    BoardC4[sel + 1] = 1;
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
                    BoardC5[sel + 1] = 1;
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
                    BoardC1[sel + 1] = 1;
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
                    BoardC2[sel + 1] = 1;
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
                    BoardC3[sel + 1] = 1;
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
                    BoardC4[sel + 1] = 1;
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
                    BoardC5[sel + 1] = 1;
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
                    Board2C1[sel + 1] = 1;
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
                    Board2C2[sel + 1] = 1;
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
                    Board2C3[sel + 1] = 1;
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
                    Board2C4[sel + 1] = 1;
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
                    Board2C5[sel + 1] = 1;
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
                    Board2C1[sel + 1] = 1;
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
                    Board2C2[sel + 1] = 1;
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
                    Board2C3[sel + 1] = 1;
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
                    Board2C4[sel + 1] = 1;
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
                    Board2C5[sel + 1] = 1;
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
}