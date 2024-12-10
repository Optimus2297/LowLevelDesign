public class CashWidhrawalProcessor {
    private CashWidhrawalProcessor nextCashWithdrawalProcessor;

    public CashWidhrawalProcessor(CashWidhrawalProcessor nextCashWithdrawalProcessor) {
        this.nextCashWithdrawalProcessor = nextCashWithdrawalProcessor;
    }

    public void withdraw(ATM atm, int remainingAmt){
        if(nextCashWithdrawalProcessor != null){
            nextCashWithdrawalProcessor.withdraw(atm, remainingAmt);
        }
    }
}
