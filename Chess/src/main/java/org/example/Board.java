package org.example;

public class Board {
    public Spots[][] spot=new Spots[8][8];
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
        //Black Pieces
        for(int i=0;i<8;i++){
            spot[1][i].setPiece(pieceFactory.getNewPiece("Pawn","b"));
        }
        spot[0][0].setPiece(pieceFactory.getNewPiece("Rook","b"));
        spot[0][1].setPiece(pieceFactory.getNewPiece("Knight","b"));
        spot[0][2].setPiece(pieceFactory.getNewPiece("Bishop","b"));
        spot[0][3].setPiece(pieceFactory.getNewPiece("Queen","b"));
        spot[0][4].setPiece(pieceFactory.getNewPiece("King","b"));
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
        spot[7][3].setPiece(pieceFactory.getNewPiece("Queen","w"));
        spot[7][2].setPiece(pieceFactory.getNewPiece("Bishop","w"));
        spot[7][1].setPiece(pieceFactory.getNewPiece("Knight","w"));
        spot[7][0].setPiece(pieceFactory.getNewPiece("Rook","w"));

    }
    public void displayBoard(){

        for(int i=0;i<8;i++) {
            for (int j = 0; j < 8; j++) {
                try {
                    if(spot[i][j].getPiece().isWhite()){
                        System.out.print("White"+spot[i][j].getPiece().getClass().getSimpleName() + "\t");
                    }
                    else{
                        System.out.print("Black"+spot[i][j].getPiece().getClass().getSimpleName() + "\t");
                    }

                } catch (Exception e) {
                    System.out.print("nullnull" + "\t");
                }


            }
            System.out.println();
        }
        //System.out.println(spot[0][0].getPiece().getClass().getSimpleName());

    }

    public void movePiece(Board board,Spots curSpot,Spots desSpot){
        int curX=curSpot.getX();
        int curY=curSpot.getY();
        int desX=desSpot.getX();
        int desY=desSpot.getY();

        if(curX==desX && curY==desY)
            return;
        System.out.println(board.spot[curX][curY].getPiece());
        spot[desX][desY].setPiece(board.spot[curX][curY].getPiece());
        System.out.println("here");
        spot[curX][curY].setPiece(null);
        if(!spot[desX][desY].getPiece().isEverMoved()){
            spot[desX][desY].getPiece().setEverMoved(true);
        }


    }

}
