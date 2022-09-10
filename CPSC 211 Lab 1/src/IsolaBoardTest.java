import static org.junit.Assert.*;

import org.junit.Test;

public class IsolaBoardTest {

	@Test
	public void BoardSpace() {
		BoardSpace board = new IsolaBoard();
		
		
		BoardSpace IsolaBoard = board.get(7, 7);
		int result = IsolaBoard;
		
		if (result != BoardSpace)
			fail("Failed to create board");
	}
	@Test
	public void getWidth() {
		getWidth width = new getWidth();
		int result = width;
		
		if (result != 7)
			fail("Failed to get correct with. Should be 7, but got" + width);
	}
	@Test
	public void getHeight() {
		getHeight height = new getHeight();
		int result = height;
		
		if (height != 7)
			fail("Failed to get correct with. Should be 7, but got" + width);
	}
	
	@Test
	public void movePlayer() {
		movePlayer move = new movePlayer();
		
		
	}
	@Test
	public void checkWinner() {
		checkWinner winner = new checkWinner();
	}
	@Test
	public void createBoard() {
		createBoard create = new createBoard();
	}
	@Test
	public void  positionIsIsolated() {
		positionIsIsolated isolate = new positionIsIsolated();
	}
	@Test
	public void illegalBoardPosition() {
		illegalBoardPosition illegal = new illegalBoardPosition();
	}
}
