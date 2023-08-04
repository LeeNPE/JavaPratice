package javaGame.chess;

public class Pawn extends Piece{

    private boolean isMoved;

    private int moveDirection;

    final int FIRST_MOVE_DISTANCE = 2;

    Pawn(Team team) {
        super(team);

        if(team == Team.WHITE) {
            moveDirection = 1;
        } else if (team == Team.BLACK) {
            moveDirection = -1;
        }


    }

    @Override
    boolean isLegalMove(int rMoveDistance, int fMoveDistance) {

        boolean isMoveOneRank = (rMoveDistance == moveDirection && fMoveDistance == 0);
        boolean isMoveTwoRank = (rMoveDistance == FIRST_MOVE_DISTANCE * moveDirection && fMoveDistance == 0);

        return (isMoveOneRank ||
                ! isMoved && isMoveTwoRank);
    }

    @Override
    public char getSymbol() {
        return 'P';
    }
}
