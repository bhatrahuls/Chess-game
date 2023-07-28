package org.example;

public class PieceFactory {


    public Piece getNewPiece(String type) {
        Piece p=null;

        switch(type){
            case "pawn":
                p=new Pawn();
                break;
            case "king":
                p=new King();
                break;
            case "queen":
                p=new Queen();
                break;
            case "knight":
                p = new Knight();
                break;
            case "rook":
                p = new Rook();
                break;
            case "bishop":
                p=new Bishop();
                break;
        }

        return p;
    }
}
