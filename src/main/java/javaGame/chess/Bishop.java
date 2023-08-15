package javaGame.chess;

public class Bishop extends Piece {

    Bishop(Team team, int location) {
        super(team, location);
    }

    @Override
    boolean isCorrectPieceMove(int rMoveDistance, int fMoveDistance){

        boolean onPlace = (rMoveDistance == 0 && fMoveDistance == 0);

        return (rMoveDistance == fMoveDistance
        && !onPlace);

    }

    @Override
    public char  getSymbol() {
        return 'B';
    }
}
