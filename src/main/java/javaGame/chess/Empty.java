package javaGame.chess;

public class Empty extends Piece{
    Empty() {
        super(null,-1);
    }

    @Override
    boolean isLegalMove(int moveLoc) {
        return false;
    }

    @Override
    boolean isCorrectPieceMove(int rMoveDistance, int fMoveDistance) {
        return false;
    }

    @Override
    public char getSymbol() {
        return 'ㅁ';
    }
}
