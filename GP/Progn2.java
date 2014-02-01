package GP;

import Spider.Spider;

public class Progn2 extends GPNode{

	Progn2()
	{
		number_of_children = 2;
		children = new GPNode[2];
		
		
	}
	
	public String toString()
	{
		return "Progn2";
	}
	
	public void evaluate(Spider s)
	{
		children[0].evaluate(s);
		children[1].evaluate(s);
	}
}
