import javax.swing.JFrame;

public class GameFrame extends JFrame implements GameConstants{
	public static Board board=new Board();
	public static GameFrame frame;
	public static void main(String[] args) {
		frame=new GameFrame();
		
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(G_WIDTH, G_HEIGHT);
        frame.setVisible(true);
        
        frame.add(board);
	}
}
