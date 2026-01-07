import java.awt.Color;
import java.awt.Graphics;

public class Projectile{
	private int x;
	private int y;
	
	private int width;
	private int height;
	
	private Color red;
	
	public Projectile(int x, int y){
		
		this.x = x;
		this.y = y;
		
		this.width = 10;
		this.height = 10;
		
		this.red = new Color(255,0,0);
	
	}
	
	public void drawMe(Graphics g){
		g.setColor(red);
		g.fillOval(x,y,width,height);
	}
	
	
}