class QueenBoard {
    private int n;

    private int[] a;

    private int level;

    private boolean isCountOnly;

    private boolean[] columns;

    private boolean[] leftDiagonals;

    private boolean[] rightDiagonals;

    public QueenBoard(int n) {
        this(n, false);
    }

    public QueenBoard(Options options) {
        this(options.getN(), options.isCountOnly());
    }

    public QueenBoard(int n, boolean isCountOnly) {
        this.n = n;
        this.isCountOnly = isCountOnly;
        this.a = new int[n];
        this.columns = new boolean[n];
        this.leftDiagonals = new boolean[2 * n - 1];
        this.rightDiagonals = new boolean[2 * n - 1];
    }

    public void printValidPositions() {
        int count = 0;

        level = 1;
        while (level > 0) {
            if (testPredicate()) {
                if (level >= n) {
                    count += 1;
                    if (!isCountOnly) {
                        prettyPrintCurrentPositions();
                    }
                    tryNextPosition();
                } else {
                    setBooleans(level - 1, true);
                    level += 1;
                }
            } else {
                tryNextPosition();
            }
        }
        System.out.printf("Found %d valid configurations\n", count);
    }

    private boolean testPredicate() {
        int i = level - 1;

        if (columns[columnIndex(i)]) {
            return false;
        }
        if (leftDiagonals[leftDiagonalIndex(i)]) {
            return false;
        }
        if (rightDiagonals[rightDiagonalIndex(i)]) {
            return false;
        }
        return true;
    }

    private void printCurrentPositions() {
        System.out.print("[");
        for (int i = 0; i < a.length; i++) {
            System.out.printf("%d", a[i]);
            if (i < a.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    private QueenBoard tryNextPosition() {
        while (level > 0 && incrementPosition(level - 1) == null) {
            resetPosition(level - 1);
            level -= 1;
            if (level >= 1) {
                setBooleans(level - 1, false);
            }
        }
        return this;
    }

    private QueenBoard incrementPosition(int i) {
        if (a[i] < n - 1) {
            a[i] += 1;
            return this;
        }
        return null;
    }

    private QueenBoard resetPosition(int i) {
        a[i] = 0;
        return this;
    }

    private void setBooleans(int i, boolean value) {
        columns[columnIndex(i)] = value;
        leftDiagonals[leftDiagonalIndex(i)] = value;
        rightDiagonals[rightDiagonalIndex(i)] = value;
    }

    private int columnIndex(int i) {
        return a[i];
    }

    private int leftDiagonalIndex(int i) {
        return i + columnIndex(i);
    }

    private int rightDiagonalIndex(int i) {
        return i - columnIndex(i) + n - 1;
    }

    private void prettyPrintCurrentPositions() {
        printHorizontalLine();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("|");
                if (a[i] == j) {
                    System.out.print(" * ");
                } else {
                    System.out.print("   ");
                }
            }
            System.out.println("|");
            printHorizontalLine();
        }
        System.out.printf("\n\n");
    }

    private void printHorizontalLine() {
        for (int i = 0; i < 4 * n; i++) {
            System.out.print("-");
        }
        System.out.println("-");
    }
}
