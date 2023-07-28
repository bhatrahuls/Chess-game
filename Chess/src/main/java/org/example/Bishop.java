package org.example;

public class Bishop extends Piece{
    @Override
    public boolean validateMove(Board board, Spots curSpot, int x, int y) {
        return false;
    }
}
