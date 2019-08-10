import java.awt.image.BufferedImage;

public class EnemyImageFlip {

	public static BufferedImage Flip(BufferedImage img) {
		
		int width=img.getWidth();
		int height=img.getHeight();
		
		
		BufferedImage mimg=new BufferedImage(width*2, height, BufferedImage.TYPE_INT_ARGB);
		
		for(int y=0;y<height;y++) {
			for(int lx=0, rx=width*2-1; lx<width;lx++,rx--) {
				int p=img.getRGB(lx, y);
				
				mimg.setRGB(lx, y, p);
				mimg.setRGB(rx, y, p);
				
			}
		}
		mimg=mimg.getSubimage(mimg.getWidth()/2, 0, width, height);
		
		
		return mimg;
	}
	
	
}
