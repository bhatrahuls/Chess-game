package org.example;

public class Rook extends Piece{
    @Override
    public boolean validateMove(Board board, Spots curPosition) {
        return false;
    }
}
