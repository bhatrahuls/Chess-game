package org.example;

public class Bishop extends Piece {
    @Override
    public boolean validateMove(Board board, Spots curSpot, Spots desSpot, Helper helper) {
        //destination
        int desX = desSpot.getX();
        int desY = desSpot.getY();

        //source
        int curX = curSpot.getX();
        int curY = curSpot.getY();

        if (helper.isValidSpot(board, desX, curX, desY, curY)) {
            if (((curX - desX) == (curY - desY)) || ((curX - desX) == (-1) * (curY - desY))) {
                Spots sp = board.spot[desX][desY];
                if (board.spot[desX][desY].getPiece() == null || board.spot[desX][desY].getPiece().isWhite() != board.spot[curX][curY].getPiece().isWhite()) {
                    int incementX = (curX > desX) ? -1 : 1;
                    int incementY = (curY > desY) ? -1 : 1;
                    while (curX != desX  && curY != desY) {
                        curX = curX + incementX;
                        curY = curY + incementY;
                        if (board.spot[curX][curY].getPiece() != null) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            }
        }
        return false;
    }


    @Override
    public boolean isCheck(Board board, Spots curSpot, Spots desSpot) {
        int desX = desSpot.getX();
        int desY = desSpot.getY();

        //source
        int curX = curSpot.getX();
        int curY = curSpot.getY();

        if (((curX - desX) == (curY - desY)) || ((curX - desX) == (-1) * (curY - desY))) {
            Spots sp = board.spot[desX][desY];
            if (board.spot[desX][desY].getPiece() == null || board.spot[desX][desY].getPiece().isWhite() != board.spot[curX][curY].getPiece().isWhite()) {
                int incementX = (curX > desX) ? -1 : 1;
                int incementY = (curY > desY) ? -1 : 1;
                System.out.println(curX+" "+desX+" "+ incementX);
                System.out.println(curY+" "+desY+" "+ incementY);
                while (curX != desX && curY != desY ) {
                    curX = curX + incementX;
                    curY = curY + incementY;
                    System.out.println(board.spot[curX][curY].getPiece());
                    if (board.spot[curX][curY].getPiece() != null) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return false;
    }
}
