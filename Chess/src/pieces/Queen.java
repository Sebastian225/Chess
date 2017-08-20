package pieces;

import game.*;

public class Queen extends Piece{
	
	public Queen(int x, int y, boolean isWhite, Game game) {
		
		super(x, y, isWhite, game);
		
	}

	@Override
	public String getType() {
		
		return "queen";
	}

	@Override
	public boolean isValidMove(Tile start, Tile end) {
		
		if(start.x - start.y == end.x - end.y) return true;
		if(start.x - (7-start.y) == end.x - (7-end.y)) return true;
		if(start.x == end.x || start.y == end.y) return true;
		
		return false;
	}

}
