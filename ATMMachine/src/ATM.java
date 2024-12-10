public class ATM {
    private static ATM atmMachine = new ATM();

    private ATM(){};

    ATMState currentATMState;

    private int atmBalance;
    int noOfTwoThousandNotes;
    int noOfFiveHundredNotes;
    int noOfOneHundredNotes;

    public void setCurrentATMState(ATMState currentATMState) {
        this.currentATMState = currentATMState;
    }

    public ATMState getCurrentATMState(){
        return this.currentATMState;
    }

    public static ATM getAtmMachine(){
        atmMachine.setCurrentATMState(new IdleState());
        return atmMachine;
    }

    public void setAtmBalance(int atmBalance, int noOfFiveHundredNotes, int noOfOneHundredNotes, int noOfTwoThousandNotes){
        this.atmBalance = atmBalance;
        this.noOfFiveHundredNotes = noOfFiveHundredNotes;
        this.noOfTwoThousandNotes = noOfTwoThousandNotes;
        this.noOfOneHundredNotes = noOfOneHundredNotes;
    }

    public void deductAmount(int amount){
        this.atmBalance -= amount;
    }

    public void deductTwoThousandNotes(int number) {
        noOfTwoThousandNotes = noOfTwoThousandNotes - number;
    }

    public void deductFiveHundredNotes(int number) {
        noOfFiveHundredNotes = noOfFiveHundredNotes - number;
    }

    public void deductOneHundredNotes(int number) {
        noOfOneHundredNotes = noOfOneHundredNotes - number;
    }

    public int getAtmBalance() {
        return atmBalance;
    }

    public int getNoOfTwoThousandNotes() {
        return noOfTwoThousandNotes;
    }

    public int getNoOfFiveHundredNotes() {
        return noOfFiveHundredNotes;
    }

    public int getNoOfOneHundredNotes() {
        return noOfOneHundredNotes;
    }

    public void printCurrentATMStatus(){
        System.out.println("Balance: " + atmBalance);
        System.out.println("2kNotes: " + noOfTwoThousandNotes);
        System.out.println("500Notes: " + noOfFiveHundredNotes);
        System.out.println("100Notes: " + noOfOneHundredNotes);

    }
}
