import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class ImageLoader {

	public static BufferedImage loadImage(String imageName) {
	   try {
		return ImageIO.read(ImageLoader.class.getResource(imageName));
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
		JOptionPane.showMessageDialog(GameFrame.frame, "Image Load Error Please contact Game Designer");
	}
	   return null;
	}
	
}
