package javaGame.chess;

import java.util.LinkedList;

public class Rule {
    Board board;

    Rule(Board board) {
        this.board = board;
    }

    boolean canMove(Piece piece, int movedLoc) {

        if (!piece.isLegalMove (movedLoc)) {
            System.out.println("It is illegal move");
            return false;
        }
        else if (isMoveBlocked (piece.getLoc(), movedLoc)) {
            System.out.println("Your piece is blocked by --");
            return false;
        }
        return true;
    }

    boolean isMoveBlocked(int originLoc, int movedLoc) { //getBlockingPieces완성후 교체
        return (getBlockingPiece(originLoc, movedLoc) instanceof Empty) ? false : true;
    }
    LinkedList<Piece> getBlockingPieces(int orginLoc, int targetLoc) {
        LinkedList<Piece> blockingPieces = new LinkedList<Piece>();

        int originRank = board.toRank(orginLoc);
        int targetRank = board.toRank(targetLoc);
        int rMoveDistance = (originRank > targetRank) ? -1 :
                (originRank < targetRank) ? 1 : 0;

        int originFile = board.toFile(orginLoc);
        int targetFile = board.toFile(targetLoc);
        int fMoveDistance = (originFile > targetFile) ? -1 :
                (originFile < targetFile) ? 1 : 0;

        int tempPieceRank = originRank;
        int tempPieceFile = originFile;
        do{
            tempPieceRank += rMoveDistance;
            tempPieceFile += fMoveDistance;

            Piece temp = board.getPiece(targetRank, tempPieceFile);
            if(temp != null) blockingPieces.add(temp);
        } while (tempPieceRank != targetRank
                && tempPieceFile != targetFile);

        return blockingPieces;
    }
    Piece getBlockingPiece(int orginLoc, int targetLoc) {

        int originRank = board.toRank(orginLoc);
        int targetRank = board.toRank(targetLoc);
        int rMoveDistance = (originRank > targetRank) ? -1 :
                (originRank < targetRank) ? 1 : 0;

        int originFile = board.toFile(orginLoc);
        int targetFile = board.toFile(targetLoc);
        int fMoveDistance = (originFile > targetFile) ? -1 :
                (originFile < targetFile) ? 1 : 0;
        do{
            originRank += rMoveDistance;
            originFile += fMoveDistance;

            Piece temp = board.getPiece(targetRank, originFile);
            if(temp != null) return temp;
        } while (originRank != targetRank
                && originFile != targetFile);

            return new Empty();
    }


}
