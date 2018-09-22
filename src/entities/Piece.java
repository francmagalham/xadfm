package entities;

import entities.enums.Color;
import entities.enums.PieceTypes;
import exceptions.MoveException;

public abstract class Piece {

	private Color color;
	private PieceTypes cPiece;
	private Boolean[][] possibleMoves = new Boolean[8][8];

	public Piece(PieceTypes cPiece, Color color) {
		this.cPiece = cPiece;
		this.color = color;
	}

	public Piece(PieceTypes cPiece, Color color, Boolean[][] possibleMoves) {
		this.cPiece = cPiece;
		this.color = color;
	}
	
	public Color getColor() {
		return color;
	}

	public PieceTypes getcPiece() {
		return cPiece;
	}

	public void setAPossibleMove(int row, int col) {
		this.possibleMoves [row][col] = true;
	}

	@Override
	public String toString() {
		return this.cPiece.toString();
	}
	
	public void cleanPossibleMoves() {
		for (int i = 0; i<8; i++) {
			for (int j=0; j<8; j++) {
				this.possibleMoves[i][j] = false;
			}
		}
	}
	
	public void validateMove (Position pos) {
		if (!this.possibleMoves[pos.getRow()][pos.getCol()]) {
			throw new MoveException ("Illegal movement to your " + this.cPiece);
		}
	}

	public abstract void possibleMoves (Board board, Piece piece, Position pos, int size);
	
}
