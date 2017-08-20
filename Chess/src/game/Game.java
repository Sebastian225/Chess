package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import pieces.*;



public class Game extends JPanel {
	
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 900;
	public static final int HEIGHT = WIDTH / 12 * 9 - 86;
	public static final String NAME = "Chess";
	
	boolean dragging;
	int startingX, startingY;
	int dragX, dragY;
	int targetX, targetY;
	
	JFrame frame;
	public static Tile[][] tiles = new Tile[9][9];
	boolean boardWhite = true;
	boolean whiteTurn = true;
	public ArrayList<Piece> pieces;

	public Game() {
		
		setMinimumSize(new Dimension(WIDTH, HEIGHT));
		setMaximumSize(new Dimension(WIDTH, HEIGHT));
		setPreferredSize(new Dimension(WIDTH, HEIGHT));

		frame = new JFrame(NAME);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());

		frame.add(this, BorderLayout.CENTER);
		frame.pack();

		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		init();
		requestFocus();
		
		PieceMoveListener listener = new PieceMoveListener(this.pieces,
                this);
        this.addMouseListener(listener);
        this.addMouseMotionListener(listener);
	}
	
	public void init() {
		
		pieces = new ArrayList<Piece>();
		
		Piece King = new King(5, 2, false, this);
		Piece King2 = new King(1, 2, true, this);
		Piece Pawn = new Pawn(0, 6, true, this);
		Piece Bishop = new Bishop(4, 7, false, this);
		Piece Rook = new Rook(5, 5, true, this);
		Piece Knight = new Knight(7, 7, false, this);
		Piece queen = new Queen(2, 4, false, this);
		Piece rook = new Rook(4, 4, false, this);
        Piece pawn2 = new Pawn(7, 1, false, this);
	}
	
	void printTable() {//debugging proposes
		for(int i = 0;i<8;i++) {
        	for(int j = 0;j<8;j++) {
        		System.out.print(tiles[j][i].ownedPiece);
        		System.out.print(" ");
        	}
        	System.out.println();
        }
		System.out.println();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				tiles[i][j] = new Tile(i, j, boardWhite);
				tiles[i][j].drawTile(g);
				boardWhite = !boardWhite;
			}
			
			boardWhite = !boardWhite;
		}
		
		drawCoordinates(g);
		
		for(Piece i : pieces) {
			if(i.isWhite) {
				g.drawImage(i.white, i.getXPx(), i.getYPx(), Tile.size, Tile.size, null);
			}
			else {
				g.drawImage(i.black, i.getXPx(), i.getYPx(), Tile.size, Tile.size, null);
			}
		}
	}
	
	private void drawCoordinates(Graphics g) {
		//coordinates
		g.setColor(Color.BLACK);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 15)); 
		g.drawRect(0, 0, Tile.size*8, Tile.size*8);
		g.drawString("a", Tile.size-10, HEIGHT+10);
		g.drawString("b",2 * Tile.size-10, HEIGHT+10);
		g.drawString("c",3 * Tile.size-10, HEIGHT+10);
		g.drawString("d",4 * Tile.size-10, HEIGHT+10);
		g.drawString("e",5 * Tile.size-10, HEIGHT+10);
		g.drawString("f",6 * Tile.size-10, HEIGHT+10);
		g.drawString("g",7 * Tile.size-10, HEIGHT+10);
		g.drawString("h",8 * Tile.size-10, HEIGHT+10);
		
		g.drawString("1", 3, 25+HEIGHT-Tile.size);
		g.drawString("2", 3, 25+HEIGHT-Tile.size * 2);
		g.drawString("3", 3, 25+HEIGHT-Tile.size * 3);
		g.drawString("4", 3, 25+HEIGHT-Tile.size * 4);
		g.drawString("5", 3, 25+HEIGHT-Tile.size * 5);
		g.drawString("6", 3, 25+HEIGHT-Tile.size * 6);
		g.drawString("7", 3, 25+HEIGHT-Tile.size * 7);
		g.drawString("8", 3, 25+HEIGHT-Tile.size * 8);
		
	}
	
	public Tile getTile(int xPx, int yPx) { //returns the tile with given x, y values (in pixels)
		int x = xPx/Tile.size;
		int y = yPx/Tile.size;
		return tiles[x][y];
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Game game = new Game();
	}

	

}
