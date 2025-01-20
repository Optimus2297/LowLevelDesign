import java.util.concurrent.ThreadLocalRandom;

public class Board {
    Cell[][] board;

    public Board(int boardSize, int noOfSnakes, int noOfLadders) {
        inilialize(boardSize);
        addSnakesAndLadders(board, noOfLadders, noOfSnakes);
    }

    public void inilialize(int n){
        board = new Cell[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                Cell cell = new Cell();
                board[i][j] = cell;
            }
        }
    }

    public void addSnakesAndLadders(Cell[][] board, int noOfLadders, int noOfSnakes){
        while(noOfSnakes > 0) {
            int snakeHead = ThreadLocalRandom.current().nextInt(1,board.length*board.length-1);
            int snakeTail = ThreadLocalRandom.current().nextInt(1,board.length*board.length-1);
            if(snakeTail >= snakeHead) {
                continue;
            }

            Jump snakeObj = new Jump();
            snakeObj.start = snakeHead;
            snakeObj.end = snakeTail;

            Cell cell = getCell(snakeHead);
            cell.jump = snakeObj;

            noOfSnakes--;
        }

        while(noOfLadders > 0) {
            int ladderStart = ThreadLocalRandom.current().nextInt(1,board.length*board.length-1);
            int ladderEnd = ThreadLocalRandom.current().nextInt(1,board.length*board.length-1);
            if(ladderStart >= ladderEnd) {
                continue;
            }

            Jump ladderObj = new Jump();
            ladderObj.start = ladderStart;
            ladderObj.end = ladderEnd;

            Cell cell = getCell(ladderStart);
            cell.jump = ladderObj;

            noOfLadders--;
        }

    }

    public Cell getCell(int cell){
        int x=cell/10;
        int y = cell%10;
        return board[x][y];
    }
}
