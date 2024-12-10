public enum TransactionType {
    CASH_WITHDRAWAL,
    CHECK_BALANCE;

    public static void ShowTransactionTye(){
        for(TransactionType t: TransactionType.values()){
            System.out.println(t.name());
        }
    }
}
