package pieces;

public class rook extends Piece{

	public rook(int player, int x_pos, int y_pos) {
		super(player, x_pos, y_pos);
		type = " R ";
	}


	@Override
	public void capture(Piece capturePiece) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean validMove(int x, int y) {
		if(y_pos == y && x_pos - x != 0 || x_pos == x && y_pos - y != 0) return true;
		return false;
	}

}
