import java.time.LocalDateTime;

public class Card {
    private int cardNumber;
    private int cvv;
    static int PIN_NUMBER = 1234;
    private String expiryDate;
    private String holderName;
    private UserBankAccount bankAccount;

    public boolean checkPin(int pin){
        return PIN_NUMBER == pin;
    }

    public int getBankBalance(){
        return bankAccount.balance;
    }

    public void deductBankBalance(int amount){
        bankAccount.withdrawalBalance(amount);
    }

    public void setBankAccount(UserBankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

}
