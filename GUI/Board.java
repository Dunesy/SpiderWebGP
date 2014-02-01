package GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;

import javax.swing.JPanel;

import Spider.Edge;
import Spider.Spider;
import Spider.Web;

public class Board extends JPanel
{
	
	Board()
	{
		this.setSize(400,400);
		this.setVisible(true);
	}
	
	public void DrawWeb(Web web, Spider spid,  Graphics graphics)
	{
		ArrayList<Edge> edges = web.strings;
		ArrayList<Edge> frame = web.frame;
		
		graphics.setColor(Color.green);
		graphics.drawOval(195, 205, 5, 5);
		
		graphics.setColor(Color.red);
	//	System.out.println(spid.position.x + " " + spid.position.y);
		
		graphics.drawOval((int)(spid.position.x + 195) , (int)(spid.position.y + 205), 5, 5);
		
		graphics.setColor(Color.black);
		for ( Edge e : frame)
		{
			Line2D l = new Line2D.Float(e.p0.x + 195 , e.p0.y + 205 , e.p1.x + 195 , e.p1.y + 205);
			((Graphics2D) graphics).draw(l);
		}
		
		for ( Edge e : edges)
		{
			Line2D l = new Line2D.Float(e.p0.x + 195 , e.p0.y + 205 , e.p1.x + 195 , e.p1.y + 205);
			((Graphics2D) graphics).draw(l);
		}		
	}
	
}
