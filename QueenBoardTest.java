class QueenBoardTest {
    public static void main(String[] args) {
        int n = 4;
        if (args.length == 1) {
            n = Integer.parseInt(args[0]);
        }
        System.out.printf("Printing all the valid positions for %d queens on a %d by %d board.\n", n, n, n);
        QueenBoard queenBoard = new QueenBoard(n);
        queenBoard.printValidPositions();
    }
}
