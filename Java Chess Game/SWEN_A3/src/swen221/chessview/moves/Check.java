package swen221.chessview.moves;

import swen221.chessview.*;

public class Check implements Move {
	private MultiPieceMove move;

	/**
	 * Create a new check move.
	 *
	 * @param move The move onto which check is being added.
	 */
	public Check(MultiPieceMove move) {
		this.move = move;
	}

	/**
	 * Get the move underlying this check move.
	 *
	 * @return The move.
	 */
	public MultiPieceMove move() {
		return move;
	}

	@Override
	public boolean isWhite() {
		return move.isWhite();
	}

	@Override
	public boolean isValid(Board board) {
		if (move.isValid(board)) { 
			// Ok, underlying move is valid; now, we need to check that it
			// actually corresponds to putting the opposition's king into check.

			// First, copy board and apply underlying move.
			board = new Board(board);
			board.apply(move);

			// Second, check opposition is now in check.
			return board.isInCheck(!isWhite()); 
		}
		return false;
	}

	@Override
	public void apply(Board board) {
		move.apply(board);
	}

	@Override
	public String toString() {
		return move.toString() + "+";
	}
}
