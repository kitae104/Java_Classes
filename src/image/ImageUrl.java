package image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import project.kakaoapi.KakaoRestApiHelper;

public class ImageUrl
{

	private final static String IMAGE_URL = "https://search1.kakaocdn.net/argon/600x0_65_wr/ImZk3b2X1w8";

	public static void main(String[] args)
	{
		ImageUrl iu = new ImageUrl();
		String path = "D:/temp/images/";
		String deleteResult = iu.deleteAllFiles(path);
		System.out.println(deleteResult);
		String existResult = iu.existFolder(path);
		System.out.println(existResult );
		
		KakaoRestApiHelper kakao = new KakaoRestApiHelper();
		kakao.kakak_API_search_web("image", "Windows", path);
	}
	
	/**
	 * 해당 경로에 있는 모든 파일 지우기 
	 * @param path
	 * @return
	 */
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
	
	
}
