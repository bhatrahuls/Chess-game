package org.example;

public class Pawn extends Piece{
    @Override
    public boolean validateMove(Board board, Spots curPosition) {
        return false;
    }
}
