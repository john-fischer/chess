package pieces;

public class bishop extends Piece {
	public bishop(int play, int x , int y) {
		super(play, x, y);
		type = " B ";
	}
	@Override
	public void move(int x, int y) {
		x_pos += x;
		y_pos += y;
	}

	@Override
	public void capture(Piece capturePiece) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean validMove(int x, int y) {
		if(Math.abs(x_pos - x)==Math.abs(y_pos - y)) {
			return true;
		}
		return false;
	}

	
}
