package model.piece;

import model.Move;

public class Rook extends Piece {
    private static final long serialVersionUID = 652968509826775765L;

    public Rook(ColorType color) {
        super(color, PieceType.ROOK, 0 ,0);
    }

    public boolean validateMove(Move move) {
        // executeMove or capture
        if ((move.getCapturedPiece() == null)
                || (move.getCapturedPiece() != null
                    && !move.getPiece().getColor().equals(move.getCapturedPiece().getColor()))) {
            // along file
            if (move.getDestinationFile() == move.getOriginFile()
                    && move.getDestinationRank() != move.getOriginRank()) {
                return true;
            }
            // along rank
            if (move.getDestinationFile() != move.getOriginFile()
                    && move.getDestinationRank() == move.getOriginRank()) {
                return true;
            }
        }

        // all other cases
        return false;
    }

}
