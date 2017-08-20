package pieces;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import game.Game;
import game.Tile;

public abstract class Piece {

	int x, y;
	int xPx, yPx;
	public boolean isWhite;
	
	public BufferedImage black;
	public BufferedImage white;
	
	Game game;
	
	public Piece(int x, int y, boolean isWhite, Game game) {
		
		this.x = x;
		this.y = y;
		this.xPx = x*Tile.size;
		this.yPx = y*Tile.size;
		this.isWhite = isWhite;
		this.game = game;
		
		game.pieces.add(this);
		
		try {
			black = ImageIO.read(new File("img/black_" + getType() + ".png"));
			white = ImageIO.read(new File("img/white_" + getType() + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		returnTile().ownedPiece = this;

		}
	
	public abstract String getType();
	
	public abstract boolean isValidMove(Tile start, Tile end);
	
	public Tile returnTile() {
		
		return Game.tiles[x][y];
	}
	
	public void setTile(Tile tile) {
		returnTile().ownedPiece=null;
		tile.ownedPiece=this;
		x = tile.x;
		y = tile.y;
		xPx = x * Tile.size;
		yPx = y * Tile.size;
		game.repaint();
	}
	
	//get set in tiles
	public int getX() {return x;}
	public int getY() {return y;}
	public void setX(int x) {this.x = x;}
	public void setY(int y) {this.y = y;}

	//get set in pixels
	public int getXPx() {return xPx;}
	public int getYPx() {return yPx;}
	public void setXPx(int x) {this.xPx = x;}
	public void setYPx(int y) {this.yPx = y;}
}
