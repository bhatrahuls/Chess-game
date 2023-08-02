package org.example;

import java.sql.SQLOutput;

public class Board {
    //Spots are the squares on chessboard
    public Spots[][] spot=new Spots[8][8];

    //to keep track of Kings position
    public int whiteKing[]= new int[2];
    public int blackKing[]= new int[2];

    //PieceFactory
    private PieceFactory pieceFactory=new PieceFactory();


    //Function to deinitialize the pieces and set it to null
    public void resetBoard(){
        for (int i=0;i<8;i++){
            for(int j=0;j<8;j++) {
                spot[i][j] = new Spots(i,j,null);
            }
        }
        //Initialize the pieces back to their starting positions
    }



    //Function to initialize the pieces back to their starting position
    public void initialize(){
        //Black Pieces
        for(int i=0;i<8;i++){
            spot[1][i].setPiece(pieceFactory.getNewPiece("Pawn","b"));
        }
        spot[0][0].setPiece(pieceFactory.getNewPiece("Rook","b"));
        spot[0][1].setPiece(pieceFactory.getNewPiece("Knight","b"));
        spot[0][2].setPiece(pieceFactory.getNewPiece("Bishop","b"));
        spot[0][3].setPiece(pieceFactory.getNewPiece("Queen","b"));
        spot[0][4].setPiece(pieceFactory.getNewPiece("King","b"));

        blackKing[0]=0;
        blackKing[1]=4;

        spot[0][5].setPiece(pieceFactory.getNewPiece("Bishop","b"));
        spot[0][6].setPiece(pieceFactory.getNewPiece("Knight","b"));
        spot[0][7].setPiece(pieceFactory.getNewPiece("Rook","b"));

        //White Pieces
        for(int i=0;i<8;i++){
            spot[6][i].setPiece(pieceFactory.getNewPiece("Pawn","w"));
        }
        spot[7][7].setPiece(pieceFactory.getNewPiece("Rook","w"));
        spot[7][6].setPiece(pieceFactory.getNewPiece("Knight","w"));
        spot[7][5].setPiece(pieceFactory.getNewPiece("Bishop","w"));
        spot[7][4].setPiece(pieceFactory.getNewPiece("King","w"));

        whiteKing[0]=7;
        whiteKing[1]=4;

        spot[7][3].setPiece(pieceFactory.getNewPiece("Queen","w"));
        spot[7][2].setPiece(pieceFactory.getNewPiece("Bishop","w"));
        spot[7][1].setPiece(pieceFactory.getNewPiece("Knight","w"));
        spot[7][0].setPiece(pieceFactory.getNewPiece("Rook","w"));

    }

    //Function to display board
    public void displayBoard(){

        for(int i=0;i<8;i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print("("+i+","+j+")");
                //Handle nullPointerException in case the spot contains no piece
                try {
                    if(spot[i][j].getPiece().isWhite()){
                        //display white pieces
                        System.out.print("White"+spot[i][j].getPiece().getClass().getSimpleName() + "\t");
                    }
                    else{
                        //display black pieces
                        System.out.print("Black"+spot[i][j].getPiece().getClass().getSimpleName() + "\t");
                    }

                }
                //Print null in case a spot is found empty
                catch (Exception e) {
                    System.out.print("        " + "\t");
                }


            }
            System.out.println();
        }
        //System.out.println(spot[0][0].getPiece().getClass().getSimpleName());
    }
}