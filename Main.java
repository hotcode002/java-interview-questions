class Main {

    public static void main(String[] args) {
        try {
            System.out.println("In try block");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            throw new RuntimeException("Exception from finally block");
        }
    }
}