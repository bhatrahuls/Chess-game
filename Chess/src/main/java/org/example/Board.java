package org.example;

public class Board {
    private Spots[][] spot=new Spots[8][8];


    public void displayBoard(){
        spot[0][0]=new Spots(0,0, new PieceFactory().getNewPiece("pawn"));
        System.out.println(spot[0][1].getPiece().getClass());

    }

}
