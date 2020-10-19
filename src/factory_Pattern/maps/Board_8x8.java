package factory_Pattern.maps;
import  factory_Pattern.*;
import java.io.Serializable;

public class Board_8x8 extends Board{
	public Board_8x8()
	{ 
		initialised = false;
		//boardArr = new String[8][8];
		boardArrPlayer = new String[8][8];
		boardArrEnemy= new String [8][8];
		boardCol = new String[]{"A","B","C","D","E","F","G","H"};
		boardRow = new String[]{" 1"," 2"," 3"," 4"," 5"," 6"," 7"," 8"};
	}
}
