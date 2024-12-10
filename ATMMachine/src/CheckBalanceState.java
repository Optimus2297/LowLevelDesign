public class CheckBalanceState extends ATMState{

    public CheckBalanceState() {
    }

    @Override
    public void checkBalance(ATM atm, Card card) {
        System.out.println("your Balance is " + card.getBankBalance());
        exit(atm);
    }

    @Override
    public void exit(ATM atmObject){
        removeCard();
        atmObject.setCurrentATMState(new IdleState());
        System.out.println("Exit happens");
    }

    @Override
    public void removeCard(){
        System.out.println("Please collect your card");
    }

}
