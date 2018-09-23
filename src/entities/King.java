package entities;

import entities.enums.Color;
import entities.enums.PieceTypes;

public class King extends Piece {

	public King(Color color) {
		super(PieceTypes.KING, color);
	}

	public void possibleMoves(Match match, Position pos, int size) {
		int rowPos = pos.getRow();
		int colPos = pos.getCol();

		Piece.cleanPossibleMoves();

		int i;
		int j;

		for (i=-1; i<=1; i++) {
			for (j=-1; j<=1 ; j++) {
				super.checkTarget(match, match.getBoard().getPieceOn(rowPos+i, colPos+j), rowPos+i, colPos+j);
			}
		}
		
	}
}
