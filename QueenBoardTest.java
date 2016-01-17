class QueenBoardTest {
    public static void main(String[] args) {
        try {
            Options options = Options.read(args);
            System.out.printf("Printing all the valid positions for %d queens on a %d by %d board.\n", options.getN(), options.getN(), options.getN());
            QueenBoard queenBoard = new QueenBoard(options);
            queenBoard.printValidPositions();
        } catch (UnrecognizedOptionException e) {
            System.out.printf("Error: %s\n", e.getMessage());
            System.out.printf("Usage: java queens %s\n", Options.getUsageExample());
        }
    }
}
