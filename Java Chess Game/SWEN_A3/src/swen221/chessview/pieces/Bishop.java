package swen221.chessview.pieces;

import swen221.chessview.*;

public class Bishop extends PieceImpl implements Piece { //interface and abstract class is used 
	/**
	 * Construct a new bishop.
	 *
	 * @param isWhite True if the bishop is white.
	 */
	public Bishop(boolean isWhite) {
		super(isWhite); //inherits proporties 
	}

	@Override
	public boolean isValidMove(Position oldPosition, Position newPosition,
			Piece isTaken, Board board) {
		Piece p = board.pieceAt(oldPosition);
		Piece t = board.pieceAt(newPosition);
		return this.equals(p)
				&& (t == isTaken || (isTaken != null && isTaken.equals(t)))
				&& (board.clearDiaganolExcept(oldPosition, newPosition, p, t)); 
	}

	@Override
	public String toString() {
		if(isWhite) {
			return "B";
		} else {
			return "b";
		}
	}
}
