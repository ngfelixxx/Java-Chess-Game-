package swen221.chessview.pieces;

public abstract class PieceImpl { //these offer methods for all peices 
	protected boolean isWhite;

	/**
	 * Construct a new piece implementation.
	 *
	 * @param isWhite True if the piece is white.
	 */
	public PieceImpl(boolean isWhite) {
		this.isWhite = isWhite;
	}

	/**
	 * Determine whether this piece is white.
	 *
	 * @return True if this piece is white.
	 */
	public boolean isWhite() {
		return isWhite;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof PieceImpl) {
			PieceImpl p = (PieceImpl) o;
			return o.getClass() == getClass() && isWhite == p.isWhite;
		}
		return false;
	}
}
