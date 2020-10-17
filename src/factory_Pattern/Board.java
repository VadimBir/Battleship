package factory_Pattern;
import java.io.Serializable;
import java.util.Arrays;

abstract public class Board implements Serializable{
	protected boolean initialised;
	public String[][] boardArrPlayer;
	public String[][] boardArrEnemy;
	public String[] boardRow;
	public String[] boardCol;
	 
	public void setBoard() 
	{
		boardClear();
		//draw();
		//System.out.println("--------------------------------------------------------");
		System.out.println("\t Player: ");
		drawT(boardArrPlayer);
		System.out.println("\t Enemy: ");
		drawT(boardArrEnemy);
		System.out.println("--------------------------------------------------------");
	}
	public void setBoardNoEnemy()
	{
		boardClear();
		//draw();
		//System.out.println("--------------------------------------------------------");
		System.out.println("\t Player: ");
		drawT(boardArrPlayer);
		System.out.println("--------------------------------------------------------");
	}
	/*
	public void draw()
	{  
		System.out.print("   ");
		for (int k=0; k<boardCol.length; k++) {
			System.out.print("[" + boardCol[k] + "]");
		}
		
		for(int i = 0; i<boardArrPlayer.length; i++) {
			System.out.print("\n["+boardRow[i]+"]");		
			for (int j= 0; j<boardArrPlayer[0].length; j++) {
					System.out.print("[" + boardArrPlayer[i][j] + "]");				
			}
		}
		System.out.println("\n");
		System.out.print(" E ");
		for (int k=0; k<boardCol.length; k++) {
			System.out.print("[" + boardCol[k] + "]");
		}
		
		for(int i = 0; i<boardArrEnemy.length; i++) {
			System.out.print("\n["+boardRow[i]+"]");		
			for (int j= 0; j<boardArrEnemy[0].length; j++) {
					System.out.print("[" + boardArrEnemy[i][j] + "]");				
			}
		}
		
		System.out.println("");
	}
	*/
	public void drawT(String[][] boardArr)
	{  
		System.out.print("   ");
		for (int k=0; k<boardCol.length; k++) {
			System.out.print("[" + boardCol[k] + "]");
		}
		
		for(int i = 0; i<boardArr.length; i++) {
			System.out.print("\n["+boardRow[i]+"]");		
			for (int j= 0; j<boardArr[0].length; j++) {
					System.out.print("[" + boardArr[i][j] + "]");				
			}
		}
		System.out.println("\n");
		
	}
	
	
	public void boardClear()
	{
		if (initialised!=true) {
			initialised =true;
			for (String[] row1 : boardArrPlayer) {
				Arrays.fill(row1, " ");
			for (String[] row2 : boardArrEnemy) {
				Arrays.fill(row2, " "); 
			}
			}
		}
	}
}
