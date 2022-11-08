package swen221.chessview.pieces;

import swen221.chessview.*;

public class Pawn extends PieceImpl implements Piece {
	private boolean wasDoubleStep; // remember whether took double step or not.

	/**
	 * Construct a new bishop.
	 *
	 * @param isWhite True if the bishop is white.
	 */
	public Pawn(boolean isWhite) {
		super(isWhite);
	}

	@Override
	public boolean isValidMove(Position oldPosition, Position newPosition,
			Piece isTaken, Board board) {
		int direction = isWhite ? 1 : -1; 
		int oldRow = oldPosition.row();
		int oldCol = oldPosition.column();
		int newRow = newPosition.row();
		int newCol = newPosition.column();

		Piece p = board.pieceAt(oldPosition);
		Piece t = board.pieceAt(newPosition);

		// this logic is more complex than for other pieces, since there is a
		// difference between a take and non-take move for pawns.
		
		if (isTaken != null) { //allow to move diagonally 
			return this.equals(p) 
					&& isTaken.equals(t) 
					&& (oldCol == (newCol + 1) 
					|| oldCol == (newCol - 1))
					&& (oldRow + 1) == newRow 
					|| (oldRow - 1) == newRow; 
		//Otherwise can only move in forward or backwards direction
		} else if (
				 (oldRow + direction) == newRow 
				&& oldCol == newCol) { //edited error
			return this.equals(p) && t == null;
		} else if (
				 (oldRow + direction + direction) == newRow 
				&& oldCol == newCol) {
			return ((direction == 1 && oldRow == 2) //from starting positions 
					|| (direction == -1 && oldRow == 7))
					&& board.pieceAt(new Position(oldRow + direction, oldCol)) == null //free up the space to be moved too
					&& t == null && this.equals(p);
		}
		return false;
	}

	/**
	 * Return true if the last move made by this piece was a double step.
	 *
	 * @return True if the last step was a double step.
	 */
	public boolean wasDoubleStep() {
		return wasDoubleStep;
	}

	/**
	 * Mark this piece has having made a double step on the last move.
	 *
	 * @param flag True if the last move was a double step, false otherwise.
	 */
	public void setDoubleStep(boolean flag) {
		wasDoubleStep = flag;
	}

	@Override
	public String toString() {
		if(isWhite) {
			return "P";
		} else {
			return "p";
		}
	}
}
