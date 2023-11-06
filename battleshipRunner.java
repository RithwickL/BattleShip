import java.io.IOException;
import java.util.Scanner;

public class battleshipRunner {
    static int Globalx;
    static char Globaly;

    public static void main(String[] args) {
        String inputY;
        String name;
        int Xval;
        char Yval;
        String Ori;

        // Arrays to store ship information
        String[] shipNames = new String[3];
        int[] shipXVals = new int[3];
        char[] shipYVals = new char[3];
        String[] shipOrientations = new String[3];
        String[] BoardC1 = new String[9];
        String[] BoardC2 = new String[9];
        String[] BoardC3 = new String[9];
        String[] BoardC4 = new String[9];
        String[] BoardC5 = new String[9];

        try (Scanner info = new Scanner(System.in)) {
            System.out.println(
                    "Player 1 you need to make three ships in total. (An Aircraft Carrier, Submarine and Battleship)");

            // Aircraft
            System.out.println("You will first make an Aircraft Carrier.");

            System.out.println("What is the name of the Aircraft Carrier");
            name = info.nextLine();
            shipNames[0] = name;

            System.out.println("What is your starting X position (Please use an int 1-10)?");
            Xval = info.nextInt();
            shipXVals[0] = Xval;

            System.out.println("What is your starting Y position (A-J)?");
            inputY = info.nextLine();
            inputY = info.nextLine();
            Yval = inputY.charAt(0);
            shipYVals[0] = Yval;

            System.out.println("Do you want it to be Vertical or Horizontal?");
            Ori = info.nextLine();
            shipOrientations[0] = Ori;

            aircraftCarrier A1 = new aircraftCarrier(name, Xval, Yval, Ori);
            points(Ori, Xval, Yval, A1.size);
            System.out.println("*******************************************");

            // Battleship
            System.out.println("You will now make a Battleship.");

            System.out.println("What is the name of the Battleship");
            name = info.nextLine();
            shipNames[1] = name;

            System.out.println("What is your starting X position (Please use an int 1-10)?");
            Xval = info.nextInt();
            shipXVals[1] = Xval;

            System.out.println("What is your starting Y position (A-J)?");
            inputY = info.nextLine();
            inputY = info.nextLine();
            Yval = inputY.charAt(0);
            shipYVals[1] = Yval;

            System.out.println("Do you want it to be Vertical or Horizontal?");
            Ori = info.nextLine();
            shipOrientations[1] = Ori;

            battleship B1 = new battleship(name, Xval, Yval, Ori);
            points(Ori, Xval, Yval, B1.size);
            System.out.println("*******************************************");

            // Submarine
            System.out.println("You will now make a Submarine.");

            System.out.println("What is the name of the Submarine");
            name = info.nextLine();
            shipNames[2] = name;

            System.out.println("What is your starting X position (Please use an int 1-10)?");
            Xval = info.nextInt();
            shipXVals[2] = Xval;

            System.out.println("What is your starting Y position (A-J)?");
            inputY = info.nextLine();
            inputY = info.nextLine();
            Yval = inputY.charAt(0);
            shipYVals[2] = Yval;

            System.out.println("Do you want it to be Vertical or Horizontal?");
            Ori = info.nextLine();
            shipOrientations[2] = Ori;

            submarine S1 = new submarine(name, Xval, Yval, Ori);
            points(Ori, Xval, Yval, S1.size);
            System.out.println("*******************************************");

            // Clear Question
            System.out.println("Press Enter to clear console and move to Player 2");

            // Wait for Enter and clear console
            try {
                System.in.read();
                clearConsole();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void points(String d, int x, char y, int s) {
        System.out.println("Points between the starting and ending points:");

        if (d.equals("vertical") || d.equals("Vertical")) {
            for (int i = x; i < x + s; i++) {
                System.out.println(i + "," + y);
            }
        } else if (d.equals("horizontal") || d.equals("Horizontal")) {
            for (char c = y; c < (char) (y + s); c++) {
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
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
