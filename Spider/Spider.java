package Spider;
import java.util.ArrayList;
import java.util.Random;


public class Spider 
{
	public static Random rand = new Random();
	
	public Vector2D position;
	public Vector2D direction;
	
	public float current_angle;
	
	public Web spider_web;
	public Edge current_edge;
	public Edge previous_edge;
	public Edge junction;
	
	
	public boolean CCWSpiral;
	public boolean CWSpiral;
	public boolean onFrame;
	
	public Spider()
	{
		CCWSpiral = false;
		CWSpiral = false;
		onFrame = true;
		
		position = new Vector2D();
		position.x = -174.0f;
		position.y = -174.0f;
		
		current_angle = 0;
		
		direction = new Vector2D();
		direction.x = 1;
		direction.y = 0;
		
		current_edge = null;
		previous_edge = null;
		junction = null;
		
		spider_web = new Web();
	}
	
	public Vector2D PointOfIntersection(Edge b)
	{
		float x3 = b.p0.x, x4 = b.p1.x;
		float y3 = b.p0.y, y4 = b.p1.y;
		Vector2D intersect_point;
		direction.Normalize();
		float ua = ((x4 - x3) * (position.y - y3) - (y4 - y3) * (position.x - x3)) / ((y4 - y3)*(direction.x) - (x4 - x3) * (direction.y));
		float ub = ((direction.x) * (position.y - y3) - (direction.y) * (position.x - x3)) / ((y4 - y3)*(direction.x) - (x4 - x3) * (direction.y));
			
		if (ua == Float.NaN || ub == Float.NaN || ua < 0 || ub < 0) 
			return null;
		else 
		{
			intersect_point = new Vector2D(position.x + ua * (direction.x), position.y + ua*(direction.y));
		}
		
		if (intersect_point.x < 175.0f && intersect_point.x > -175.0f && intersect_point.y < 175.0f && intersect_point.y > -175.0f && 
				((x3 > intersect_point.x && x4 < intersect_point.x) || (x3 < intersect_point.x && x4 > intersect_point.x)
				|| (y3 < intersect_point.y && y4 > intersect_point.y) || (y3 > intersect_point.y && y4 < intersect_point.y)))				
		{
			return intersect_point;
		}
		
		return null;
	}
	
	public Vector2D PointOfIntersectionWithWall()
	{
		//Top Frame // Bottom Frame
		
		Vector2D closest_wall = new Vector2D();
		
		for (Edge e : Web.frame)
		{
			float x3 = e.p0.x , x4 = e.p1.x;
			float y3 = e.p0.y , y4 = e.p1.y;
				
			float ua = ((x4 - x3) * (position.y - y3) - (y4 - y3) * (position.x - x3)) / ((y4 - y3)*(direction.x) - (x4 - x3) * (direction.y));
			float ub = ((direction.x) * (position.y - y3) - (direction.y) * (position.x - x3)) / ((y4 - y3)*(direction.x) - (x4 - x3) * (direction.y));
		
			if (ua != Float.NaN && ub != Float.NaN && ua > 0 && ub > 0)
			{
				Vector2D temp = new Vector2D(position.x + ua * (direction.x),position.y + ua * (direction.y));
				if (closest_wall.x == 0 || Vector2D.distance(temp, position) < Vector2D.distance(closest_wall, position))
				{
					closest_wall.x = position.x + ua * (direction.x);
					closest_wall.y = position.y + ua * (direction.y);
					current_edge = e;
				}
			}
			
		}
		return closest_wall;
	}

	public void RotateCW(double radians)
	{
		direction.x = 1;
		direction.y = 0;
		
		current_angle += radians;
		
		if (current_angle > 2 * Math.PI)
		{
			current_angle = current_angle - (float)(Math.PI * 2);
		}
		
		float x = direction.x;
		float y = direction.y;
		
		direction.x = (float) (x * Math.cos(current_angle) - y * Math.sin(current_angle));
		direction.y = (float) (y * Math.cos(current_angle) + x * Math.sin(current_angle));	
	}
	
	public void RotateCCW(double radians)
	{
		direction.x = 1;
		direction.y = 0;
		
		
		current_angle -= radians;
		if (current_angle < 0)
		{
			current_angle = current_angle + (float)(Math.PI * 2);
		}
				
		float x = direction.x;
		float y = direction.y;
		
		direction.x = (float) (x * Math.cos(current_angle) - y * Math.sin(current_angle));
		direction.y = (float) (y * Math.cos(current_angle) + x * Math.sin(current_angle));	
	
	}
	
	public void UpdateSpiderPosition(float x , float y)
	{
		position.x = x;
		position.y = y;
	}

	public void TraverseEdgeRandomly()
	{
		//Determine Which End Point
		
		double distance_tot = Math.sqrt(  (double)Vector2D.distance(current_edge.p0, current_edge.p1));
		double distance_a = Math.sqrt ( (double) Vector2D.distance(position, current_edge.p0));
		double distance_b = Math.sqrt( (double) Vector2D.distance(position, current_edge.p1));
		if (rand.nextFloat() < distance_a / distance_tot)
		{
			direction = Vector2D.Subtract(position, current_edge.p0);
			direction.Normalize();
			position = Vector2D.Add(position, Vector2D.Scale(direction, rand.nextInt((int)distance_a)));
		}		
		else
		{
			direction = Vector2D.Subtract(current_edge.p1, position);
			direction.Normalize();
			position = Vector2D.Add(position, Vector2D.Scale(direction, rand.nextInt((int)distance_b)));
		}
		
	}
	
	public boolean IsNearMid()
	{	
		if (position.x * position.x + position.y * position.y < 1.0)
			return false;
		else
			return false;
	}
	
	public boolean IsNearEdge()
	{
		for (Edge e : spider_web.strings)
		{
			Vector2D v = new Vector2D();
			v.x = (e.p1.x - e.p0.x);
			v.y = (e.p1.y - e.p0.x);
						
			Vector2D w = new Vector2D();
			w.x = (position.x - e.p0.x);
			w.y = (position.y - e.p0.y);
			
			if (Vector2D.DotProduct(w, v) <= 0)
				if (Vector2D.distance(position, e.p0) < 10.0 && e != current_edge)
					return true;
			
			if (Vector2D.DotProduct(v,v) <= Vector2D.DotProduct(w, v))
				if (Vector2D.distance(position, e.p1) <= 10 && e != current_edge)
					return true;
				
			float result = Vector2D.DotProduct(w, v) / Vector2D.DotProduct(v, v);
			Vector2D Pb = Vector2D.Add(e.p0, Vector2D.Scale(v , result));
			
			float distance = Vector2D.distance(position, Pb);
			if (distance < 10.0 && e != current_edge)
				return true;
		}
		return false;
	}	
	
	public void AimTowardsMid()
	{
		direction = new Vector2D(0 - position.x, 0 - position.y);
		direction.Normalize();
	}
	
	public void AimPerpendicularToEdge()
	{
		direction.x = (current_edge.p0.x - current_edge.p1.x);
		direction.y = (current_edge.p0.y - current_edge.p1.y);
		direction.Normalize();
		
		if (rand.nextFloat() < .5f 
				&& position.x + direction.x < 175 
				&& position.x + direction.x > -175 
				&& position.y + direction.y < 175
				&& position.y + direction.y > -175
			)			
		{
			direction = new Vector2D(-direction.y, direction.x);
		}		
		else
			direction = new Vector2D(direction.y, -direction.x);
	}
	
	public void CreateEdge()
	{
		Vector2D closest = null;
				
		if (spider_web.strings != null)
			for (Edge e : spider_web.strings)
			{	
				if (e != current_edge)
				{
					Vector2D temp = PointOfIntersection(e);
					if (closest == null || Vector2D.distance(position, temp) < Vector2D.distance(closest, position))
					{
						closest = temp;
						current_edge = e;
					}				
				}
			}
			if (closest != null)
			{
				spider_web.strings.add(new Edge(position, closest));
				
			}
			else 
			{
				closest = PointOfIntersectionWithWall();			
				spider_web.strings.add(new Edge(position, closest));
			}
						
			position = closest;
	}
			
	public void MoveToNextJunction()
	{
		if (rand.nextFloat() < 0.5)
		{
			direction = Vector2D.Subtract(position, current_edge.p0);
			direction.Normalize();			
		}		
		else
		{
			direction = Vector2D.Subtract(current_edge.p1, position);
			direction.Normalize();
		}

		Vector2D closest = null;
		
		if (spider_web.strings != null)
			for (Edge e : spider_web.strings)
			{	
				if (e != current_edge)
				{
					Vector2D temp = PointOfIntersection(e);
					if (closest == null || Vector2D.distance(position, temp) < Vector2D.distance(closest, position))
					{					
						closest = temp;
						previous_edge = current_edge;
						junction = previous_edge;
						current_edge = e;
												
					}				
				}
			}
		if (closest == null)
		{
			closest = PointOfIntersectionWithWall();							
		}
					
		position = closest;		
	}
	
	public void SwitchEdge()
	{
		if (junction != null)
		{
			current_edge = junction;
			junction = null;
		}
	}
	
}