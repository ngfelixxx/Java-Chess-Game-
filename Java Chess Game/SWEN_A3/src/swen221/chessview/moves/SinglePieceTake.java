package swen221.chessview.moves;

import swen221.chessview.*;
import swen221.chessview.pieces.Piece;

public class SinglePieceTake extends SinglePieceMove { //take extends aka inherits the proporties of the move class now 
	private Piece isTaken;

	/**
	 * Construct a new single piece take move.
	 *
	 * @param piece       The piece being moved.
	 * @param isTaken     The piece being taken.
	 * @param oldPosition The starting position of the piece being moved.
	 * @param newPosition The ending position of the piece being moved.
	 */
	public SinglePieceTake(Piece piece, Piece isTaken, Position oldPosition, Position newPosition) {
		super(piece,oldPosition,newPosition);
		this.isTaken = isTaken;
	}

	@Override
	public boolean isValid(Board board) {
		return piece.isValidMove(oldPosition, newPosition, isTaken, board);
	}

	@Override
	public String toString() { 
		return pieceChar(piece) + oldPosition + "x" + pieceChar(isTaken) + newPosition;
	}
}
