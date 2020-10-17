package factory_Pattern;
import java.io.Serializable;
import factory_Pattern.maps.*;;

public class BoardFactory implements Serializable{
	public Board createBoard(String string) {
		Board board = null;
		if(string.equals("8x8")) {
			board = new Board_8x8();
		}else if (string.equals("10x10")) {
			board = new Board_10x10();
		}
		
		 
		return board;
		
	}
}
