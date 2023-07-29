package org.example;

public class King extends Piece{
    @Override
    public boolean validateMove(Board board, Spots curSpot, int desX, int desY) {
        int curX= curSpot.getX();
        int curY=curSpot.getY();

        return false;
    }
}
