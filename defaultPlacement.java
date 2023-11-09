public class defaultPlacement {
    static int[] BoardR1 = new int[11];
    static int[] BoardR2 = new int[11];
    static int[] BoardR3 = new int[11];
    static int[] BoardR4 = new int[11];
    static int[] BoardR5 = new int[11];
    static int[] Board2R1 = new int[11];
    static int[] Board2R2 = new int[11];
    static int[] Board2R3 = new int[11];
    static int[] Board2R4 = new int[11];
    static int[] Board2R5 = new int[11];

    public static void defaultPlacement() {
        // Aircraft Carrier
        BoardR1[2] = 1;
        BoardR2[2] = 1;
        BoardR3[2] = 1;
        BoardR4[2] = 1;
        BoardR5[2] = 1;

        // Battleship
        BoardR1[6] = 1;
        BoardR1[7] = 1;
        BoardR1[8] = 1;

        // Submarine
        BoardR1[10] = 1;
        BoardR2[10] = 1;

        // Player 2
        // Airship
        Board2R1[2] = 1;
        Board2R2[2] = 1;
        Board2R3[2] = 1;
        Board2R4[2] = 1;
        Board2R5[2] = 1;

        // Battleship
        Board2R1[6] = 1;
        Board2R1[7] = 1;
        Board2R1[8] = 1;

        // Submarine
        Board2R1[10] = 1;
        Board2R2[10] = 1;
    }
}
