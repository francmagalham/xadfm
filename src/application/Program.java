package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import entities.Board;
import entities.Piece;
import exceptions.MoveException;

public class Program {

	public static void main(String[] args) {

		int size = 8;
		Board board = new Board(size);

		boolean check = false;
		boolean checkMate = false;

		Scanner sc = new Scanner(System.in);

		String source;
		String target;

		Boolean repeatMove = false;

		while (!checkMate) {

			while (!repeatMove) {
				try {
					UIB.printBoard(board, size);
					System.out.println("Make your move:");
					System.out.printf("Source> ");
					source = sc.nextLine();
					UIB.validateCoord(source);

					System.out.printf("Target> ");
					target = sc.nextLine();
					UIB.validateCoord(target);
					
					//System.out.println(Piece.toPosition(source, size) + " -> " +  Piece.toPosition(target, size));
					System.out.println(board.getPieceOn (4, 4));
					sc.nextLine();
					
				} catch (MoveException e) {
					System.out.println(e);
				} catch (InputMismatchException e) {
					System.out.println(e);
				}
				
			}
			
		}
		
		sc.close();
	}
}
