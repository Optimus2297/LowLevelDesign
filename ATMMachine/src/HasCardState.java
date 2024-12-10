import java.util.IdentityHashMap;

public class HasCardState extends ATMState{

    public HasCardState(){
        System.out.println("Enter your pin");
    }

    @Override
    public void validatePin(ATM atm, Card card, int pin) {
        boolean isValid = card.checkPin(pin);
        if(isValid){
            atm.setCurrentATMState(new SelectOperationState());
        }else{
            System.out.println("Invalid Pin");
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
