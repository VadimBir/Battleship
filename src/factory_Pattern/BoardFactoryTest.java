package factory_Pattern;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runners.JUnit4;
import org.junit.runners.model.InitializationError;

import junit.framework.Assert;

class BoardFactoryTest {


	@SuppressWarnings("deprecation")
	@Test
	void testCreateBoard() throws InitializationError {
		//Class klass;
		
		String toTest1 = "10x10";
		String toTest2 = "8x8";
		BoardFactory boardFactory = new BoardFactory();
		
		Board board1 = boardFactory.createBoard(toTest1);
		Board board2 = boardFactory.createBoard(toTest2);
		String[][] board1Is = board1.boardArrPlayer;
		String[][] board2Is = board2.boardArrPlayer;
		board1.boardClear();
		board2.boardClear();
		String[][] boardToBe1= 
			   {{" "," "," "," "," "," "," "," "," "," "},
				{" "," "," "," "," "," "," "," "," "," "},
				{" "," "," "," "," "," "," "," "," "," "},
				{" "," "," "," "," "," "," "," "," "," "},
				{" "," "," "," "," "," "," "," "," "," "},
				{" "," "," "," "," "," "," "," "," "," "},
				{" "," "," "," "," "," "," "," "," "," "},
				{" "," "," "," "," "," "," "," "," "," "},
				{" "," "," "," "," "," "," "," "," "," "},
				{" "," "," "," "," "," "," "," "," "," "}};
		String[][] boardToBe2= 
			   {{" "," "," "," "," "," "," "," "},
				{" "," "," "," "," "," "," "," "},
				{" "," "," "," "," "," "," "," "},
				{" "," "," "," "," "," "," "," "},
				{" "," "," "," "," "," "," "," "},
				{" "," "," "," "," "," "," "," "},
				{" "," "," "," "," "," "," "," "},
				{" "," "," "," "," "," "," "," "}};
						
		assertTrue(boardCompare(board1Is, boardToBe1));
		assertTrue(boardCompare(board2Is, boardToBe2));
		//assertEquals(boardToBe2, board2.boardArrPlayer);
		
	}
	boolean boardCompare(String[][] board1Is,String[][] boardToBe1 ) 
	{
		for (int i = 0; i<boardToBe1.length; i++) {
			for(int j = 0; j<boardToBe1.length; j++) {
				if(!boardToBe1[i][j].equals(board1Is[i][j])) {
					return false;
				}	
			}
		}
		return true;
	}
	

}
