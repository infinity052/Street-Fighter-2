import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class EnemyHonda extends Player implements GameConstants, PlayerConstants {

	int healthtaken;
	int moveIndex=0;
	int fightIndex=0;
	int punchIndex=0;
	int force=-35;
	boolean attacked=false;
	int health;
	int punchHealth;
	int punch2Health;
	int punch3Health;
	int kickHealth;
	int kick2Health;
	int kick3Health;
	
	
	
	
	
	public int getHealthtaken() {
		return healthtaken;
	}



	public void setHealthtaken(int healthtaken) {
		this.healthtaken = healthtaken;
	}



	@Override
	protected void fall() {
		if(y>=FLOOR-height) {
			y=FLOOR-height;
		}
		y+=GRAVITY;
	}
	
	
	
	public boolean isAttacked() {
		return attacked;
	}



	public void setAttacked(boolean attacked) {
		this.attacked = attacked;
	}



	public int getHealth() {
		return health;
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
	
	
	
	
	
	@Override
	protected
	void jump() {
		y+=force;
		force+=GRAVITY;
	}
	
	EnemyHonda(){
		health=100;
		punchHealth=20;
//		int punch2Health;
//		int punch3Health;
		kickHealth=25;
		kick2Health=30;
//		int kick3Health;
		
		
		width=280;
		height=300;
		x=641;
		y=FLOOR-height+25;
		
		image=ImageLoader.loadImage("honda.jpg");
		loadEnterImages();
		loadIdleImages();
		loadJumpImages();
		loadPunchImages();
		loadCrouchImages();
		loadKickImages();
		loadDefendImages();
		loadKick2Images();
		loadHurtImage();
		loadDeadImage();
	}
	
	
	private void loadDeadImage() {
		playerDead=image.getSubimage(65, 406, 97, 46);
		
	}



	void loadHurtImage() {
		playerHurt=image.getSubimage(231,330, 62, 75);
	}
	
	private void loadKick2Images() {
		playerKick2[0]=image.getSubimage(1, 331, 95, 60);
		
	}

	private void loadDefendImages() {
		playerDefend[0]=image.getSubimage(0, 0, 75, 67);
		playerDefend[1]=image.getSubimage(0, 70, 65, 79);
		playerDefend[2]=image.getSubimage(0, 0, 75, 67);
		
		
		
	}

	private void loadKickImages() {
		playerKick[0]=image.getSubimage(0, 0, 75, 67);
		playerKick[1]=image.getSubimage(139, 258, 87, 61);
		playerKick[2]=image.getSubimage(0, 0, 75, 67);
		
	}

	private void loadCrouchImages() {
		playerCrouch[0]=image.getSubimage(0, 0, 75, 67);
		playerCrouch[1]=image.getSubimage(138, 85, 59, 45);
		playerCrouch[2]=image.getSubimage(0, 0, 75, 67);
		
	}

	private void loadJumpImages() {
		playerJump[0]=image.getSubimage(140, 84, 56, 48);
		playerJump[1]=image.getSubimage(196, 67, 65, 68);
		playerJump[2]=image.getSubimage(140, 84, 56, 48);
		
		
	}

	void loadEnterImages() {
		playerEnter[0]=image.getSubimage(0, 0, 74, 68);
		playerEnter[1]=image.getSubimage(85, 2, 67, 69);
		playerEnter[2]=image.getSubimage(260, 66, 60, 109);
	}
	
	void loadIdleImages() {
		playerIdle[0]=image.getSubimage(0, 0, 74, 68);
		playerIdle[1]=image.getSubimage(86, 0, 64, 72);
		
	}
	
	void loadPunchImages() {
		playerPunch[0]=image.getSubimage(74, 135, 63, 54);
		playerPunch[1]=image.getSubimage(138, 137, 103, 68);

		playerPunch[2]=image.getSubimage(74, 135, 63, 54);
		}
	
	void drawPlayer(Graphics g,BufferedImage image) {
		
		g.drawImage(image, x, y, width, height, null);
	}
	
	
	
	public boolean checkIfHit() {
		return attacked;
	}
	
	
	
	
	protected
	void draw(Graphics g) {
		if(playerState==PLAYER_ENTER) {
			drawPlayer(g,EnemyImageFlip.Flip(playerEnter[moveIndex]));
			if(fightTime>=0 && fightTime<=9) {
				fightTime++;
			}
		if(fightTime%3==0 && moveIndex<3) {
			
			moveIndex++;
		}
		
		
		if(moveIndex>=3) {
			fightTime=0;
			moveIndex=0;
			playerState=PLAYER_IDLE;
			
		}
		}
	
		else if(playerState==PLAYER_IDLE) {
			
			drawPlayer(g,EnemyImageFlip.Flip(playerIdle[moveIndex]));
			if(fightTime>=0 && fightTime<=6) {
				fightTime++;
			}
			
			if(fightTime%3==0 & moveIndex<2) {
				moveIndex++;
			}
//			
			if(moveIndex>=2) {
				moveIndex=0;
				fightTime=0;
			}}
		
		else if(playerState==PLAYER_PUNCH) {
			
			drawPlayer(g,EnemyImageFlip.Flip(playerPunch[punchIndex]));
			
			if(fightTime>=0 && fightTime<=9)
			{fightTime++;}
			if(fightTime%3==0 && punchIndex<2) {
				punchIndex++;
			}
			
			if(punchIndex==1) {
				setHealthTaken(punchHealth);
				setAttacked(true);
			}
			if(punchIndex>=2) {
				setAttacked(false);
				fightTime=0;
				setHealthTaken(0);
				punchIndex=0;
				playerState=PLAYER_IDLE;
				
				
			}
		}

		
		else if(playerState==PLAYER_JUMP) {
			
			this.jump();
			if(fightTime>=0 && fightTime<=6) {
				fightTime++;
			}
		if(fightTime%2==0 && punchIndex<1) {
			
			punchIndex++;
		}
		if(fightTime>=6 && y!=FLOOR-height) {
			punchIndex=1;
		}
		
		drawPlayer(g,EnemyImageFlip.Flip(playerJump[punchIndex]));
		if(y==FLOOR-height) {
			fightTime=0;
			punchIndex=0;
			force=-35;
			playerState=PLAYER_IDLE;
			
		}
			
		}
		
		
		else if(playerState==PLAYER_MOVE) {
			{
			drawPlayer(g,EnemyImageFlip.Flip(playerIdle[0]));
			
			move();
			playerState=PLAYER_IDLE;
			
		
			}
			
		}
		else if(playerState==PLAYER_HURT) {
			if(fightTime>=0 && fightTime<=6) {
				drawPlayer(g,EnemyImageFlip.Flip(playerHurt));
				fightTime++;
			}
			else
				{fightTime=0;
				playerState=PLAYER_IDLE;}
		
		}
		
		
		
		else if(playerState==PLAYER_CROUCH) {
			height=200;
			y+=100;
			
			drawPlayer(g,EnemyImageFlip.Flip(playerCrouch[punchIndex]));
			
			
			if(punchIndex<2) {
				punchIndex++;
			}
			
			else if(punchIndex>=2) {
				playerState=PLAYER_IDLE;
				height=300;
				y-=100;
			}
		}
		
		else if(playerState==PLAYER_DEAD) {
			drawPlayer(g,playerDead);
		}
		
		
		else if(playerState==PLAYER_KICK) {
			drawPlayer(g,EnemyImageFlip.Flip(playerKick[punchIndex]));
			if(fightTime>=0 && fightTime<=6) {
				fightTime++;
			}
			
			
			
			if(fightTime%2==0 && punchIndex<2) {
				punchIndex++;
			}
			
			if(punchIndex==1) {
				setAttacked(true);
				setHealthTaken(punchHealth);
			}
			if(punchIndex>=2) {
				setAttacked(false);
				fightTime=0;
				setHealthTaken(0);
				punchIndex=0;
				playerState=PLAYER_IDLE;
				
				
			}
			
			
		}
		
		else if(playerState==PLAYER_DEFEND) {
			
			drawPlayer(g,EnemyImageFlip.Flip(playerDefend[punchIndex]));
			if(punchIndex>=0 && punchIndex<=2) {
				punchIndex++;
			}
			
			
			if(punchIndex>2) {
				
				
				playerState=PLAYER_IDLE;
				punchIndex=0;
				
			}
		}
		
		
		else if(playerState==PLAYER_KICK2) {
			if(fightTime>=0 && fightTime<=15) {
				fightTime++;
			
			
			drawPlayer(g,EnemyImageFlip.Flip(playerKick2[0]));
			setSpeed(60);
			y-=10;
			this.move();  }
			
		if(x>=300)
		{	fightTime=0;
			playerState=PLAYER_IDLE;
		}
		
		}
		
		else if(playerState==TIME_UP) {
			drawPlayer(g,EnemyImageFlip.Flip(playerIdle[1]));
		}
		
//		else if(playerState==PLAYER_KICK3) {
//			y+=force;
//			force+=GRAVITY;
//			
//			
//			drawPlayer(g,playerKick3[punchIndex]);
//			if(fightTime>=0 && fightTime<=22) {
//				fightTime++;
//			}
//			
//			
//			if(fightTime%2==0 && punchIndex<=10) {
//				punchIndex++;
//			}
//			
//			
//			if(punchIndex>10) {
//				
//				fightTime=0;
//				playerState=PLAYER_IDLE;
//				punchIndex=0;
//				force=-50;
//				
//			}
//		}
//		
//		
//		else if(playerState==PLAYER_PUNCH2) {
//			
//			y+=force2;
//			force2+=GRAVITY;
//			
//			
//			drawPlayer(g,playerPunch2[punchIndex]);
//			if(fightTime>=0 && fightTime<=14) {
//				fightTime++;
//			}
//			
//			
//			if(fightTime%2==0 && punchIndex<=5) {
//				punchIndex++;
//			}
//			
//			
//			if(punchIndex>5) {
//				
//				fightTime=0;
//				playerState=PLAYER_IDLE;
//				punchIndex=0;
//				force2=-32;
//				
//			}
//		}
//		
//		
//		else if(playerState==PLAYER_PUNCH3) {
//			
//			
//			
//			
//			drawPlayer(g,playerPunch3[punchIndex]);
//			if(fightTime>=0 && fightTime<=26) {
//				fightTime++;
//			}
//			
//			
//			if(fightTime%2==0 && punchIndex<=12) {
//				punchIndex++;
//			}
//			
//			
//			if(punchIndex>12) {
//				fire=new RyuCannon(x,y);
//				ryucannon.add(fire);
//				fightTime=0;
//				playerState=PLAYER_IDLE;
//				punchIndex=0;
//				cannonDraw=true;
//				
//			}
//		}
//		
//		
//		}
//
//
		}
	@Override
	protected void move() {
		x+=speed;
	}


}
