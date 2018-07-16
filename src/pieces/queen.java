package pieces;

public class queen extends Piece {

	public queen(int player, int x_pos, int y_pos) {
		super(player, x_pos, y_pos);
		type = " Q ";
	}


	@Override
	public void capture(Piece capturePiece) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean validMove(int x, int y) {
		if(Math.abs(x_pos - x)==Math.abs(y_pos - y) 
				|| (((x_pos - x == 0 && y_pos-y !=0) 
				|| (x_pos - x != 0 && y_pos-y ==0)))){
			return true;
		}
		return false;
	}


}
