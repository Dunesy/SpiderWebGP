package GP;

import Spider.Spider;

public class Progn3 extends GPNode{

	Progn3()
	{
		number_of_children = 3;
		children = new GPNode[3];
		
		
	}
	
	public String toString()
	{
		return "Progn2";
	}
	
	public void evaluate(Spider s)
	{super.evaluate(s);
		children[0].evaluate(s);
		children[1].evaluate(s);
		children[2].evaluate(s);
	}
}
