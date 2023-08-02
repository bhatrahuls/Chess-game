package org.example;

public class King extends Piece{
    @Override
    public boolean validateMove(Board board, Spots curSpot, Spots desSpot,Helper helper) {
        int curX= curSpot.getX();
        int curY=curSpot.getY();

        int desX=desSpot.getX();
        int desY=desSpot.getY();

        if( ((Math.abs(curX-desX)<=1) && (Math.abs(curY-desY)<=1)) &&
                (board.spot[desX][desY].getPiece() == null ||
                        (board.spot[desX][desY].getPiece().isWhite() !=
                                board.spot[curX][curY].getPiece().isWhite())))
        {
            return true;
        }
        else if (curSpot.getPiece().isEverMoved()==false){
            if (curX == 7){
                if (desX==7 && board.spot[7][7].getPiece().isEverMoved()==false){
                    for(int i =4;i<7;i++){
                        if (board.spot[i][curY].getPiece() != null) {
                            return false;
                        }
                    }
                    for(int i =3;i<6;i++){
                        if(helper.checkHelper(board, board.spot[7][i], helper))
                            return false;
//                            validate for check conditions at 7,i blocks
                    }
                }
                if (desX==0 && board.spot[0][0].getPiece().isEverMoved()==false){
                    for(int i =1;i<3;i++){
                        if (board.spot[i][curY].getPiece() != null) {
                            return false;
                        }
                    }
                    for(int i =1;i<4;i++){
                        if(helper.checkHelper(board, board.spot[7][i], helper))
                            return false;
//                            validate for check conditions at 7,i blocks
                    }
                }
            }
            else if (curX == 0){
                if (desX==7 && board.spot[7][7].getPiece().isEverMoved()==false){
                    for(int i =5;i<7;i++){
                        if (board.spot[i][curY].getPiece() != null) {
                            return false;
                        }
                    }
                    for(int i =4;i<7;i++){
                        if(helper.checkHelper(board, board.spot[0][i], helper))
                            return false;
//                            validate for check conditions at 0,i blocks
                    }
                }
                if (desX==0 && board.spot[0][0].getPiece().isEverMoved()==false){
                    for(int i =1;i<4;i++){
                        if (board.spot[i][curY].getPiece() != null) {
                            return false;
                        }
                    }
                    for(int i =2;i<5;i++){
                        if(helper.checkHelper(board, board.spot[0][i], helper))
                            return false;
//                            validate for check conditions at 0,i blocks
                    }
                }
            }
        }

        return true;
    }

    @Override
    public boolean isCheck(Board board, Spots curSpot, Spots desSpot, Helper helper) {

        return false;
    }

}
