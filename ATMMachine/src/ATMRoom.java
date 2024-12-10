public class ATMRoom {

    ATM atm;
    User user;

    public static void main(String[] args) {
        ATMRoom atmRoom = new ATMRoom();
        atmRoom.initialize();

        atmRoom.atm.printCurrentATMStatus();
        atmRoom.atm.getCurrentATMState().insertCard(atmRoom.atm, atmRoom.user.getCard());
        atmRoom.atm.getCurrentATMState().validatePin(atmRoom.atm, atmRoom.user.getCard(), 1234);
        atmRoom.atm.getCurrentATMState().selectOperation(atmRoom.atm, atmRoom.user.getCard(), TransactionType.CASH_WITHDRAWAL);
        atmRoom.atm.getCurrentATMState().cashWithdraw(atmRoom.atm, atmRoom.user.getCard(), 2700);
        atmRoom.atm.printCurrentATMStatus();
    }
    private void initialize() {

        //create ATM
        atm = ATM.getAtmMachine();
        atm.setAtmBalance(3500, 2,5,1);

        //create User
        this.user = createUser();
    }

    private User createUser(){

        User user = new User();
        user.setCard(createCard());
        return user;
    }

    private Card createCard(){

        Card card = new Card();
        card.setBankAccount(createBankAccount());
        return card;
    }

    private UserBankAccount createBankAccount() {

        UserBankAccount bankAccount = new UserBankAccount();
        bankAccount.balance = 3000;

        return bankAccount;

    }

}