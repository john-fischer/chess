package pieces;

public class pawn extends Piece {
	boolean firstMove = true;
	// Constructor
	public pawn(int play, int x, int y){
		super(play, x, y);
		type = " P ";
	}
	
	// Valid Move
	public boolean validMove(int x, int y) {
		if(x == x_pos && (y_pos -y)*player == 1) {
		return true;}
		if(x == x_pos && (y_pos-y)*player == 2 && firstMove) {
			return true;}
		return false;
	}

	// Move
	public void move(int x, int y) {
		if(validMove(x,y)) {
		x_pos += x;
		y_pos += y;

	}
		else {
			System.out.println("This is not a valid move");
		}}
	@Override
	
	// Capture
	public void capture(Piece capturePiece) {
		// TODO Auto-generated method stub
		
	}
	
	
}
