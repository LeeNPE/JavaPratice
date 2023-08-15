package javaGame.chess;

public class King extends Piece{

    King(Team team, int location) {
        super(team, location);
    }

    @Override
    boolean  isCorrectPieceMove(int rMoveDistance, int fMoveDistance){

        boolean onPlace = (rMoveDistance == 0 && fMoveDistance == 0);

        return (rMoveDistance <= 1 && fMoveDistance <= 1
                && !onPlace);
    }

    @Override
    public char getSymbol() {
        return 'K';
    }
}
