package Spider;

import GUI.WebView;

public class Main
{
	
	public static void main (String args[])
	{
		WebView w = new WebView();
		w.setVisible(true);
		
		
		Spider spider = new Spider();
		
		spider.AimTowardsMid();
		spider.CreateEdge();
		
		spider.TraverseEdgeRandomly();
		spider.AimTowardsMid();
		spider.CreateEdge();
		
		spider.AimPerpendicularToEdge();		
		spider.CreateEdge();
	
		spider.TraverseEdgeRandomly();
		spider.AimPerpendicularToEdge();
		spider.CreateEdge();
		
		spider.TraverseEdgeRandomly();
		spider.RotateCCW(Math.PI/6);
		spider.CreateEdge();
		
		spider.TraverseEdgeRandomly();
		spider.AimPerpendicularToEdge();
		spider.CreateEdge();
		
		spider.MoveToNextJunction();
		spider.AimTowardsMid();
		spider.CreateEdge();
		
		while (true)
			w.Update(spider);
				
	}
		
}
