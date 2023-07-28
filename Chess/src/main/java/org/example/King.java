package org.example;

public class King extends Piece{
    @Override
    public boolean validateMove(Board board, Spots curPosition) {
        return false;
    }
}
