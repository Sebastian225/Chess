package pieces;

import game.*;

public class King extends Piece{

	public King(int x, int y, boolean isWhite, Game game) {
		
		super(x, y, isWhite, game);
		
	}

	@Override
	public String getType() {
		
		return "king";
	}

	@Override
	public boolean isValidMove(Tile start, Tile end) {
		
		if(end.x-start.x==1 && start.y==end.y) return true;
		else if(start.x-end.x==1 && start.y==end.y) return true;
		else if(end.y-start.y==1 && start.x==end.x) return true;
		else if(start.y-end.y==1 && start.x==end.x) return true;
		
		else if(end.x-start.x==1 && end.y-start.y==1) return true;
		else if(end.x-start.x==1 && start.y-end.y==1) return true;
		else if(start.x-end.x==1 && end.y-start.y==1) return true;
		else if(start.x-end.x==1 && start.y-end.y==1) return true;
		
		else if(start.y-end.y==1 && start.x-end.x==1) return true;
		else if(start.y-end.y==1 && end.x-start.x==1) return true;
		else if(end.y-start.y==1 && end.x-start.x==1) return true;
		else if(end.y-start.y==1 && start.x-end.x==1) return true;
		
		return false;
	}
	

}
