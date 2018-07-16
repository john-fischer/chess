package pieces;

public abstract class Piece extends Object{
	public String type;
	public boolean alive = true;
	public final int player; // -1 for black and 1 for white
	public int x_pos;
	public int y_pos;
	public void move(int x, int y) {x_pos+= x; y_pos+=y;};
	public void capture(Piece capturePiece) {
		int newx = capturePiece.x_pos;
		int newy = capturePiece.y_pos;
		x_pos = newx;
		y_pos = newy;

	};
	public abstract boolean validMove(int x, int y);
	// pawn rook bishop knight king queen
	Piece(int player, int x_pos, int y_pos){
		this.player = player;
		this.x_pos = x_pos;
		this.y_pos = y_pos;
	}
}
