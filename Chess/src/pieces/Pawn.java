package pieces;

import game.*;

public class Pawn extends Piece{

	public Pawn(int x, int y, boolean isWhite, Game game) {
		
		super(x, y, isWhite, game);
	}

	@Override
	public String getType() {
		
		return "pawn";
	}

	@Override
	public boolean isValidMove(Tile start, Tile end) {
		
		if(isWhite) {
			if(start.y<6 && start.y-end.y==1) return true;
			else if(start.y==6 && start.y-end.y==1 || start.y==6 && start.y-end.y==2) return true;
		}
		else {
			if(start.y>1 && end.y-start.y==1) return true;
			else if(start.y==1 && end.y-start.y==1 || start.y==1 && end.y-start.y==2) return true;
		}
		
		return false;
	}


}
