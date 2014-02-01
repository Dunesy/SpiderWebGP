package GP;

import Spider.Spider;


public class CreateEdge extends GPNode
{
	CreateEdge()
	{
		number_of_children = 0;
		children = null;
	}
	
	public String toString()
	{
		return "Create-Edge";
	}
	
	public void evaluate(Spider s)
	{
		super.evaluate(s);
		s.CreateEdge();
	}
	
}
