package javaGame.chess;

public class Knight extends Piece{

    Knight(Team team) {
        super(team);
    }

    @Override
    boolean isLegalMove(int rMoveDistance, int fMoveDistance) {

        return (rMoveDistance == 2 && fMoveDistance == 1
                || rMoveDistance == 1 && fMoveDistance == 2);

    }

    @Override
    public char getSymbol() {
        return 'N';
    }
}
