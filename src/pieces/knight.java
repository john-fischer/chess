package pieces;

public class knight extends Piece {

	public knight(int play, int x, int y) {
		super(play, x, y);
		type = " K ";
	}

	@Override
	public void capture(Piece capturePiece) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean validMove(int x, int y) {
		if((Math.abs(x_pos - x)== 2 && Math.abs(y_pos - y )== 1)
				||
				(Math.abs(x_pos - x)== 1 && Math.abs(y_pos - y)== 2)) {
			return true;
		}
				
		return false;
	}
	
}
