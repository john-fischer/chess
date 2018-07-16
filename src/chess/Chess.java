package chess;
import java.util.*;
public class Chess {
	Board board;
	public void game(Scanner sc) {
		board = new Board();
		board.initializeBoard();
		int turn_counter =1;
		while(true) {
			board.printBoard();
			if(turn_counter == 1) {
				System.out.println("White's turn");
			}
			else {
				System.out.println("Blacks's turn");
			}
			while(true) {
			
			System.out.println("Which piece?");
			int s = sc.nextInt();
			int p = sc.nextInt();
			if(board.board[p][s].player != turn_counter) {
				System.out.println("This piece does not belong to you!");
				continue;
			}
			System.out.println("To where?");
			int m = sc.nextInt();
			int n = sc.nextInt();
			if(!board.board[p][s].validMove(m,n)) {
				System.out.println("You can not move this piece here");
				continue;
			}
			board.move(s, p, m, n);
			break;}
			turn_counter += turn_counter * (-2);
		}
		
	}
	
}
