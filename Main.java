class Account {
    public int number;
}

class CurrentAccount extends Account {
    // This class has access to `number` variable
   
}

class Main {

    public static void main (String[] args){
        CurrentAccount account = new CurrentAccount();
        account.number = 1;
        System.out.println(account.number);
    }
}