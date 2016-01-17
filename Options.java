class Options {

    private static final String errorTemplate = "Unrecognized Option: %s\n";

    private final String[] originalArgs;

    private int n = 4;

    private boolean countOnly = false;

    public static String getUsageExample() {
        return "--count-only 8";
    }

    public static Options read (String[] args) throws UnrecognizedOptionException {
        Options options = new Options(args);
        return options.parse();
    }

    public Options(String[] args) {
        this.originalArgs = args;
    }

    public int getN() {
        return n;
    }

    public boolean isCountOnly() {
        return countOnly;
    }

    private Options parse() throws UnrecognizedOptionException {
        for (int i = 0; i < originalArgs.length; i++) {
            String thisArg = originalArgs[i];
            handleArg(thisArg);
        }
        return this;
    }

    private void handleArg(String arg) throws UnrecognizedOptionException {
        if (arg.equals("--count-only")) {
            countOnly = true;
        } else {
            try {
                n = Integer.parseInt(arg);
                return;
            } catch (Exception e) {
                String message = String.format(errorTemplate, arg);
                throw new UnrecognizedOptionException(message, e);
            }
        }
    }
}
