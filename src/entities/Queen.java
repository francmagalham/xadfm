package entities;

import entities.enums.Color;
import entities.enums.PieceTypes;

public class Queen extends Piece {

	public Queen(Color color) {
		super(PieceTypes.QUEEN, color);
	}

	public void possibleMoves(Match match, Position pos, int size) {
		int rowPos = pos.getRow();
		int colPos = pos.getCol();

		Piece.cleanPossibleMoves();
		boolean stop = false;

		int i;
		int j;

		// Move N.
		stop = false;
		j = colPos;
		for (i = rowPos - 1; i >= 0 && !stop; i--) {
			stop = super.checkTarget(match, match.getBoard().getPieceOn(i, j), i, j);
		}
		// Move S.
		stop = false;
		j = colPos;
		for (i = rowPos + 1; i < match.getSize() && !stop; i++) {
			stop = super.checkTarget(match, match.getBoard().getPieceOn(i, j), i, j);
		}
		// Move E.
		stop = false;
		i = rowPos;
		for (j = colPos + 1; j < match.getSize() && !stop; j++) {
			stop = super.checkTarget(match, match.getBoard().getPieceOn(i, j), i, j);
		}
		// Move W.
		stop = false;
		i = rowPos;
		for (j = colPos - 1; j >=0 && !stop; j--) {
			stop = super.checkTarget(match, match.getBoard().getPieceOn(i, j), i, j);
		}
		
		// Move NE.
		stop = false;
		j = colPos;
		for (i = rowPos - 1; i >= 0 && !stop; i--) {
			j++;
			if ((j >= 0) && (j < match.getSize())) {
				stop = super.checkTarget(match, match.getBoard().getPieceOn(i, j), i, j);
			}
		}
		// Move SE.
		stop = false;
		j = colPos;
		for (i = rowPos + 1; i < match.getSize() && !stop; i++) {
			j++;
			if ((j >= 0) && (j < match.getSize())) {
				stop = super.checkTarget(match, match.getBoard().getPieceOn(i, j), i, j);
			}
		}
		// Move NW.
		stop = false;
		j = colPos;
		for (i = rowPos - 1; i >= 0 && !stop; i--) {
			j--;
			if ((j >= 0) && (j < match.getSize())) {
				stop = super.checkTarget(match, match.getBoard().getPieceOn(i, j), i, j);
			}
		}
		// Move SW.
		stop = false;
		j = colPos;
		for (i = rowPos + 1; i < match.getSize() && !stop; i++) {
			j--;
			if ((j >= 0) && (j < match.getSize())) {
				stop = super.checkTarget(match, match.getBoard().getPieceOn(i, j), i, j);
			}
		}		
		
	}
}
