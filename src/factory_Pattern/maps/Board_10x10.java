package factory_Pattern.maps;
import factory_Pattern.*;
import java.io.Serializable;


public class Board_10x10 extends Board{
	public Board_10x10()
	{ 
		initialised = false;
		boardArrPlayer = new String[10][10];
		boardArrEnemy= new String [10][10];
		boardCol = new String[]{"1","2","3","4","5","6","7","8","9","10"};
		boardRow = new String[]{" 1"," 2"," 3"," 4"," 5"," 6"," 7"," 8"," 9","10"};
	}
}
