package GP;

import Spider.Spider;

public class IsNearMid extends GPNode 
{

	IsNearMid()
	{
		number_of_children = 2;
		children = new GPNode[2];
	}
	
	public String toString()
	{
		return "Is-Near-Mid";
	}
	
	public void evaluate(Spider s)
	{
		if (s.IsNearMid())
		{
			children[0].evaluate(s);
		}
		else
		{
			children[1].evaluate(s);
		}
	}
	
	
	
}
