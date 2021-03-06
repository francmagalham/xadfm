package entities;

import entities.enums.Color;
import entities.enums.PieceTypes;

public class Bishop extends Piece {

	public Bishop(Color color) {
		super(PieceTypes.BISHOP, color);
	}

	public boolean possibleMoves(Match match, Position pos, int size) {
		int rowPos = pos.getRow();
		int colPos = pos.getCol();

		Piece.cleanPossibleMoves();
		boolean stop = false;
		boolean anyMove = false;

		int i;
		int j;

		// Move NE.
		stop = false;
		j = colPos;
		for (i = rowPos - 1; i >= 0 && !stop; i--) {
			j++;
			if ((j >= 0) && (j < match.getSize())) {
				stop = super.checkTarget(match, match.getBoard().getPieceOn(i, j), i, j);
				if (!anyMove) anyMove = !stop;
			}
		}
		
		// Move SE.
		stop = false;
		j = colPos;
		for (i = rowPos + 1; i < match.getSize() && !stop; i++) {
			j++;
			if ((j >= 0) && (j < match.getSize())) {
				stop = super.checkTarget(match, match.getBoard().getPieceOn(i, j), i, j);
				if (!anyMove) anyMove = !stop;
			}
		}
		
		// Move NW.
		stop = false;
		j = colPos;
		for (i = rowPos - 1; i >= 0 && !stop; i--) {
			j--;
			if ((j >= 0) && (j < match.getSize())) {
				stop = super.checkTarget(match, match.getBoard().getPieceOn(i, j), i, j);
				if (!anyMove) anyMove = !stop;
			}
		}
		
		// Move SW.
		stop = false;
		j = colPos;
		for (i = rowPos + 1; i < match.getSize() && !stop; i++) {
			j--;
			if ((j >= 0) && (j < match.getSize())) {
				stop = super.checkTarget(match, match.getBoard().getPieceOn(i, j), i, j);
				if (!anyMove) anyMove = !stop;
			}
		}		
		
		return anyMove;
	}
}
