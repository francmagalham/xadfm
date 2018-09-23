package application;

import entities.Board;
import entities.Match;
import entities.Piece;
import entities.enums.Color;
import exceptions.MoveException;

public class UIB {

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

	private static char piece;
	private static Piece pieceToPrint;

	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
	
	// Limpa o ecran e imprime o tabuleiro.
	public static void printBoard(Match match, Boolean printPossibleMoves) {
		
		Board board = match.getBoard();
		int size = match.getSize();
		int turn = match.getTurn();
		
		clearScreen();		
		System.out.print(ANSI_YELLOW);
		System.out.println(" | TURN NUMBER: " + turn + " |");
		System.out.print(ANSI_RESET);
		System.out.println("  a b c d e f g h");

		for (int i = 0; i < size; i++) {
			System.out.print(size - i + " ");
			
			System.out.print(ANSI_PURPLE_BACKGROUND);
			for (int j = 0; j < size; j++) {
				pieceToPrint = board.getPieceOn(i, j);
								
				if (printPossibleMoves && Piece.possibleTarget (i, j)) {
					System.out.print(ANSI_RED_BACKGROUND);					
				} else {
					System.out.print(ANSI_PURPLE_BACKGROUND);
				}
				
				if (!(pieceToPrint==null)) {				
					if (pieceToPrint.getColor() == Color.WHITE) {
						System.out.print(ANSI_WHITE);
					} else {
						System.out.print(ANSI_BLACK);
					}
					System.out.print(pieceToPrint.toString().charAt(0) + " ");
				} else {
					System.out.print("  ");
				}
				
			}
			
			System.out.print(ANSI_RESET);
			System.out.println(size - i);
		}
		
		System.out.println("  a b c d e f g h");
		
		System.out.print(ANSI_YELLOW);
		System.out.println("- Black captured pieces: " + match.getBlackCaptured());
		System.out.println("- White captured pieces: " + match.getWhiteCaptured());
		System.out.print(ANSI_RESET);
	}

	// Valida se coordenadas introduzidas são corretas.
	public static void validateCoord(String coord) {
		if ((coord.length() > 2) || (coord.length() < 1) || (coord.charAt(0) < 'a' || coord.charAt(0) > 'h')
				|| (coord.charAt(1) < '1' || coord.charAt(1) > '8')) {
			throw new MoveException(
					"Input a letter between 'a' and 'h' immediatly followed by a number between '1' and '8'");
		}
	}
	
}
