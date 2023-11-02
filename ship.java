public class ship {
    private String name;
    private int startLocationX;
    private char startLocationY;

    public ship(String n, int locationx, char locationY) {
        name = n;
        startLocationX = locationx;
        startLocationY = locationY;
    }

    public void setName(String newName) {
        name = newName;
    }

    public String getName() {
        return name;
    }

    public void setStartLocationX(int lx) {
        startLocationX = lx;

    }

    public int getStartLocationX() {
        return startLocationX;
    }

    public void setStartLocationY(char ly) {
        startLocationY = ly;
    }

    public char getStartLocationY() {
        return startLocationY;
    }

}