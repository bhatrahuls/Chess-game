package org.example;

public class Queen extends Piece{
    @Override
    public boolean validateMove(Board board, Spots curSpot, int desX, int desY) {
        if(desX>7 || desX<0 || desY>7 || desY<0)
            return false;

        int curX=curSpot.getX();
        int curY=curSpot.getY();


        if(board.spot[desX][desY].getPiece()==null){
            if(desX>curX){
                for(int i=curX+1;i<desX;i++) {
                    if (!(board.spot[i][desY].getPiece() == null))
                        return false;
                }
            }
            else if(desX<curX){
                for(int i=curY+1;i>desY;i--){
                    if (!(board.spot[i][desY].getPiece() == null))
                        return false;
                }
            }
            else if(desY>curY){
                for(int i=curY;i<desY;i++){
                    if(!(board.spot[desX][i].getPiece()==null))
                        return false;
                }
            }
            else{
                for(int i=curY;i>desY;i--){
                    if(!(board.spot[desX][i].getPiece()==null))
                        return false;
                }
            }
        }

        else if (((curX-desX) == (curY-desY))||((curX-desX) == (-1)*(curY-desY))){
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
        else if(board.spot[desX][desY].getPiece().isWhite() == board.spot[curX][curY].getPiece().isWhite())
            return false;

        return true;
    }
}
