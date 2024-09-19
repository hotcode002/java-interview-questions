class Account {
    int number;
}

/** Another class in the same package */
class CurrentAccount extends Account {
    // This class has access to `number` variable
   
}

class Main {

    public static void main (String[] args){
        Account account = new Account();
        account.number = 1;
        System.out.println(account.number);
    }
}