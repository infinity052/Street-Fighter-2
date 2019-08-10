import java.util.Random;

public class EnemyFightPatterns implements GameConstants, PlayerConstants{
	static int fightTime=0;
	static int time;
	
	public static void EnemyPatternCommit(Player player, Player enemy) {
		timeIncrement();
		if(checkPlayerDistance(player,enemy)) {
			
			if(time%5==0) {
				enemyPattern(enemy);
			}
			
		}
	}
	
	public static void timeIncrement() {
		
		if(fightTime>=0 && fightTime<=13) {
			fightTime++;
		}
		if(fightTime==13 && time<=120) {
			time++;
			fightTime=0;
		}
		}
	
	public static boolean checkPlayerDistance(Player player, Player enemy) {
		int xDistance=Math.abs(player.getX()-enemy.getX());
		if(xDistance<=150) {
			return true;
		}
		return false;
		
		
	}
	
	
	public static void enemyPattern(Player enemy) {
		if(enemy.playerState==PLAYER_IDLE) {
			int choice=getRandomNumberInts(0,10);
		
			
			
			if(choice<5) {
				enemy.playerState=PLAYER_PUNCH;
				
			}
			if(choice>=5 && choice <9) {
				enemy.playerState=PLAYER_KICK;
			}
			
			if(choice>=9 && choice<=10) {
				enemy.playerState=PLAYER_JUMP;
				
			}
			
			
		}
	}
	
	public static int getRandomNumberInts(int min,int max){
	    Random random = new Random();
	    return random.ints(min,(max+1)).findFirst().getAsInt();
	}

}
