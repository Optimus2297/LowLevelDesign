public class HundredProcessor extends CashWidhrawalProcessor{

    public HundredProcessor(CashWidhrawalProcessor nextCashWithdrawalProcessor) {
        super(nextCashWithdrawalProcessor);
    }

    @Override
    public void withdraw(ATM atm, int remainingAmt) {
        int required = remainingAmt /100;
        int balance = remainingAmt % 100;

        if(required <= atm.getNoOfOneHundredNotes()){
            atm.deductOneHundredNotes(required);
        }else if(required > atm.getNoOfOneHundredNotes()){
            atm.deductOneHundredNotes(atm.getNoOfOneHundredNotes());
            balance = balance + (required - atm.getNoOfOneHundredNotes()) * 100;
        }

        if(balance != 0){
            super.withdraw(atm, balance);
        }
    }
}
