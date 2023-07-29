package org.example;
import java.lang.Math;
public class Pawn extends Piece{
    @Override
    public boolean validateMove(Board board, Spots curSpot, int destX, int destY) {
        if (destX>7 || destX<0 || destY<0 ||destY>7) {
            return false;
        }
        int curX = curSpot.getX();
        int curY = curSpot.getY();
        boolean valid = false;
        boolean destOccupied = board.spot[destX][destY].getPiece() != null;
        boolean isDestWhite = board.spot[destX][destY].getPiece().isWhite();
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
            if(isDestWhite != isSrcWhite)
                valid = true;
        }
        //double step cancellation functionality to be added
        return valid;

    }

}
