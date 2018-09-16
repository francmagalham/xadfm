package entities;

import entities.enums.Color;
import entities.enums.PieceTypes;

public class Board {

	private Piece[][] board;

	public Board(int size) {
		
		board = new Piece [size][size];
		board[0][0] = new Rook(Color.BLACK);
		/*
		board[0][1] = new Horse(Color.BLACK);
		board[0][2] = new Bishop(Color.BLACK);
		board[0][3] = new Queen(Color.BLACK);
		board[0][4] = new King(Color.BLACK);
		board[0][2] = new Bishop(Color.BLACK);
		board[0][1] = new Horse(Color.BLACK);
		*/
		board[0][0] = new Rook(Color.BLACK);
		/*
		board[0][7] = new Pawn(Color.BLACK);		
		board[0][7] = new Pawn(Color.BLACK);
		board[0][7] = new Pawn(Color.BLACK);
		board[0][7] = new Pawn(Color.BLACK);
		board[0][7] = new Pawn(Color.BLACK);
		board[0][7] = new Pawn(Color.BLACK);
		board[0][7] = new Pawn(Color.BLACK);
		board[0][7] = new Pawn(Color.BLACK);
		*/
		board[0][0] = new Rook(Color.WHITE);
		/*
		board[0][1] = new Horse(Color.WHITE);
		board[0][2] = new Bishop(Color.WHITE);
		board[0][3] = new Queen(Color.WHITE);
		board[0][4] = new King(Color.WHITE);
		board[0][2] = new Bishop(Color.WHITE);
		board[0][1] = new Horse(Color.WHITE);
		*/
		board[0][0] = new Rook(Color.WHITE);
		/*
		board[0][7] = new Pawn(Color.WHITE);		
		board[0][7] = new Pawn(Color.WHITE);
		board[0][7] = new Pawn(Color.WHITE);
		board[0][7] = new Pawn(Color.WHITE);
		board[0][7] = new Pawn(Color.WHITE);
		board[0][7] = new Pawn(Color.WHITE);
		board[0][7] = new Pawn(Color.WHITE);
		board[0][7] = new Pawn(Color.WHITE);
		 */
		
	}
	
	// Obtém a Piece de uma linha/coluna
	public Piece getPieceOn (int row, int col) {
		return board[row][col];
	}

	// Obtém a Piece de uma Posicao
	public Piece getPieceOn (Position pos) {
		return board [pos.getRow()][pos.getCol()];
	}

	// Converte de coordenadas [introduzidas] para Posição,
	public static Position toPosition (String coord, int size) {
			
		return new Position(size - Character.getNumericValue(coord.charAt(1)), coord.charAt(0) - 'a');
	}
	
	/*
	board[0][0] = new Piece(PieceTypes.ROOK, Color.BLACK);
	board[0][1] = new Piece(PieceTypes.HORSE, Color.BLACK);
	board[0][2] = new Piece(PieceTypes.BISHOP, Color.BLACK);
	board[0][3] = new Piece(PieceTypes.QUEEN, Color.BLACK);
	board[0][4] = new Piece(PieceTypes.KING, Color.BLACK);
	board[0][5] = new Piece(PieceTypes.BISHOP, Color.BLACK);
	board[0][6] = new Piece(PieceTypes.HORSE, Color.BLACK);
	board[0][7] = new Piece(PieceTypes.ROOK, Color.BLACK);
	board[1][0] = new Piece(PieceTypes.PAWN, Color.BLACK);
	board[1][1] = new Piece(PieceTypes.PAWN, Color.BLACK);
	board[1][2] = new Piece(PieceTypes.PAWN, Color.BLACK);
	board[1][3] = new Piece(PieceTypes.PAWN, Color.BLACK);
	board[1][4] = new Piece(PieceTypes.PAWN, Color.BLACK);
	board[1][5] = new Piece(PieceTypes.PAWN, Color.BLACK);
	board[1][6] = new Piece(PieceTypes.PAWN, Color.BLACK);
	board[1][7] = new Piece(PieceTypes.PAWN, Color.BLACK);
	
	board[7][0] = new Piece(PieceTypes.ROOK, Color.WHITE);
	board[7][1] = new Piece(PieceTypes.HORSE, Color.WHITE);
	board[7][2] = new Piece(PieceTypes.BISHOP, Color.WHITE);
	board[7][3] = new Piece(PieceTypes.QUEEN, Color.WHITE);
	board[7][4] = new Piece(PieceTypes.KING, Color.WHITE);
	board[7][5] = new Piece(PieceTypes.BISHOP, Color.WHITE);
	board[7][6] = new Piece(PieceTypes.HORSE, Color.WHITE);
	board[7][7] = new Piece(PieceTypes.ROOK, Color.WHITE);
	board[6][0] = new Piece(PieceTypes.PAWN, Color.WHITE);
	board[6][1] = new Piece(PieceTypes.PAWN, Color.WHITE);
	board[6][2] = new Piece(PieceTypes.PAWN, Color.WHITE);
	board[6][3] = new Piece(PieceTypes.PAWN, Color.WHITE);
	board[6][4] = new Piece(PieceTypes.PAWN, Color.WHITE);
	board[6][5] = new Piece(PieceTypes.PAWN, Color.WHITE);
	board[6][6] = new Piece(PieceTypes.PAWN, Color.WHITE);
	board[6][7] = new Piece(PieceTypes.PAWN, Color.WHITE);
	*/	
	
}
