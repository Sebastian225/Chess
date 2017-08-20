package pieces;

import game.*;

public class Bishop extends Piece{

	public Bishop(int x, int y, boolean isWhite, Game game) {
		
		super(x, y, isWhite, game);
		
	}

	@Override
	public String getType() {
		
		return "bishop";
	}

	@Override
	public boolean isValidMove(Tile start, Tile end) {
		
		if(start.x - start.y == end.x - end.y) return true;
		if(start.x - (7-start.y) == end.x - (7-end.y)) return true;
		
		return false;
	}

}
