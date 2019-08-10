import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Camera extends Sprite implements GameConstants,PlayerConstants{
   protected int position;
   protected int stageWidth;
   protected int stageHeight;
   protected int imageWidth;
   private Player player;
   
	
	public Player getPlayer() {
	return player;
}


public void setPlayer(Player player) {
	this.player = player;
}


	void drawCamera(Graphics g){if(Board.gameStage==FIGHT_START) {
		BufferedImage img=image.getSubimage(position,0,stageWidth, stageHeight);
		g.drawImage(img, 0,0, G_WIDTH,G_HEIGHT,null);}}
	

@Override
protected
void move() {
	if(player.getX()<=50 || player.getX()>=800) {
	
	
	
	if(position<5) {
		position=5;
	}
	else if(position>imageWidth-stageWidth-5) {
		position=imageWidth-stageWidth-5;
	}
	else
	position+=speed;}
}

}