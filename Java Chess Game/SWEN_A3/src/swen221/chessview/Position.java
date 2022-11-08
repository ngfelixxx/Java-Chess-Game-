package swen221.chessview;

public final class Position {
	private int row; // must be between 1 and 8
	private int col; // must be between 1 and 8

	/**
	 * Construct a new board position.
	 *
	 * @param row Row for position.
	 * @param col Column for position.
	 */
	public Position(int row, int col) {
		this.row = row;
		this.col = col;
	}

	/**
	 * Get the row number of this position.
	 *
	 * @return The row.
	 */
	public int row() {
		return row;
	}

	/**
	 * Get the column number of this position.
	 *
	 * @return The column.
	 */
	public int column() {
		return col;
	}

	/**
	 * Check whether this is a valid position on the board.
	 *
	 * @return True if the position is valid.
	 */
	public boolean isValid() {
		return col >= 1 && col <= 8 && row >= 1 && row <= 8;
	}

	@Override
	public boolean equals(Object o) { 
		if(o instanceof Position) {
			Position p = (Position) o;
			return row == p.row && col == p.col;
		}
		return false;
	}

	@Override
	public int hashCode() { 
		return row ^ col;
	}

	@Override
	public String toString() {
		return ((char)('a'+(col-1))) + Integer.toString(row);
	}
}
