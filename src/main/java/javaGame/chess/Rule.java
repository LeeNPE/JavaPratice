package javaGame.chess;

import java.util.LinkedList;

public class Rule {
    Board board;

    Rule(Board board) {
        this.board = board;
    }

    void movePiece(int originLoc, int movedLoc) {
        System.out.println("from " + originLoc+ ", to " + movedLoc);
        if (canMove(originLoc, movedLoc)) {
            board.setPiece(board.getPiece(originLoc), movedLoc);
            board.setPiece(new Empty(), originLoc);
        } else {
            System.out.println("You can't move from" + board.toRank(originLoc) + ", " + board.toFile(originLoc)+
                    " to " + board.toRank(movedLoc) + ", " + board.toFile(movedLoc));
        }
    }

    boolean canMove(int originLoc, int movedLoc) {

        Piece piece = board.getPiece(originLoc);

        int pieceRankDistance = Piece.GET_DISTANCE(board.toRank(originLoc), board.toRank(movedLoc));
        int pieceFileDistance = Piece.GET_DISTANCE(board.toFile(originLoc), board.toFile(movedLoc));

        if (!piece.isLegalMove (pieceRankDistance, pieceFileDistance)) {
            System.out.println("It is illegal move!");
            return false;
        }
        else if (isMoveBlocked (originLoc, movedLoc)) {
            System.out.println("Your piece is blocked by --");
            return false;
        }
        return true;
    }

    LinkedList<Piece> getThreatingPieces(int location) {

        LinkedList<Piece> threatingPieces = new LinkedList<Piece>();

        for (int tempLoc = 0 ; tempLoc < board.getPieces().length ; tempLoc++) {

            Piece temp = board.getPiece(tempLoc);

            int rankDistance = Piece.GET_DISTANCE(board.toRank(tempLoc), board.toRank(location) );
            int fileDistance = Piece.GET_DISTANCE(board.toFile(tempLoc), board.toFile(location) );

            if( temp.isLegalMove (rankDistance, fileDistance)
                    && !isMoveBlocked ( tempLoc, location ) )

                threatingPieces.add(temp);
        }

        return threatingPieces;
    }

    boolean isMoveBlocked(int orginLoc, int movedLoc) {

        Piece piece = board.getPiece( board.toRank(orginLoc), board.toFile(orginLoc) );
        // movingPiece와 도착지점 사이에 움직임을 가로막는 기물이 있는가?
        // 위의 내용 반환
        return false;
    }


}
