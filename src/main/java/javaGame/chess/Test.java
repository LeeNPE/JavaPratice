package javaGame.chess;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Board board = new Board();
        Piece wKing = null, bKing = null;
        Rule rule = new Rule(board, new Piece[]{wKing, bKing});
        ChessProgressManager cpm = new ChessProgressManager(board, rule, sc);

        cpm.defaltPieceSetting(wKing, bKing);


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

    /**
     *
     * @return king's location
     */
    void defaltPieceSetting(Piece wKing, Piece bKing){
        board.setPiece(new Piece(Piece.Team.BLACK, 0, Piece.Type.ROOK) , 0);
        board.setPiece(new Piece(Piece.Team.BLACK, 1, Piece.Type.KNIGHT) , 1);
        board.setPiece(new Piece(Piece.Team.BLACK, 2, Piece.Type.BISHOP) , 2);
        board.setPiece(new Piece(Piece.Team.BLACK, 3, Piece.Type.QUEEN) , 3);
        bKing = new Piece(Piece.Team.BLACK, 4, Piece.Type.KING);
        board.setPiece(bKing , 4);
        board.setPiece(new Piece(Piece.Team.BLACK, 5, Piece.Type.BISHOP) , 5);
        board.setPiece(new Piece(Piece.Team.BLACK, 6, Piece.Type.KNIGHT) , 6);
        board.setPiece(new Piece(Piece.Team.BLACK, 7, Piece.Type.ROOK) , 7);
        for (int i = 0 ; i < 8 ; i++) {
            board.setPiece(new Piece(Piece.Team.BLACK, i + 8, Piece.Type.PAWN) , i + 8);
        }

        board.setPiece(new Piece(Piece.Team.WHITE, 56 + 0, Piece.Type.ROOK) , 56 + 0);
        board.setPiece(new Piece(Piece.Team.WHITE, 56 + 1, Piece.Type.KNIGHT) , 56 + 1);
        board.setPiece(new Piece(Piece.Team.WHITE, 56 + 2, Piece.Type.BISHOP) , 56 + 2);
        board.setPiece(new Piece(Piece.Team.WHITE, 56 + 3, Piece.Type.QUEEN) , 56 + 3);
        wKing = new Piece(Piece.Team.WHITE, 56 + 4, Piece.Type.KING);
        board.setPiece(wKing, 56 + 4);
        board.setPiece(new Piece(Piece.Team.WHITE, 56 + 5, Piece.Type.BISHOP) , 56 + 5);
        board.setPiece(new Piece(Piece.Team.WHITE, 56 + 6, Piece.Type.KNIGHT) , 56 + 6);
        board.setPiece(new Piece(Piece.Team.WHITE, 56 + 7, Piece.Type.ROOK) , 56 + 7);
        for (int i = 0 ; i < 8 ; i++) {
            board.setPiece(new Piece(Piece.Team.WHITE, i + 48, Piece.Type.PAWN) , i + 48);
        }
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
        if (moveTarget == null || moveTarget.team != team) { // 고른 piece가 합법적인지 확인
            System.out.println("illegal piece choose, choose another one");
            System.out.println("Team: " + moveTarget + ", R[" + originRank + "] F[" + originFile + "]");

            halfMoveProgress(team);

        } else {

            System.out.println(moveTarget + ", (rank, file) = (" + originRank + "," + originFile + ")");

            System.out.println("insert square where you go");// 움직일 곳 정하기
            System.out.println("insert rank.");
            int movedRank = sc.nextInt() - 1;
            System.out.println("insert file.");
            int movedFile = sc.nextInt() - 1;

            int moveIndex = board.toIndex(movedRank, movedFile);
            if(rule.canMove(moveTarget, moveIndex)) {
                movePiece(moveIndex, board.getPiece(originRank, originFile));
            } else halfMoveProgress(team);

        }
    }

    void movePiece (int location, Piece p){

        System.out.println("from " + p.getLoc()+ ", to " + location);
        board.setPiece(p, location);
        board.setPiece(null, p.getLoc());
        p.setLoc(location);

    }
}
