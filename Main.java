class Main {

    public static void main(String[] args) {
        try {
            // Simulating an exception
            throw new NumberFormatException("Invalid number format");
        } catch (NumberFormatException e) {
            // Wrapping the caught exception with a custom one
            throw new RuntimeException("Error processing input", e);
        }
    }
}