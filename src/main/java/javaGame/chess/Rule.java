package javaGame.chess;

import java.util.LinkedList;

public class Rule {
    Board board;

    Rule(Board board) {
        this.board = board;
    }

    void movePiece(int originRank, int originFile, int movedRank, int movedFile) {
        if( canMove(originRank, originFile, movedRank, movedFile) ){

            board.setPiece(board.getPiece(originRank, originFile), movedRank, movedFile);

            board.setPiece(new Empty(), originRank, originFile);

        }
    }

    boolean canMove(int originRank, int originFile, int movedRank, int movedFile) {

        Piece piece = board.getPiece(originRank, originFile);

        int pieceRankDistance = Piece.GET_DISTANCE(originRank, movedRank);
        int pieceFileDistance = Piece.GET_DISTANCE(originFile, movedFile);

        // 절대적 핀이 걸려있는지 확인

        return piece.isLegalMove (pieceRankDistance, pieceFileDistance)
                && isMoveBlocked (originRank, originFile, movedRank, movedFile);
    }

    LinkedList<Piece> getThreatingPieces(int rank, int file) {

        LinkedList<Piece> threatingPieces = new LinkedList<Piece>();

        for(int i = 0 ; i < board.RANK_SIZE ; i++) {
            for (int j = 0 ; j < board.FILE_SIZE ; j++) {

                Piece temp = board.getPiece(i, j);
                int tempRankDistance = Piece.GET_DISTANCE(i, rank);
                int tempFileDistance = Piece.GET_DISTANCE(j, file);

                if( temp.isLegalMove (tempRankDistance, tempFileDistance)
                        && isMoveBlocked (i, j, rank, file) ) {

                    threatingPieces.add(temp);
                }
            }
        }

        return threatingPieces;
    }

    boolean isMoveBlocked(int originRank, int originFile, int movedRank, int movedFile) {

        Piece movingPiece = board.getPiece(originRank, originFile);
        // movingPiece와 도착지점 사이에 움직임을 가로막는 기물이 있는가?
        // 위의 내용 반환
        return false;
    }


}
