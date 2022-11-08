package swen221.chessview.pieces;

import swen221.chessview.*;

public class Rook extends PieceImpl implements Piece {
	/**
	 * Construct a new rook.
	 *
	 * @param isWhite True if the rook is white.
	 */
	public Rook(boolean isWhite) {
		super(isWhite);
	}

	@Override
	public boolean isValidMove(Position oldPosition, Position newPosition,
			Piece isTaken, Board board) {
		Piece p = board.pieceAt(oldPosition);
		Piece t = board.pieceAt(newPosition);

		return this.equals(p)
				&& (t == isTaken || (isTaken != null && isTaken.equals(t)))
				&& (board.clearColumnExcept(oldPosition, newPosition, p, t) || board
						.clearRowExcept(oldPosition, newPosition, p, t));
	}

	@Override
	public String toString() {
		if(isWhite) {
			return "R";
		} else {
			return "r";
		}
	}
}
