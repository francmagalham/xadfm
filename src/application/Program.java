package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import entities.Match;
import entities.Piece;
import entities.Position;
import exceptions.MoveException;

public class Program {

	public static void main(String[] args) {

		boolean check = false;
		boolean checkMate = false;

		Scanner sc = new Scanner(System.in);

		String source;
		String target;

		Position sourcePosition;
		Position targetPosition;
		
		Boolean repeatMove = false;
		
		// Initialize match with size 8!                      
		Match match = new Match(8);
		
		while (!checkMate) {

			while (!repeatMove) {
				try {
					UIB.printBoard(match, false);
					System.out.println("Make your move:");
					System.out.printf("Source> ");
					source = sc.nextLine();
					UIB.validateCoord(source);
					sourcePosition = match.getBoard().toPosition(source, match.getSize());
					
					Piece.validateSourceMove (match, sourcePosition);
					
					match.showPossibleMoves(sourcePosition);
					sc.nextLine();
					
					UIB.printBoard(match, true);
					
					System.out.println("Continue your move (source=" + source + ")");
					System.out.printf("Target> ");
					target = sc.nextLine();
					UIB.validateCoord(target);
					targetPosition = match.getBoard().toPosition(target, match.getSize());
					
					Piece.validateTargetMove (targetPosition);
					
					match.doMove(sourcePosition, targetPosition);
					
					match.incrementTurn();
					
				} catch (MoveException e) {
					System.out.println(e);
				} catch (InputMismatchException e) {
					System.out.println(e);
				}
				
			sc.nextLine();
				
			}
			
		}
		
		sc.close();
	}
}
