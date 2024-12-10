public abstract class ATMState {

    public void insertCard(ATM atm, Card card){
        System.out.println("Oops!. Something went wrong");
    }


    public void validatePin(ATM atm,Card card, int pin){
        System.out.println("Oops!. Something went wrong");
    }

    public void selectOperation(ATM atm, Card card, TransactionType txnType){
        System.out.println("Oops!. Something went wrong");
    }

    public void cashWithdraw(ATM atm, Card card, int amount){
        System.out.println("Oops!. Something went wrong");
    }

    public void checkBalance(ATM atm, Card card){
        System.out.println("Oops!. Something went wrong");
    }

    public void removeCard(){
        System.out.println("Oops!. Something went wrong");
    }

    public void exit(ATM atm){
        System.out.println("Oops!. Something went wrong");
    }
}
