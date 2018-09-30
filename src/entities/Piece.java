package entities;

import entities.enums.Color;
import entities.enums.PieceTypes;
import exceptions.MoveException;

public abstract class Piece {

	private Color color;
	private PieceTypes cPiece;
	static private Boolean[][] possibleMoves = new Boolean[8][8];
	private Boolean firstMove;
	
	public Piece(PieceTypes cPiece, Color color) {
		this.cPiece = cPiece;
		this.color = color;
		this.firstMove = true;
	}

	public Color getColor() {
		return color;
	}

	public PieceTypes getcPiece() {
		return cPiece;
	}
	
	public Boolean isFirstMove() {
		return firstMove;
	}
	
	public void setFirstMove(Boolean firstMove) {
		this.firstMove = firstMove;
	}

	@Override
	public String toString() {
		return this.cPiece.toString();
	}

	// Assinala na matriz do tabuleiro uma posição com TRUE se for uma jogada
	// possível para a peça.
	static public void markPossibleMove(int row, int col) {
		possibleMoves[row][col] = true;

	}

	// Inicializa todas as possíveis posições a FALSE.
	static public void cleanPossibleMoves() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				possibleMoves[i][j] = false;
			}
		}
	}

	public void validateMove(Position pos) {
		if (!possibleMoves[pos.getRow()][pos.getCol()]) {
			throw new MoveException("Illegal " + this.cPiece + " movement");
		}
	}

	static public void validateSourceMove(Match match, Position sourcePosition) {
		Piece pieceSource = match.getBoard().getPieceOn(sourcePosition);
		
		if (pieceSource == null) {
			throw new MoveException ("You chose a position with no chess piece");
		} else if (pieceSource.getColor() != match.turnPlayer()) {
			throw new MoveException ("Pick up a piece of your own");
		}
	}
	
	static public Boolean checkTarget(Match match, Piece pieceTarget, int i, int j) {
		if (pieceTarget == null) {										// Posição vazia.
			Piece.markPossibleMove(i, j);
			return false; 	
		} else if (pieceTarget.getColor() == match.turnOpponent()) {	// Posição com peça do oponente.
			Piece.markPossibleMove(i, j);
			return true; 	
		} else {														// Posição não ocupável.
			return true;	
		}
	}
	
	static public Boolean possibleTarget(int row, int col) {
		return possibleMoves[row][col];
	}
	
	static public Boolean possibleTarget(Position targetPosition) {
		return possibleMoves[targetPosition.getRow()][targetPosition.getCol()];
	}
	
	static public void validateTargetMove(Position targetPosition) {
		if (!possibleTarget(targetPosition)) {
			throw new MoveException("Target position not allowed");
		}
	}

	public abstract boolean possibleMoves(Match match, Position pos, int size);

}
