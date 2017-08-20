package pieces;

import game.*;

public class Rook extends Piece{
	
	public Rook(int x, int y, boolean isWhite, Game game) {

		super(x, y, isWhite, game);
		
	}

	@Override
	public String getType() {
		
		return "rook";
	}

	@Override
	public boolean isValidMove(Tile start, Tile end) {
		
		if(start.x == end.x || start.y == end.y) return true;
		
		return false;
	}

}
