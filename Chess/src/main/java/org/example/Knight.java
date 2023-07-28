package org.example;

public class Knight extends Piece{
    @Override
    public boolean validateMove(Board board, Spots curPosition) {
        return false;
    }
}
