package game;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import pieces.*;

public class PieceMoveListener implements MouseListener, MouseMotionListener{

	private ArrayList<Piece> pieces;
	private Game game;
	
	int startingX, startingY;
	Tile startingTile;
	Tile endTile;
	
	private Piece dragPiece;
    private int dragOffsetX;
    private int dragOffsetY;
	
	public PieceMoveListener(ArrayList<Piece> pieces, Game game) {
		
		this.game = game;
		this.pieces = pieces;
		
		//System.out.println(pieces.size());
	}
	
	private boolean mouseOverPiece(Piece piece, int x, int y) {
		
		return piece.getXPx() <= x
	            && piece.getXPx()+Tile.size >= x
	            && piece.getYPx() <= y
	            && piece.getYPx()+Tile.size >= y;
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		
		if(this.dragPiece != null){
            this.dragPiece.setXPx(e.getPoint().x - this.dragOffsetX);
            this.dragPiece.setYPx(e.getPoint().y - this.dragOffsetY);
            this.game.repaint();
        }
		//if it starts lagging it might be because of this:
		if(dragPiece != null){
        	
            this.pieces.remove(this.dragPiece);
            this.pieces.add(this.dragPiece);
        }
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Point start = e.getPoint();
		startingX = start.x;
		startingY = start.y;

		for(int i = this.pieces.size()-1; i >= 0; i--) {
			Piece piece = this.pieces.get(i);

            if( mouseOverPiece(piece,startingX,startingY)){
                // calculate offset, because we do not want the drag piece
                // to jump with it's upper left corner to the current mouse
                // position
                //
            	
                this.dragOffsetX = startingX - piece.getXPx();
                this.dragOffsetY = startingY - piece.getYPx();
                this.dragPiece = piece;
                startingTile = dragPiece.returnTile();
                
                break;
            }
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		if(dragPiece!=null) {
		
		endTile = game.getTile(e.getX(), e.getY());
		
		if(e.getX()<0 || e.getX()>8*Tile.size || e.getY()<0 || e.getY()>8*Tile.size) {
			dragPiece.setTile(startingTile);
		}
		else if(dragPiece.isValidMove(startingTile, endTile)) {
			dragPiece.setTile(endTile);
		}
		else {
			dragPiece.setTile(startingTile);
		}
		game.printTable();
		dragPiece = null;
		}
	}

}
