package Spider;

public class Edge 
{
	
	public Vector2D p0;
	public Vector2D p1; 
	public boolean secure;
	
	Edge()
	{
		p0 = new Vector2D(0, 0);
		p1 = new Vector2D();
		secure = false;
	}
	
	Edge(float x1, float y1, float x2, float y2)
	{
		p0 = new Vector2D(x1, y1);
		p1 = new Vector2D(x2, y2);
		secure = false;
	}
	
	Edge(Vector2D u, Vector2D v)
	{
		p0 = u;
		p1 = v;
	}
	public boolean Collides(Vector2D p)
	{
		//TODO
		
		Vector2D v = new Vector2D();
		v.x = (p1.x - p0.x);
		v.y = (p1.y - p0.x);
						
		Vector2D w = new Vector2D();
		w.x = (p.x - p0.x);
		w.y = (p.y - p0.y);
		
		if (Vector2D.DotProduct(w, v) <= 0)
			if (Vector2D.distance(p, p0) < 15.0)
				return true;
			
		if (Vector2D.DotProduct(v,v) <= Vector2D.DotProduct(w, v))
			if (Vector2D.distance(p, p1) <= 15 )
				return true;
				
		float result = Vector2D.DotProduct(w, v) / Vector2D.DotProduct(v, v);
		Vector2D Pb = Vector2D.Add(p0, Vector2D.Scale(v , result));
			
		float distance = Vector2D.distance(p, Pb);
		if (distance < 15.0 )
			return true;
		
		return false;
	
	}
	
}
