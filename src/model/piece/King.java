package model.piece;

import model.Move;

public class King extends Piece {
    private static final long serialVersionUID = 652968509826775762L;

    public King(ColorType color) {
        super(color, PieceType.KING, 0, 0);
    }

    public boolean validateMove(Move move) {
        // executeMove or capture
        if ((move.getCapturedPiece() == null)
                || (move.getCapturedPiece() != null
                && !move.getPiece().getColor().equals(move.getCapturedPiece().getColor()))) {
            // one square executeMove
            if (Math.abs(move.getDestinationFile() - move.getOriginFile()) <= 1
                    && Math.abs(move.getDestinationRank() - move.getOriginRank()) <= 1) {
                return true;
            }
        }

        // all other cases
        return false;
    }

}
