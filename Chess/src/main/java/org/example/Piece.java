package org.example;

abstract class Piece {
    private boolean isWhite=false;
    private boolean everMoved=false;

    public boolean isWhite() {
        return isWhite;
    }

    public void setWhite(boolean white) {
        isWhite = white;
    }
    public boolean isEverMoved() {
        return everMoved;
    }

    public void setEverMoved(boolean everMoved) {
        this.everMoved = everMoved;
    }
    public abstract boolean validateMove(Board board, Spots curSpot,int x,int y);
        /*

        To get initial position:
        curSpot.getX();
        curSpot.getY();


        To get piece:
        curSpot.getPiece();




         */





}
