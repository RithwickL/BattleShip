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

        try (Scanner info = new Scanner(System.in)) {
            System.out.println(
                    "Player 1 you need to make three ships in total. (An Aircraft Carrier, Submarine and Battleship)");

            // Aircraft
            System.out.println("You will first make an Aircraft Carrier.");

            System.out.println("What is the name of the Aircraft Carrier");
            name = info.nextLine();

            System.out.println("What is your starting X position (Please use an int 1-10)?");
            Xval = info.nextInt();

            System.out.println("What is your starting Y position (A-J)?");
            inputY = info.nextLine();
            inputY = info.nextLine();
            Yval = inputY.charAt(0);

            System.out.println("Do you want it to be Vertical or Horizontal?");
            Ori = info.nextLine();

            aircraftCarrier A1 = new aircraftCarrier(name, Xval, Yval, Ori);
            endPoints(Ori, Xval, Yval, A1.size);
            System.out.println("*******************************************");

            // Battleship
            System.out.println("You will now make a Battleship.");

            System.out.println("What is the name of the Battleship");
            name = info.nextLine();

            System.out.println("What is your starting X position (Please use an int 1-10)?");
            Xval = info.nextInt();

            System.out.println("What is your starting Y position (A-J)?");
            inputY = info.nextLine();
            inputY = info.nextLine();
            Yval = inputY.charAt(0);

            System.out.println("Do you want it to be Vertical or Horizontal?");
            Ori = info.nextLine();

            battleship B1 = new battleship(name, Xval, Yval, Ori);
            endPoints(Ori, Xval, Yval, B1.size);
            System.out.println("*******************************************");

            // Submarine
            System.out.println("You will now make a Submarine.");

            System.out.println("What is the name of the Submarine");
            name = info.nextLine();

            System.out.println("What is your starting X position (Please use an int 1-10)?");
            Xval = info.nextInt();

            System.out.println("What is your starting Y position (A-J)?");
            inputY = info.nextLine();
            inputY = info.nextLine();
            Yval = inputY.charAt(0);

            System.out.println("Do you want it to be Vertical or Horizontal?");
            Ori = info.nextLine();

            submarine S1 = new submarine(name, Xval, Yval, Ori);
            endPoints(Ori, Xval, Yval, S1.size);
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

    public static void endPoints(String d, int x, char y, int s) {
        if (d.equals("vertical") || d.equals("Vertical")) {
            Globalx = s + x;
            System.out.println("End Points: " + Globalx + "," + y);
        } else if (d.equals("horizontal") || d.equals("Horizontal")) {
            Globaly = (char) (y + s);
            System.out.println("End Points: " + x + "," + Globaly);
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
