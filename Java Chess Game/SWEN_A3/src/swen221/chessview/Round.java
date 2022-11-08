package swen221.chessview;

import swen221.chessview.moves.Move;

public class Round {
	private Move white;
	private Move black;

	/**
	 * Create a round from a white move, and an optional black move.
	 *
	 * @param white - whites move; cannot be null;
	 * @param black - blacks move; may be null.
	 */
	public Round(Move white, Move black) {
		if(white == null) { 
			throw new IllegalArgumentException("A round must always consist of a move by white");
		}
		this.white = white;
		this.black = black;
	}

	/**
	 * Get the move for White.
	 *
	 * @return The move.
	 */
	public Move white() {
		return white;
	}

	/**
	 * Get the move for Black.
	 *
	 * @return The move.
	 */
	public Move black() {
		return black;
	}

	@Override
	public String toString() {
		String r = white.toString();
		if(black != null) {
			r += " " + black.toString();
		}
		return r;
	}
}
