public class SelectOperationState extends ATMState{

    public SelectOperationState() {
        System.out.println("Select Operation");
        TransactionType.ShowTransactionTye();
    }

    @Override
    public void selectOperation(ATM atm, Card card, TransactionType txnType) {
        if(txnType.equals(TransactionType.CASH_WITHDRAWAL)){
            atm.setCurrentATMState(new CashWithdrawalState());
        }else if(txnType.equals(TransactionType.CHECK_BALANCE)){
            atm.setCurrentATMState(new CheckBalanceState());
        }
        else{
            exit(atm);
            System.out.println("Invalid Transaction");
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
