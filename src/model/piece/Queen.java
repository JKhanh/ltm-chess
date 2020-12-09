package model.piece;

import model.Move;

public class Queen extends Piece {
    private static final long serialVersionUID = 652968509826775764L;

    public Queen(ColorType color) {
        super(color, PieceType.QUEEN, 0 ,0);
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
            // diagonal
            if (Math.abs(move.getDestinationFile() - move.getOriginFile())
                    == Math.abs(move.getDestinationRank() - move.getOriginRank())) {
                return true;
            }
        }

        // all other cases
        return false;
    }

}
