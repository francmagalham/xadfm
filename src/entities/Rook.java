package entities;

import entities.enums.Color;
import entities.enums.PieceTypes;

public class Rook extends Piece {

	public Rook(Color color) {
		super(PieceTypes.ROOK, color);
	}

	public boolean possibleMoves(Match match, Position pos, int size) {
		int rowPos = pos.getRow();
		int colPos = pos.getCol();

		Piece.cleanPossibleMoves();
		boolean stop;
		boolean anyMove = false;

		int i;
		int j;

		// Move N.
		stop = false;
		j = colPos;
		for (i = rowPos - 1; i >= 0 && !stop; i--) {
			stop = super.checkTarget(match, match.getBoard().getPieceOn(i, j), i, j);
			if (!anyMove) anyMove = !stop;
		}

		// Move S.
		stop = false;
		j = colPos;
		for (i = rowPos + 1; i < match.getSize() && !stop; i++) {
			stop = super.checkTarget(match, match.getBoard().getPieceOn(i, j), i, j);
			if (!anyMove) anyMove = !stop;
		}
		
		// Move E.
		stop = false;
		i = rowPos;
		for (j = colPos + 1; j < match.getSize() && !stop; j++) {
			stop = super.checkTarget(match, match.getBoard().getPieceOn(i, j), i, j);
			if (!anyMove) anyMove = !stop;
		}

		// Move W.
		stop = false;
		i = rowPos;
		for (j = colPos - 1; j >=0 && !stop; j--) {
			stop = super.checkTarget(match, match.getBoard().getPieceOn(i, j), i, j);
			if (!anyMove) anyMove = !stop;
		}
		
		return anyMove;
		
	}
}
