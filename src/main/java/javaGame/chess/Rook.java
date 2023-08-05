package javaGame.chess;

public class Rook extends Piece {

    Rook(Team team) {
        super(team);
    }

    @Override
    boolean isLegalMove(int rMoveDistance, int fMoveDistance) {

        boolean onPlace = (rMoveDistance == 0 && fMoveDistance == 0);

        return (rMoveDistance == 0 || fMoveDistance == 0
                && !onPlace);

    }

    @Override
    public char getSymbol() {
        return 'R';
    }
}
