package model.piece;

import model.Move;

public class Knight extends Piece {
    private static final long serialVersionUID = 652968509826775763L;

    public Knight(ColorType color) {
        super(color, PieceType.KNIGHT, 0, 0);
    }

    public boolean validateMove(Move move) {
        // executeMove or capture
        if ((move.getCapturedPiece() == null)
                || (move.getCapturedPiece() != null
                    && !move.getPiece().getColor().equals(move.getCapturedPiece().getColor()))) {
            // l-shape executeMove
            if ((Math.abs(move.getDestinationFile() - move.getOriginFile()) == 1
                    && Math.abs(move.getDestinationRank() - move.getOriginRank()) == 2)
                    || (Math.abs(move.getDestinationFile() - move.getOriginFile()) == 2
                    && Math.abs(move.getDestinationRank() - move.getOriginRank()) == 1)) {
                return true;
            }
        }

        // all other cases
        return false;
    }
}
