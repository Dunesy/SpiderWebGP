package GP;

import java.util.Random;
import Spider.Spider;

public class RotateCCW extends GPNode
{
	public static Random rand = new Random();
	public double angle_of_rotation;
	
	RotateCCW()
	{
		number_of_children = 0;
		children = null;
		angle_of_rotation = rand.nextDouble() * Math.PI/2;
	}
	
	public String toString()
	{
		return "Rotate-CCW";
	}
	
	public void evaluate(Spider s)
	{
		s.RotateCCW(angle_of_rotation);
	}
}
