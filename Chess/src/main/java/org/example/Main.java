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

                if(board.spot[srcX][srcY].getPiece().validateMove(board,board.spot[srcX][srcY],board.spot[desX][desY],helper)){
                    Piece temp=board.spot[desX][desY].getPiece();
                    int kingX;
                    int kingY;
                    boolean isWhite=true;
                    if(board.spot[srcX][srcY].getPiece().isWhite()){
                        isWhite=false;
                    }
                    else{
                        isWhite=true;
                    }

                    if(isWhite){
                        System.out.println("Here");
                        helper.movePiece(board,board.spot[srcX][srcY],board.spot[desX][desY]);
                        System.out.println(helper.checkHelper(board,board.spot[board.whiteKing[0]][board.whiteKing[1]]));
                        if(helper.checkHelperSelf(board,board.spot[board.blackKing[0]][board.blackKing[1]])){
                            System.out.println("You get a check");
                            board.spot[srcX][srcY].setPiece(board.spot[desX][desY].getPiece());
                            board.spot[desX][desY].setPiece(temp);
                            continue;
                        }
                    }
                    else{
                        System.out.println("here2");
                        helper.movePiece(board,board.spot[srcX][srcY],board.spot[desX][desY]);
                        System.out.println(helper.checkHelper(board,board.spot[board.blackKing[0]][board.blackKing[1]]));
                        if(helper.checkHelperSelf(board,board.spot[board.whiteKing[0]][board.whiteKing[1]])) {
                            System.out.println("You get a check");
                            board.spot[srcX][srcY].setPiece(board.spot[desX][desY].getPiece());
                            board.spot[desX][desY].setPiece(temp);
                            continue;
                        }
                    }
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