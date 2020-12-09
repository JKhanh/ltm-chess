package model.piece;

import model.Move;

public class Pawn extends Piece {
    private static final long serialVersionUID = 652968509826775760L;

    public Pawn(ColorType color) {
        super(color, PieceType.PAWN, 0, 0);
    }

    public boolean validateMove(Move move) {
        Piece.ColorType color = move.getPiece().getColor();

        // diagonal capture
        switch (color) {
            case WHITE:
                if (Math.abs(move.getDestinationFile() - move.getOriginFile()) == 1
                        && move.getDestinationRank() - move.getOriginRank() == 1
                        && move.getCapturedPiece() != null
                        && Piece.ColorType.BLACK.equals(move.getCapturedPiece().getColor())) {
                    // abs(file difference) = 1
                    // rank difference = +1
                    // opposite color for captured piece
                    return true;
                }
                break;
            case BLACK:
                if (Math.abs(move.getDestinationFile() - move.getOriginFile()) == 1
                        && move.getDestinationRank() - move.getOriginRank() == -1
                        && move.getCapturedPiece() != null
                        && Piece.ColorType.WHITE.equals(move.getCapturedPiece().getColor())) {
                    // abs(file difference) = 1
                    // rank difference = +1
                    // opposite color for captured piece
                    return true;
                }
                break;
        }

        // initial executeMove
        switch (color) {
            case WHITE:
                if (move.getOriginRank() == 2
                        && move.getDestinationFile() == move.getOriginFile()
                        && move.getDestinationRank() - move.getOriginRank() <= 2
                        && move.getDestinationRank() - move.getOriginRank() >= 1
                        && move.getCapturedPiece() == null) {
                    // origin rank = 2
                    // no file difference
                    // 1 <= rank difference <= 2
                    // no captured piece
                    return true;
                }
                break;
            case BLACK:
                if (move.getOriginRank() == 7
                        && move.getDestinationFile() == move.getOriginFile()
                        && move.getDestinationRank() - move.getOriginRank() >= -2
                        && move.getDestinationRank() - move.getOriginRank() <= -1
                        && move.getCapturedPiece() == null) {
                    // origin rank = 7
                    // no file difference
                    // -2 <= rank difference <= -1
                    // no captured piece
                    return true;
                }
                break;
        }

        // forward executeMove
        switch (color) {
            case WHITE:
                if (move.getDestinationFile() == move.getOriginFile()
                        && move.getDestinationRank() - move.getOriginRank() == 1
                        && move.getCapturedPiece() == null) {
                    // executeMove along file
                    // rank difference = 1
                    // no captured piece
                    return true;
                }
                break;
            case BLACK:
                if (move.getDestinationFile() == move.getOriginFile()
                        && move.getDestinationRank() - move.getOriginRank() == -1
                        && move.getCapturedPiece() == null) {
                    // executeMove along file
                    // rank difference = -1
                    // no captured piece
                    return true;
                }
                break;
        }

        // all other cases
        return false;
    }
}
