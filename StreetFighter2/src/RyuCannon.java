import java.awt.Graphics;

public class RyuCannon extends Sprite implements GameConstants{
	
	
	
	RyuCannon(int x , int y){
		this.x=x+60;
		this.y=y+50;
		height=80;
		width=100;
		speed=25;
		image=ImageLoader.loadImage("ryu.jpg").getSubimage(12, 3111, 58, 31);
		
	}
	
	protected void draw(Graphics g){
	    g.drawImage(image, x, y, width, height,null);
			
		}

}
