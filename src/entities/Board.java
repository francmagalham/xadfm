package entities;

import entities.enums.ChessPiece;
import entities.enums.Color;

public class Board {

	private Piece[][] board;

	public Board(Piece[][] board) {
		this.movePieceTo(Piece(0, 0, ChessPiece.ROOK, Color.BLACK);
		
		
	
	}
	
	
	public void movePieceTo(Piece piece, Position pos) {
		board[pos.getRow()][pos.getCol()] = piece;
		
	}
	
	
	
	
}
