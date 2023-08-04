package javaGame.chess;

public class Queen extends Piece{

    Queen(Team team) {
        super(team);
    }

    @Override
    boolean isLegalMove(int rMoveDistance, int fMoveDistance) {

        boolean bishopMove =  new Bishop(team).isLegalMove(rMoveDistance, fMoveDistance);
        boolean RookMove = new Rook(team).isLegalMove(rMoveDistance, fMoveDistance);

        return bishopMove || RookMove;
    }

    @Override
    public char getSymbol() {
        return 'Q';
    }
}
