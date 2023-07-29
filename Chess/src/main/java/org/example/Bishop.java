package org.example;

public class Bishop extends Piece{
    @Override
    public boolean validateMove(Board board, Spots curSpot, int desX, int desY) {
        if (desX>7 || desX<0 || desY<0 ||desY>7) {
            return false;
        }
        Spots sp = board.spot[desX][desY];
        if(curSpot.getPiece().isWhite()==sp.getPiece().isWhite()){
            return false;
        }
        int curX=curSpot.getX();
        int curY=curSpot.getY();
        if (((curX-desX) == (curY-desY))||((curX-desX) == (-1)*(curY-desY))){
            int incementX = (curX>desX)?-1:1;
            int incementY = (curY>desY)?-1:1;
            while (curX < (desX - incementX) && curY < (desY - incementY)){
                curX = curX + incementX;
                curY = curY + incementY;
                if(board.spot[curX][curY].getPiece()!=null){
                    return false;
                }
            }
            return true;
        }
        else{
            return false;
        }
    }
}
