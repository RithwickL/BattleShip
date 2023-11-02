import java.util.*;

public class battleshipRunner {
    static int Globalx;
    static char Globaly;

    public static void main(String[] args) {
        String temp = "";
        String input = "";
        int input2;
        char input3 = 'A';
        String input4 = "";
        try (Scanner info = new Scanner(System.in)) {
            System.out
                    .println(
                            "You need to make four ships in total.(1 Aircraft Carrier, One Submarine and 2 Battleships)");
            System.out.println("You will first make an aircraft carrier.");

            System.out.println("What is the name of the aircraft carrier");
            input = info.nextLine();

            System.out.println("What is your starting x position(Please use an int 1-10)?");
            input2 = info.nextInt();

            System.out.println("What is your starting y position(A-J)?");
            temp = info.nextLine();
            temp = info.nextLine();
            input3 = temp.charAt(0);

            System.out.println("Do you want it to be vertical or horizontal?");
            input4 = info.nextLine().toLowerCase();

            aircraftCarrier jack = new aircraftCarrier(input, input2, input3, input4);
            endPoints(input4, input2, input3, jack.size);
            System.out.println("******************");

            System.out.println("You will now make a Battleship.");

            System.out.println("What is the name of the Battleship");
            input = info.nextLine();

            System.out.println("Do you want it to be vertical or horizontal");
            input4 = info.nextLine().toLowerCase();

            System.out.println("What is your starting x position(Please use an int 1-10)");
            input2 = info.nextInt();

            System.out.println("What is your starting y position(Please use an character A-J)");
            temp = info.nextLine();
            temp = info.nextLine();
            input3 = temp.charAt(0);

            battleship james = new battleship(input, input2, input3, input4);
            endPoints(input4, input2, input3, james.size);
            System.out.println("******************");

            System.out.println("You will now make a second Battleship.");

            System.out.println("What is the name of the Battleship");
            input = info.nextLine();

            System.out.println("What is your starting x position(Please use an int 1-10)");
            input2 = info.nextInt();

            System.out.println("What is your starting y position(Please use an character A-J)");
            temp = info.nextLine();
            temp = info.nextLine();
            input3 = temp.charAt(0);

            System.out.println("Do you want it to be vertical or horizontal?");
            input4 = info.nextLine().toLowerCase();

            battleship jame = new battleship(input, input2, input3, input4);
            endPoints(input4, input2, input3, jame.size);
            System.out.println("******************");

            System.out.println("You will now make a Submarine.");

            System.out.println("What is the name of the Submarine");
            input = info.nextLine();

            System.out.println("What is your starting x position(Please use an int 1-10)");
            input2 = info.nextInt();

            System.out.println("What is your starting y position(Please use an character A-J)");
            temp = info.nextLine();
            temp = info.nextLine();
            input3 = temp.charAt(0);

            System.out.println("Do you want it to be vertical or horizontal");
            input4 = info.nextLine().toLowerCase();
        }

        submarine steve = new submarine(input, input2, input3, input4);
        endPoints(input4, input2, input3, steve.size);
        System.out.println("******************");

    }

    public static void endPoints(String d, int x, char y, int s) {
        if (d.equals("vertical")) {
            Globalx = s + x;
            System.out.println("End Points: " + Globalx + "," + y);
        } else if (d.equals("horizontal")) {
            Globaly = (char) (y + s);
            System.out.println("End Points: " + x + "," + Globaly);
        } else {

            System.err.println("Invalid orientation: " + d);

        }
    }
}