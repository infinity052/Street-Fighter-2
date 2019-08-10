import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Honda extends Player implements GameConstants, PlayerConstants{
	
	
	int moveIndex=0;
	int fightIndex=0;
	int punchIndex=0;
	int force=-35;
	
	
	
	
	
	
	@Override
	protected
	void jump() {
		y+=force;
		force+=GRAVITY;
	}
	
	Honda(){
		width=280;
		height=300;
		x=141;
		y=FLOOR-height;
		
		image=ImageLoader.loadImage("honda.jpg");
		loadEnterImages();
		loadIdleImages();
		loadJumpImages();
		loadPunchImages();
		loadCrouchImages();
		loadKickImages();
		loadDefendImages();
		loadKick2Images();
		
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
	
	
	
	
	
	
	
	
	protected
	void draw(Graphics g) {
		if(playerState==PLAYER_ENTER) {
			drawPlayer(g,playerEnter[moveIndex]);
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
			
			drawPlayer(g,playerIdle[moveIndex]);
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
			
			drawPlayer(g,playerPunch[punchIndex]);
			
			if(fightTime>=0 && fightTime<=9)
			{fightTime++;}
			if(fightTime%3==0 && punchIndex<2) {
				punchIndex++;
			}
			
			
			if(punchIndex>=2) {
				
				fightTime=0;
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
		
		drawPlayer(g,playerJump[punchIndex]);
		if(y==FLOOR-height) {
			fightTime=0;
			punchIndex=0;
			force=-35;
			playerState=PLAYER_IDLE;
			
		}
			
		}
		
		
		else if(playerState==PLAYER_MOVE) {
			{
			drawPlayer(g,playerIdle[0]);
			
			move();
			playerState=PLAYER_IDLE;
			
		
			}
			
		}
		
		
		else if(playerState==PLAYER_CROUCH) {
			height=200;
			y+=100;
			
			drawPlayer(g,playerCrouch[punchIndex]);
			
			
			if(punchIndex<2) {
				punchIndex++;
			}
			
			else if(punchIndex>=2) {
				playerState=PLAYER_IDLE;
				height=300;
				y-=100;
			}
		}
		
		
		else if(playerState==PLAYER_KICK) {
			drawPlayer(g,playerKick[punchIndex]);
			if(fightTime>=0 && fightTime<=6) {
				fightTime++;
			}
			
			
			
			if(fightTime%2==0 && punchIndex<=2) {
				punchIndex++;
			}
			
			
			if(punchIndex>2) {
				
				fightTime=0;
				punchIndex=0;
				playerState=PLAYER_IDLE;
				
				
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
			if(fightTime>=0 && fightTime<=15) {
				fightTime++;
			
			
			drawPlayer(g,playerKick2[0]);
			setSpeed(60);
			y-=10;
			this.move();  }
			
		if(x>=300)
		{	fightTime=0;
			playerState=PLAYER_IDLE;
		}
		
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
	
