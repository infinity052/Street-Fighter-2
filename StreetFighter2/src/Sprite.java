import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class Sprite implements GameConstants,PlayerConstants{
	
	protected int x;
	protected int y;
	protected int width;
	protected int height;
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	protected int speed;
	protected BufferedImage image;
	
	protected void draw(Graphics g){
    g.drawImage(image, x, y, width, height,null);
		
	}
	
	protected void move() {
		x+=speed;
	}
	
	protected void fall() {
		if(y>=FLOOR-height) {
			y=FLOOR-height;
		}
		y+=GRAVITY;
	}
	
	
}
