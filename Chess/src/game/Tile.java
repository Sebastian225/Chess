package game;

import java.awt.Color;
import java.awt.Graphics;

import pieces.Piece;

public class Tile {
	
	public int x;
	public int y;
	boolean isWhite;
	public Piece ownedPiece;
	
	public final static int size = 75;

	public Tile(int x, int y, boolean isWhite) {

		this.x = x;
		this.y = y;
		this.isWhite = isWhite;
	}
	
	int getX() {return x;}
	int getY() {return y;}
	
	void drawTile(Graphics g) {
		
		if(isWhite) {
			g.setColor(new Color(247, 249, 245));
		}
		else {
			g.setColor(new Color(106, 97, 103));
		}
		
		g.fillRect(x * size,y * size, size, size);
	}
	
}
