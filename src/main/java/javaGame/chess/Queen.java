package javaGame.chess;

public class Queen extends Piece{

    Queen(Team team, int location) {
        super(team, location);
    }

    @Override
    boolean isCorrectPieceMove(int rMoveDistance, int fMoveDistance){

        boolean bishopMove =  new Bishop(team, getLoc() ).isCorrectPieceMove(rMoveDistance, fMoveDistance);
        boolean RookMove = new Rook(team, getLoc()).isCorrectPieceMove(rMoveDistance, fMoveDistance);

        return bishopMove || RookMove;
    }

    @Override
    public char getSymbol() {
        return 'Q';
    }
}
