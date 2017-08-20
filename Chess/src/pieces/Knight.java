package pieces;

import game.*;

public class Knight extends Piece{

	public Knight(int x, int y, boolean isWhite, Game game) {
		
		super(x, y, isWhite, game);

	}

	@Override
	public String getType() {
		
		return "knight";
	}

	@Override
	public boolean isValidMove(Tile start, Tile end) {
		
		if(end.x-start.x==1 && start.y-end.y==2) return true;
		else if(end.x-start.x==2 && start.y-end.y==1) return true;
		else if(start.x-end.x==2 && start.y-end.y==1) return true;
		else if(start.x-end.x==1 && start.y-end.y==2) return true;
		
		else if(end.y-start.y==1 && start.x-end.x==2) return true;
		else if(end.y-start.y==1 && end.x-start.x==2) return true;
		else if(end.y-start.y==2 && end.x-start.x==1) return true;
		else if(end.y-start.y==2 && start.x-end.x==1) return true;
		
		return false;
	}
}
