/*
package javaGame;

import gridFrame.*;

import java.util.HashMap;

class test{
    public static void main(String[] args) {
        GameOfLife g = new GameOfLife();
        g.board.printBoard();
        for (int i = 1 ; i <= 1 ; i++ ) {
            g.nextTurn();
            g.board.printBoard();
        }
    }
}
public class GameOfLife {
    final int X_BOADER = 10 , Y_BOADER = 10;
    GridBoard board;
    HashMap<Integer, Cell> tempBoard = new HashMap<Integer,Cell>();
    public GameOfLife() {
        board = new GridBoard (X_BOADER, Y_BOADER, new Cell() );
    }
    void nextTurn(){
        for (int i = 0 ; i < board.getBoard().size() ; i++){
            cellLive(i);
        }
        for (int i = 0 ; i < board.getBoard().size() ; i++){
            int x = board.toLocation(i)[0];
            int y = board.toLocation(i)[1];
            Cell cell = (Cell) board.getLocatable(x, y);
            cell.isAlive = tempBoard.get(i).isAlive;
        }
    }
    void cellLive(int n){
        int x = n % X_BOADER;
        int y = n / X_BOADER;
        Cell cell = new Cell();
        tempBoard.put(n, cell);
        cell.live(countNeiborhood(x, y));
    }
    int countNeiborhood(int x, int y){
        int count = 0;
        Cell cell = (Cell) board.getLocatable(x, y);
        Cell temp;
        for(int i = -1 ; i <= 1 ; i++){
            for (int j = -1 ; j <= 1 ; j++ ){

                try {
                    temp = (Cell) board.getAnotherLocAble(i, j, cell);
                    if(temp.isAlive) count++;
                } catch (NullPointerException e){}
            }
        }// if문을 9번 돌리는 것보단 나음.
        if(cell.isAlive) count--;
        return count;
    }
}

class Cell extends Square{
    boolean isAlive;
    final boolean LIVE = true;
    final boolean DEATH = false;

    Cell() {isAlive = LIVE;}
    @Override
    public Locatable newObj() {
        return new Cell();
    }

    void live(int neiCount){
        if (isAlive) {
            survive(neiCount);
        } else {
            born(neiCount);
        }
    }
    void survive(int neiCount){
        final boolean IS_SURVIVE = (neiCount == 2 || neiCount == 3);
        isAlive = (IS_SURVIVE) ? LIVE : DEATH;
    }
    void born(int neiCount){
        final boolean IS_BORN = (neiCount == 3);
        isAlive = (IS_BORN) ? LIVE : DEATH;
    }

    @Override
    public char getSymbol() {
        return (isAlive) ? '*' : '-';
    }
}
*/