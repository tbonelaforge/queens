class UnrecognizedOptionException extends Exception {
    public UnrecognizedOptionException() {
        super();
    }

    public UnrecognizedOptionException(String message) {
        super(message);
    }

    public UnrecognizedOptionException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnrecognizedOptionException(Throwable cause) {
        super(cause);
    }
}
