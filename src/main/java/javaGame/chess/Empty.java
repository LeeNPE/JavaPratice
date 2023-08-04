package javaGame.chess;

public class Empty extends Piece{
    Empty() {
        super(null);
    }

    @Override
    boolean isLegalMove(int rMoveDistance, int fMoveDistance) {
        return false;
    }

    @Override
    public char getSymbol() {
        return 'ㅁ';
    }
}
