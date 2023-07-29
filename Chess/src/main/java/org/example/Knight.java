package org.example;

import java.lang.Math;

public class Knight extends Piece{
    @Override
    public boolean validateMove(Board board, Spots curSpot, int desX, int desY) {

        if(desX>7 || desX<0 || desY>7 || desY<0)
            return false;

        int curX=curSpot.getX();
        int curY=curSpot.getY();

        return Math.abs(desX-curX)*Math.abs(desY-curY)==2;

    }
}
