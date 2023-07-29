package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Board board=new Board();
        Scanner sc=new Scanner(System.in);
        //System.out.println(b.getClass().getSimpleName());
        //b.displayBoard();
        board.resetBoard();
        board.displayBoard();
        while(true){
            System.out.println("Move piece from: ");
            int srcX= sc.nextInt();
            int srcY= sc.nextInt();
            System.out.println("Move piece to: ");
            int desX= sc.nextInt();
            int desY=sc.nextInt();
            String type=null;
            System.out.println(board.spot[srcX][srcY].getPiece().validateMove(board,board.spot[srcX][srcY],desX,desY));
            try {
                //System.out.println("here");

                if(board.spot[srcX][srcY].getPiece().validateMove(board,board.spot[srcX][srcY],desX,desY)){
                    System.out.println(board.spot[srcX][srcY].getPiece());
                    board.movePiece(board,board.spot[srcX][srcY],board.spot[desX][desY]);
                    //System.out.println("done");

                }

            }
            catch(Exception e){


                System.out.println("Source is empty");
            }
            board.displayBoard();
        }



    }
}