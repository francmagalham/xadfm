package entities;

import java.util.ArrayList;
import java.util.List;

import entities.enums.Color;

public class Match {

	private int turn;
	private int size;
	private Board board;

	private boolean check;
	private boolean checkMate;

	private List<Piece> blackCaptured = new ArrayList<Piece>();
	private List<Piece> whiteCaptured = new ArrayList<Piece>();

	public Match(int size) {
		this.board = new Board(size);
		this.turn = 1;
		this.size = size;
		this.check = false;
		this.checkMate = false;
	}

	public int getSize() {
		return size;
	}

	public int getTurn() {
		return turn;
	}

	public Board getBoard() {
		return board;
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}

	public boolean isCheck() {
		return check;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}

	public boolean isCheckMate() {
		return checkMate;
	}

	public List<Piece> getBlackCaptured() {
		return blackCaptured;
	}

	public List<Piece> getWhiteCaptured() {
		return whiteCaptured;
	}

	public void addCapturedPiece(Piece piece) {
		if (piece.getColor() == Color.BLACK) {
			this.blackCaptured.add(piece);
		} else if (piece.getColor() == Color.WHITE) {
			this.whiteCaptured.add(piece);
		} else {
			throw new IllegalStateException();
		}
	}

	public void setCheckMate(boolean checkMate) {
		this.checkMate = checkMate;
	}

	public void incrementTurn() {
		this.turn += 1;
	}

	public Color turnPlayer() {
		return (this.turn % 2.0 == 0.0) ? Color.BLACK : Color.WHITE;
	}

	public Color turnOpponent() {
		return (this.turn % 2.0 == 0.0) ? Color.WHITE : Color.BLACK;
	}

	// Exibe o tabuleiro com as jogadas possíveis com base na peça origem.
	public void showPossibleMoves(Position source) {
		Piece piece = this.getBoard().getPieceOn(source);
		piece.possibleMoves(this, source, size);
	}

	// Realiza a jogada com base nas peça origem e na posição destino.
	public void doMove(Position sourcePos, Position targetPos) {
		// Move peça.
		Piece sourcePiece = board.getPieceOn(sourcePos);
		Piece targetPiece = board.getPieceOn(targetPos);
		board.removePieceFrom(sourcePos);
		board.putPieceOn(sourcePiece, targetPos);
		
		if  (targetPiece!=null) {
			if (targetPiece.getColor()==Color.WHITE) {
				whiteCaptured.add(targetPiece);
			} else {
				blackCaptured.add(targetPiece);
			}
		}
			
		if (sourcePiece.isFirstMove()) {
			sourcePiece.setFirstMove(false);
		}
	
	}

}
