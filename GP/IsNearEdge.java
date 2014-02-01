package GP;

import Spider.Spider;


public class IsNearEdge extends GPNode
{	
	IsNearEdge()
	{
		number_of_children = 2;
		children = new GPNode[2];
	}
	
	public String toString()
	{
		return "Is-Near-Edge";
	}
	
	public void evaluate(Spider s)
	{super.evaluate(s);
		if (s.IsNearEdge())
		{
			children[0].evaluate(s);
		}
		else
		{
			children[1].evaluate(s);
		}
	}
}
