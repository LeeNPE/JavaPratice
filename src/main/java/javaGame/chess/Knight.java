package javaGame.chess;

public class Knight extends Piece{

    Knight(Team team, int location) {
        super(team, location);
    }

    @Override
    boolean isCorrectPieceMove(int rMoveDistance, int fMoveDistance) {

        return (rMoveDistance == 2 && fMoveDistance == 1
                || rMoveDistance == 1 && fMoveDistance == 2);

    }

    @Override
    public char getSymbol() {
        return 'N';
    }
}
