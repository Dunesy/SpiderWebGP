package GP;

import Spider.Spider;

public class AimPerpendicularToEdge extends GPNode
{
	
	AimPerpendicularToEdge()
	{
		number_of_children = 0;
		children = null;
	}
	
	public String toString()
	{
		return "Aim-Perpendicular-To-Edge";
	}
	
	public void evaluate(Spider s)
	{
		s.AimPerpendicularToEdge();
	}
	
}
