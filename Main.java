class Account {
    private int number;
}

class CurrentAccount extends Account {
    private int accNumber = number;
}

class Main {

    public static void main (String[] args){
        CurrentAccount account = new CurrentAccount();
    }
}