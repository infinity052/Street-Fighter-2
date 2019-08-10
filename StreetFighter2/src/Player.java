import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Player extends Sprite implements PlayerConstants{
	boolean cannonDraw=false;
	public int playerState;
	protected int fightTime;
	public boolean isEnemy=false;
	int force;
	int health;
	int punchHealth;
	int punch2Health;
	int punch3Health;
	int kickHealth;
	int kick2Health;
	int kick3Health;
	 int healthTaken=0;
	public int getHealth() {
		return health;
	}

	public int getHealthTaken() {
		return healthTaken;
	}

	public void setHealthTaken(int healthTaken) {
		this.healthTaken = healthTaken;
	}
	public void setHealth(int health) {
		this.health = health;
	}

	public int getPunchHealth() {
		return punchHealth;
	}

	public void setPunchHealth(int punchHealth) {
		this.punchHealth = punchHealth;
	}

	public int getPunch2Health() {
		return punch2Health;
	}

	public void setPunch2Health(int punch2Health) {
		this.punch2Health = punch2Health;
	}

	public int getPunch3Health() {
		return punch3Health;
	}

	public void setPunch3Health(int punch3Health) {
		this.punch3Health = punch3Health;
	}

	public int getKickHealth() {
		return kickHealth;
	}

	public void setKickHealth(int kickHealth) {
		this.kickHealth = kickHealth;
	}

	public int getKick2Health() {
		return kick2Health;
	}

	public void setKick2Health(int kick2Health) {
		this.kick2Health = kick2Health;
	}

	public int getKick3Health() {
		return kick3Health;
	}

	public void setKick3Health(int kick3Health) {
		this.kick3Health = kick3Health;
	}


	BufferedImage[] playerEnter=new BufferedImage[9];
	BufferedImage[] playerIdle=new BufferedImage[11];
	BufferedImage[] playerPunch=new BufferedImage[6];
	BufferedImage[] playerJump=new BufferedImage[6];
	BufferedImage[] playerCrouch=new BufferedImage[3];
	BufferedImage[] playerKick=new BufferedImage[7];
	BufferedImage[] playerDefend=new BufferedImage[3];
	BufferedImage[] playerKick2=new BufferedImage[4];
	BufferedImage[] playerKick3=new BufferedImage[11];
	BufferedImage[] playerPunch2=new BufferedImage[6];
	BufferedImage[] playerPunch3=new BufferedImage[13];
	BufferedImage playerHurt=null;
	BufferedImage playerDead=null;
	
	 public boolean checkIfHit() {
		 return false;
	 }

protected void jump() {
	y+=force;
	force+=GRAVITY;
	
}

public int getForce() {
	return force;
}

public void setForce(int force) {
	this.force = force;
}


void ryuCannonFireDraw(Graphics g) {}


}