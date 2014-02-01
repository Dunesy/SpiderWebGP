package GP;

import Spider.Spider;

public abstract class GPNode {

	public int number_of_children;
	public GPNode parent;
	public GPNode[] children;
	public int depth;
	
	
	GPNode()
	{
		
	}
	
	public void evaluate(Spider s)
	{
		//Remain Empty
	}

		
	
}
