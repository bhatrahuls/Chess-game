package org.example;

public class Spots {
    private int x;
    private int y;
    private Piece piece;

    public Spots(int x, int y, Piece piece){
        this.setX(x);
        this.setY(y);
        this.setPiece(piece);
    }
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}
