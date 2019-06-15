package gui.model;
import model.interfaces.DicePair;

public class DicePairImpl implements DicePair 
{
	final private int dice1, dice2, numFaces;
	
	public DicePairImpl (int dice1, int dice2, int numFaces) 
	{
		this.dice1 = dice1;
		this.dice2 = dice2;
		this.numFaces = numFaces;
	}

	public int getDice1() 
	{
		return dice1;
	}

	public int getDice2() 
	{
		return dice2;
	}

	public int getNumFaces() 
	{
		return numFaces;
	}

	public String toString() 
	{
		int total = dice1 + dice2;
		String line = "Dice 1: " + dice1 + ", Dice 2: " + dice2 + " .. Total: " + total;
		return line;
	}
}
