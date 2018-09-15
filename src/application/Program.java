package application;

import entities.Piece;
import entities.Position;
import entities.enums.ChessPiece;
import entities.enums.Color;

public class Program {

	public static void main(String[] args) {
		
		System.out.println("Hello chess game!");
		
		Position pos1 = new Position(2,5);
		System.out.println(pos1);
		
		Piece p1 = new Piece (pos1, ChessPiece.KING, Color.BLACK);
		
		System.out.println(p1);
		
	
	}

}
