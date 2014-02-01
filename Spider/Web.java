package Spider;
import java.util.ArrayList;

public class Web 
{	
	public static ArrayList<Edge> frame = new ArrayList<Edge>();
	
	public ArrayList<Edge> strings;
	public ArrayList<Point> Intercections;
	
	
	Web()
	{
		strings = new ArrayList<Edge>();
		Intercections = new ArrayList<Point>();
		
		frame.add(new Edge(-175, -175, 175, -175));
		frame.add(new Edge(-175, 175, 175, 175));
		frame.add(new Edge(-175, -175, -175, 175));
		frame.add(new Edge(175, -175, 175, 175));
	}
	
	//Fitness//
	//Given a set of objects that pass through the web, which ones intercect with the web .
	public float Evaluate( ArrayList<Vector2D> flies)
	{
		int score = 0;
		for (Vector2D p : flies)
		{
			for (Edge e : strings)
			{
				if (e.Collides(p))
				{
					score++;
				}			
			}			
		}
		return score / flies.size();
	}
	//
	
	
	
}


