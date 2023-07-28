package org.example;

public class Board {
    private Spots[][] spot=new Spots[8][8];
    private PieceFactory pieceFactory=new PieceFactory();



    public void resetBoard(){
        for (int i=0;i<8;i++){
            for(int j=0;j<8;j++) {
                spot[i][j] = new Spots(i,j,null);
            }
        }
        this.initialize();
    }
    public void initialize(){
        //White Pawns
        for(int i=0;i<8;i++){
            spot[1][i].setPiece(pieceFactory.getNewPiece("pawn"));
        }

    }
    public void displayBoard(){

        for(int i=0;i<8;i++) {
            for (int j = 0; j < 8; j++) {
                try {
                    System.out.print(spot[i][j].getPiece().getClass().getSimpleName() + " ");
                } catch (Exception e) {
                    System.out.print(null + " ");
                }


            }
            System.out.println();
        }
        //System.out.println(spot[0][0].getPiece().getClass().getSimpleName());

    }

    public void movePiece(Spots curSpot,Spots desSpot){

    }

}
