import java.util.Scanner;

class Ship {
    private String name;
    private int xLocation;
    private char yLocation;

    public Ship(String name, int xLocation, char yLocation) {
        this.name = name;
        this.xLocation = xLocation;
        this.yLocation = yLocation;
    }

    public void setName(String newName) {
        name = newName;
    }

    public String getName() {
        return name;
    }

    public void setXLocation(int newXLocation) {
        xLocation = newXLocation;
    }

    public int getXLocation() {
        return xLocation;
    }

    public void setYLocation(char newYLocation) {
        yLocation = newYLocation;
    }

    public char getYLocation() {
        return yLocation;
    }

    public void printEndCoordinates() {
        System.out.println("End Coordinates: (" + xLocation + ", " + yLocation + ")");
    }
}

class Battleship extends Ship {
    private int size;
    private String orientation;
    private int endXLocation;
    private int endYLocation;
    private int CalcY;

    public Battleship(String name, int xLocation, char yLocation, String orientation) {
        super(name, xLocation, yLocation);
        this.size = 3;
        this.orientation = orientation;
        calculateEndLocation();

    }

    public int getSize() {
        return size;
    }

    public String getOrientation() {
        return orientation;
    }

    public int getEndXLocation() {
        return endXLocation;
    }

    public int getEndYLocation() {
        return endYLocation;
    }

    private void calculateEndLocation() {

        switch (getYLocation()) {
            case 'A':
                CalcY = 1;
                break;
            case 'B':
                CalcY = 2;
                break;
            case 'C':
                CalcY = 3;
                break;
            case 'D':
                CalcY = 4;
                break;
            case 'E':
                CalcY = 5;
                break;
            case 'F':
                CalcY = 6;
                break;
            case 'G':
                CalcY = 7;
                break;
            default:
                CalcY = 0; // Default value for characters not in the mapping
                break;
        }

        if (orientation == "Vertical") {
            endXLocation = getXLocation() + size - 1;
            endYLocation = getYLocation();
        } else if (orientation == "Horizontal") {
            endXLocation = getXLocation();
            endYLocation = (CalcY + size - 1);
        }
    }

    public void printEndCoordinates() {
        System.out.println("End Coordinates: (" + getEndXLocation() + ", " + getEndYLocation() + ")");
    }
}

class Submarine extends Ship {
    private int size;
    private String orientation;
    private int endXLocation;
    private int endYLocation;
    private int CalcY;

    public Submarine(String name, int xLocation, char yLocation, String orientation) {
        super(name, xLocation, yLocation);
        this.size = 2;
        this.orientation = orientation;
        calculateEndLocation();
    }

    public int getSize() {
        return size;
    }

    public String getOrientation() {
        return orientation;
    }

    public int getEndXLocation() {
        return endXLocation;
    }

    public int getEndYLocation() {
        return endYLocation;
    }

    private void calculateEndLocation() {

        switch (getYLocation()) {
            case 'A':
                CalcY = 1;
                break;
            case 'B':
                CalcY = 2;
                break;
            case 'C':
                CalcY = 3;
                break;
            case 'D':
                CalcY = 4;
                break;
            case 'E':
                CalcY = 5;
                break;
            case 'F':
                CalcY = 6;
                break;
            case 'G':
                CalcY = 7;
                break;
            default:
                CalcY = 0; // Default value for characters not in the mapping
                break;
        }

        if (orientation == "Vertical") {
            endXLocation = getXLocation() + size - 1;
            endYLocation = getYLocation();
        } else if (orientation == "Horizontal") {
            endXLocation = getXLocation();
            endYLocation = (CalcY + size - 1);
        }
    }

    public void printEndCoordinates() {
        System.out.println("End Coordinates: (" + getEndXLocation() + ", " + getEndYLocation() + ")");
    }
}

class AircraftCarrier extends Ship {
    private int size;
    private String orientation;
    private int endXLocation;
    private int endYLocation;
    private int CalcY;

    public AircraftCarrier(String name, int xLocation, char yLocation, String orientation) {
        super(name, xLocation, yLocation);
        this.size = 5;
        this.orientation = orientation;
        calculateEndLocation();
    }

    public int getSize() {
        return size;
    }

    public String getOrientation() {
        return orientation;
    }

    public int getEndXLocation() {
        return endXLocation;
    }

    public int getEndYLocation() {
        return endYLocation;
    }

    private void calculateEndLocation() {

        switch (getYLocation()) {
            case 'A':
                CalcY = 1;
                break;
            case 'B':
                CalcY = 2;
                break;
            case 'C':
                CalcY = 3;
                break;
            case 'D':
                CalcY = 4;
                break;
            case 'E':
                CalcY = 5;
                break;
            case 'F':
                CalcY = 6;
                break;
            case 'G':
                CalcY = 7;
                break;
            default:
                CalcY = 0; // Default value for characters not in the mapping
                break;
        }

        if (orientation == "Vertical") {
            endXLocation = getXLocation() + size - 1;
            endYLocation = getYLocation();
        } else if (orientation == "Horizontal") {
            endXLocation = getXLocation();
            endYLocation = (CalcY + size - 1);
        }
    }

    public void printEndCoordinates() {
        System.out.println("End Coordinates: (" + getEndXLocation() + ", " + getEndYLocation() + ")");
    }
}

class ShipPlacement {
    public static void placeShips() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Place an Aircraft Carrier");
        System.out.print("Name of Aircraft Carrier: ");
        String acName = scanner.nextLine();
        System.out.print("X Location: ");
        int acX = scanner.nextInt();
        System.out.print("Y Location: ");
        char acY = scanner.next().charAt(0);
        System.out.print("Orientation choose (Vertical/Horizontal): ");
        String acOrientation = scanner.next();

        AircraftCarrier ac = new AircraftCarrier(acName, acX, acY, acOrientation);

        System.out.println("Place 2 Battleships");
        System.out.print("Name of Battleship: ");
        String bName = scanner.next();
        System.out.print("X Location: ");
        int bX = scanner.nextInt();
        System.out.print("Y Location: ");
        char bY = scanner.next().charAt(0);
        System.out.print("Orientation choose (Vertical/Horizontal): ");
        String bOrientation = scanner.next();

        Battleship b = new Battleship(bName, bX, bY, bOrientation);

        System.out.print("Name of Second Battleship: ");
        String b2Name = scanner.next();
        System.out.print("X Location: ");
        int b2X = scanner.nextInt();
        System.out.print("Y Location: ");
        char b2Y = scanner.next().charAt(0);
        System.out.print("Orientation choose (Vertical/Horizontal): ");
        String b2Orientation = scanner.next();

        Battleship b2 = new Battleship(b2Name, b2X, b2Y, b2Orientation);

        System.out.println("Please place a Submarine:");
        System.out.print("Name of Submarine: ");
        String sName = scanner.next();
        System.out.print("X Location: ");
        int sX = scanner.nextInt();
        System.out.print("Y Location: ");
        char sY = scanner.next().charAt(0);
        System.out.print("Orientation choose (Vertical/Horizontal): ");
        String sOrientation = scanner.next();

        Submarine s = new Submarine(sName, sX, sY, sOrientation);

        // You can now access the details of each ship if needed.
        System.out.println("Ships placed successfully!");

        ac.printEndCoordinates();
        b.printEndCoordinates();
        b2.printEndCoordinates();
        s.printEndCoordinates();
    }
}

public class MainShip_DNE {
    public static void main(String[] args) {
        ShipPlacement.placeShips();
    }
}
