package javaGame.chess;
public abstract class Piece {

    public enum Team {WHITE, BLACK;}

    Team team;

    Piece (Team team) {
        this.team = team;
    }

    abstract boolean isLegalMove (int rMoveDistance, int fMoveDistance);
    static int GET_DISTANCE (int origin, int moved) {
        return Math.abs(origin - moved);
    }

    public abstract char getSymbol();

}