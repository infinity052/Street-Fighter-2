import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements GameConstants,PlayerConstants{
    Camera camera;
    Player player;
    Player enemy;
	Timer timer;
	int fightTime;
    int gameTime=0;
    int choice=0;
   
    static int selectionChoice=RYU;
    static int gameStage=LOADING_STAGE;
    int playerSelected;
    BufferedImage[] screen=new BufferedImage[3];
    BufferedImage[] selectionScreen = new BufferedImage[8];
    boolean beginningProcess=true;
	Board(){
		setBackground(Color.black);
		
		setFocusable(true);

		loadScreen();
		loadSelectionScreen();
		camera=new Camera();
		player=new Player();
		enemy=new Player();
		registerEvents();
	
		gameLoop();
		
		
	}
	int a=0;

	void fightTimer(Graphics g) {
		
		if(gameStage==FIGHT_START) {
			

			g.drawImage(ImageLoader.loadImage("ko.jpg"), camera.getX()+camera.stageWidth+150, 50,null);
			
			
			g.setFont(new Font("ARIAL",Font.BOLD,40));
			g.setColor(Color.orange);
			g.drawString(""+fightTime, camera.getX()+camera.stageWidth+150, 140);
			
			if(player.playerState==PLAYER_IDLE) {
			if(a>=0 && a<=13) {
				a++;
			}
			if(a==13) {
				fightTime--;
				a=0;
			}}
		if(fightTime<=1) {
			g.setColor(Color.BLACK);
			
			g.setFont(new Font("ARIAL",Font.BOLD,80));
			g.drawString("TIME UP",camera.getX()+camera.stageWidth+80 , 300);
			player.playerState=TIME_UP;
			enemy.playerState=TIME_UP;
//			gameStage=FIGHT_OVER;
			fightTime=0;
		}
		
		}
		
	}
	
	
	void loadScreen() {
		screen[0]=ImageLoader.loadImage("choice1.png");
		screen[1]=ImageLoader.loadImage("choice2.png");
		screen[2]=ImageLoader.loadImage("choice3.png");
	}
	
	void loadSelectionScreen() {
		selectionScreen[RYU]= ImageLoader.loadImage("ryuselection.png");
		selectionScreen[HONDA]= ImageLoader.loadImage("hondaselection.png");
		selectionScreen[BLANKA]= ImageLoader.loadImage("blankaselection.png");
		selectionScreen[GUILE]= ImageLoader.loadImage("guileselection.png");
		selectionScreen[KEN]= ImageLoader.loadImage("Kenselection.png");
		selectionScreen[CHUNLI]= ImageLoader.loadImage("chunliselection.png");
		selectionScreen[ZANGIEF]= ImageLoader.loadImage("zangiefselection.png");
		selectionScreen[DHALSIM]= ImageLoader.loadImage("dhalsimselection.png");
		
		
	}
	
	void drawOptionsPane(Graphics g) {
		if(gameStage==MENU_STAGE)
			
			{
			drawBackground(g,screen[choice],G_HEIGHT);
			}
	}
	
	  
		void stageSelection() {
		
			fightTime=100;
			switch(playerSelected) {
			case RYU: camera= new RyuStage(); player=new Ryu(); enemy=new EnemyHonda();
			break;
			case HONDA: camera= new HondaStage(); player=new Honda();break;
			case DHALSIM: camera=new DhalsimStage();break;
			case CHUNLI: camera=new ChunliStage();break;
			case KEN: camera= new KenStage();break;
			case GUILE: camera= new GuileStage();break;
			case BLANKA: camera= new BlankaStage();break;
			case ZANGIEF: camera= new ZangiefStage();break;
			
			}
		}
	int time;
	void fightOver() {
		if(gameStage==FIGHT_OVER) {
			if(time>=0 && time<=30) {
				fightTime++;
			}
			if(time>=30) {
				gameStage=MENU_STAGE;
			}
		}
	}
		
	void registerEvents() {
		
		this.addKeyListener(new KeyAdapter() {
		
			public void keyPressed (KeyEvent e) {
				
				if(e.getKeyCode()==KeyEvent.VK_UP) {
					if(gameStage==MENU_STAGE) {decrementChoice();
					}
					else if(gameStage==GAME_START_SELECTION_STAGE) {selectionUpKey();}
				}
				if(e.getKeyCode()==KeyEvent.VK_DOWN) {
					if(gameStage==MENU_STAGE) {incrementChoice();}
					else if(gameStage==GAME_START_SELECTION_STAGE){selectionDownKey();}
					else if(gameStage==FIGHT_START && player.playerState==PLAYER_IDLE) {
						player.playerState=PLAYER_CROUCH;
					}
				}
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					
					if(gameStage==MENU_STAGE)
					{gameStage=GAME_START_SELECTION_STAGE;
					}
					else if(gameStage==GAME_START_SELECTION_STAGE) {
						playerSelected=selectionChoice;
						stageSelection();
						gameStage=FIGHT_START;
					}
					
					}
				
			if(e.getKeyCode()==KeyEvent.VK_RIGHT)
			{   if(gameStage==GAME_START_SELECTION_STAGE) {
				selectionRightKey();}
			else if(gameStage==FIGHT_START && player.playerState==PLAYER_IDLE) {
				camera.setPlayer(player);
				camera.setSpeed(5);camera.move();
				if(player.getX()<=800) {
					player.setSpeed(45);
					}
					else
					{player.setSpeed(0);}
					player.playerState=PLAYER_MOVE;
			}}
			if(e.getKeyCode()==KeyEvent.VK_Z) {
				if(gameStage==FIGHT_START && player.playerState==PLAYER_IDLE ) {
					player.playerState=PLAYER_KICK;
				}
				
				
			}
			
			
			
			
			if(e.getKeyCode()==KeyEvent.VK_LEFT) {
				if(gameStage==GAME_START_SELECTION_STAGE) {
				selectionLeftKey();}
				else if(gameStage==FIGHT_START && player.playerState==PLAYER_IDLE) {
					camera.setPlayer(player);
					camera.setSpeed(-5);camera.move();
					if(player.getX()>=50) {
					player.setSpeed(-45);
					}
					else
					{player.setSpeed(0);}
					player.playerState=PLAYER_MOVE;
					
					
					
				}
			}

			if(e.getKeyCode()==KeyEvent.VK_S) {
				if(gameStage==FIGHT_START && player.playerState==PLAYER_IDLE) {
					player.playerState=PLAYER_PUNCH2;
				}
			}
			

			if(e.getKeyCode()==KeyEvent.VK_D) {
				if(gameStage==FIGHT_START && player.playerState==PLAYER_IDLE) {
					player.playerState=PLAYER_PUNCH3;
				}
			}
			
			
			
			if(e.getKeyCode()==KeyEvent.VK_C) {
				if(gameStage==FIGHT_START && player.playerState==PLAYER_IDLE) {
					player.playerState=PLAYER_KICK3;
				}
			}
			
			
			if(e.getKeyCode()==KeyEvent.VK_X) {
				if(gameStage==FIGHT_START && player.playerState==PLAYER_IDLE) {
					player.playerState=PLAYER_KICK2;
				}
			}
			
		
			if(e.getKeyCode()==KeyEvent.VK_A) {
				if(gameStage==FIGHT_START && player.playerState==PLAYER_IDLE) {
					player.playerState=PLAYER_PUNCH;
				}
			}
			
			if(e.getKeyCode()==KeyEvent.VK_SPACE) {
				if(gameStage==FIGHT_START && player.playerState==PLAYER_IDLE) {
					player.setForce(-50);
					player.playerState=PLAYER_JUMP;
				}
			}
			
		}
				
		});
	}
					
		   
		    	
		
	
	
	
			private void selectionUpKey() {
				if(selectionChoice==RYU) {
					selectionChoice=KEN;
				}
				else if(selectionChoice==HONDA) {
					selectionChoice=CHUNLI;
				}
				else if(selectionChoice==BLANKA) {
					selectionChoice=ZANGIEF;
				}
				else if(selectionChoice==GUILE) {
					selectionChoice=DHALSIM;
				}
				else
					selectionChoice-=4;
				
			}
			private void selectionDownKey() {
				if(selectionChoice==KEN) {
					selectionChoice=RYU;
				}
				else if(selectionChoice==CHUNLI) {
					selectionChoice=HONDA;
				}
				else if(selectionChoice==ZANGIEF) {
					selectionChoice=BLANKA;
				}
				else if(selectionChoice==DHALSIM) {
					selectionChoice=GUILE;
				}
				else
					selectionChoice+=4;
				
			}
			
			private void selectionLeftKey() {
				if(selectionChoice==0) {
					selectionChoice=7;
				}
				
				else
					selectionChoice-=1;
			}
			
			private void selectionRightKey() {
				
				if(selectionChoice==7) {
					selectionChoice=0;
				}
				else
					selectionChoice+=1;
			}
		
			private void incrementChoice() {
			
				
				if(choice==2) {
					choice=0;
				}
				else choice++;
				
				
			
			
			}
			
			private void decrementChoice() {
				
				if(choice==0) {
					choice=2;
					}
				else 
				choice-=1;
				
			}
				
	
	void gameLoop() {
		timer=new Timer(DELAY,(e)->{
			requestFocus(true);
			enemy.fall();
			player.fall();
			
			repaint();
		});
		
		timer.start();
	}

	void drawBackground(Graphics g,BufferedImage image,int height){
		
		g.drawImage(image, 0, 0, G_WIDTH, height, null);}
	    
	
	
	
	void backgroundSelecter(Graphics g) {
		if(gameStage==LOADING_STAGE) {
		if(gameTime>=10 && gameTime<=40)
		{drawBackground(g,ImageLoader.loadImage("bg1.png"),P_HEIGHT);}
		else
			if(gameTime>45 && gameTime<=75) {
				drawBackground(g,ImageLoader.loadImage("bg2.png"),P_HEIGHT);
			}
			else
				if(gameTime>80 && gameTime<=110) {
					drawBackground(g,ImageLoader.loadImage("bg4.png"),G_HEIGHT-100);
				}
			
				else
					if(gameTime>130) {
						
						gameStage=MENU_STAGE;
						
					}
		gameTime++;
		}
		
		
	}
	
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		backgroundSelecter(g);
		drawOptionsPane(g);
		drawSelectionScreen(g);
		camera.drawCamera(g);
		playerDraw(g);
		if(player.checkIfHit()) {
			enemyHit();
		}
		if(enemy.checkIfHit()) {
			playerHit();
		}
		if(player.cannonDraw) {
			player.ryuCannonFireDraw(g);
		}
		fightTimer(g);
		healthBars(g);
		if(gameStage==FIGHT_START) {
			EnemyFightPatterns.EnemyPatternCommit(player, enemy);
		}
		winOrLose(g);
	}
	
	private void enemyHit() {
		if(enemy.playerState==PLAYER_IDLE || enemy.playerState==PLAYER_JUMP || enemy.playerState==PLAYER_CROUCH) {
			int xDistance=Math.abs(player.getX()-enemy.getX());
			int yDistance=Math.abs(player.getY()-enemy.getY());
			int width=Math.max(player.width,enemy.width);
			int height=Math.max(player.height,enemy.height);
			
			if(xDistance<=width-120 && yDistance<=height-70) {
				enemy.playerState=PLAYER_HURT;	
				enemy.setHealth(enemy.getHealth()-player.getHealthTaken());
			}
			
			
		}
	}
	
	private void playerHit() {
		if(player.playerState==PLAYER_IDLE || player.playerState==PLAYER_JUMP || player.playerState==PLAYER_CROUCH) {
			int xDistance=Math.abs(player.getX()-enemy.getX());
			int yDistance=Math.abs(player.getY()-enemy.getY());
			int width=player.width;
			int height=player.height;
			
			if(xDistance<=width-50 && yDistance<=height-50) {
				player.playerState=PLAYER_HURT;	
				player.setHealth(enemy.getHealth()-enemy.getHealthTaken());
			}
			
			
		}
	}
	
	
	
	private void playerDraw(Graphics g) {
		if(gameStage==FIGHT_START) {
			player.draw(g);
			enemy.draw(g);
		}
	}
	
	private void drawSelectionScreen(Graphics g) {
		switch(gameStage) {
		case GAME_START_SELECTION_STAGE: gameStart(g); break;
//		case 2: vsBattle(g); break;
//		case 3: optionMode(g); break;
		default: return;
		}
		
	}
	private void gameStart(Graphics g) {
		drawBackground(g,selectionScreen[selectionChoice],G_HEIGHT);
		
	}
	
	private void winOrLose(Graphics g) {
		if(player.getHealth()<=0 && gameStage==FIGHT_START) {
			g.setColor(Color.red);
			g.setFont(new Font("LUCIDA HANDWRITING",Font.BOLD,80));
			g.drawString("You Lose", 300, 300);
			player.playerState=PLAYER_DEAD;
			gameStage=FIGHT_OVER;
			time=0;
		}
		else if(enemy.getHealth()<=0 && gameStage==FIGHT_START) {
			g.setColor(Color.red);
			g.setFont(new Font("LUCIDA HANDWRITING",Font.BOLD,80));
			g.drawString("You Win", 300, 300);
			enemy.playerState=PLAYER_DEAD;
			gameStage=FIGHT_OVER;
			time=0;
		}
	}
	
	
	private void healthBars(Graphics g) {
		if(gameStage==FIGHT_START) {
			
			
		
		g.setColor(Color.WHITE);
		
		g.drawRect(camera.getX()+110,55 ,camera.stageWidth+40 , 25);
		g.setColor(Color.YELLOW);
		g.fillRect(camera.getX()+110,55 , (camera.stageWidth+55)/100*player.getHealth(), 25);
		g.setColor(Color.RED);
		g.fillRect(camera.getX()+110+(camera.stageWidth+55)/100*player.getHealth(),55 , camera.stageWidth+40-(camera.stageWidth+55)/100*player.getHealth(), 25);
		
		g.setColor(Color.BLACK);
		g.setFont(new Font("LUCIDA HANDWRITING", Font.BOLD, 25));
		g.drawString("RYU", camera.getX()+110, 110);
		
		g.setColor(Color.WHITE);
		
		g.drawRect(camera.getX()+570,55 ,camera.stageWidth+40 , 25);
		g.setColor(Color.YELLOW);
		g.fillRect(camera.getX()+570,55 , ((camera.stageWidth+55)/100*enemy.getHealth()), 25);
		g.setColor(Color.RED);
		g.fillRect(camera.getX()+570+((camera.stageWidth+55)/100*enemy.getHealth()),55 , camera.stageWidth+40-((camera.stageWidth+55)/100*enemy.getHealth()), 25);
		g.setColor(Color.BLACK);
		g.setFont(new Font("LUCIDA HANDWRITING", Font.BOLD, 25));
		g.drawString("E. HONDA", camera.getX()+850, 110);
		
		
		}
		}
	
	
	
}
