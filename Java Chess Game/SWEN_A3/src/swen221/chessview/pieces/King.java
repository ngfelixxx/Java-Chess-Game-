package swen221.chessview.pieces;

import swen221.chessview.*;

public class King extends PieceImpl implements Piece {
	/**
	 * Construct a new king.
	 *
	 * @param isWhite True if the king is white.
	 */
	public King(boolean isWhite) {
		super(isWhite);
	}

	@Override
	public boolean isValidMove(Position oldPosition, Position newPosition,
			Piece isTaken, Board board) {
		int diffRow = Math.max(oldPosition.row(), newPosition.row())
				- Math.min(oldPosition.row(), newPosition.row());
		int diffCol = Math.max(oldPosition.column(), newPosition.column())
				- Math.min(oldPosition.column(), newPosition.column());
		Piece p = board.pieceAt(oldPosition);
		Piece t = board.pieceAt(newPosition);
		return this.equals(p)
				&& (t == isTaken || (isTaken != null && isTaken.equals(t)))
				&& (diffCol == 1 || diffRow == 1) && diffCol <= 1 && diffRow <= 1; 
	}

	@Override
	public String toString() {
		if(isWhite) {
			return "K";
		} else {
			return "k";
		}
	}
}
