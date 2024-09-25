class Main {

    public static void main(String[] args) {
        try{
            String str = null;
            System.out.println(str.length()); // Causes NullPointerException
        }catch(NullPointerException e){
            System.out.println(e);
        }
    }
}