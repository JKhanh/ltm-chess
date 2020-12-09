package model.piece;

import model.Move;

public class Bishop extends Piece {
    private static final long serialVersionUID = 652968509826775761L;

    public Bishop(ColorType color) {
        super(color, PieceType.BISHOP, 0, 0);
    }

    public boolean validateMove(Move move) {
        // executeMove or capture
        if ((move.getCapturedPiece() == null)
                || (move.getCapturedPiece() != null
                && !move.getPiece().getColor().equals(move.getCapturedPiece().getColor()))) {
            // diagonal executeMove
            if (Math.abs(move.getDestinationFile() - move.getOriginFile())
                    == Math.abs(move.getDestinationRank() - move.getOriginRank())) {
                return true;
            }
        }

        // all other cases
        return false;
    }
}
