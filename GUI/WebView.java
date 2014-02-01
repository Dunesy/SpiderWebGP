package GUI;
import java.awt.Graphics2D;

import javax.swing.JFrame;

import Spider.Spider;
import Spider.Web;

public class WebView extends JFrame{
	
	Board drawingboard;
	public WebView()
	{
		drawingboard = new Board();
		this.setSize(400,400);
		this.setVisible(true);
	}
	
	public void Update(Spider s)
	{
		drawingboard.DrawWeb(s.spider_web, s, this.getGraphics());
	}
	
}
