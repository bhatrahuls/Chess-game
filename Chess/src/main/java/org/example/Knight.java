package org.example;

import java.lang.Math;

public class Knight extends Piece{
    //Function to validate the given move for Knight
    @Override
    public boolean validateMove(Board board, Spots curSpot, Spots desSpot, Helper helper) {

        //destination
        int desX=desSpot.getX();
        int desY=desSpot.getY();

        //source
        int curX=curSpot.getX();
        int curY=curSpot.getY();

        if(helper.isValidSpot(board,desX,curX,desY,curY))
        {
            //logic
            return Math.abs(desX-curX)*Math.abs(desY-curY)==2;
        }
        return false;
    }
}