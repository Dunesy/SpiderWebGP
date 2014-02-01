package GP;

import Spider.Spider;

public class TraverseEdgeRandomly extends GPNode
{

	TraverseEdgeRandomly()
	{
		number_of_children = 0;
		children = null;
	}
	
	public String toString()
	{
		return "Traverse-Edge-Randomly";
	}
	
	public void evaluate(Spider s)
	{
		s.TraverseEdgeRandomly();
	}
	
}
