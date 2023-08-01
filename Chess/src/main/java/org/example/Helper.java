package org.example;

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
    public void movePiece(Board board,Spots curSpot,Spots desSpot){
        //get current positions
        int curX=curSpot.getX();
        int curY=curSpot.getY();

        //get destination positions
        int desX=desSpot.getX();
        int desY=desSpot.getY();

        //Store the piece that will be removed in temp variable
        Piece temp=board.spot[desX][desY].getPiece();

        //setting destination to the piece at source
        board.spot[desX][desY].setPiece(board.spot[curX][curY].getPiece());

        //setting the source position as empty
        board.spot[curX][curY].setPiece(null);

        //get color
        String color;
        int kingX;
        int kingY;
        if(board.spot[desX][desY].getPiece().isWhite()){
            kingX=board.whiteKing[0];
            kingY=board.whiteKing[1];
        }
        else{
            kingX=board.blackKing[0];
            kingY=board.blackKing[1];
        }

        boolean flag=false;
        for(int i =0;i<8;i++) {
            for (int j = 0; j < 8; j++) {
                if(board.spot[i][j]!=null){
                    if(board.spot[i][j].getPiece().isCheck(board,board.spot[kingX][kingY],board.spot[i][j])){
                        board.spot[curX][curY].setPiece(board.spot[desX][desY].getPiece());
                        board.spot[desX][desY].setPiece(temp);
                        flag=true;
                        break;
                    }
                }
            }
            if(flag)
                break;
        }
        if(flag)
            return;
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
    }
}
