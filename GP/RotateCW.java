package GP;

import java.util.Random;

import Spider.Spider;

public class RotateCW extends GPNode{

	public static Random rand = new Random();
	public double angle_of_rotation;
	RotateCW()
	{
		number_of_children = 0;
		children = null;
		angle_of_rotation = rand.nextDouble() * Math.PI/2;		
	}
	
	public String toString()
	{
		return "Rotate-CW";
	}
	
	public void evaluate(Spider s)
	{
		s.RotateCW(angle_of_rotation);
	}
}
