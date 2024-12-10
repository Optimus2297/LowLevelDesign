public class CashWithdrawalState extends ATMState{

    @Override
    public void cashWithdraw(ATM atm, Card card, int amount) {
        int balance = card.getBankBalance();
        if(atm.getAtmBalance() < amount){
            System.out.println("ATM Balance is low");
            exit(atm);
        }
        else if(balance < amount){
            System.out.println("Account Balance is low");
            exit(atm);
        }else{
            card.deductBankBalance(amount);
            atm.deductAmount(amount);

            CashWidhrawalProcessor withdrawalProcessor = new TwoThousandProcessor(new FiveHundredProcessor(new HundredProcessor(null)));

            withdrawalProcessor.withdraw(atm, amount);
            exit(atm);
        }
    }

    @Override
    public void removeCard() {
        System.out.println("Please collect your card");
    }

    @Override
    public void exit(ATM atm) {
        removeCard();
        atm.setCurrentATMState(new IdleState());
        System.out.println("EXITED");
    }
}
