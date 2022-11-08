package swen221.chessview.moves;

import swen221.chessview.*;
import swen221.chessview.pieces.*;

public class SinglePieceMove implements MultiPieceMove { //implements empty interface of multi peice move and move interface is not used  
	protected Piece piece;
	protected Position oldPosition;
	protected Position newPosition;

	/**
	 * Construct a new single piece move.
	 *
	 * @param piece       The piece being moved.
	 * @param oldPosition The starting position.
	 * @param newPosition The ending position.
	 */
	public SinglePieceMove(Piece piece, Position oldPosition, Position newPosition) {
		this.piece = piece;
		this.oldPosition = oldPosition;
		this.newPosition = newPosition;
	}

	/**
	 * Get the piece being moved.
	 * @return The piece.
	 */
	public Piece piece() {
		return piece;
	}

	@Override
	public boolean isWhite() {
		return piece.isWhite();
	}

	/**
	 * Get the starting position of this move.
	 *
	 * @return A position.
	 */
	public Position oldPosition() {
		return oldPosition;
	}

	/**
	 * Get the ending position of this move.
	 *
	 * @return A position.
	 */
	public Position newPosition() {
		return newPosition;
	}

	@Override
	public boolean isValid(Board board) {
		return oldPosition.isValid() && newPosition.isValid() && piece.isValidMove(oldPosition, newPosition, null, board);
	}

	@Override
	public void apply(Board b) {
		b.move(oldPosition,newPosition);
		if(piece instanceof King) {
			b.setKingMoved(piece.isWhite());
		} else if(piece instanceof Rook) {
			if(piece.isWhite()) { 
				if(oldPosition.equals(new Position(1,1))) { 
					b.setRookMoved(true,false); 
				} else if(oldPosition.equals(new Position(1,8))) {
					b.setRookMoved(true,true);
				}
			} else {
				if(oldPosition.equals(new Position(8,1))) {
					b.setRookMoved(false,false); 
				} else if(oldPosition.equals(new Position(8,8))) {
					b.setRookMoved(false,true);
				}
			}
		} else if(piece instanceof Pawn) {
			// Store the double-step information required to implement En
			// Passant.
			int deltaRow = Math.abs(oldPosition.row() - newPosition.row()); 
			Pawn p = (Pawn) b.pieceAt(newPosition);
			p.setDoubleStep(deltaRow == 2);
		}
	}

	@Override
	public String toString() { 
		return pieceChar(piece) + oldPosition + "-" + newPosition;
	}

	protected static String pieceChar(Piece p) { //definition of peices here 
		if(p instanceof Pawn) {
			return "";
		} else if(p instanceof Knight) {
			return "N";
		} else if(p instanceof Bishop) {
			return "B";
		} else if(p instanceof Rook) {
			return "R";
		} else if(p instanceof Queen) {
			return "Q";
		} else {
			return "K";
		}
	}
}
