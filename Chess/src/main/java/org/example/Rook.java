package org.example;

public class Rook extends Piece{
    @Override
    public boolean validateMove(Board board, Spots curSpot, int desX, int desY) {
        if(desX>7 || desX<0 || desY>7 || desY<0)
            return false;

        int curX= curSpot.getX();
        int curY=curSpot.getY();

        if(desX==curX && desY==curY)
            return false;

        if(!(desX==curX || desY==curY))
            return false;


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
        
        else if(board.spot[desX][desY].getPiece().isWhite() == board.spot[curX][curY].getPiece().isWhite())
        {
            System.out.println("here");
            return false;
        }
        //System.out.println(board.spot[desX][desY].getPiece().isWhite() && board.spot[curX][curY].getPiece().isWhite());

        return true;
    }
}
