package javaGame.chess;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Board board = new Board();
        Rule rule = new Rule(board);
        ChessProgressManager cpm = new ChessProgressManager(board, rule, sc);

        cpm.defaltPieceSetting();


        int answer = 1;
        int turn = 0;
        while (answer == 1) {
            board.printBoard();
            if (turn % 2 == 1) {
                cpm.halfMoveProgress(Piece.Team.WHITE);

            } else {
                cpm.halfMoveProgress(Piece.Team.BLACK);
            }
            turn ++;

        }
    }

}

class ChessProgressManager {
    Board board;
    Rule rule;
    Scanner sc;

    void placeNewPieceFactory(char name , Piece.Team team, int loc) {
        Piece newPiece;

        switch (name) { // 후에 enum으로 개선
            case 'P' -> newPiece = new Pawn(team, loc);
            case 'B' -> newPiece = new Bishop(team, loc);
            case 'N' -> newPiece = new Knight(team, loc);
            case 'R' -> newPiece = new Rook(team, loc);
            case 'Q' -> newPiece = new Queen(team, loc);
            case 'K' -> newPiece = new King(team, loc);

            default -> throw new IllegalStateException("Unexpected value: " + name);
        }
        newPiece.setLoc(loc);
        board.setPiece(newPiece, loc);
    }

    void defaltPieceSetting () {
        placeNewPieceFactory('P', Piece.Team.BLACK, board.toIndex(1, 0));
        placeNewPieceFactory('P', Piece.Team.BLACK, board.toIndex(1, 1));
        placeNewPieceFactory('P', Piece.Team.BLACK, board.toIndex(1, 2));
        placeNewPieceFactory('P', Piece.Team.BLACK, board.toIndex(1, 3));
        placeNewPieceFactory('P', Piece.Team.BLACK, board.toIndex(1, 4));
        placeNewPieceFactory('P', Piece.Team.BLACK, board.toIndex(1, 5));
        placeNewPieceFactory('P', Piece.Team.BLACK, board.toIndex(1, 6));
        placeNewPieceFactory('P', Piece.Team.BLACK, board.toIndex(1, 7));

        placeNewPieceFactory('R', Piece.Team.BLACK, board.toIndex(0, 0));
        placeNewPieceFactory('N', Piece.Team.BLACK, board.toIndex(0, 1));
        placeNewPieceFactory('B', Piece.Team.BLACK, board.toIndex(0, 2));
        placeNewPieceFactory('Q', Piece.Team.BLACK, board.toIndex(0, 3));
        placeNewPieceFactory('K', Piece.Team.BLACK, board.toIndex(0, 4));
        placeNewPieceFactory('B', Piece.Team.BLACK, board.toIndex(0, 5));
        placeNewPieceFactory('N', Piece.Team.BLACK, board.toIndex(0, 6));
        placeNewPieceFactory('R', Piece.Team.BLACK, board.toIndex(0, 7));

        placeNewPieceFactory('P', Piece.Team.WHITE, board.toIndex(6, 0));
        placeNewPieceFactory('P', Piece.Team.WHITE, board.toIndex(6, 1));
        placeNewPieceFactory('P', Piece.Team.WHITE, board.toIndex(6, 2));
        placeNewPieceFactory('P', Piece.Team.WHITE, board.toIndex(6, 3));
        placeNewPieceFactory('P', Piece.Team.WHITE, board.toIndex(6, 4));
        placeNewPieceFactory('P', Piece.Team.WHITE, board.toIndex(6, 5));
        placeNewPieceFactory('P', Piece.Team.WHITE, board.toIndex(6, 6));

        placeNewPieceFactory('P', Piece.Team.WHITE, board.toIndex(6, 7));
        placeNewPieceFactory('R', Piece.Team.WHITE, board.toIndex(7, 0));
        placeNewPieceFactory('N', Piece.Team.WHITE, board.toIndex(7, 1));
        placeNewPieceFactory('B', Piece.Team.WHITE, board.toIndex(7, 2));
        placeNewPieceFactory('Q', Piece.Team.WHITE, board.toIndex(7, 3));
        placeNewPieceFactory('K', Piece.Team.WHITE, board.toIndex(7, 4));
        placeNewPieceFactory('B', Piece.Team.WHITE, board.toIndex(7, 5));
        placeNewPieceFactory('N', Piece.Team.WHITE, board.toIndex(7, 6));
        placeNewPieceFactory('R', Piece.Team.WHITE, board.toIndex(7, 7));
    }
    ChessProgressManager (Board board, Rule rule, Scanner sc) {
        this.board = board;
        this.rule = rule;
        this.sc = sc;
    }

    void halfMoveProgress (Piece.Team team) {

        System.out.println(team.name() + " turn");// piece 선택
        System.out.println("insert piece's rank.");
        int originRank = sc.nextInt() - 1;
        System.out.println("insert piece's file.");
        int originFile = sc.nextInt() - 1;

        Piece moveTarget = board.getPiece(originRank, originFile);
        if ( moveTarget.team != team ||  moveTarget.team == null ) { // 고른 piece가 합법적인지 확인
            System.out.println("illegal piece choose, choose another one");
            System.out.println("Team: " + moveTarget + ", R[" + originRank + "] F[" + originFile + "]");

            halfMoveProgress(team);

        } else {

            System.out.println("Team: " + moveTarget + ", R[" + originRank + "] F[" + originFile + "]");

            System.out.println("insert square where you go");// 움직일 곳 정하기
            System.out.println("insert rank.");
            int movedRank = sc.nextInt() - 1;
            System.out.println("insert file.");
            int movedFile = sc.nextInt() - 1;

            int movedIndex = board.toIndex(movedRank, movedFile);
            movePiece(movedIndex, board.getPiece(originRank, originFile));
        }
    }

    void movePiece (int location, Piece p){
        if( rule.canMove(p, location) ) {
            System.out.println("from " + p.getLoc()+ ", to " + location);

            board.setPiece(p, location);
            board.setPiece(new Empty(), p.getLoc());
            p.setLoc(location);

        } else {
                System.out.println("You can't move from" + board.toRank(p.getLoc()) + ", " + board.toFile(p.getLoc())+
                        " to " + board.toRank(location) + ", " + board.toFile(location));
        }
    }
}
