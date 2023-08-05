package javaGame.chess;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Board board = new Board();
        Rule rule = new Rule(board);
        board.setPiece(new Rook(Piece.Team.BLACK), 0);
        board.setPiece(new Knight(Piece.Team.BLACK), 1);
        board.setPiece(new Bishop(Piece.Team.BLACK), 2);
        board.setPiece(new Queen(Piece.Team.BLACK), 3);
        board.setPiece(new King(Piece.Team.BLACK), 4);
        board.setPiece(new Bishop(Piece.Team.BLACK), 5);
        board.setPiece(new Knight(Piece.Team.BLACK), 6);
        board.setPiece(new Rook(Piece.Team.BLACK), 7);
        board.setPiece(new Pawn(Piece.Team.BLACK), 8);
        board.setPiece(new Pawn(Piece.Team.BLACK), 9);
        board.setPiece(new Pawn(Piece.Team.BLACK), 10);
        board.setPiece(new Pawn(Piece.Team.BLACK), 11);
        board.setPiece(new Pawn(Piece.Team.BLACK), 12);
        board.setPiece(new Pawn(Piece.Team.BLACK), 13);
        board.setPiece(new Pawn(Piece.Team.BLACK), 14);
        board.setPiece(new Pawn(Piece.Team.BLACK), 15);


        board.setPiece(new Rook(Piece.Team.WHITE), 63);
        board.setPiece(new Knight(Piece.Team.WHITE), 62);
        board.setPiece(new Bishop(Piece.Team.WHITE), 61);
        board.setPiece(new Queen(Piece.Team.WHITE), 60);
        board.setPiece(new King(Piece.Team.WHITE), 59);
        board.setPiece(new Bishop(Piece.Team.WHITE), 58);
        board.setPiece(new Knight(Piece.Team.WHITE), 57);
        board.setPiece(new Rook(Piece.Team.WHITE), 56);
        board.setPiece(new Pawn(Piece.Team.WHITE), 55);
        board.setPiece(new Pawn(Piece.Team.WHITE), 54);
        board.setPiece(new Pawn(Piece.Team.WHITE), 53);
        board.setPiece(new Pawn(Piece.Team.WHITE), 52);
        board.setPiece(new Pawn(Piece.Team.WHITE), 51);
        board.setPiece(new Pawn(Piece.Team.WHITE), 50);
        board.setPiece(new Pawn(Piece.Team.WHITE), 49);
        board.setPiece(new Pawn(Piece.Team.WHITE), 48);



        int answer = 1;
        int turn = 0;
        while (answer == 1) {
            board.printBoard();
            if (turn % 2 == 1) {

                System.out.println("White turn, choose piece to move");
                System.out.println("insert rank.");
                int originRank = sc.nextInt();
                System.out.println("insert file.");
                int originFile = sc.nextInt();

                Piece moveTarget = board.getPiece(originRank, originFile);
                if ( moveTarget.team != Piece.Team.WHITE ||  moveTarget.team == null ) {
                    System.out.println("illegal piece choose, choose another one");
                    System.out.println("Team: " + moveTarget + ", R[" + originRank + "] F[" + originFile + "]");
                    continue;
                }
                System.out.println("Team: " + moveTarget + ", R[" + originRank + "] F[" + originFile + "]");

                System.out.println("insert move square");
                System.out.println("insert rank.");
                int movedRank = sc.nextInt();
                System.out.println("insert file.");
                int movedFile = sc.nextInt();
                rule.movePiece(board.toIndex(originRank, originFile),
                        board.toIndex(movedRank, movedFile));// Rule 클래스의 canMove를 이용한 것으로 바꿀것

            } else {

                System.out.println("Black turn, choose piece to move");
                System.out.println("insert rank.");
                int originRank = sc.nextInt();
                System.out.println("insert file.");
                int originFile = sc.nextInt();

                Piece moveTarget = board.getPiece(originRank, originFile);
                if( moveTarget.team != Piece.Team.BLACK ||  moveTarget.team == null ) {
                    System.out.println("illegal piece choose, choose another one");
                    break;
                }
                System.out.println("Team: " + moveTarget + ", R[" + originRank + "] F[" + originFile + "]");

                System.out.println("insert move square");
                System.out.println("insert rank.");
                int movedRank = sc.nextInt();
                System.out.println("insert file.");
                int movedFile = sc.nextInt();
                rule.movePiece(board.toIndex(originRank, originFile),
                        board.toIndex(movedRank, movedFile));// Rule 클래스의 canMove를 이용한 것으로 바꿀것

            }
            turn ++;

        }
    }

}
