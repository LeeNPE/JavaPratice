package javaGame.chess;

public class Pawn extends Piece{

    private boolean isFirst;

    private int moveDirection;

    final int FIRST_MOVE_DISTANCE = 2;

    Pawn(Team team) {
        super(team);

        isFirst = true;
        if(team == Team.WHITE) {
            moveDirection = -1;
        } else if (team == Team.BLACK) {
            moveDirection = 1;
        }

        moveDirection = 1;


    }

    @Override
    boolean isLegalMove(int rMoveDistance, int fMoveDistance) {
        if (fMoveDistance != 0) {
            System.out.println("your pawn run away from file = " + fMoveDistance);
            return false;
        }

        boolean isMoveOneRank = (rMoveDistance == moveDirection);
        boolean isMoveTwoRank = (rMoveDistance == FIRST_MOVE_DISTANCE * moveDirection);

        if (isFirst) {
            if (isMoveOneRank || isMoveTwoRank) {
                isFirst = false;
                return true;
            }
            else {
                System.out.println("You can move 1 or 2 rank, but distance = " +  rMoveDistance);
                return false;
            }
        } else {
            if (isMoveOneRank) {
                return true;
            } else {
                System.out.println("You can move only 1 rank, but distance = " +  rMoveDistance);
                return false;
            }

        }
    }

    @Override
    public char getSymbol() {
        return 'P';
    }
}
