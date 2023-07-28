package org.example;

public class PieceFactory {


    public Piece getNewPiece(String type) {
        Piece p=null;

        if(type=="pawn"){
            p=new Pawn();
        }
        else if(type=="king"){
            p=new King();
        }
        else if(type=="queen"){
            p=new Queen();
        }
        else if(type=="knight"){
            p = new Knight();
        }
        else if(type=="rook"){
            p = new Rook();
        }
        else if(type=="bishop"){
            p=new Bishop();
        }
        return p;
    }
}
