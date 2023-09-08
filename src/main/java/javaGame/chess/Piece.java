package javaGame.chess;
public class Piece {

    private int location;

    public enum Team {WHITE, BLACK;}

    Team team;

    public enum Type{
        PAWN,
        BISHOP,
        KNIGHT,
        ROOK,
        QUEEN,
        KING
    }
    Type type;

    Piece (Team team, int location, Type type) {

        this.team = team;
        setLoc(location);
        this.type = type;
    }

    int getLoc () {return location;}
    void setLoc(int location) {
        this.location = location;
    }

    public char getSymbol() {
        char symbol;
        switch (type) {
            case PAWN -> symbol = 'P';
            case BISHOP -> symbol = 'B';
            case KNIGHT -> symbol = 'N';
            case ROOK -> symbol = 'R';
            case QUEEN -> symbol = 'Q';
            case KING -> symbol = 'K';
            default -> symbol = 'O';
        }
        return symbol;
    }
    @Override
    public String toString() {
        return "Piece{" +
                "team=" + team + ", " + type +
                '}';
    }
}