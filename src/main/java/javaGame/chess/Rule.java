package javaGame.chess;

import java.util.LinkedList;

public class Rule {
    Board board;

    Piece[] kings;

    /**
     *
     * @param board
     * @param kings input Kings.
     */
    Rule(Board board, Piece[] kings) {
        this.board = board;
    }

    boolean canMove(Piece piece, int targetLoc) {

        if (isLegalMoveMethod(piece.getLoc(), targetLoc)) {//옳은 행마법인지
            System.out.println("It is illegal move");
            return false;
        }

        Piece blockingPiece = getBlockingPiece(piece.getLoc(), targetLoc);
        if(blockingPiece != null){//막고있는 기물이 없는지
            if ( (blockingPiece == board.getPiece(targetLoc)) ) {
                if(board.getPiece(targetLoc).team == piece.team) return false;
            } else {
                return false;
            }
        }

        int originLoc = piece.getLoc();
        board.setPiece(piece, targetLoc);
        board.setPiece(null,originLoc);
        piece.setLoc(targetLoc);

        if(isCheck(piece.team)) return false;   //절대 핀이 있는지

        board.setPiece(piece, originLoc);
        board.setPiece(null, targetLoc);
        piece.setLoc(originLoc);


        return true;
    }

    boolean isLegalMoveMethod(int pieceLoc, int targetLoc) {

        Piece piece = board.getPiece(pieceLoc);
        boolean answer;
        switch (piece.type) {

            case PAWN -> answer = isPawnLegalMove(piece, targetLoc);
            case BISHOP -> answer = isBishopLegalMove(piece, targetLoc);
            case KNIGHT -> answer = isKnightLegalMove(piece, targetLoc);
            case ROOK -> answer = isRookLegalMove(piece, targetLoc);
            case QUEEN -> answer = isQueenLegalMove(piece, targetLoc);
            case KING -> answer = isKingLegalMove(piece, targetLoc);

            default -> throw new IllegalStateException("Unexpected value: " + piece.type);
        }
        return answer;
    }

    //moveMethods

    int getRankMove(int originLoc, int moveLoc) {
        return Board.toRank(moveLoc) - Board.toRank(originLoc);
    }
    int getFileMove(int originLoc, int moveLoc) {
        return Board.toFile(moveLoc) - Board.toFile(originLoc);
    }

    boolean isPawnLegalMove(Piece piece, int targetLoc){

        int moveDirection = (piece.team == Piece.Team.WHITE) ? -1 : 1;
        boolean canMoveTwoSquare =
                (piece.team == Piece.Team.WHITE && Board.toRank(piece.getLoc()) == 6
                || piece.team == Piece.Team.BLACK && Board.toRank(piece.getLoc()) == 1)
                ? true : false;
        int targetFile = Board.toFile(targetLoc);
        int pieceFile = Board.toFile(piece.getLoc());

        if(targetFile == pieceFile){

            int rankMove = getRankMove(piece.getLoc(), targetLoc);
            return (rankMove == moveDirection || (rankMove == 2 * moveDirection && canMoveTwoSquare))
                    ? true : false;
        } else if (targetFile == pieceFile + 1 || targetFile == pieceFile -1) {

            return (getRankMove(piece.getLoc(), targetLoc) == moveDirection) ? true : false;
        }
        return false;
    }

    boolean isBishopLegalMove(Piece piece, int targetLoc){
        if (piece.getLoc() == targetLoc) {
            return false;
        }

        int rankMove = getRankMove(piece.getLoc(), targetLoc);
        int fileMove = getFileMove(piece.getLoc(), targetLoc);

        return (rankMove == fileMove || rankMove == -fileMove) ? true : false;
    }

    boolean isKnightLegalMove(Piece piece, int targetLoc){

        int rankMove = getRankMove(piece.getLoc(), targetLoc);
        int fileMove = getFileMove(piece.getLoc(), targetLoc);
        if (rankMove == 1 || rankMove == -1) {

            return (fileMove == 2 || fileMove == -2) ? true : false;
        } else if (rankMove == 2 || rankMove == -2) {

            return (fileMove == 1 || fileMove == -1) ? true : false;
        }
        return false;
    }

    boolean isRookLegalMove(Piece piece, int targetLoc){
        if (piece.getLoc() == targetLoc) {
            return false;
        }

        return (getRankMove(piece.getLoc(), targetLoc) == 0
                || getFileMove(piece.getLoc(), targetLoc) == 0) ? true : false;
    }

    boolean isQueenLegalMove(Piece piece, int targetLoc){
        if (piece.getLoc() == targetLoc) {
            return false;
        }
        int rankMove = getRankMove(piece.getLoc(), targetLoc);
        int fileMove = getFileMove(piece.getLoc(), targetLoc);

        if (rankMove == fileMove || rankMove == -fileMove) return true;
        if(rankMove == 0 || fileMove == 0) return true;

        return false;
    }

    boolean isKingLegalMove(Piece piece, int targetLoc){
        if (piece.getLoc() == targetLoc) {
            return false;
        }

        int rankMove = getRankMove(piece.getLoc(), targetLoc);
        int fileMove = getFileMove(piece.getLoc(), targetLoc);
        return (rankMove <= 1 && rankMove >= -1
                || fileMove <= 1 && fileMove >= -1) ? true : false;
    }


    Piece getBlockingPiece(int orginLoc, int targetLoc) {

        if(board.getPiece(orginLoc).type == Piece.Type.KNIGHT) {
            return board.getPiece(targetLoc);
        }
        int rankMove = getRankMove(orginLoc, targetLoc);
        int fileMove = getFileMove(orginLoc, targetLoc);
        int tempLoc = orginLoc;

        if(rankMove == fileMove) {
            while (tempLoc != targetLoc) {
                tempLoc += (rankMove > 0) ? Board.RANK_SIZE+1 : -(Board.RANK_SIZE+1);
                if(board.getPiece(tempLoc) != null) return board.getPiece(tempLoc);
            }
            return null;
        }

        if(rankMove == -fileMove) {
            while (tempLoc != targetLoc) {
                tempLoc += (rankMove > 0) ? Board.RANK_SIZE-1 : -(Board.RANK_SIZE-1);
                if(board.getPiece(tempLoc) != null) return board.getPiece(tempLoc);
            }
            return null;
        }

        if(rankMove == 0) {
            while (tempLoc != targetLoc) {
                tempLoc += (fileMove > 0) ? Board.RANK_SIZE : -(Board.RANK_SIZE);
                if(board.getPiece(tempLoc) != null) return board.getPiece(tempLoc);
            }
            return null;
        }

        if(fileMove == 0) {
            while (tempLoc != targetLoc) {
                tempLoc += (rankMove > 0) ? 1 : -1;
                if(board.getPiece(tempLoc) != null) return board.getPiece(tempLoc);
            }
            return null;
        }

            return null;
    }

    boolean isCheck(Piece.Team team) {

        Piece king = kings[0];

        for (Piece temp:
             kings) {
            if (temp.team == team) {
                king = temp;
                break;
            }
        }

        for (Piece temp : board.getPieces()) {
            if(temp != null) {
                if (temp.team != team) {
                    int tempLoc = temp.getLoc(), kingLoc = king.getLoc();
                    
                    if (isLegalMoveMethod(tempLoc, kingLoc) && getBlockingPiece(tempLoc, kingLoc) == king)
                        return true;
                }
            }
        }

        return false;
    }
}

