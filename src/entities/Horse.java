package entities;

import entities.enums.Color;
import entities.enums.PieceTypes;

public class Horse extends Piece {

	public Horse(Color color) {
		super(PieceTypes.HORSE, color);
	}

	public void possibleMoves(Match match, Position pos, int size) {
		int rowPos = pos.getRow();
		int colPos = pos.getCol();

		Piece.cleanPossibleMoves();

		int i;
		int j;

		for (i=-2; i<=2; i++) {
			for (j=-2; j<=2 ; j++) {
				if (i != 0 && j != 0 && Math.abs(i) != Math.abs(j)) {
					if (rowPos+i>=0 && rowPos+i<match.getSize() && colPos+j>=0 && colPos+j<match.getSize() ) {
						super.checkTarget(match, match.getBoard().getPieceOn(rowPos+i, colPos+j), rowPos+i, colPos+j);
					}
				}
			}
		}
				
	}
}
