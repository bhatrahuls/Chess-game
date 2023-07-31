package org.example;

public class Rook extends Piece{
    //Function to validate the given move for Rook
    @Override
    public boolean validateMove(Board board, Spots curSpot, Spots desSpot, Helper helper) {
        //destination
        int desX=desSpot.getX();
        int desY= desSpot.getY();

        //Source
        int curX= curSpot.getX();
        int curY=curSpot.getY();


        if(helper.isValidSpot(board,desX,curX,desY,curY)){
            //Check if the rook is moving in a single direction (horizontal/vertical and not both at a time)
            if(!(desX==curX || desY==curY))
                return false;

            //if the destination spot is empty
            if(board.spot[desX][desY].getPiece() == null || board.spot[desX][desY].getPiece().isWhite() != board.spot[curX][curY].getPiece().isWhite()){
                //check if there are any hurdles(other pieces) between the source and destination
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

            //If there is a piece at the destination spot, check its color and validate move
            else if(board.spot[desX][desY].getPiece().isWhite() == board.spot[curX][curY].getPiece().isWhite())
            {
                return false;
            }

            return true;
        }
        return false;
    }
}
