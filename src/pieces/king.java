package pieces;

public class king extends Piece {

	public king(int player, int x_pos, int y_pos) {
		super(player, x_pos, y_pos);
		type = " I ";
	}

	@Override
	public void capture(Piece capturePiece) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean validMove(int x, int y) {
		if(Math.abs(x_pos - x) == Math.abs(y_pos - y) || 
				(Math.abs(x_pos - x) == 1 && y_pos - y == 0 || 
				Math.abs(y_pos - y) == 1 && x_pos - x == 0)) {
			return true;
			}
		return false;
		}
		

}
