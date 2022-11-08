package swen221.chessview;

import java.util.*;

import swen221.chessview.moves.*;
import swen221.chessview.pieces.*;

import java.io.*;

public class ChessGame {
	private ArrayList<Round> rounds;

	/**
	 * Construct a new game of chess from a given game in long algebraic notation.
	 *
	 * @param sheet A string representing the game in algebraic notation.
	 * @throws IOException If there is a problem parsing the game.
	 */
	public ChessGame(String sheet) throws IOException {
		this(new StringReader(sheet));
	}

	/**
	 * Construct a ChessGame object from a given game sheet, where each round
	 * occurs on a new line.
	 *
	 * @param input The input reader to read the game from.
	 * @throws IOException If there is a problem parsing the game.
	 */
	public ChessGame(Reader input) throws IOException { //reads the moves in a round 
		rounds = new ArrayList<>();

		BufferedReader reader = new BufferedReader(input);

		// First, read in the commands
		String line;
		while((line = reader.readLine()) != null) {
			if(line.equals("")) { continue; } // skip blank lines
			int pos = line.indexOf(' ');
			if(pos == -1) { pos = line.length(); }
			Move white = moveFromString(line.substring(0,pos),true);
			Move black = null;
			if(pos != line.length()) {
				black = moveFromString(line.substring(pos+1),false);
			}
			rounds.add(new Round(white,black));
		}
	}

	/**
	 * Get the list of rounds in the game.
	 *
	 * @return A list of rounds.
	 */
	public List<Round> rounds() {
		return rounds;
	}

	/**
	 * This method computes the list of boards which make up the game. If an invalid
	 * move is encountered then method terminates producing the list of boards upto
	 * this point.
	 *
	 * @return The list of boards.
	 */
	public List<Board> boards() { //increments moves in the board otherwise will not if invalid
		ArrayList<Board> boards = new ArrayList<>();
		Board b = new Board();
		boards.add(b);
		boolean lastTime = false;
		for(Round r : rounds) {
			if (lastTime) { return boards; }
			b = new Board(b);
			if(!b.apply(r.white())) { return boards; }
			boards.add(b);
			if(r.black() != null) {
				b = new Board(b);
				if(!b.apply(r.black())) { return boards; }
				boards.add(b);
			} else {
				lastTime = true;
			}
		}
		return boards;
	}

	/**
	 * Construct a move object from a given string.
	 *
	 * @param str
	 * @return
	 */
	private static Move moveFromString(String str, boolean isWhite) { 
		Piece piece;
		int index = 0;
		char lookahead = str.charAt(index);

		switch(lookahead) {
			case 'N':
				piece = new Knight(isWhite);
				index++;
				break;
			case 'B':
				piece = new Bishop(isWhite);
				index++;
				break;
			case 'R':
				piece = new Rook(isWhite);
				index++;
				break;
			case 'K':
				piece = new King(isWhite);
				index++;
				break;
			case 'Q':
				piece = new Queen(isWhite);
				index++;
				break;
			case 'O':
				if(str.equals("O-O")) {
					return new Castling(isWhite,true); 
				} else if(str.equals("O-O-O")) {
					return new Castling(isWhite,false);
				} else if(str.equals("O-O+")) {
					return new Check(new Castling(isWhite,true)); 
				} else if(str.equals("O-O-O+")) {
					return new Check(new Castling(isWhite,false)); 
				} else {
					throw new IllegalArgumentException("invalid sheet");
				}
			default:
				piece = new Pawn(isWhite);
		}

		Position start = positionFromString(str.substring(index,index+2));
		char moveType = str.charAt(index+2);
		Piece target = null;
		index = index + 3;

		if(moveType == 'x') { //if we are trying to take 
			lookahead = str.charAt(index);
			switch(lookahead) {
				case 'N':
					target = new Knight(!isWhite); 
					index++;
					break;
				case 'B':
					target = new Bishop(!isWhite);
					index++;
					break;
				case 'R':
					target = new Rook(!isWhite);
					index++;
					break;
				case 'Q':
					target = new Queen(!isWhite);
					index++;
					break;
				default:
					target = new Pawn(!isWhite);
			}
		} else if(moveType != '-') {
			throw new IllegalArgumentException("invalid sheet");
		}

		Position end = positionFromString(str.substring(index,index+2));
		index = index + 2;

		Move move;

		if(target != null) { //if out target exists 
			move = new SinglePieceTake(piece,target,start,end); //call take 
		} else {
			move = new SinglePieceMove(piece,start,end);
		}

		if((index+1) < str.length() && str.charAt(index) == 'e' && str.charAt(index+1) == 'p') {
			move = new EnPassant((SinglePieceMove) move); //EnPassant used here 
			index+=2;
		} else if((index+1) < str.length() && str.charAt(index)=='=') {
			lookahead = str.charAt(index+1);
			Piece promotion;
			switch(lookahead) {
				case 'N':
					promotion = new Knight(isWhite);
					break;
				case 'B':
					promotion = new Rook(isWhite);
					break;
				case 'R':
					promotion = new Bishop(isWhite);
					break;
				case 'K':
					promotion = new King(isWhite);
					break;
				case 'Q':
					promotion = new Queen(isWhite);
					break;
				default:
					throw new IllegalArgumentException("invalid sheet");
			}
			move = new PawnPromotion((SinglePieceMove) move,promotion); //pawn promotion used here 
			index+=2;
		}

		if(index < str.length() && str.charAt(index) == '+') {
			move = new Check((MultiPieceMove) move); //check used here 
			index++;
		} else {
			move = new NonCheck((MultiPieceMove) move); 
		}

		if(index != str.length()) {
			throw new IllegalArgumentException("invalid sheet");
		}

		return move;
	}

	private static Position positionFromString(String pos) {
		if(pos.length() != 2) { 
			throw new IllegalArgumentException("invalid position: " + pos);
		}
		int col = (pos.charAt(0) - 'a') + 1;
		int row = Integer.parseInt(pos.substring(1,2));
		return new Position(row,col);
	}
}
