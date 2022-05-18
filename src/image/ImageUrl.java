package image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class ImageUrl
{

	private final static String IMAGE_URL = "https://search1.kakaocdn.net/argon/600x0_65_wr/ImZk3b2X1w8";

	public static void main(String[] args)
	{
		ImageUrl iu = new ImageUrl();
		String result = iu.deleteAllFiles("D:/temp/images/");
		System.out.println(result);
	}
	
	public String deleteAllFiles(String path) 
	{
		File f = new File(path);
		if(f.exists()) {
			try
			{
				File[] allFiles = f.listFiles();
				if (allFiles != null) {
		            for (File file : allFiles) {
		                file.delete();
		            }
		        }
				return "모든 파일 삭제 완료";
			} 
			catch (Exception e)
			{				
				e.getStackTrace();
				return "오류 발생";
			}			
		} 
		else 
		{
			return "해당 디렉토리가 존재하지 않습니다.";
		}
	}
	
	/**
	 * 폴더 생성하기 
	 * @param path
	 * @return
	 */
	public String existFolder(String path) 
	{
		File f = new File(path);
		if(!f.exists()) {
			try
			{
				f.mkdir();				
			} 
			catch (Exception e)
			{
				e.getStackTrace();
			}			
		}
		return "해당 디렉토리가 존재합니다.";
	}
	
	/**
	 * 웹에 있는 이미지 저장하기 
	 * @param imageUrl
	 * @param fileName
	 */
	public void saveImage(String imageUrl, String fileName)
	{
		try
		{
			// if you want to get png or jpg ... you can do it
			URL url = new URL(imageUrl);
			String extension = imageUrl.substring(imageUrl.indexOf('.') + 1);

			if (!extension.equals("jpg") && !extension.equals("png"))
			{
				extension = "jpg";
			}

			BufferedImage image = ImageIO.read(url);
			File file = new File(fileName);

			ImageIO.write(image, extension, file);
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
