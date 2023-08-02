package org.example;

public class King extends Piece{
    @Override
    public boolean validateMove(Board board, Spots curSpot, Spots desSpot,Helper helper) {
        int curX= curSpot.getX();
        int curY=curSpot.getY();

        int desX=desSpot.getX();
        int desY=desSpot.getY();

        if(helper.isValidSpot(board,desX,curX,desY,curY)){

            //write logic here
            return false;

        }
        return false;
    }

    @Override
    public boolean isCheck(Board board, Spots curSpot, Spots desSpot) {
        return false;
    }

}
