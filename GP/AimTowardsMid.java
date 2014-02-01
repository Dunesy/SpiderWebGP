package GP;

import Spider.Spider;

public class AimTowardsMid extends GPNode
{
	AimTowardsMid()
	{
		number_of_children = 0;
		children = null;
	}
	
	public String toString()
	{
		return "Aim-Towards-Mid";
	}
	
	public void evaluate(Spider s)
	{
		s.AimTowardsMid();
	}
	
}
