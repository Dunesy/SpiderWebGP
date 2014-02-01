package GP;

import Spider.Spider;

public class MoveToNextJunction extends GPNode
{
	MoveToNextJunction()
	{
		number_of_children = 0;
		children = null;
	}
	
	public String toString()
	{
		return "Switch-Node";
	}
	
	public void evaluate(Spider s)
	{
		s.MoveToNextJunction();
	}
	
}
