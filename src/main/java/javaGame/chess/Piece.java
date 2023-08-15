package javaGame.chess;
public abstract class Piece {

    private int location;

    public enum Team {WHITE, BLACK;}

    Team team;

    Piece (Team team, int location) {
        this.team = team;
        setLoc(location);
    }

    boolean isLegalMove (int moveLoc){
        int rMoveDistance = getDistance(Board.toRank(location), Board.toRank(moveLoc)); //수정필요
        int fMoveDistance = getDistance(Board.toFile(location), Board.toFile(moveLoc));
        return isCorrectPieceMove(rMoveDistance, fMoveDistance);
    }
    abstract boolean isCorrectPieceMove(int rMoveDistance, int fMoveDistance);


    int getLoc () {return location;}
    void setLoc(int location) {
        this.location = location;
    }

    static int getDistance (int origin, int moved) {
        return Math.abs(origin - moved);
    }

    public abstract char getSymbol();
    @Override
    public String toString() {
        return "Piece{" +
                "team=" + team + ", " + getClass().toString() +
                '}';
    }
}