package image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class ImageUrl {

	private final static String IMAGE_URL = "https://search1.kakaocdn.net/argon/600x0_65_wr/ImZk3b2X1w8";
	  public static void main(String[] args) {
		String fileName = "temp/aaa.jpg";
	    saveImage(IMAGE_URL, fileName);
	  }
	private static void saveImage(String imageUrl, String fileName) {
		try {
	      // if you want to get png or jpg ... you can do it
	      URL url = new URL(imageUrl);
	      String extension = imageUrl.substring(imageUrl.indexOf('.') + 1);
	      
	      if(!extension.equals("jpg") && !extension.equals("png")) {
	    	  extension = "jpg";
	      }
	      
	      BufferedImage image = ImageIO.read(url);
	      File file = new File(fileName);

	      ImageIO.write(image, extension, file);
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	}
}
