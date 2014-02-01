package GP;

import Spider.Spider;

public class SwitchEdge extends GPNode
{
	SwitchEdge()
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
		s.SwitchEdge();
	}
	
}
