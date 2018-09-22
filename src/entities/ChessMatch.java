package entities;

public class ChessMatch {

	private int turn;
	private int size;
	private Board board;
	
	boolean check;
	boolean checkMate;
	
	public ChessMatch(int turn, int size, Board board, boolean check, boolean checkMate) {
		this.turn = turn;
		this.size = size;
		this.board = board;
		this.check = check;
		this.checkMate = checkMate;
	}
	
	public ChessMatch(int size) {
		this.turn = 0;
		this.size = size;
		this.board = new Board (size);
		this.check = false;
		this.checkMate = false;
	}
	
	public int getSize () {
		return size;
	}

	
}
