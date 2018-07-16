package chess;

import java.util.Scanner;

public class ChessMain {

	public static void space() {System.out.println();
	System.out.println();
	System.out.println();
	System.out.println();}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Chess chess = new Chess();
		chess.game(sc);
		


		}
}
