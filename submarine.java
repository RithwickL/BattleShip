public class submarine extends ship {
    final int size = 2;
    private String orientation;
    private int endLocationX;
    private char endLocationY;

    public submarine(String name, int xs, char ys, String orient, int endX, char endY) {
        super(name, xs, ys);
        orientation = orient;
        endLocationX = endX;
        endLocationY = endY;

    }

    public submarine(String name, int xs, char ys, String orient) {
        super(name, xs, ys);
        orientation = orient;

    }

    public void setOrientation(String orient) {
        orientation = orient;

    }

    public String getOrientation() {
        return orientation;
    }

    public void setEndLocationX(int elx) {
        endLocationX = elx;

    }

    public int getEndLocationX() {
        return endLocationX;
    }

    public void setEndLocationY(char ely) {
        endLocationY = ely;

    }

    public char getEndLocationY() {
        return endLocationY;
    }

}