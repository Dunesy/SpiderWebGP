package Spider;

public class Vector2D {

	public float x;
	public float y;
	
	
	Vector2D(float x, float y)
	{
		this.x = x;
		this.y = y;
	}
	
	Vector2D()
	{
		this.x = 0;
		this.y = 0;
	}
	
	void North()
	{
		this.x = 0;
		this.y = -1;
	}
	
	static float distance(Vector2D arg0, Vector2D arg1)
	{
		if (arg1 != null)
			return (arg0.x - arg1.x) * (arg0.x - arg1.x) + (arg0.y - arg1.y) * (arg0.y - arg1.y);
		else 
			return (arg0.x * arg0.x) + (arg0.y * arg0.y);
	}
	
	void Normalize()
	{	
		Vector2D temp = new Vector2D(this.x , this.y);
		this.x /= Math.sqrt(distance(temp, null));
		this.y /= Math.sqrt(distance(temp, null));
	}
	
	static float DotProduct(Vector2D arg0, Vector2D arg1)
	{
		return (arg0.x * arg1.x + arg0.y * arg1.y);
	}
	
	static Vector2D Add ( Vector2D arg0, Vector2D arg1)
	{
		Vector2D add = new Vector2D();
		add.x = arg0.x + arg1.x;
		add.y = arg0.y + arg1.y;
		return add;
	}
	
	static Vector2D Scale (Vector2D arg0, float factor)
	{
		Vector2D scale = new Vector2D();
		scale.x = arg0.x * factor;
		scale.y = arg0.y * factor;
		return scale;
	}
	
	static Vector2D Subtract(Vector2D arg0 , Vector2D arg1)
	{
		Vector2D sub = new Vector2D();
		sub.x = arg1.x - arg0.x;
		sub.y = arg1.y - arg0.y;
		return sub;
	}
	
	
}
