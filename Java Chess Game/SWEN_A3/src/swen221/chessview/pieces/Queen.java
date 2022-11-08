package swen221.chessview.pieces;

import swen221.chessview.*;

public class Queen extends PieceImpl implements Piece {
	/**
	 * Construct a new queen.
	 *
	 * @param isWhite True if the queen is white.
	 */
	public Queen(boolean isWhite) {
		super(isWhite);
	}

	@Override
	public boolean isValidMove(Position oldPosition, Position newPosition,
			Piece isTaken, Board board) {
		Piece p = board.pieceAt(oldPosition);
		Piece t = board.pieceAt(newPosition);
		return this.equals(p)
				&& (t == isTaken || (isTaken != null && isTaken.equals(t)))
				&& (board.clearDiaganolExcept(oldPosition, newPosition, p, t)
						|| board.clearColumnExcept(oldPosition, newPosition, p,
								t) || board.clearRowExcept(oldPosition,
						newPosition, p, t));
	}

	@Override
	public String toString() {
		if(isWhite) {
			return "Q";
		} else {
			return "q";
		}
	}
}
