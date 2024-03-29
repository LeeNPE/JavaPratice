package javaGame.chess;

public class Board {
    private Piece[] pieces;
    public static final int RANK_SIZE = 8; // 가로
    public static final int FILE_SIZE = 8; // 세로

    final char emptySymbol = '+';

    public Board(){
        pieces = new Piece[ RANK_SIZE * FILE_SIZE ];
    }

    public Piece[] getPieces() {
        return pieces;
    }
    public Piece getPiece (int rank, int file) {
        return getPiece(toIndex(rank, file));
    }
    public Piece getPiece (int index) {
        return pieces[index];
    }

    /**
     * @param newPiece make the piece move to (rank, file).
     */
    public void setPiece (Piece newPiece ,int rank, int file) {
        setPiece(newPiece, toIndex(rank, file) );
    }
    /**
     * @param newPiece make the piece move to (rank, file).
     */
    public void setPiece (Piece newPiece, int index) {
        pieces[index] = newPiece;
    }


    public void printBoard() {
        Piece piece;
        for (int i = 0 ; i < RANK_SIZE ; i++) {
            for (int j = 0 ; j < FILE_SIZE ; j++) {
                //System.out.println("i = " + i + ", j = " + j + ", index = " + toIndex(i, j) );
                piece = pieces[toIndex(i, j)];
                System.out.print( (piece != null) ? piece.getSymbol() : emptySymbol );
            }

            System.out.println();
        }
    }

    public static int toIndex(int rank, int file) {
        if (rank >= RANK_SIZE || rank < 0) throw new RuntimeException() ;
        if (file >= FILE_SIZE || file < 0) throw new RuntimeException();
        return rank * FILE_SIZE + file;
    }

    public static int toRank (int index) {
        return index / FILE_SIZE;
    }
    public static int toFile (int index) {
        return index % FILE_SIZE;
    }
}
