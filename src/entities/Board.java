package entities;

import entities.enums.Color;

public class Board {

	public Piece[][] board;

	public Board(int size) {
		
		board = new Piece [size][size];
		board[0][0] = new Rook(Color.BLACK);
//		board[0][1] = new Horse(Color.BLACK);
		board[0][2] = new Bishop(Color.BLACK);
//		board[0][3] = new Queen(Color.BLACK);
//		board[0][4] = new King(Color.BLACK);
		board[0][5] = new Bishop(Color.BLACK);
//		board[0][6] = new Horse(Color.BLACK);
		board[0][7] = new Rook(Color.BLACK);
//		board[1][0] = new Pawn(Color.BLACK);		
//		board[1][1] = new Pawn(Color.BLACK);
		
		// zona de teste:
		board[3][5] = new Bishop(Color.BLACK);
		board[3][4] = new Bishop(Color.BLACK);
		board[2][4] = new Rook(Color.WHITE);
		board[4][2] = new Horse(Color.WHITE);
		board[5][3] = new Horse(Color.BLACK);
		board[2][5] = new Queen(Color.WHITE);
		board[5][5] = new Queen(Color.BLACK);
		board[3][6] = new King(Color.WHITE);
		board[5][1] = new King(Color.WHITE);
		board[4][4] = new King(Color.WHITE);
		board[6][4] = new Pawn(Color.WHITE);
		board[4][3] = new Pawn(Color.WHITE);
		
//		board[1][2] = new Pawn(Color.BLACK);
//		board[1][3] = new Pawn(Color.BLACK);
//		board[1][4] = new Pawn(Color.BLACK);
//		board[1][5] = new Pawn(Color.BLACK);
//		board[1][6] = new Pawn(Color.BLACK);
//		board[1][7] = new Pawn(Color.BLACK);
		board[7][0] = new Rook(Color.WHITE);
//		board[7][1] = new Horse(Color.WHITE);
		board[7][2] = new Bishop(Color.WHITE);
//		board[7][3] = new Queen(Color.WHITE);
//		board[7][4] = new King(Color.WHITE);
		board[7][5] = new Bishop(Color.WHITE);
//		board[7][6] = new Horse(Color.WHITE);
		board[7][7] = new Rook(Color.WHITE);
//		board[6][0] = new Pawn(Color.WHITE);		
//		board[6][1] = new Pawn(Color.WHITE);
//		board[6][2] = new Pawn(Color.WHITE);
//		board[6][3] = new Pawn(Color.WHITE);
//		board[6][4] = new Pawn(Color.WHITE);
//		board[6][5] = new Pawn(Color.WHITE);
//		board[6][6] = new Pawn(Color.WHITE);
//		board[6][7] = new Pawn(Color.WHITE);
		
	}
	
	// Obtém a Piece de uma linha/coluna
	public Piece getPieceOn (int row, int col) {
		return board[row][col];
	}

	// Obtém a Piece de uma Posição
	public Piece getPieceOn (Position pos) {
		return board [pos.getRow()][pos.getCol()];
	}

	// Converte de coordenadas [introduzidas] para Posição,
	public static Position toPosition (String coord, int size) {
		
		return new Position(size - Character.getNumericValue(coord.charAt(1)), coord.charAt(0) - 'a');
	}
	
}
