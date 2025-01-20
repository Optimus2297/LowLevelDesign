import java.util.*;

public class Game {
    private Queue<Player> players;
    Board board;
    Dice dice;

    public Game() {
       board = new Board(10,5,6);
       dice = new Dice(1);
       Player p1 = new Player(0,1);
       Player p2 = new Player(0,2);
       players = new LinkedList<>();
       players.add(p1);
       players.add(p2);
    }

    public Player play(){
        while(true){
            Player curr = players.poll();
            System.out.println("Current player is: " + curr.getId() + "current position is: " + curr.getPosition());
            int diceCount = dice.rollDice();

            int playerNewPosition = curr.getPosition() + diceCount;
            playerNewPosition = jumpCheck(playerNewPosition);
            curr.setPosition(playerNewPosition);
            System.out.println("player turn is:" + curr.getId() + " new Position is: " + playerNewPosition);

            if(curr.getPosition() >= board.board.length * board.board.length-1){
                return curr;
            }

            players.add(curr);
        }
    }

    public int jumpCheck(int playerPosition){
        if(playerPosition > board.board.length * board.board.length-1){
            return playerPosition;
        }
        Cell cell = board.getCell(playerPosition);
        if(cell.jump != null && cell.jump.start == playerPosition){
            String jumpBy = (cell.jump.start < cell.jump.end)? "Snake" : "Ladder";
            System.out.println("jump done by: " + jumpBy);
            return cell.jump.end;
        }
        return playerPosition;
    }
}
