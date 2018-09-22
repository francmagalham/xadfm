package entities;

import entities.enums.Color;
import entities.enums.PieceTypes;

public class Rook extends Piece {

	public Rook(Color color) {
		super(PieceTypes.ROOK, color);
	}
	
	public void possibleMoves(Board board, Piece piece, Position pos, int size) {
		int rowPos = pos.getRow();
		int colPos = pos.getCol();
		Color pieceColor = piece.getColor();
		
		
		piece.cleanPossibleMoves();
		boolean stop = false;
		
		
		
		for (int i=rowPos; i<size && !stop ; i++) {
			
			Piece pieceTarget = board.getPieceOn(new Position (i, colPos));
			
			if (pieceTarget == null) {
		//		if pieceTarget.getColor() == cor do jogador do turno...
				
			}
		}
		
		
	}
	
	
}
