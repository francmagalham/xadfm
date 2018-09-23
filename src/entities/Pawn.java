package entities;

import entities.enums.Color;
import entities.enums.PieceTypes;

public class Pawn extends Piece {

	private Boolean firstMove;
	
	public Pawn(Color color) {
		super(PieceTypes.PAWN, color);
		this.firstMove = true;
	}

	public Boolean isFirstMove() {
		return firstMove;
	}

	public void possibleMoves(Match match, Position pos, int size) {
		int rowPos = pos.getRow();
		int colPos = pos.getCol();

		Piece.cleanPossibleMoves();
		boolean stop = false;

		int i;
		int j;
		int delta;

		int moves = 1;
		Pawn piece = (Pawn)match.getBoard().getPieceOn(pos);
		if (piece.firstMove) {
			moves = 2;
		}
		
		if (match.getBoard().getPieceOn(pos).getColor() == Color.WHITE) {
			delta = -1;
		} else if (match.getBoard().getPieceOn(pos).getColor() == Color.BLACK) {
			delta = 1;
		} else {
			throw new IllegalStateException ();
		}

		int n;
		// Testar movimento vertical.
		for (i=1; i<=moves && !stop; i++) {
			n = i * delta;
			if ((rowPos+n >= 0) && (rowPos+n < match.getSize())) {
				stop = super.checkTarget(match, match.getBoard().getPieceOn(rowPos+n, colPos), rowPos+n , colPos);
			}
		}
		// Testar diagonal.
		for (j=-1; j<=1; j++) {
			i = rowPos + delta;
			if (j != 0 && match.getBoard().getPieceOn(i, colPos+j) != null) {
				if ( (i>=0) && (i<match.getSize()) && (colPos+j>=0) && (colPos+j<match.getSize()) ) {
					super.checkTarget(match, match.getBoard().getPieceOn(i, colPos+j), i , colPos+j);
				}
			}
		}
	}
}
