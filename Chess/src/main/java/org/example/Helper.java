package org.example;

import java.util.Scanner;

public class Helper {
    public boolean isValidSpot(Board board, int desX, int curX, int desY, int curY){
        //check if the destination is valid
        if (desX>7 || desX<0 || desY<0 || desY>7) {
            System.out.println("Invalid destination");
            return false;
        }

        //If source and destination are same, don't do anything
        if(curX==desX && curY==desY)
            return false;

        //Move is invalid is source is empty
        if(this.isEmpty(board.spot[curX][curY])){
            System.out.println("Source is empty");
            return false;
        }


        //check if the destination spot has a King
        if(board.spot[desX][desY].getPiece()!=null){
            if("King".equals(board.spot[desX][desY].getPiece().getClass().getSimpleName())){
                System.out.println("Invalid move");
                return false;
            }
        }
        return true;
    }

    //check if the sourceSpot is empty
    public boolean isEmpty(Spots curSpot){
        //check if the source is empty
        try{
            curSpot.getPiece().isWhite();
        }
        catch(Exception e){
            System.out.println("Source is empty");
            return true;
        }
        return false;
    }

    //Logic to move piece from source to destination
    public void movePiece(Board board,Spots curSpot,Spots desSpot, String color){
        //get current positions
        int curX=curSpot.getX();
        int curY=curSpot.getY();

        //get destination positions
        int desX=desSpot.getX();
        int desY=desSpot.getY();


        //Store the piece that will be removed in temp variable
        //Piece temp=board.spot[desX][desY].getPiece();

        System.out.println();
        //setting destination to the piece at source
        board.spot[desX][desY].setPiece(board.spot[curX][curY].getPiece());

        //setting the source position as empty
        board.spot[curX][curY].setPiece(null);

        //get color

        //if the piece moved is King, store its new position
        if("King".equals(board.spot[desX][desY].getPiece().getClass().getSimpleName())){
            if(board.spot[desX][desY].getPiece().isWhite()){
                board.whiteKing[0]=desX;
                board.whiteKing[1]=desY;
            }
            else{
                board.blackKing[0]=desX;
                board.blackKing[1]=desY;
            }
        }
        //to know if the piece was moved anytime in game
        if(!board.spot[desX][desY].getPiece().isEverMoved()){
            board.spot[desX][desY].getPiece().setEverMoved(true);
        }

        boolean promote = false;
        if(desSpot.getPiece().getClass().getSimpleName().equals("Pawn") && (desX == 0 || desX == 7)){
            promote = true;
        }

        if(promote){
            while (true){
                Scanner sc = new Scanner(System.in);
                System.out.println("Choose any one of {Queen, Rook, Bishop, or Knight} to promote the pawn");
                String piece = sc.next();
                if(!piece.equals("Queen") && !piece.equals("Rook") && !piece.equals("Bishop") && !piece.equals("Knight")) {
                    continue;
                }
                promotePawn(board, piece, desSpot, color);
                break;
            }
        }
    }

    public void promotePawn(Board board, String piece ,Spots curSpot, String color){
        int curX = curSpot.getX();
        int curY = curSpot.getY();

        PieceFactory pieceFactory = new PieceFactory();
        board.spot[curX][curY].setPiece(pieceFactory.getNewPiece(piece, color));
    }

    public boolean checkHelper(Board board, Spots desSpot, Helper helper){


        //get destination positions
        int desX=desSpot.getX();
        int desY=desSpot.getY();

        boolean flag=false;
        for(int i =0;i<8;i++) {
            for (int j = 0; j < 8; j++) {
                if((board.spot[i][j].getPiece()!=null) && (board.spot[i][j].getPiece().isWhite() != desSpot.getPiece().isWhite())){
                    if(board.spot[i][j].getPiece().isCheck(board,board.spot[i][j],desSpot,helper)){
                        flag=true;
                        break;
                    }
                }
            }
            if(flag)
                break;
        }
        return flag;
    }

    public boolean checkHelperSelf(Board board, Spots desSpot, Helper helper){


        //get destination positions
        int desX=desSpot.getX();
        int desY=desSpot.getY();

        boolean flag=false;
        for(int i =0;i<8;i++) {
            for (int j = 0; j < 8; j++) {
                if((board.spot[i][j].getPiece()!=null) && (board.spot[i][j].getPiece().isWhite() != desSpot.getPiece().isWhite())){
                    if(board.spot[i][j].getPiece().isCheck(board,board.spot[i][j],desSpot,helper)){
                        flag=true;
                        System.out.println("It is a check from"+board.spot[i][j].getPiece() );
                        System.out.println(board.spot[i][j].getPiece().isWhite());
                        break;
                    }
                }
            }
            if(flag)
                break;
        }
        return flag;
    }
}
