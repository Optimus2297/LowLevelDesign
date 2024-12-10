public class FiveHundredProcessor extends CashWidhrawalProcessor{

    public FiveHundredProcessor(CashWidhrawalProcessor nextCashWithdrawalProcessor) {
        super(nextCashWithdrawalProcessor);
    }

    @Override
    public void withdraw(ATM atm, int remainingAmt) {
        int required = remainingAmt /500;
        int balance = remainingAmt % 500;

        if(required <= atm.getNoOfFiveHundredNotes()){
            atm.deductFiveHundredNotes(required);
        }else if(required > atm.getNoOfFiveHundredNotes()){
            atm.deductFiveHundredNotes(atm.getNoOfFiveHundredNotes());
            balance = balance + (required - atm.getNoOfFiveHundredNotes()) * 500;
        }

        if(balance != 0){
            super.withdraw(atm, balance);
        }
    }
}
