class QueenBoard {
    private int n;

    private int[] a;

    private int level;

    public QueenBoard(int n) {
        this.n = n;
        this.a = new int[n];
    }

    public void printValidPositions() {
        level = 1;
        while (level > 0) {
            if (testPredicate()) {
                if (level >= n) {
                    prettyPrintCurrentPositions();
                    System.out.println("\n");
                    tryNextPosition();
                } else {
                    level += 1;
                }
            } else {
                tryNextPosition();
            }
        }
    }

    private boolean testPredicate() {
        int j = level - 1;
        for (int i = 0; i < j; i++) {
            if (a[i] == a[j]) {
                return false;
            }
            if (Math.abs(a[j] - a[i]) == j - i) {
                return false;
            }
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
    }

    private void printHorizontalLine() {
        for (int i = 0; i < 4 * n; i++) {
            System.out.print("-");
        }
        System.out.println("-");
    }
}
