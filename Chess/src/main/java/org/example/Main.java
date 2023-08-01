package org.example;

import java.util.Scanner;

public class Main {

    public static int srcX,srcY,desX,desY;

    public static void main(String[] args) {
        //board object
        Board board=new Board();

        //helper object
        Helper helper=new Helper();

        Scanner sc=new Scanner(System.in);
        int count=0;
        //reset the board and initialize it to start condition
        board.resetBoard();
        board.initialize();

        //display the board
        board.displayBoard();

        //Input handling
        while(true){
            if(count%2==0){
                System.out.println("White's turn");
                System.out.println("Move piece from: ");
                srcX= sc.nextInt();
                srcY= sc.nextInt();

                //get destination
                System.out.println("Move piece to: ");
                desX= sc.nextInt();
                desY=sc.nextInt();

                if( !board.spot[srcX][srcY].getPiece().isWhite()){
                    board.displayBoard();
                    continue;
                }

            }
            else{
                System.out.println("Black's turn");
                System.out.println("Move piece from: ");
                srcX= sc.nextInt();
                srcY= sc.nextInt();

                //get destination
                System.out.println("Move piece to: ");
                desX= sc.nextInt();
                desY=sc.nextInt();

                if( board.spot[srcX][srcY].getPiece().isWhite()) {
                    board.displayBoard();
                    continue;
                }
            }

            //Index for black pawns start at (1,0) and travel forwards for eg (2,0)
            //Index for white pawns start at (6 0) and travel backwards for eg (5,0)




            //Validate the move and if valid move the piece
            //try catch to avoid nullPointerException

            //System.out.println(board.spot[srcX][srcY].getPiece().validateMove(board,board.spot[srcX][srcY],board.spot[desX][desY],helper));
            try {
                //System.out.println(board.spot[srcX][srcY].getPiece());
                if(board.spot[srcX][srcY].getPiece().validateMove(board,board.spot[srcX][srcY],board.spot[desX][desY],helper)){
                    helper.movePiece(board,board.spot[srcX][srcY],board.spot[desX][desY]);
                }
                else{
                    System.out.println("Invalid move");
                    continue;
                }
            }
            catch(Exception e){
                System.out.println(e);
                System.out.println("Source is empty");
                continue;
            }

            //display the board after moving
            count++;
            board.displayBoard();
        }
    }
}