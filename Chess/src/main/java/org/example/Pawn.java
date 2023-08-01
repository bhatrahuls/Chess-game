package org.example;
import java.lang.Math;
public class Pawn extends Piece{
    @Override
    public boolean validateMove(Board board, Spots curSpot, Spots desSpot, Helper helper) {
        //destination
        int destX=desSpot.getX();
        int destY=desSpot.getY();

        //source
        int curX = curSpot.getX();
        int curY = curSpot.getY();

        if(helper.isValidSpot(board,destX,curX,destY,curY)){
            boolean valid = false;
            boolean destOccupied = board.spot[destX][destY].getPiece() != null;
            boolean isSrcWhite = curSpot.getPiece().isWhite();
            int flag = isSrcWhite? -1: 1;
            if(destY == curY && !destOccupied){
                if(destX - curX == flag){
                    valid = true;
                }
                else if(destX - curX == (2 * flag) && !curSpot.getPiece().isEverMoved() && board.spot[curX + flag][destY].getPiece() == null){
                    valid = true;
                }
            }
            else if(destX - curX == flag && Math.abs(destY-curY) == 1 && destOccupied){
                boolean isDestWhite = board.spot[destX][destY].getPiece().isWhite();
                if(isDestWhite != isSrcWhite){
                    valid = true;
                }
            }
            //double step cancellation functionality to be added
            return valid;
        }

        return false;

    }

    @Override
    public boolean isCheck(Board board, Spots curSpot, Spots desSpot) {
        return false;
    }
}
