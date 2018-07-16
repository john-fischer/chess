package chess;

import pieces.*;

public class Board {
	Piece[][] board = new Piece[8][8];

	void move(int x, int y, int sx, int sy) {
		if (board[y][x].validMove(sx, sy) && board[sy][sx] == null) {
			if (!pathFree(board[y][x], sx, sy))
				return;
			board[y][x].move(sx, sy);
			board[sy][sx] = board[y][x];
			board[sy][sx].x_pos = sx;
			board[sy][sx].y_pos = sy;
			board[y][x] = null;
		}
		// capturing
		else if (board[y][x].validMove(sx, sy) && (board[sy][sx] != null) && (board[sy][sx].player != board[y][x].player)) {
			if (!pathFree(board[y][x], sx, sy)) return;
			String color = "";
			String otherColor = "";
			if(board[y][x].player == 1) {
				color = "Black's";
				otherColor = "white's";
			}
			if(board[y][x].player == -1) {
				color = "White's";
				otherColor = "black's";
			}
			System.out.println("Capture!");
			System.out.println(color+ board[y][x].type + "took "+ otherColor + board[sy][sx].type);
			board[y][x].move(sx, sy);
			board[sy][sx] = board[y][x];
			board[sy][sx].x_pos = sx;
			board[sy][sx].y_pos = sy;
			board[y][x] = null;
		} else {
			System.out.println("Can't go there!");
		}

	}

	public boolean pathFree(Piece p, int x, int y) {
		if (p.type == " K ") {
			if (board[y][x] != null && board[y][x].player == p.player) {
				System.out.println("Piece in way you dummo");
				return false;
			} else {
				return true;
			}
		}
		int startx = p.x_pos;
		int starty = p.y_pos;
		int dirX = 1;
		int dirY = 1;
		if (x < startx) {
			dirX = -1;
		}
		if (y < starty) {
			dirY = -1;
		}
		String movementDir = "";
		if (startx - x != 0 && starty - y != 0) {
			movementDir = "DIAGONAL";
		} else if (startx - x != 0) {
			movementDir = "HORIZONTAL";
		} else if (starty - y != 0) {
			movementDir = "VERTICAL";
		}
		System.out.println(movementDir);
		if (movementDir.equals("VERTICAL")) {
			int track = dirY;

			while (track + starty != y + dirY) {
				if (board[starty + track][startx] != null && board[starty + track][startx].player == p.player) {
					System.out.println("Cant go here, your own piece is in the way");
					return false;
				}
				track += dirY;
			}
			return true;
		}
		if (movementDir.equals("HORIZONTAL")) {
			int track = dirX;
			while (track + startx != x + dirX) {
				if (board[starty][startx + track] != null && board[starty][startx + track].player == p.player) {
					System.out.println("Cant go here, your own piece is in the way");
					return false;
				}
				track += dirX;
			}
			return true;
		}
		if (movementDir.equals("DIAGONAL")) {
			int trackx = dirX;
			int tracky = dirY;

			while (trackx + startx != x + dirX && tracky + starty != y + dirY) {
				if (board[starty + tracky][startx + trackx] != null && board[starty + tracky][startx + trackx].player == p.player) {
					System.out.println("Cant go here, your own piece is in the way");
					return false;
				}
				trackx += dirX;
				tracky += dirY;
			}
			return true;
		}
		return false;
	}

	// . Initialize Board is done
	void initializeBoard() {
		for (int i = 0; i < 8; ++i) {
			for (int j = 0; j < 8; ++j) {
				// initialize a pawn
				if (i == 1) {
					board[i][j] = new pawn(-1, j, i);
				}
				if (i == 6) {
					board[i][j] = new pawn(1, j, i);
				}
				// initialize a rook
				if (i == 0 && (j == 0 || j == 7)) {
					board[i][j] = new rook(-1, j, i);
				}
				if (i == 7 && (j == 0 || j == 7)) {
					board[i][j] = new rook(1, j, i);
				}
				// Initialize a Knight
				if (i == 0 && (j == 1 || j == 6)) {
					board[i][j] = new knight(-1, j, i);
				}
				if (i == 7 && (j == 1 || j == 6)) {
					board[i][j] = new knight(1, j, i);
				}
				// Initialize a Bishop
				if (i == 0 && (j == 2 || j == 5)) {
					board[i][j] = new bishop(-1, j, i);
				}
				if (i == 7 && (j == 2 || j == 5)) {
					board[i][j] = new bishop(1, j, i);
				}
				// Initialize a Queen
				if (i == 0 && (j == 4)) {
					board[i][j] = new queen(-1, j, i);
				}
				if (i == 7 && (j == 3)) {
					board[i][j] = new queen(1, j, i);
				}
				// Initialize a King
				if (i == 0 && (j == 3)) {
					board[i][j] = new king(-1, j, i);
				}
				if (i == 7 && (j == 4)) {
					board[i][j] = new king(1, j, i);
				}
			}
		}
	}

	public void getspace(int x, int y) {
		if ((board[y][x]) == null) {
			System.out.println("nothing here!");
			return;
		}
		System.out.println(board[y][x].type);

	}

	public void printBoard() {
		for (int i = 0; i < 8; ++i) {
			for (int j = 0; j < 8; ++j) {
				if (board[i][j] == null) {
					System.out.print("---" + " ");
				} else {
					System.out.print(board[i][j].type + " ");
				}
			}
			System.out.println();
		}
	}

}
