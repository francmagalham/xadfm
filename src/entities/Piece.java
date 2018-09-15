package entities;

import entities.enums.ChessPiece;
import entities.enums.Color;

public abstract class Piece extends Position {

	private Color color;
	private ChessPiece cPiece;

	public Piece(int row, int col, ChessPiece cPiece, Color color) {
		super(row, col);
		this.cPiece = cPiece;
		this.color = color;
	}
	
	public Piece(Position pos, ChessPiece cPiece, Color color) {
		super(pos.getRow(), pos.getCol());
		this.cPiece = cPiece;
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	public ChessPiece getName() {
		return cPiece;
	}

	@Override
	public String toString() {
		return "Piece [position/row=" + this.getRow() + " position/col=" + this.getCol() + " name = " + cPiece + " color=" + color + "]";
	}
	
	public abstract Boolean canMovePieceTo (Board board, Position pos);
	
}
