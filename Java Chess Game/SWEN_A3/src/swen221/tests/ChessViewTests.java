package swen221.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.Test;

import swen221.chessview.Board;
import swen221.chessview.ChessGame;

public class ChessViewTests {

	// ================================================
	// Valid Tests
	// ================================================

	@Test public void testValid_01() {
		String input =
			"a2-a3\n" +
			"";
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|p|p|p|p|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|_|_|_|_|_|_|_|_|\n" +
			"3|P|_|_|_|_|_|_|_|\n" +
			"2|_|P|P|P|P|P|P|P|\n" +
			"1|R|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	
	//black pawn takes white pawn AND uses 2 rounds to do so 
	@Test public void testValid_02() { //error (solved)
		String input = "e2-e4 e7-e5\n"+"d2-d4 e5xd4\n";
		String output =
				"8|r|n|b|q|k|b|n|r|\n" +
				"7|p|p|p|p|_|p|p|p|\n" +
				"6|_|_|_|_|_|_|_|_|\n" +
				"5|_|_|_|_|_|_|_|_|\n" +
				"4|_|_|_|p|P|_|_|_|\n" +
				"3|_|_|_|_|_|_|_|_|\n" +
				"2|P|P|P|_|_|P|P|P|\n" +
				"1|R|N|B|Q|K|B|N|R|\n" +
				"  a b c d e f g h";
		check(input,output);
	}
	
	//Knight can move 
	@Test public void testValid_03() {
		String input = "Nb1-c3\n"+"";
		String output = 
				"8|r|n|b|q|k|b|n|r|\n" +
				"7|p|p|p|p|p|p|p|p|\n" +
				"6|_|_|_|_|_|_|_|_|\n" +
				"5|_|_|_|_|_|_|_|_|\n" +
				"4|_|_|_|_|_|_|_|_|\n" +
				"3|_|_|N|_|_|_|_|_|\n" +
				"2|P|P|P|P|P|P|P|P|\n" +
				"1|R|_|B|Q|K|B|N|R|\n" +
				"  a b c d e f g h";
		check(input,output);
	}
	
	//white pawn can double move 
	@Test public void testValid_04() {//error (solved)
		String input = "e2-e4\n"+"";
		String output = 
				"8|r|n|b|q|k|b|n|r|\n" +
				"7|p|p|p|p|p|p|p|p|\n" +
				"6|_|_|_|_|_|_|_|_|\n" +
				"5|_|_|_|_|_|_|_|_|\n" +
				"4|_|_|_|_|P|_|_|_|\n" +
				"3|_|_|_|_|_|_|_|_|\n" +
				"2|P|P|P|P|_|P|P|P|\n" +
				"1|R|N|B|Q|K|B|N|R|\n" +
				"  a b c d e f g h";
		check(input,output);
	}
	
	//Black pieces can move as well 
	@Test public void testValid_05() { //error (solved)
		String input = "e2-e3 e7-e6\n";
		String output = 
				"8|r|n|b|q|k|b|n|r|\n" +
				"7|p|p|p|p|_|p|p|p|\n" +
				"6|_|_|_|_|p|_|_|_|\n" +
				"5|_|_|_|_|_|_|_|_|\n" +
				"4|_|_|_|_|_|_|_|_|\n" +
				"3|_|_|_|_|P|_|_|_|\n" +
				"2|P|P|P|P|_|P|P|P|\n" +
				"1|R|N|B|Q|K|B|N|R|\n" +
				"  a b c d e f g h";
		check(input,output);
	}
	
	//Moves Queen AND uses 2 rounds to do so
	@Test public void testValid_06() { //error (solved)
		String input = "e2-e3 e7-e6\n"+"Qd1-f3 Qd8-f6\n";
		String output = 
				"8|r|n|b|_|k|b|n|r|\n" +
				"7|p|p|p|p|_|p|p|p|\n" +
				"6|_|_|_|_|p|q|_|_|\n" +
				"5|_|_|_|_|_|_|_|_|\n" +
				"4|_|_|_|_|_|_|_|_|\n" +
				"3|_|_|_|_|P|Q|_|_|\n" +
				"2|P|P|P|P|_|P|P|P|\n" +
				"1|R|N|B|_|K|B|N|R|\n" +
				"  a b c d e f g h";
		check(input,output);
	}
	
	//Bishops can move (allows multiple moves and rounds)
	@Test public void testValid_07() { //error (solved)
		String input = "d2-d3 e7-e6\n"+"Bc1-e3\n"+"";
		String output = 
				"8|r|n|b|q|k|b|n|r|\n" +
				"7|p|p|p|p|_|p|p|p|\n" +
				"6|_|_|_|_|p|_|_|_|\n" +
				"5|_|_|_|_|_|_|_|_|\n" +
				"4|_|_|_|_|_|_|_|_|\n" +
				"3|_|_|_|P|B|_|_|_|\n" +
				"2|P|P|P|_|P|P|P|P|\n" +
				"1|R|N|_|Q|K|B|N|R|\n" +
				"  a b c d e f g h";
		check(input,output);
	}
	
	//King can move 
	@Test public void testValid_08() { //error (solved)
		String input = "d2-d3 e7-e6\n"+"Ke1-d2\n";
		String output = 
				"8|r|n|b|q|k|b|n|r|\n" +
				"7|p|p|p|p|_|p|p|p|\n" +
				"6|_|_|_|_|p|_|_|_|\n" +
				"5|_|_|_|_|_|_|_|_|\n" +
				"4|_|_|_|_|_|_|_|_|\n" +
				"3|_|_|_|P|_|_|_|_|\n" +
				"2|P|P|P|K|P|P|P|P|\n" +
				"1|R|N|B|Q|_|B|N|R|\n" +
				"  a b c d e f g h";
		check(input,output);
	}
	
	//Rook can move and take peice
	@Test public void testValid_09() {
		String input = "a2-a4 b7-b5\n"+"a4xb5 h7-h6\n"+"Ra1xa7\n"+"";
		String output = 
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|R|_|p|p|p|p|p|_|\n" +
			"6|_|_|_|_|_|_|_|p|\n" +
			"5|_|P|_|_|_|_|_|_|\n" +
			"4|_|_|_|_|_|_|_|_|\n" +
			"3|_|_|_|_|_|_|_|_|\n" +
			"2|_|P|P|P|P|P|P|P|\n" +
			"1|_|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";
		check(input,output);
	}
	
	//Knight takes a pawn (no double steps included)
	@Test public void testValid_10() {
		String input = "d2-d3 Nb8-c6\n"+"Nb1-c3 Nc6-e5\n"+"Nc3-d5 Ne5xd3\n";
		String output = 
				"8|r|_|b|q|k|b|n|r|\n" +
				"7|p|p|p|p|p|p|p|p|\n" +
				"6|_|_|_|_|_|_|_|_|\n" +
				"5|_|_|_|N|_|_|_|_|\n" +
				"4|_|_|_|_|_|_|_|_|\n" +
				"3|_|_|_|n|_|_|_|_|\n" +
				"2|P|P|P|_|P|P|P|P|\n" +
				"1|R|_|B|Q|K|B|N|R|\n" +
				"  a b c d e f g h";
		check(input,output);
	}
	
	//White pawn takes black one 
	@Test public void testValid_11() {
		String input = "d2-d4 e7-e5\n"+"d4xe5 h7-h6\n";
		String output = 
				"8|r|n|b|q|k|b|n|r|\n" +
				"7|p|p|p|p|_|p|p|_|\n" +
				"6|_|_|_|_|_|_|_|p|\n" +
				"5|_|_|_|_|P|_|_|_|\n" +
				"4|_|_|_|_|_|_|_|_|\n" +
				"3|_|_|_|_|_|_|_|_|\n" +
				"2|P|P|P|_|P|P|P|P|\n" +
				"1|R|N|B|Q|K|B|N|R|\n" +
				"  a b c d e f g h";
		check(input,output);
	}
	
	//Black castleing 
	@Test public void testValid_12() { //error (solved)
		String input = "Ng1-f3 Ng8-f6\n" + "g2-g3 g7-g6\n" + "Bf1-h3 Bf8-h6\n" + "O-O O-O\n" + "";
		String output = 
			"8|r|n|b|q|_|r|k|_|\n" +
            "7|p|p|p|p|p|p|_|p|\n" +
            "6|_|_|_|_|_|n|p|b|\n" +
            "5|_|_|_|_|_|_|_|_|\n" +
            "4|_|_|_|_|_|_|_|_|\n" +
            "3|_|_|_|_|_|N|P|B|\n" +
            "2|P|P|P|P|P|P|_|P|\n" +
            "1|R|N|B|Q|_|R|K|_|\n" +
            "  a b c d e f g h";
		check(input,output);
	} 	
	
	//Pawn promotion with black
	@Test public void testValid_13() { //error (solved)
		String input = "a2-a4 b7-b5\n"+"a4xb5 Nb8-c6\n"+"b5-b6 a7-a6\n"+"b6-b7 a6-a5\n"+"b7-b8=N\n"+"";
		String output = 
			"8|r|N|b|q|k|b|n|r|\n" +
			"7|_|_|p|p|p|p|p|p|\n" +
			"6|_|_|n|_|_|_|_|_|\n" +
			"5|p|_|_|_|_|_|_|_|\n" +
			"4|_|_|_|_|_|_|_|_|\n" +
			"3|_|_|_|_|_|_|_|_|\n" +
			"2|_|P|P|P|P|P|P|P|\n" +
			"1|R|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";
		check(input,output);
	}
	
	//Enpassant 
	@Test public void testValid_14() { //error 
		String input = "h2-h3 b7-b5\n"+"g2-g3 b5-b4\n"+"a2-a4 b4xa3ep";
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|p|_|p|p|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|_|_|_|_|_|_|_|_|\n" +
			"3|p|_|_|_|_|_|P|P|\n" +
			"2|_|P|P|P|P|P|_|_|\n" +
			"1|R|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";
		check(input,output);
	}
	
	@Test public void testValid_15() { //error
		String input = "a2-a4 h7-h6\n"+"a4-a5 b7-b5\n"+"na5xb6ep\n"+"";
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|p|_|p|p|p|p|p|_|\n" +
			"6|_|P|_|_|_|_|_|p|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|_|_|_|_|_|_|_|_|\n" +
			"3|_|_|_|_|_|_|_|_|\n" +
			"2|_|P|P|P|P|P|P|P|\n" +
			"1|R|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";
		check(input,output);
	}
	
	//King can move in diagonal back right 
	@Test public void testValid_16() { 
		String input =
		    "e2-e4 d7-d5\n" + "Ke1-e2 Ke8-d7\n" + "Ke2-d3 a7-a6\n" + "Kd3-d4 a6-a5\n" + "Kd4-e3\n" +
		    "";
		  String output =
		    "8|r|n|b|q|_|b|n|r|\n" +
		    "7|_|p|p|k|p|p|p|p|\n" +
		    "6|_|_|_|_|_|_|_|_|\n" +
		    "5|p|_|_|p|_|_|_|_|\n" +
		    "4|_|_|_|_|P|_|_|_|\n" +
		    "3|_|_|_|_|K|_|_|_|\n" +
		    "2|P|P|P|P|_|P|P|P|\n" +
		    "1|R|N|B|Q|_|B|N|R|\n" +
		    "  a b c d e f g h";

		  check(input, output);
	}
	
	//King can move diagonal back left 
	@Test public void testValid_17() { 
		String input =
		    "e2-e4 d7-d5\n" + "Ke1-e2 Ke8-d7\n" + "Ke2-d3 a7-a6\n" + "Kd3-d4 a6-a5\n" + "Kd4-c3\n" +
		    "";
		  String output =
		    "8|r|n|b|q|_|b|n|r|\n" +
		    "7|_|p|p|k|p|p|p|p|\n" +
		    "6|_|_|_|_|_|_|_|_|\n" +
		    "5|p|_|_|p|_|_|_|_|\n" +
		    "4|_|_|_|_|P|_|_|_|\n" +
		    "3|_|_|K|_|_|_|_|_|\n" +
		    "2|P|P|P|P|_|P|P|P|\n" +
		    "1|R|N|B|Q|_|B|N|R|\n" +
		    "  a b c d e f g h";

		  check(input, output);
	}
	
	//King can move diagonal top right 
	@Test public void testValid_18() { 
		String input =
		    "e2-e4 d7-d5\n" + "Ke1-e2 Ke8-d7\n" + "Ke2-d3 a7-a6\n" + "Kd3-d4 a6-a5\n" + "Kd4-e5\n" +
		    "";
		  String output =
		    "8|r|n|b|q|_|b|n|r|\n" +
		    "7|_|p|p|k|p|p|p|p|\n" +
		    "6|_|_|_|_|_|_|_|_|\n" +
		    "5|p|_|_|p|K|_|_|_|\n" +
		    "4|_|_|_|_|P|_|_|_|\n" +
		    "3|_|_|_|_|_|_|_|_|\n" +
		    "2|P|P|P|P|_|P|P|P|\n" +
		    "1|R|N|B|Q|_|B|N|R|\n" +
		    "  a b c d e f g h";

		  check(input, output);
	}
	
	//King can move diagonal top left
	@Test public void testValid_19() { 
		
	}
	
	//Check check
	@Test public void testValid_20() { //error(solved)
		String input = "g2-g3 d7-d6\n"+"Bf1-h3 h7-h6\n"+"Bh3-d7+\n"+"";
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|p|p|p|B|p|p|p|_|\n" +
			"6|_|_|_|p|_|_|_|p|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|_|_|_|_|_|_|_|_|\n" +
			"3|_|_|_|_|_|_|P|_|\n" +
			"2|P|P|P|P|P|P|_|P|\n" +
			"1|R|N|B|Q|K|_|N|R|\n" +
			"  a b c d e f g h";
		check(input,output);
	}
	
	//Bishop can move diagonally
	@Test public void testValid_21() { //error (solved)
		String input = "g2-g3 g7-g6\n"+"Bf1-h3 Bf8-h6\n";
		String output =
			"8|r|n|b|q|k|_|n|r|\n" +
			"7|p|p|p|p|p|p|_|p|\n" +
			"6|_|_|_|_|_|_|p|b|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|_|_|_|_|_|_|_|_|\n" +
			"3|_|_|_|_|_|_|P|B|\n" +
			"2|P|P|P|P|P|P|_|P|\n" +
			"1|R|N|B|Q|K|_|N|R|\n" +
			"  a b c d e f g h";
		check(input,output);
	}
	
	//white and black castling 
	@Test public void testValid_22() { //error 
        String input =
            "e2-e3 e7-e6\n" + "Ke1-e2 Ke8-e7\n" + "Ke2-e1\n" +
            "";
        String output =
            "8|r|n|b|q|k|b|n|r|\n" +
            "7|p|p|p|p|_|p|p|p|\n" +
            "6|_|_|_|_|p|_|_|_|\n" +
            "5|_|_|_|_|_|_|_|_|\n" +
            "4|_|_|_|_|_|_|_|_|\n" +
            "3|_|_|_|_|P|_|_|_|\n" +
            "2|P|P|P|P|_|P|P|P|\n" +
            "1|R|N|B|Q|K|B|N|R|\n" +
            "  a b c d e f g h";
        check(input,output);
    }
	
	//black pawn taking peices 
	@Test public void testValid_23() {
		String input = "e2-e4 f7-f5\n"+"h2-h3 f5xe4\n";
		String output =
            "8|r|n|b|q|k|b|n|r|\n" +
            "7|p|p|p|p|p|_|p|p|\n" +
            "6|_|_|_|_|_|_|_|_|\n" +
            "5|_|_|_|_|_|_|_|_|\n" +
            "4|_|_|_|_|p|_|_|_|\n" +
            "3|_|_|_|_|_|_|_|P|\n" +
            "2|P|P|P|P|_|P|P|_|\n" +
            "1|R|N|B|Q|K|B|N|R|\n" +
            "  a b c d e f g h";
        check(input,output);
	}
	
	//White won 
	@Test public void testValid_24() {
		String input = "Nb1-c3 h7-h6\n"+"Nc3-d5 h6-h5\n"+"Nd5-f6 h5-h4\n"+"Nf6xe8 0-1\n"+"";
		String output =
            "8|r|n|b|q|N|b|n|r|\n" +
            "7|p|p|p|p|p|p|p|_|\n" +
            "6|_|_|_|_|_|_|_|_|\n" +
            "5|_|_|_|_|_|_|_|_|\n" +
            "4|_|_|_|_|_|_|_|p|\n" +
            "3|_|_|_|_|_|_|_|_|\n" +
            "2|P|P|P|P|P|P|P|P|\n" +
            "1|R|_|B|Q|K|B|N|R|\n" +
            "  a b c d e f g h";
        check(input,output);
	}
	
	//Black won 
	@Test public void testValid_25() {
		String input = "a2-a3 Nb8-c6\n"+"a3-a4 Nc6-d4\n"+"a4-a5 Nd4-f3\n"+"a5-a6 Nf3xe1 1-0\n";
		String output =
            "8|r|_|b|q|k|b|n|r|\n" +
            "7|p|p|p|p|p|p|p|p|\n" +
            "6|P|_|_|_|_|_|_|_|\n" +
            "5|_|_|_|_|_|_|_|_|\n" +
            "4|_|_|_|_|_|_|_|_|\n" +
            "3|_|_|_|_|_|_|_|_|\n" +
            "2|_|P|P|P|P|P|P|P|\n" +
            "1|R|N|B|Q|n|B|N|R|\n" +
            "  a b c d e f g h";
        check(input,output);
	}
	
	//When taking peice should be able to do pawn promotion
	@Test public void testValid_26() { 
        String input = "a2-a4 b7-b5\n"+"a4xb5 Nb8-c6\n"+"b5-b6 a7-a6\n"+"b6-b7 a6-a5\n"+"b7xBc8=N\n"+"";
        String output = 
            "8|r|_|N|q|k|b|n|r|\n" +
            "7|_|_|p|p|p|p|p|p|\n" +
            "6|_|_|n|_|_|_|_|_|\n" +
            "5|p|_|_|_|_|_|_|_|\n" +
            "4|_|_|_|_|_|_|_|_|\n" +
            "3|_|_|_|_|_|_|_|_|\n" +
            "2|_|P|P|P|P|P|P|P|\n" +
            "1|R|N|B|Q|K|B|N|R|\n" +
            "  a b c d e f g h";
        check(input,output);
    }
	
	//white Knight can take Bishop
	@Test public void testValid_27() { 
		String input = "Ng1-f3 d7-d6\n"+"Nf3-g5 Bc8-e6\n"+"Ng5xe6\n"+"";
		String output = 
			"8|r|n|_|q|k|b|n|r|\n" +
            "7|p|p|p|_|p|p|p|p|\n" +
            "6|_|_|_|p|N|_|_|_|\n" +
            "5|_|_|_|_|_|_|_|_|\n" +
            "4|_|_|_|_|_|_|_|_|\n" +
            "3|_|_|_|_|_|_|_|_|\n" +
            "2|P|P|P|P|P|P|P|P|\n" +
            "1|R|N|B|Q|K|B|_|R|\n" +
            "  a b c d e f g h";
        check(input,output);
	}
	
	//black Knight can take Bishop
	@Test public void testValid_28() { 
		String input = "d2-d3 Ng8-f6\n"+"Bc1-e3 Nf6-g4\n"+"h2-h3 Ng4xe3\n";
		String output = 
			"8|r|n|b|q|k|b|_|r|\n" +
            "7|p|p|p|p|p|p|p|p|\n" +
            "6|_|_|_|_|_|_|_|_|\n" +
            "5|_|_|_|_|_|_|_|_|\n" +
            "4|_|_|_|_|_|_|_|_|\n" +
            "3|_|_|_|P|n|_|_|P|\n" +
            "2|P|P|P|_|P|P|P|_|\n" +
            "1|R|N|_|Q|K|B|N|R|\n" +
            "  a b c d e f g h";
        check(input,output);
	}
	
	//black bishops can take pawns 
	@Test public void testValid_29() { 
		String input = "h2-h3 d7-d6\n"+"a2-a3 Bc8xh3\n";
		String output = 
			"8|r|n|_|q|k|b|n|r|\n" +
            "7|p|p|p|_|p|p|p|p|\n" +
            "6|_|_|_|p|_|_|_|_|\n" +
            "5|_|_|_|_|_|_|_|_|\n" +
            "4|_|_|_|_|_|_|_|_|\n" +
            "3|P|_|_|_|_|_|_|b|\n" +
            "2|_|P|P|P|P|P|P|_|\n" +
            "1|R|N|B|Q|K|B|N|R|\n" +
            "  a b c d e f g h";
        check(input,output);
	}
	
	//white bishops can take pawns 
	@Test public void testValid_30() { 
		String input = "e2-e3 a7-a6\n"+"Bf1xa6\n"+"";
		String output = 
			"8|r|n|b|q|k|b|n|r|\n" +
            "7|_|p|p|p|p|p|p|p|\n" +
            "6|B|_|_|_|_|_|_|_|\n" +
            "5|_|_|_|_|_|_|_|_|\n" +
            "4|_|_|_|_|_|_|_|_|\n" +
            "3|_|_|_|_|P|_|_|_|\n" +
            "2|P|P|P|P|_|P|P|P|\n" +
            "1|R|N|B|Q|K|_|N|R|\n" +
            "  a b c d e f g h";
        check(input,output);
	}
	
	//white Knight can take a pawn 
	@Test public void testValid_31() { 
		String input = "Ng1-f3 a7-a6\n"+"Nf3-g5 a6-a5\n"+"Ng5xf7\n"+"";
		String output = 
			"8|r|n|b|q|k|b|n|r|\n" +
            "7|_|p|p|p|p|N|p|p|\n" +
            "6|_|_|_|_|_|_|_|_|\n" +
            "5|p|_|_|_|_|_|_|_|\n" +
            "4|_|_|_|_|_|_|_|_|\n" +
            "3|_|_|_|_|_|_|_|_|\n" +
            "2|P|P|P|P|P|P|P|P|\n" +
            "1|R|N|B|Q|K|B|_|R|\n" +
            "  a b c d e f g h";
        check(input,output);
	}
	
	//black Knight can take a pawn 
	@Test public void testValid_32() { 
		String input = "a2-a3 Ng8-f6\n"+"a3-a4 Nf6-g4\n"+"a4-a5 Ng4-f2";
		String output = 
			"8|r|n|b|q|k|b|_|r|\n" +
            "7|p|p|p|p|p|p|p|p|\n" +
            "6|_|_|_|_|_|_|_|_|\n" +
            "5|P|_|_|_|_|_|_|_|\n" +
            "4|_|_|_|_|_|_|_|_|\n" +
            "3|_|_|_|_|_|_|_|_|\n" +
            "2|_|P|P|P|P|n|P|P|\n" +
            "1|R|N|B|Q|K|B|N|R|\n" +
            "  a b c d e f g h";
        check(input,output);
	}
	
	//white Knight can take Knight 
	@Test public void testValid_33() { 
		String input = "Ng1-f3 Ng8-h6\n"+"Nf3-d4 Nh6-f5\n"+"Nd4xf5\n"+"";
		String output = 
			"8|r|n|b|q|k|b|_|r|\n" +
            "7|p|p|p|p|p|p|p|p|\n" +
            "6|_|_|_|_|_|_|_|_|\n" +
            "5|_|_|_|_|_|N|_|_|\n" +
            "4|_|_|_|_|_|_|_|_|\n" +
            "3|_|_|_|_|_|_|_|_|\n" +
            "2|P|P|P|P|P|P|P|P|\n" +
            "1|R|N|B|Q|K|B|_|R|\n" +
            "  a b c d e f g h";
        check(input,output);
	}
	
	//black Knight can take Knight 
	@Test public void testValid_34() { 
		String input = "Ng1-f3 Ng8-h6\n"+"Nf3-d4 Nh6-f5\n"+"h2-h3 Nf5xd4\n";
		String output = 
			"8|r|n|b|q|k|b|_|r|\n" +
            "7|p|p|p|p|p|p|p|p|\n" +
            "6|_|_|_|_|_|_|_|_|\n" +
            "5|_|_|_|_|_|_|_|_|\n" +
            "4|_|_|_|n|_|_|_|_|\n" +
            "3|_|_|_|_|_|_|_|P|\n" +
            "2|P|P|P|P|P|P|P|_|\n" +
            "1|R|N|B|Q|K|B|_|R|\n" +
            "  a b c d e f g h";
        check(input,output);
	}
	
	//white pawn can Take after a double step 
	@Test public void testValid_35() { 
		String input = "d2-d4 e7-e5\n"+"d4xe5\n"+"";
		String output = 
			"8|r|n|b|q|k|b|n|r|\n" +
            "7|p|p|p|p|_|p|p|p|\n" +
            "6|_|_|_|_|_|_|_|_|\n" +
            "5|_|_|_|_|P|_|_|_|\n" +
            "4|_|_|_|_|_|_|_|_|\n" +
            "3|_|_|_|_|_|_|_|_|\n" +
            "2|P|P|P|_|P|P|P|P|\n" +
            "1|R|N|B|Q|K|B|N|R|\n" +
            "  a b c d e f g h";
        check(input,output);
	}
	
	//black pawn can Take after a double step 
	@Test public void testValid_36() { 
		String input = "d2-d4 e7-e5\n"+"h2-h3 e5xd4\n";
		String output = 
			"8|r|n|b|q|k|b|n|r|\n" +
            "7|p|p|p|p|_|p|p|p|\n" +
            "6|_|_|_|_|_|_|_|_|\n" +
            "5|_|_|_|_|_|_|_|_|\n" +
            "4|_|_|_|p|_|_|_|_|\n" +
            "3|_|_|_|_|_|_|_|P|\n" +
            "2|P|P|P|_|P|P|P|_|\n" +
            "1|R|N|B|Q|K|B|N|R|\n" +
            "  a b c d e f g h";
        check(input,output);
	}
	
	//Black queen can move forwards and then diagonally
	@Test public void testValid_37() { 
		String input = "a2-a3 d7-d6\n"+"a3-a4 Qd8-d7\n"+"a4-a5 Qd7-h3\n";
		String output = 
			"8|r|n|b|_|k|b|n|r|\n" +
            "7|p|p|p|_|p|p|p|p|\n" +
            "6|_|_|_|p|_|_|_|_|\n" +
            "5|P|_|_|_|_|_|_|_|\n" +
            "4|_|_|_|_|_|_|_|_|\n" +
            "3|_|_|_|_|_|_|_|q|\n" +
            "2|_|P|P|P|P|P|P|P|\n" +
            "1|R|N|B|Q|K|B|N|R|\n" +
            "  a b c d e f g h";
        check(input,output);
	}
	
	//White queen can move forwards and then diagonally
	@Test public void testValid_38() { 
		String input = "d2-d3 a7-a6\n"+"Qd1-d2 a6-a5\n"+"Qd2-h6\n"+"";
		String output = 
			"8|r|n|b|q|k|b|n|r|\n" +
            "7|_|p|p|p|p|p|p|p|\n" +
            "6|_|_|_|_|_|_|_|Q|\n" +
            "5|p|_|_|_|_|_|_|_|\n" +
            "4|_|_|_|_|_|_|_|_|\n" +
            "3|_|_|_|P|_|_|_|_|\n" +
            "2|P|P|P|_|P|P|P|P|\n" +
            "1|R|N|B|_|K|B|N|R|\n" +
            "  a b c d e f g h";
        check(input,output);
	}
	
	//White Queen can take Queen 
	@Test public void testValid_39() { 
		String input = "e2-e3 e7-e6\n"+"Qd1-g4 Qd8-g5\n"+"Qg4xQg5\n"+"";
		String output = 
			"8|r|n|b|_|k|b|n|r|\n" +
            "7|p|p|p|p|_|p|p|p|\n" +
            "6|_|_|_|_|p|_|_|_|\n" +
            "5|_|_|_|_|_|_|Q|_|\n" +
            "4|_|_|_|_|_|_|_|_|\n" +
            "3|_|_|_|_|P|_|_|_|\n" +
            "2|P|P|P|P|_|P|P|P|\n" +
            "1|R|N|B|_|K|B|N|R|\n" +
            "  a b c d e f g h";
        check(input,output);
	}
	
	//Black Queen can take Queen 
	@Test public void testValid_40() { 
		String input = "e2-e3 e7-e6\n"+"Qd1-g4 Qd8-g5\n"+"a2-a3 Qg5xQg4\n";
		String output = 
			"8|r|n|b|_|k|b|n|r|\n" +
            "7|p|p|p|p|_|p|p|p|\n" +
            "6|_|_|_|_|p|_|_|_|\n" +
            "5|_|_|_|_|_|_|_|_|\n" +
            "4|_|_|_|_|_|_|q|_|\n" +
            "3|P|_|_|_|P|_|_|_|\n" +
            "2|_|P|P|P|_|P|P|P|\n" +
            "1|R|N|B|_|K|B|N|R|\n" +
            "  a b c d e f g h";
        check(input,output);
	}
	
	//white Pawn can take queen 
	@Test public void testValid_41() { 
		String input = "f2-f4 e7-e6\n"+"a2-a3 Qd8-g5\n"+"f4xQg5"; 
		String output = 
			"8|r|n|b|_|k|b|n|r|\n" +
            "7|p|p|p|p|_|p|p|p|\n" +
            "6|_|_|_|_|p|_|_|_|\n" +
            "5|_|_|_|_|_|_|P|_|\n" +
            "4|_|_|_|_|_|_|_|_|\n" +
            "3|P|_|_|_|_|_|_|_|\n" +
            "2|_|P|P|P|P|_|P|P|\n" +
            "1|R|N|B|Q|K|B|N|R|\n" +
            "  a b c d e f g h";
        check(input,output);
	}
	
	//Black pawn can take queen 
	@Test public void testValid_42() { 
		String input = "e2-e3 f7-f5\n"+"Qd1-g4 f5xQg4\n";
		String output = 
			"8|r|n|b|q|k|b|n|r|\n" +
            "7|p|p|p|p|p|_|p|p|\n" +
            "6|_|_|_|_|_|_|_|_|\n" +
            "5|_|_|_|_|_|_|_|_|\n" +
            "4|_|_|_|_|_|_|p|_|\n" +
            "3|_|_|_|_|P|_|_|_|\n" +
            "2|P|P|P|P|_|P|P|P|\n" +
            "1|R|N|B|_|K|B|N|R|\n" +
            "  a b c d e f g h";
        check(input,output);
	}
	
	//black rook and white rook can both move forward in same round 
	@Test public void testValid_43() { 
		String input = "a2-a3 a7-a6\n"+"Ra1-a2 Ra8-a7\n";
		String output = 
			"8|_|n|b|q|k|b|n|r|\n" +
            "7|r|p|p|p|p|p|p|p|\n" +
            "6|p|_|_|_|_|_|_|_|\n" +
            "5|_|_|_|_|_|_|_|_|\n" +
            "4|_|_|_|_|_|_|_|_|\n" +
            "3|P|_|_|_|_|_|_|_|\n" +
            "2|R|P|P|P|P|P|P|P|\n" +
            "1|_|N|B|Q|K|B|N|R|\n" +
            "  a b c d e f g h";
        check(input,output);
	}
	
	//white Rook can move horizontally 
	@Test public void testValid_44() { 
		String input = "h2-h4 h7-h6\n"+"Rh1-h3 h6-h5\n"+"Rh3-a3\n"+"";
		String output = 
			"8|r|n|b|q|k|b|n|r|\n" +
            "7|p|p|p|p|p|p|p|_|\n" +
            "6|_|_|_|_|_|_|_|_|\n" +
            "5|_|_|_|_|_|_|_|p|\n" +
            "4|_|_|_|_|_|_|_|P|\n" +
            "3|R|_|_|_|_|_|_|_|\n" +
            "2|P|P|P|P|P|P|P|_|\n" +
            "1|R|N|B|Q|K|B|N|_|\n" +
            "  a b c d e f g h";
        check(input,output);
	}
	
	//black Rook can move horizontally 
	@Test public void testValid_45() { 
		String input = "h2-h3 h7-h5\n"+"h3-h4 Rh8-h6\n"+"a2-a3 Rh6-a6\n";
		String output = 
			"8|r|n|b|q|k|b|n|_|\n" +
            "7|p|p|p|p|p|p|p|_|\n" +
            "6|r|_|_|_|_|_|_|_|\n" +
            "5|_|_|_|_|_|_|_|p|\n" +
            "4|_|_|_|_|_|_|_|P|\n" +
            "3|P|_|_|_|_|_|_|_|\n" +
            "2|_|P|P|P|P|P|P|_|\n" +
            "1|R|N|B|Q|K|B|N|R|\n" +
            "  a b c d e f g h";
        check(input,output);
	}
	
	//white Rook can take a rook 
	@Test public void testValid_46() { 
		String input = "h2-h4 h7-h5\n"+"Rh1-h3 Rh8-h6\n"+"Rh3-a3 Rh6-a6\n"+"Ra3xa6\n"+"";
		String output = 
			"8|r|n|b|q|k|b|n|_|\n" +
            "7|p|p|p|p|p|p|p|_|\n" +
            "6|R|_|_|_|_|_|_|_|\n" +
            "5|_|_|_|_|_|_|_|p|\n" +
            "4|_|_|_|_|_|_|_|P|\n" +
            "3|_|_|_|_|_|_|_|_|\n" +
            "2|P|P|P|P|P|P|P|_|\n" +
            "1|R|N|B|Q|K|B|N|_|\n" +
            "  a b c d e f g h";
        check(input,output);
	}
	
	//black Rook can take a rook 
	@Test public void testValid_47() { 
		String input = "h2-h4 h7-h5\n"+"Rh1-h3 Rh8-h6\n"+"Rh3-a3 Rh6-a6\n"+"g2-g3 Ra6xa3\n";
		String output = 
			"8|r|n|b|q|k|b|n|_|\n" +
            "7|p|p|p|p|p|p|p|_|\n" +
            "6|_|_|_|_|_|_|_|_|\n" +
            "5|_|_|_|_|_|_|_|p|\n" +
            "4|_|_|_|_|_|_|_|P|\n" +
            "3|r|_|_|_|_|_|P|_|\n" +
            "2|P|P|P|P|P|P|_|_|\n" +
            "1|R|N|B|Q|K|B|N|_|\n" +
            "  a b c d e f g h";
        check(input,output);
	}
	
	//white Rook can take a pawn 
	@Test public void testValid_48() { 
		String input = "a2-a4 a7-a6\n"+"Ra1-a3 a6-a5\n"+"Ra3-b3 h7-h6\n"+"Rb3xb7\n"+"";
		String output = 
			"8|r|n|b|q|k|b|n|r|\n" +
            "7|_|R|p|p|p|p|p|_|\n" +
            "6|_|_|_|_|_|_|_|p|\n" +
            "5|p|_|_|_|_|_|_|_|\n" +
            "4|P|_|_|_|_|_|_|_|\n" +
            "3|_|_|_|_|_|_|_|_|\n" +
            "2|_|P|P|P|P|P|P|P|\n" +
            "1|_|N|B|Q|K|B|N|R|\n" +
            "  a b c d e f g h";
        check(input,output);
	}
	
	//black Rook can take a pawn 
	@Test public void testValid_49() { 
		String input = "a2-a3 a7-a5\n"+"a3-a4 Ra8-a6\n"+"h2-h3 Ra6-b6\n"+"h3-h4 Rb6xb2\n";
		String output = 
			"8|r|n|b|q|k|b|n|r|\n" +
            "7|_|p|p|p|p|p|p|p|\n" +
            "6|_|_|_|_|_|_|_|_|\n" +
            "5|p|_|_|_|_|_|_|_|\n" +
            "4|P|_|_|_|_|_|_|P|\n" +
            "3|_|_|_|_|_|_|_|_|\n" +
            "2|_|P|P|P|P|P|P|_|\n" +
            "1|R|N|B|Q|K|B|N|R|\n" +
            "  a b c d e f g h";
        check(input,output);
	}
	
	//Enpassant and then a pawn promotion
	@Test public void testValid_50() {
		String input =
			"a2-a4 h7-h5\n"+"Ra1-a3 Rh8-h6\n"+"Ra3-d3 Rh6-g6\n"+"Rd3xd7 h5-h4\n"+"g2-g4 h4xg3ep\n" +
			"h2-h4 b7-b5\n"+"h4-h5 b5-b4\n"+"h5-h6 b4-b3\n"+"h6-h7 b3xc2\n"+"h7-h8=Q\n"+"";
		String output =
			"8|r|n|b|q|k|b|n|Q|\n" +
			"7|p|_|p|R|p|p|p|_|\n" +
			"6|_|_|_|_|_|_|r|_|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|P|_|_|_|_|_|_|_|\n" +
			"3|_|_|_|_|_|_|p|_|\n" +
			"2|_|P|p|P|P|P|_|_|\n" +
			"1|_|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";
		check(input,output);
	}
	
	//Queen side castling 
	@Test public void testValid_51() {
		String input =
			"Nb1-a3 h7-h5\n"+"d2-d4 g7-g5\n"+"Bc1-e3 f7-f5\n"+"Qd1-d3 e7-e5\n"+"O-O-O"+"";
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|p|p|p|p|_|_|_|_|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|_|p|p|p|p|\n" +
			"4|_|_|_|P|_|_|_|_|\n" +
			"3|N|_|_|Q|B|_|_|_|\n" +
			"2|P|P|P|_|P|P|P|P|\n" +
			"1|_|_|K|R|_|B|N|R|\n" +
			"  a b c d e f g h";
		check(input,output);
	}
	

// ================================================
// Invalid Tests
// ================================================

@Test public void testInvalid_01() {
	String input =
		"a2-a2\n" +
		"";
	String output =
		"8|r|n|b|q|k|b|n|r|\n" +
		"7|p|p|p|p|p|p|p|p|\n" +
		"6|_|_|_|_|_|_|_|_|\n" +
		"5|_|_|_|_|_|_|_|_|\n" +
		"4|_|_|_|_|_|_|_|_|\n" +
		"3|_|_|_|_|_|_|_|_|\n" +
		"2|P|P|P|P|P|P|P|P|\n" +
		"1|R|N|B|Q|K|B|N|R|\n" +
		"  a b c d e f g h";

	check(input,output);
}

//cannot moving bishop into pawn
@Test public void testInvalid_02() {
	String input =
		"c1-d2\n" +
		"";
	String output =
		"8|r|n|b|q|k|b|n|r|\n" +
		"7|p|p|p|p|p|p|p|p|\n" +
		"6|_|_|_|_|_|_|_|_|\n" +
		"5|_|_|_|_|_|_|_|_|\n" +
		"4|_|_|_|_|_|_|_|_|\n" +
		"3|_|_|_|_|_|_|_|_|\n" +
		"2|P|P|P|P|P|P|P|P|\n" +
		"1|R|N|B|Q|K|B|N|R|\n" +
		"  a b c d e f g h";
	check(input,output);
}

//cannot Moving Rook out of bounds by row 
@Test public void testInvalid_03() {
	String input = "h1-i1\n"+"";
	String output =
		"8|r|n|b|q|k|b|n|r|\n" +
		"7|p|p|p|p|p|p|p|p|\n" +
		"6|_|_|_|_|_|_|_|_|\n" +
		"5|_|_|_|_|_|_|_|_|\n" +
		"4|_|_|_|_|_|_|_|_|\n" +
		"3|_|_|_|_|_|_|_|_|\n" +
		"2|P|P|P|P|P|P|P|P|\n" +
		"1|R|N|B|Q|K|B|N|R|\n" +
		"  a b c d e f g h";
	check(input,output);
}

//cannot Moving pawn backwards 
@Test public void testInvalid_04() {
	String input = "a2-a1\n"+"";
	String output =
		"8|r|n|b|q|k|b|n|r|\n" +
		"7|p|p|p|p|p|p|p|p|\n" +
		"6|_|_|_|_|_|_|_|_|\n" +
		"5|_|_|_|_|_|_|_|_|\n" +
		"4|_|_|_|_|_|_|_|_|\n" +
		"3|_|_|_|_|_|_|_|_|\n" +
		"2|P|P|P|P|P|P|P|P|\n" +
		"1|R|N|B|Q|K|B|N|R|\n" +
		"  a b c d e f g h";
	check(input,output);
}

//cannot Moving Pawn diagonally 
@Test public void testInvalid_05() { //error
	String input = "a2-b3\n"+"";
	String output =
		"8|r|n|b|q|k|b|n|r|\n" +
		"7|p|p|p|p|p|p|p|p|\n" +
		"6|_|_|_|_|_|_|_|_|\n" +
		"5|_|_|_|_|_|_|_|_|\n" +
		"4|_|_|_|_|_|_|_|_|\n" +
		"3|_|_|_|_|_|_|_|_|\n" +
		"2|P|P|P|P|P|P|P|P|\n" +
		"1|R|N|B|Q|K|B|N|R|\n" +
		"  a b c d e f g h";
	check(input,output);
}

//cannot Moving pawn into occupied space 
@Test public void testInvalid_06() {
	String input = "a2-a3 a7-a6\n"+"a3-a4 a6-a5\n"+"a4-a5\n"+"";
	String output =
		"8|r|n|b|q|k|b|n|r|\n" +
		"7|_|p|p|p|p|p|p|p|\n" +
		"6|_|_|_|_|_|_|_|_|\n" +
		"5|p|_|_|_|_|_|_|_|\n" +
		"4|P|_|_|_|_|_|_|_|\n" +
		"3|_|_|_|_|_|_|_|_|\n" +
		"2|_|P|P|P|P|P|P|P|\n" +
		"1|R|N|B|Q|K|B|N|R|\n" +
		"  a b c d e f g h";
	check(input,output);
}

//Pawn cannot take another peice via forward direction
@Test public void testInvalid_07() {
	String input = "a2-a3 a7-a6\n"+"a3-a4 a6-a5\n"+"a4xa5\n"+"";
	String output =
		"8|r|n|b|q|k|b|n|r|\n" +
		"7|_|p|p|p|p|p|p|p|\n" +
		"6|_|_|_|_|_|_|_|_|\n" +
		"5|p|_|_|_|_|_|_|_|\n" +
		"4|P|_|_|_|_|_|_|_|\n" +
		"3|_|_|_|_|_|_|_|_|\n" +
		"2|_|P|P|P|P|P|P|P|\n" +
		"1|R|N|B|Q|K|B|N|R|\n" +
		"  a b c d e f g h";
	check(input,output);
}

//Pawn cannot take another peice from more than one diagonal neighbour
@Test public void testInvalid_08() {
	String input = "a2-a3 c7-c6\n"+"a3-a4 c6xa4\n";
	String output =
		"8|r|n|b|q|k|b|n|r|\n" +
		"7|p|p|_|p|p|p|p|p|\n" +
		"6|_|_|p|_|_|_|_|_|\n" +
		"5|_|_|_|_|_|_|_|_|\n" +
		"4|P|_|_|_|_|_|_|_|\n" +
		"3|_|_|_|_|_|_|_|_|\n" +
		"2|_|P|P|P|P|P|P|P|\n" +
		"1|R|N|B|Q|K|B|N|R|\n" +
		"  a b c d e f g h";
	check(input,output);
}

//Pawn cannot take another pawn horizontally
@Test public void testInvalid_09() {
	String input = "a2-a3 b7-b6\n"+"a3-a4 b6-b5\n"+"a4-a5 b5xa5\n";
	String output =
		"8|r|n|b|q|k|b|n|r|\n" +
		"7|p|_|p|p|p|p|p|p|\n" +
		"6|_|_|_|_|_|_|_|_|\n" +
		"5|P|p|_|_|_|_|_|_|\n" +
		"4|_|_|_|_|_|_|_|_|\n" +
		"3|_|_|_|_|_|_|_|_|\n" +
		"2|_|P|P|P|P|P|P|P|\n" +
		"1|R|N|B|Q|K|B|N|R|\n" +
		"  a b c d e f g h";
	check(input,output);
}

//King cannot move into occupied space 
@Test public void testInvalid_10() {
	String input = "Ke1-e2\n"+"";
	String output =
		"8|r|n|b|q|k|b|n|r|\n" +
		"7|p|p|p|p|p|p|p|p|\n" +
		"6|_|_|_|_|_|_|_|_|\n" +
		"5|_|_|_|_|_|_|_|_|\n" +
		"4|_|_|_|_|_|_|_|_|\n" +
		"3|_|_|_|_|_|_|_|_|\n" +
		"2|P|P|P|P|P|P|P|P|\n" +
		"1|R|N|B|Q|K|B|N|R|\n" +
		"  a b c d e f g h";
	check(input,output);
}

//King cannot move more than one space at a time 
@Test public void testInvalid_11() {
	String input = "e2-e3 e7-e6\n"+"e3-e4 e6-5\n"+"Ke1-e3"+"";
	String output = 
		"8|r|n|b|q|k|b|n|r|\n" +
		"7|p|p|p|p|p|p|p|p|\n" +
		"6|_|_|_|_|_|_|_|_|\n" +
		"5|_|_|_|_|_|_|_|_|\n" +
		"4|_|_|_|_|_|_|_|_|\n" +
		"3|_|_|_|_|_|_|_|_|\n" +
		"2|P|P|P|P|P|P|P|P|\n" +
		"1|R|N|B|Q|K|B|N|R|\n" +
		"  a b c d e f g h";
	check(input,output);
}

//Bishop cannot move in any other direction but diagonal 
@Test public void testInvalid_12() { //error 
	String input = "f2-f3 f1-f4\n";
	String output = 
		"8|r|n|b|q|k|b|n|r|\n" +
		"7|p|p|p|p|p|p|p|p|\n" +
		"6|_|_|_|_|_|_|_|_|\n" +
		"5|_|_|_|_|_|_|_|_|\n" +
		"4|_|_|_|_|_|_|_|_|\n" +
		"3|_|_|_|_|_|P|_|_|\n" +
		"2|P|P|P|P|P|_|P|P|\n" +
		"1|R|N|B|Q|K|B|N|R|\n" +
		"  a b c d e f g h";
	check(input,output);
}

//King cannot take its own pawn
@Test public void testInvalid_13() {
	String input = "Ke1xe2";
	String output = 
		"8|r|n|b|q|k|b|n|r|\n" +
		"7|p|p|p|p|p|p|p|p|\n" +
		"6|_|_|_|_|_|_|_|_|\n" +
		"5|_|_|_|_|_|_|_|_|\n" +
		"4|_|_|_|_|_|_|_|_|\n" +
		"3|_|_|_|_|_|_|_|_|\n" +
		"2|P|P|P|P|P|P|P|P|\n" +
		"1|R|N|B|Q|K|B|N|R|\n" +
		"  a b c d e f g h";
	check(input,output);
}

//King cannot take an empty square 
@Test public void testInvalid_14() {
	String input = "e2-e3 e7-e6\n"+"Ke1xe2\n"+"";
	String output = 
		"8|r|n|b|q|k|b|n|r|\n" +
		"7|p|p|p|p|p|p|p|p|\n" +
		"6|_|_|_|_|_|_|_|_|\n" +
		"5|_|_|_|_|_|_|_|_|\n" +
		"4|_|_|_|_|_|_|_|_|\n" +
		"3|_|_|_|_|P|_|_|_|\n" +
		"2|P|P|P|P|_|P|P|P|\n" +
		"1|R|N|B|Q|K|B|N|R|\n" +
		"  a b c d e f g h";
	check(input,output);
}

//King cannot take peices more than a square away 
@Test public void testInvalid_15() {
	String input = "e2-e4 f7-f5\n"+"e4xf5 e7-e5\n"+"Ke1xe5\n"+"";
	String output = 
		"8|r|n|b|q|k|b|n|r|\n" +
		"7|p|p|p|p|p|_|p|p|\n" +
		"6|_|_|_|_|_|_|_|_|\n" +
		"5|_|_|_|_|_|P|_|_|\n" +
		"4|_|_|_|_|_|_|_|_|\n" +
		"3|_|_|_|_|_|_|_|_|\n" +
		"2|P|P|P|P|_|P|P|P|\n" +
		"1|R|N|B|Q|K|B|N|R|\n" +
		"  a b c d e f g h";
	check(input,output);
}

//Knight cannot move 2 squares forward 
@Test public void testInvalid_16() {
	String input = "b2-b4 b7-b5\n"+"Nb1-b3\n"+"";
	String output = 
		"8|r|n|b|q|k|b|n|r|\n" +
		"7|p|p|p|p|p|p|p|p|\n" +
		"6|_|_|_|_|_|_|_|_|\n" +
		"5|_|_|_|_|_|_|_|_|\n" +
		"4|_|P|_|_|_|_|_|_|\n" +
		"3|_|_|_|_|_|_|_|_|\n" +
		"2|P|_|P|P|P|P|P|P|\n" +
		"1|R|N|B|Q|K|B|N|R|\n" +
		"  a b c d e f g h";
	check(input,output);
}

//Knight can't move to occupied square 
@Test public void testInvalid_17() {
	String input = "Nb1-d2"+"";
	String output = 
		"8|r|n|b|q|k|b|n|r|\n" +
		"7|p|p|p|p|p|p|p|p|\n" +
		"6|_|_|_|_|_|_|_|_|\n" +
		"5|_|_|_|_|_|_|_|_|\n" +
		"4|_|_|_|_|_|_|_|_|\n" +
		"3|_|_|_|_|_|_|_|_|\n" +
		"2|P|P|P|P|P|P|P|P|\n" +
		"1|R|N|B|Q|K|B|N|R|\n" +
		"  a b c d e f g h";
	check(input,output);
}

//Knight can't move in horizontal direction 
@Test public void testInvalid_18() {
	String input = "d2-d3 d7-d6\n"+"Bc1-e3 h7-h6\n"+"Nb1-c1"+"";
	String output = 
		"8|r|n|b|q|k|b|n|r|\n" +
		"7|p|p|p|_|p|p|p|p|\n" +
		"6|_|_|_|p|_|_|_|_|\n" +
		"5|_|_|_|_|_|_|_|_|\n" +
		"4|_|_|_|_|_|_|_|_|\n" +
		"3|_|_|_|P|B|_|_|_|\n" +
		"2|P|P|P|_|P|P|P|P|\n" +
		"1|R|N|_|Q|K|B|N|R|\n" +
		"  a b c d e f g h";
	check(input,output);
}

//Knight cannot take its own pecies 
@Test public void testInvalid_19() {
	String input = "Nb1-d2"+"";
	String output = 
		"8|r|n|b|q|k|b|n|r|\n" +
		"7|p|p|p|p|p|p|p|p|\n" +
		"6|_|_|_|_|_|_|_|_|\n" +
		"5|_|_|_|_|_|_|_|_|\n" +
		"4|_|_|_|_|_|_|_|_|\n" +
		"3|_|_|_|_|_|_|_|_|\n" +
		"2|P|P|P|P|P|P|P|P|\n" +
		"1|R|N|B|Q|K|B|N|R|\n" +
		"  a b c d e f g h";
	check(input,output);
}

//Knights cannot take peices from diagonal position
@Test public void testInvalid_20() {
	String input = "Nb1-c3 h7-h6\n"+"Nc3-d5 h6-h5\n"+"Nd5-f7\n"+"";
	String output = 
		"8|r|n|b|q|k|b|n|r|\n" +
		"7|p|p|p|p|p|p|p|_|\n" +
		"6|_|_|_|_|_|_|_|_|\n" +
		"5|_|_|_|N|_|_|_|p|\n" +
		"4|_|_|_|_|_|_|_|_|\n" +
		"3|_|_|_|_|_|_|_|_|\n" +
		"2|P|P|P|P|P|P|P|P|\n" +
		"1|R|_|B|Q|K|B|N|R|\n" +
		"  a b c d e f g h";
	check(input,output);
}

//Bishop cannot move in a vertical drection
@Test public void testInvalid_21() {
	String input = "c2-c4 c7-c5\n"+"Bc1-c3\n"+"";
	String output = 
		"8|r|n|b|q|k|b|n|r|\n" +
		"7|p|p|_|p|p|p|p|p|\n" +
		"6|_|_|_|_|_|_|_|_|\n" +
		"5|_|_|p|_|_|_|_|_|\n" +
		"4|_|_|P|_|_|_|_|_|\n" +
		"3|_|_|_|_|_|_|_|_|\n" +
		"2|P|P|_|P|P|P|P|P|\n" +
		"1|R|N|B|Q|K|B|N|R|\n" +
		"  a b c d e f g h";
	check(input,output);
}

//Bishop can't move through other peices 
@Test public void testInvalid_22() {
	String input = "Bc1-e3\n"+"";
	String output = 
		"8|r|n|b|q|k|b|n|r|\n" +
		"7|p|p|p|p|p|p|p|p|\n" +
		"6|_|_|_|_|_|_|_|_|\n" +
		"5|_|_|_|_|_|_|_|_|\n" +
		"4|_|_|_|_|_|_|_|_|\n" +
		"3|_|_|_|_|_|_|_|_|\n" +
		"2|P|P|P|P|P|P|P|P|\n" +
		"1|R|N|B|Q|K|B|N|R|\n" +
		"  a b c d e f g h";
	check(input,output);
}

//Bishop can't move like a knight 
@Test public void testInvalid_23() {
	String input = "Bc1-d3\n"+"";
	String output = 
		"8|r|n|b|q|k|b|n|r|\n" +
		"7|p|p|p|p|p|p|p|p|\n" +
		"6|_|_|_|_|_|_|_|_|\n" +
		"5|_|_|_|_|_|_|_|_|\n" +
		"4|_|_|_|_|_|_|_|_|\n" +
		"3|_|_|_|_|_|_|_|_|\n" +
		"2|P|P|P|P|P|P|P|P|\n" +
		"1|R|N|B|Q|K|B|N|R|\n" +
		"  a b c d e f g h";
	check(input,output);
}

//BLACK bishop cannot move in vertical direction
@Test public void testInvalid_24() {
	String input = "c2-c4 c7-c5\n"+"Bc8-c6\n"+"";
	String output = 
		"8|r|n|b|q|k|b|n|r|\n" +
		"7|p|p|_|p|p|p|p|p|\n" +
		"6|_|_|_|_|_|_|_|_|\n" +
		"5|_|_|p|_|_|_|_|_|\n" +
		"4|_|_|P|_|_|_|_|_|\n" +
		"3|_|_|_|_|_|_|_|_|\n" +
		"2|P|P|_|P|P|P|P|P|\n" +
		"1|R|N|B|Q|K|B|N|R|\n" +
		"  a b c d e f g h";
	check(input,output);
}

//BLACK bishop cannot move through peices 
@Test public void testInvalid_25() {
	String input = "c2-c4 Bc8-e6\n";
	String output = 
		"8|r|n|b|q|k|b|n|r|\n" +
		"7|p|p|p|p|p|p|p|p|\n" +
		"6|_|_|_|_|_|_|_|_|\n" +
		"5|_|_|_|_|_|_|_|_|\n" +
		"4|_|_|P|_|_|_|_|_|\n" +
		"3|_|_|_|_|_|_|_|_|\n" +
		"2|P|P|_|P|P|P|P|P|\n" +
		"1|R|N|B|Q|K|B|N|R|\n" +
		"  a b c d e f g h";
	check(input,output);
}

//Bishop cannot take a peice in vertical direction
@Test public void testInvalid_26() {
	String input = "d2-d3 d7-d6\n"+"Bc1-h6 a7-a6\n"+"Bh6xh7\n"+"";
	String output = 
		"8|r|n|b|q|k|b|n|r|\n" +
		"7|_|p|p|_|p|p|p|p|\n" +
		"6|p|_|_|p|_|_|_|B|\n" +
		"5|_|_|_|_|_|_|_|_|\n" +
		"4|_|_|_|_|_|_|_|_|\n" +
		"3|_|_|_|P|_|_|_|_|\n" +
		"2|P|P|P|_|P|P|P|P|\n" +
		"1|R|N|_|Q|K|B|N|R|\n" +
		"  a b c d e f g h";
	check(input,output);
}

//Bishops cannot take another peice through another peice 
@Test public void testInvalid_27() {
	String input = "Bc1xh6";
	String output = 
		"8|r|n|b|q|k|b|n|r|\n" +
		"7|p|p|p|p|p|p|p|p|\n" +
		"6|_|_|_|_|_|_|_|_|\n" +
		"5|_|_|_|_|_|_|_|_|\n" +
		"4|_|_|_|_|_|_|_|_|\n" +
		"3|_|_|_|_|_|_|_|_|\n" +
		"2|P|P|P|P|P|P|P|P|\n" +
		"1|R|N|B|Q|K|B|N|R|\n" +
		"  a b c d e f g h";
	check(input,output);
}

//Rook cannot move into occupied square 
@Test public void testInvalid_28() {
	String input = "Ra1-a2\n"+"";
	String output = 
		"8|r|n|b|q|k|b|n|r|\n" +
		"7|p|p|p|p|p|p|p|p|\n" +
		"6|_|_|_|_|_|_|_|_|\n" +
		"5|_|_|_|_|_|_|_|_|\n" +
		"4|_|_|_|_|_|_|_|_|\n" +
		"3|_|_|_|_|_|_|_|_|\n" +
		"2|P|P|P|P|P|P|P|P|\n" +
		"1|R|N|B|Q|K|B|N|R|\n" +
		"  a b c d e f g h";
	check(input,output);
}

//Rook cannot move through other peices 
@Test public void testInvalid_29() {
	String input = "Bc1-a3\n"+"";
	String output = 
		"8|r|n|b|q|k|b|n|r|\n" +
		"7|p|p|p|p|p|p|p|p|\n" +
		"6|_|_|_|_|_|_|_|_|\n" +
		"5|_|_|_|_|_|_|_|_|\n" +
		"4|_|_|_|_|_|_|_|_|\n" +
		"3|_|_|_|_|_|_|_|_|\n" +
		"2|P|P|P|P|P|P|P|P|\n" +
		"1|R|N|B|Q|K|B|N|R|\n" +
		"  a b c d e f g h";
	check(input,output);
}

//Rook cannot move into a BLACK occupied square
@Test public void testInvalid_30() {
	String input = "d2-d3 d7-d6\n"+"Bc1-h6 Bc8-h3\n"+"Bh6-g7\n"+"";
	String output = 
		"8|r|n|_|q|k|b|n|r|\n" +
		"7|p|p|p|_|p|p|p|p|\n" +
		"6|_|_|_|p|_|_|_|B|\n" +
		"5|_|_|_|_|_|_|_|_|\n" +
		"4|_|_|_|_|_|_|_|_|\n" +
		"3|_|_|_|P|_|_|_|b|\n" +
		"2|P|P|P|_|P|P|P|P|\n" +
		"1|R|N|_|Q|K|B|N|R|\n" +
		"  a b c d e f g h";
	check(input,output);
}

//Rook cannot move diagonally 
@Test public void testInvalid_31() {
	String input = "b2-b3 b7-b6\n"+"Ra1-c3\n"+"";
	String output = 
		"8|r|n|b|q|k|b|n|r|\n" +
		"7|p|_|p|p|p|p|p|p|\n" +
		"6|_|p|_|_|_|_|_|_|\n" +
		"5|_|_|_|_|_|_|_|_|\n" +
		"4|_|_|_|_|_|_|_|_|\n" +
		"3|_|P|R|_|_|_|_|_|\n" +
		"2|P|_|P|P|P|P|P|P|\n" +
		"1|_|N|B|Q|K|B|N|R|\n" +
		"  a b c d e f g h";
	check(input,output);
}

//Rook cannot move into an occupied square 
@Test public void testInvalid_32() {
	String input = "Ra1-a2\n"+"";
	String output = 
		"8|r|n|b|q|k|b|n|r|\n" +
		"7|p|p|p|p|p|p|p|p|\n" +
		"6|_|_|_|_|_|_|_|_|\n" +
		"5|_|_|_|_|_|_|_|_|\n" +
		"4|_|_|_|_|_|_|_|_|\n" +
		"3|_|_|_|_|_|_|_|_|\n" +
		"2|P|P|P|P|P|P|P|P|\n" +
		"1|R|N|B|Q|K|B|N|R|\n" +
		"  a b c d e f g h";
	check(input,output);
}

//Rook cannot take a peice diagonally 
@Test public void testInvalid_33() {
	String input = "a2-a4 b7-b5\n"+"a4xb5 h7-h6\n"+"Ra1-a6 h6-h5\n"+"Ra6xc8\n"+"";
	String output = 
		"8|r|n|b|q|k|b|n|r|\n" +
		"7|p|_|p|p|p|p|p|_|\n" +
		"6|R|_|_|_|_|_|_|p|\n" +
		"5|_|P|_|_|_|_|_|_|\n" +
		"4|_|_|_|_|_|_|_|_|\n" +
		"3|_|_|_|_|_|_|_|_|\n" +
		"2|_|P|P|P|P|P|P|P|\n" +
		"1|_|N|B|Q|K|B|N|R|\n" +
		"  a b c d e f g h";
	check(input,output);
}

//Rook cannot take a peice that doesn't exists 
@Test public void testInvalid_34() {
	String input = "a2-a3 a7-a6\n"+"Ra1xa2";
	String output = 
		"8|r|n|b|q|k|b|n|r|\n" +
		"7|_|p|p|p|p|p|p|p|\n" +
		"6|p|_|_|_|_|_|_|_|\n" +
		"5|_|_|_|_|_|_|_|_|\n" +
		"4|_|_|_|_|_|_|_|_|\n" +
		"3|P|_|_|_|_|_|_|_|\n" +
		"2|_|P|P|P|P|P|P|P|\n" +
		"1|R|N|B|Q|K|B|N|R|\n" +
		"  a b c d e f g h";
	check(input,output);
}

//Queen can't move diagonally through a pawn 
@Test public void testInvalid_35() {
	String input = "Qd1-f3"+"";
	String output = 
		"8|r|n|b|q|k|b|n|r|\n" +
		"7|p|p|p|p|p|p|p|p|\n" +
		"6|_|_|_|_|_|_|_|_|\n" +
		"5|_|_|_|_|_|_|_|_|\n" +
		"4|_|_|_|_|_|_|_|_|\n" +
		"3|_|_|_|_|_|_|_|_|\n" +
		"2|P|P|P|P|P|P|P|P|\n" +
		"1|R|N|B|Q|K|B|N|R|\n" +
		"  a b c d e f g h";
	check(input,output);
}

//Queen can't move forward through a pawn 
@Test public void testInvalid_36() {
	String input = "Qd1-d3"+"";
	String output = 
		"8|r|n|b|q|k|b|n|r|\n" +
		"7|p|p|p|p|p|p|p|p|\n" +
		"6|_|_|_|_|_|_|_|_|\n" +
		"5|_|_|_|_|_|_|_|_|\n" +
		"4|_|_|_|_|_|_|_|_|\n" +
		"3|_|_|_|_|_|_|_|_|\n" +
		"2|P|P|P|P|P|P|P|P|\n" +
		"1|R|N|B|Q|K|B|N|R|\n" +
		"  a b c d e f g h";
	check(input,output);
}

//Queen cannot move into an occupied space
@Test public void testInvalid_37() {
	String input = "Qd1-d2"+"";
	String output = 
		"8|r|n|b|q|k|b|n|r|\n" +
		"7|p|p|p|p|p|p|p|p|\n" +
		"6|_|_|_|_|_|_|_|_|\n" +
		"5|_|_|_|_|_|_|_|_|\n" +
		"4|_|_|_|_|_|_|_|_|\n" +
		"3|_|_|_|_|_|_|_|_|\n" +
		"2|P|P|P|P|P|P|P|P|\n" +
		"1|R|N|B|Q|K|B|N|R|\n" +
		"  a b c d e f g h";
	check(input,output);
}

//Queen cannot take through other peices 
@Test public void testInvalid_38() {
	String input = "Qd1-d7"+"";
	String output = 
		"8|r|n|b|q|k|b|n|r|\n" +
		"7|p|p|p|p|p|p|p|p|\n" +
		"6|_|_|_|_|_|_|_|_|\n" +
		"5|_|_|_|_|_|_|_|_|\n" +
		"4|_|_|_|_|_|_|_|_|\n" +
		"3|_|_|_|_|_|_|_|_|\n" +
		"2|P|P|P|P|P|P|P|P|\n" +
		"1|R|N|B|Q|K|B|N|R|\n" +
		"  a b c d e f g h";
	check(input,output);
}

//Queen cannot take its own peices 
@Test public void testInvalid_39() {
	String input = "Qd1xd2"+"";
	String output = 
		"8|r|n|b|q|k|b|n|r|\n" +
		"7|p|p|p|p|p|p|p|p|\n" +
		"6|_|_|_|_|_|_|_|_|\n" +
		"5|_|_|_|_|_|_|_|_|\n" +
		"4|_|_|_|_|_|_|_|_|\n" +
		"3|_|_|_|_|_|_|_|_|\n" +
		"2|P|P|P|P|P|P|P|P|\n" +
		"1|R|N|B|Q|K|B|N|R|\n" +
		"  a b c d e f g h";
	check(input,output);
}

//Queen cannot take a pawn that doesn't exist 
@Test public void testInvalid_40() {
	String input = "e2-e3 h7-h6\n"+"Qd1xh5\n"+"";
	String output = 
		"8|r|n|b|q|k|b|n|r|\n" +
		"7|p|p|p|p|p|p|p|_|\n" +
		"6|_|_|_|_|_|_|_|p|\n" +
		"5|_|_|_|_|_|_|_|Q|\n" +
		"4|_|_|_|_|_|_|_|_|\n" +
		"3|_|_|_|_|P|_|_|_|\n" +
		"2|P|P|P|P|_|P|P|P|\n" +
		"1|R|N|B|_|K|B|N|R|\n" +
		"  a b c d e f g h";
	check(input,output);
}

//Cannot use queen at incorrect position 
@Test public void testInvalid_41() {
	String input = "e2-e3 h7-h6\n"+"Qe1xh5\n"+"";
	String output = 
		"8|r|n|b|q|k|b|n|r|\n" +
		"7|p|p|p|p|p|p|p|_|\n" +
		"6|_|_|_|_|_|_|_|p|\n" +
		"5|_|_|_|_|_|_|_|Q|\n" +
		"4|_|_|_|_|_|_|_|_|\n" +
		"3|_|_|_|_|P|_|_|_|\n" +
		"2|P|P|P|P|_|P|P|P|\n" +
		"1|R|N|B|_|K|B|N|R|\n" +
		"  a b c d e f g h";
	check(input,output);
}

//Cannot promote pawn to piece not previously captured.

//Cannot move pawn onto last row due to not having had a Queen,Rook,Bishop or kNight captured previously.

//Board cannot reset since white won but instead saying black did 
@Test public void testInvalid_42() {
	String input = "Nb1-c3 h7-h6\n"+"Nc3-d5 h6-h5\n"+"Nd5-f6 h5-h4\n"+"Nf6xe8 1-0\n"+"";
	String output =
        "8|r|n|b|q|N|b|n|r|\n" +
        "7|p|p|p|p|p|p|p|_|\n" +
        "6|_|_|_|_|_|_|_|_|\n" +
        "5|_|_|_|_|_|_|_|_|\n" +
        "4|_|_|_|_|_|_|_|p|\n" +
        "3|_|_|_|_|_|_|_|_|\n" +
        "2|P|P|P|P|P|P|P|P|\n" +
        "1|R|_|B|Q|K|B|N|R|\n" +
        "  a b c d e f g h";
    check(input,output);
}

//Game ended and black cannot continue 
@Test public void testInvalid_43() {
	String input = "Nb1-c3 h7-h6\n"+"Nc3-d5 h6-h5\n"+"Nd5-f6 h5-h4\n"+"Nf6xe8 a7-a6\n"+"";
	String output =
        "8|r|n|b|q|N|b|n|r|\n" +
        "7|p|p|p|p|p|p|p|_|\n" +
        "6|_|_|_|_|_|_|_|_|\n" +
        "5|_|_|_|_|_|_|_|_|\n" +
        "4|_|_|_|_|_|_|_|p|\n" +
        "3|_|_|_|_|_|_|_|_|\n" +
        "2|P|P|P|P|P|P|P|P|\n" +
        "1|R|_|B|Q|K|B|N|R|\n" +
        "  a b c d e f g h";
    check(input,output);
}

//Black won not white so board doesn't reset 
@Test public void testInvalid_44() {
	String input = "a2-a3 Nb8-c6\n"+"a3-a4 Nc6-d4\n"+"a4-a5 Nd4-f3\n"+"a5-a6 Nf3xe1 0-1\n";
	String output =
        "8|r|_|b|q|k|b|n|r|\n" +
        "7|p|p|p|p|p|p|p|p|\n" +
        "6|P|_|_|_|_|_|_|_|\n" +
        "5|_|_|_|_|_|_|_|_|\n" +
        "4|_|_|_|_|_|_|_|_|\n" +
        "3|_|_|_|_|_|_|_|_|\n" +
        "2|_|P|P|P|P|P|P|P|\n" +
        "1|R|N|B|Q|n|B|N|R|\n" +
        "  a b c d e f g h";
    check(input,output);
}

//cannot have 2 white moves in one round
@Test public void testInvalid_45() {
	String input = "a2-a3 a3-a4\n";
	String output =
        "8|r|n|b|q|k|b|n|r|\n" +
        "7|p|p|p|p|p|p|p|p|\n" +
        "6|_|_|_|_|_|_|_|_|\n" +
        "5|_|_|_|_|_|_|_|_|\n" +
        "4|_|_|_|_|_|_|_|_|\n" +
        "3|P|_|_|_|_|_|_|_|\n" +
        "2|_|P|P|P|P|P|P|P|\n" +
        "1|R|N|B|Q|K|B|N|R|\n" +
        "  a b c d e f g h";
    check(input,output);
}



	// The following provides a simple helper method for all tests.
	public static void check(String input, String expectedOutput) {
		try {
			ChessGame game = new ChessGame(input);
			List<Board> boards = game.boards();
			if (boards.isEmpty()) {
				fail("test failed with insufficient boards on input: " + input);
			}
			String actualOutput = boards.get(boards.size() - 1).toString();
			assertEquals(expectedOutput, actualOutput);
		} catch (Exception e) {
			fail("test failed because of exception on input: " + input);
		}
	}
}
