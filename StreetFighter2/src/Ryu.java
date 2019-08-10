import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Ryu extends Player implements GameConstants,PlayerConstants{
	ArrayList <RyuCannon> ryucannon=new ArrayList();
	RyuCannon fire;
	
	boolean attacked=false;
	int i=0;
    int force=-50;
    int force2=-32;
	
    int healthTaken=0;
	int health;
	int punchHealth;
	int punch2Health;
	int punch3Health;
	int kickHealth;
	int kick2Health;
	int kick3Health;
	
	
	
	public int getHealthTaken() {
		return healthTaken;
	}

	public void setHealthTaken(int healthTaken) {
		this.healthTaken = healthTaken;
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
    
    
	Ryu(){
		health=100;
		punchHealth=3;
		punch2Health=10;
		punch3Health=7;
		kickHealth=5;
		kick2Health=2;
		kick3Health=9;
	height=280;
	width=160;
	x=141;
	y=FLOOR-height;
	fightTime=0;
	image=ImageLoader.loadImage("ryu.jpg");
	loadEnterImages();
	loadIdleImages();
	loadPunchImages();
	loadJumpImages();
	loadCrouchImages();
	loadKickImages();
	loadDefendImages();
	loadKick2Images();
	loadKick3Images();
	loadPunch2Images();
	loadPunch3Images();
	loadPlayerHurtImage();
	loadPlayerDeadImage();
	playerState=PLAYER_ENTER;
	}
	private void loadPlayerDeadImage() {
		playerDead=image.getSubimage(284, 2821, 133,34);
		
	}

	void loadPlayerHurtImage() {
		playerHurt=image.getSubimage(309, 2434, 68, 82);
	}
	
	void loadKick3Images() {
		playerKick3[0]=image.getSubimage(70,1921,71,110);
		playerKick3[1]=image.getSubimage(158,1925,61,87);
		playerKick3[2]=image.getSubimage(234,1930,54,68);
		playerKick3[3]=image.getSubimage(306,1920,95,104);
		playerKick3[4]=image.getSubimage(409,1923,58,104);
		playerKick3[5]=image.getSubimage(474,1927,96,98);
		playerKick3[6]=image.getSubimage(14,2061,61,98);
		playerKick3[7]=image.getSubimage(94,2057,53,104);
		playerKick3[8]=image.getSubimage(163,2056,53,104);
		playerKick3[9]=image.getSubimage(240,2061,54,98);
		playerKick3[10]=image.getSubimage(313,2056,53,98);
		
	}
	
	void loadPunch3Images() {
		playerPunch3[0]=image.getSubimage(51, 1597, 74, 90);
		playerPunch3[1]=image.getSubimage(139, 1602, 91, 85);
		playerPunch3[2]=image.getSubimage(240, 1607, 96, 80);
		playerPunch3[3]=image.getSubimage(25, 1707, 111, 85);
		playerPunch3[4]=image.getSubimage(151, 1702, 91, 90);
		playerPunch3[5]=image.getSubimage(247, 1702, 111, 90);
		playerPunch3[6]=image.getSubimage(373, 1707, 91, 85);
		playerPunch3[7]=image.getSubimage(473, 1707, 117, 85);
		playerPunch3[8]=image.getSubimage(3, 1812, 115, 90);
		playerPunch3[9]=image.getSubimage(126, 1811, 115, 90);
		playerPunch3[10]=image.getSubimage(254, 1812, 117, 90);
		playerPunch3[11]=image.getSubimage(385, 1818, 98, 85);
		playerPunch3[12]=image.getSubimage(490, 1817, 144, 85);
	}
	
	void loadPunch2Images() {
		playerPunch2[0]=image.getSubimage(379, 2077, 66, 86);
		playerPunch2[1]=image.getSubimage(461, 2073, 78, 90);
		playerPunch2[2]=image.getSubimage(561, 2036, 62, 130);
		playerPunch2[3]=image.getSubimage(15, 2182, 55, 121);
		playerPunch2[4]=image.getSubimage(93, 2186, 59, 117);
		playerPunch2[5]=image.getSubimage(171, 2203, 62, 100);
		
		
		
	}
	
	
	void loadKick2Images() {
		playerKick2[0]=image.getSubimage(40,1047,67,94);
		playerKick2[1]=image.getSubimage(121,1046,65,94);
		playerKick2[2]=image.getSubimage(200,1051,118,90);
		playerKick2[3]=image.getSubimage(330,1048,64,94);
		}
	
	void loadDefendImages() {
		playerDefend[0]=image.getSubimage(434,700,77,94);
		playerDefend[1]=image.getSubimage(348,702,65,92);
		playerDefend[2]=image.getSubimage(259,703,69,91);
		
		
	}
	
	
	void loadKickImages() {
		
		playerKick[0]=image.getSubimage(5,938,76,93);
		playerKick[1]=image.getSubimage(97,937,69,94);
		playerKick[2]=image.getSubimage(177,932,83,99);
		playerKick[3]=image.getSubimage(271,939,59,91);
		playerKick[4]=image.getSubimage(343,944,101,86);
		playerKick[5]=image.getSubimage(457,943,55,88);
		playerKick[6]=image.getSubimage(537,930,83,101);
		
		
	}
	
	void loadCrouchImages() {
		playerCrouch[0]=image.getSubimage(9,596,62,72);
		playerCrouch[1]=image.getSubimage(89,603,62,65);
		
		
	}
	
	void loadJumpImages() {
		playerJump[0]=image.getSubimage(115,461,62,108);
		playerJump[1]=image.getSubimage(193,461,64,88);
		playerJump[2]=image.getSubimage(274,463,61,70);
		playerJump[3]=image.getSubimage(348,468,61,65);
		playerJump[4]=image.getSubimage(425,464,64,86);
		playerJump[5]=image.getSubimage(506,453,62,116);
		
	}
	
	
	void loadEnterImages() {
		 
			playerEnter[0]=image.getSubimage(18, 7, 61, 100);
			playerEnter[1]=image.getSubimage(92, 7, 63, 100);
			playerEnter[2]=image.getSubimage(245, 4, 70, 103);
			playerEnter[3]=image.getSubimage(322, 7, 64, 100);
			playerEnter[4]=image.getSubimage(395, 7, 61, 100);
			playerEnter[5]=image.getSubimage(466, 7, 61, 100);
			playerEnter[6]=image.getSubimage(536, 8, 61, 100);
			playerEnter[7]=image.getSubimage(38, 121, 61, 100);
			playerEnter[8]=image.getSubimage(111, 127, 68, 94);
			
			
	}
	
	void loadIdleImages() {
		playerIdle[0]=image.getSubimage(64, 238, 70, 93);
		playerIdle[1]=image.getSubimage(145, 236, 68, 95);
		playerIdle[2]=image.getSubimage(228, 236, 59, 95);
		playerIdle[3]=image.getSubimage(307, 236, 54, 94);
		playerIdle[4]=image.getSubimage(379, 237, 56, 93);
		playerIdle[5]=image.getSubimage(455, 241, 63, 81);
		playerIdle[6]=image.getSubimage(66, 347, 61, 93);
		playerIdle[7]=image.getSubimage(143, 346, 54, 93);
		playerIdle[8]=image.getSubimage(221, 345, 54, 95);
		playerIdle[9]=image.getSubimage(292, 346, 61, 95);
		
		
	}
	
	void loadPunchImages() {
		playerPunch[0]=image.getSubimage(434, 700, 77, 94);
		playerPunch[1]=image.getSubimage(524, 699, 107, 95);
		playerPunch[2]=image.getSubimage(27, 823, 65, 94);
		playerPunch[3]=image.getSubimage(107, 823, 71, 94);
		playerPunch[4]=image.getSubimage(190, 823, 109, 93);
		playerPunch[5]=image.getSubimage(310, 822, 80, 93);
		
	}
	
	
	
	int fightTime=0;
	int moveIndex=0;
	int punchIndex=0;
	
	
		
	
	void drawPlayer(Graphics g,BufferedImage image) {
		
			g.drawImage(image, x, y, width, height, null);
		}
	
	@Override
	public boolean checkIfHit() {
		return attacked;
	}
	
	@Override
		
protected
	void draw(Graphics g) {

				
		
		if(playerState==PLAYER_ENTER) {
			if(fightTime>=0 && fightTime<=18) {
				fightTime++;
			}
		if(fightTime%2==0 && moveIndex<8) {
			
			moveIndex++;
		}
		
		drawPlayer(g,playerEnter[moveIndex]);
		if(fightTime>18) {
			fightTime=0;
			moveIndex=0;
			playerState=PLAYER_IDLE;
			
		}
		}
		
		else if(playerState==PLAYER_IDLE) {
			
			drawPlayer(g,playerIdle[moveIndex]);
			
			
			if(moveIndex>=0 && moveIndex<=9) {
				moveIndex++;
			}
			
			
			if(moveIndex>9) {
				
				moveIndex=0;
			}
		}
		
		
		else if(playerState==PLAYER_PUNCH) {
			
			drawPlayer(g,playerPunch[punchIndex]);
			if(punchIndex>=0 && punchIndex<=5) {
				punchIndex++;
			}
			
			if(punchIndex==4) {
				attacked=true;
				setHealthTaken(punchHealth);
			}
			
			if(punchIndex>5) {
				
				attacked=false;
				playerState=PLAYER_IDLE;
				punchIndex=0;
				setHealthTaken(0);
				
			}
		}
		
		
		else if(playerState==PLAYER_JUMP) {
			this.jump();
			if(fightTime>=0 && fightTime<=10) {
				fightTime++;
			}
		if(fightTime%2==0 && punchIndex<4) {
			
			punchIndex++;
		}
		if(fightTime>=10 && y!=FLOOR-height) {
			punchIndex=5;
		}
		
		drawPlayer(g,playerJump[punchIndex]);
		if(y==FLOOR-height) {
			fightTime=0;
			punchIndex=0;
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
				playerState=PLAYER_IDLE;}}
		
		else if(playerState==PLAYER_MOVE) {
			{
			drawPlayer(g,playerIdle[9]);
			
			move();
			playerState=PLAYER_IDLE;
			
		
			}
			
		}
		
		
		else if(playerState==PLAYER_CROUCH) {
			height=160;
			y+=100;
			
			drawPlayer(g,playerCrouch[punchIndex]);
			
			
			if(punchIndex<=1) {
				punchIndex++;
			}
			
			else if(punchIndex>1) {
				playerState=PLAYER_IDLE;
				height=280;
				y-=100;
			}
		}
		
		else if(playerState==PLAYER_DEAD) {
			drawPlayer(g,EnemyImageFlip.Flip(playerDead));
		}
		
		else if(playerState==PLAYER_KICK) {
			drawPlayer(g,playerKick[punchIndex]);
			if(fightTime>=0 && fightTime<=14) {
				fightTime++;
			}
			
			
			
			if(fightTime%2==0 && punchIndex<=6) {
				punchIndex++;
			}
			if(punchIndex==5) {
				attacked=true;
				setHealthTaken(kickHealth);
			}
			
			if(punchIndex>6) {
				
				fightTime=0;
				attacked=false;
				playerState=PLAYER_IDLE;
				punchIndex=0;
				setHealthTaken(0);
				
			}
			
			
		}
		
		else if(playerState==PLAYER_DEFEND) {
			
			drawPlayer(g,playerDefend[punchIndex]);
			if(punchIndex>=0 && punchIndex<=2) {
				punchIndex++;
			}
			
			
			if(punchIndex>2) {
				
				
				playerState=PLAYER_IDLE;
				punchIndex=0;
				
			}
		}
		
		
		else if(playerState==PLAYER_KICK2) {
			
			drawPlayer(g,playerKick2[punchIndex]);
			if(fightTime>=0 && fightTime<=8) {
				fightTime++;
			}
			
			
			if(fightTime%2==0 && punchIndex<=3) {
				punchIndex++;
			}
			
			if(punchIndex==2) {
				attacked=true;
				setHealthTaken(kick2Health);
			}
			if(punchIndex>3) {
				
				fightTime=0;
				attacked=false;
				playerState=PLAYER_IDLE;
				punchIndex=0;
				setHealthTaken(0);
				
			}
		}
		
		else if(playerState==PLAYER_KICK3) {
			y+=force;
			force+=GRAVITY;
			
			
			drawPlayer(g,playerKick3[punchIndex]);
			if(fightTime>=0 && fightTime<=22) {
				fightTime++;
			}
			
			
			if(fightTime%2==0 && punchIndex<=10) {
				punchIndex++;
			}
			
			if(punchIndex==7) {
				attacked=true;
				setHealthTaken(kick3Health);
			}
			
			if(punchIndex>10) {
				attacked=false;
				fightTime=0;
				playerState=PLAYER_IDLE;
				punchIndex=0;
				force=-50;
				setHealthTaken(0);
				
			}
		}
		
		
		else if(playerState==PLAYER_PUNCH2) {
			
			y+=force2;
			force2+=GRAVITY;
			
			
			drawPlayer(g,playerPunch2[punchIndex]);
			if(fightTime>=0 && fightTime<=14) {
				fightTime++;
			}
			
			
			if(fightTime%2==0 && punchIndex<=5) {
				punchIndex++;
			}
			if(punchIndex==4) {
				attacked=true;
				setHealthTaken(punch2Health);
			}
			
			if(punchIndex>5) {
				attacked=false;
				fightTime=0;
				playerState=PLAYER_IDLE;
				punchIndex=0;
				force2=-32;
				setHealthTaken(0);
				
			}
		}
		
		
		else if(playerState==PLAYER_PUNCH3) {
			
			
			
			
			drawPlayer(g,playerPunch3[punchIndex]);
			if(fightTime>=0 && fightTime<=26) {
				fightTime++;
			}
			
			
			if(fightTime%2==0 && punchIndex<=12) {
				punchIndex++;
			}
			
			
			
			if(punchIndex>12) {
				fire=new RyuCannon(x,y);
				ryucannon.add(fire);
				fightTime=0;
				playerState=PLAYER_IDLE;
				punchIndex=0;
				cannonDraw=true;
				
			}
		}
		
		else if(playerState==TIME_UP) {
			drawPlayer(g,playerIdle[1]);
		}
		}
	
	@Override
	public void ryuCannonFireDraw(Graphics g) {
		
		
		
		fire.draw(g);
		fire.move();
		
		
	}
		
		
	}


	
	
	
	
	
