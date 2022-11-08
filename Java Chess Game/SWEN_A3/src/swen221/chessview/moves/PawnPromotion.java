package swen221.chessview.moves;

import swen221.chessview.*;
import swen221.chessview.pieces.*;

public class PawnPromotion implements MultiPieceMove { //this is when pawn reaches end of board so we can choose a new peice in its place 
	private Piece promotion;
	private SinglePieceMove move;

	/**
	 * Construct a new pawn promotion move.
	 *
	 * @param move      The underlying move which lead to a pawn promotion.
	 * @param promotion The piece to which the pawn is promoted.
	 */
	public PawnPromotion(SinglePieceMove move, Piece promotion) {
		this.promotion = promotion;
		this.move = move;
	}

	@Override
	public boolean isWhite() {
		return move.isWhite();
	}

	@Override
	public boolean isValid(Board board) {
		int row = isWhite() ? 8 : 1;
		return move.isValid(board) && move.piece() instanceof Pawn
				&& move.newPosition.row() == row;
	}

	@Override
	public void apply(Board board) {
		move.apply(board);
		board.setPieceAt(move.newPosition(), promotion);
	}

	@Override
	public String toString() {
		return super.toString() + "=" + SinglePieceMove.pieceChar(promotion);
	}
}
