package project.kakaoapi;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class KakaoRestApiHelper
{
	public void kakak_API_search_web(String type, String query, String path)
	{
		///////////// GET 방식
		String sss = "query=" + query; // 보낼 데이터를 xml 형식으로 만들어주고
		String url = "";
		// type = "image";
		switch (type)
		{

		case "vclip":
			// 동영상검색
			url = "https://dapi.kakao.com/v2/search/vclip?" + sss;
			break;
		case "image":
			// 이미지검색
			url = "https://dapi.kakao.com/v2/search/image?" + sss;
			System.out.println(url);
			break;
		case "blog":
			// 블로그검색
			url = "https://dapi.kakao.com/v2/search/blog?" + sss;
			break;
		case "book":
			// 책검색
			url = "https://dapi.kakao.com/v3/search/book?" + sss;
			break;
		case "cafe":
			// 카페검색
			url = "https://dapi.kakao.com/v2/search/cafe?" + sss;
			break;
		case "web":
			// 웹문서
		default:
			url = "https://dapi.kakao.com/v2/search/web?" + sss; // HOST 및 URL
			break;
		}

		String rest_api_key = "KakaoAK 956c283d6115ab0b8fdce98d3cf8d3b1"; // 내 어플리케이션 => 어플선택 => 기본정보의 앱 키 > REST Key 값
																			// 부여

		try
		{
			URL searchURL = new URL(url);
			HttpURLConnection con = (HttpURLConnection) searchURL.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Authorization", rest_api_key);

			int status = con.getResponseCode();
			System.out.println(">>> Status : " + status);
			if (status != 200)
			{
				System.out.println(">>> 정상 상태 아님!!!");
				Reader streamReader = null;

				if (status > 299)
				{
					streamReader = new InputStreamReader(con.getErrorStream());
				} else
				{
					streamReader = new InputStreamReader(con.getInputStream());
				}
				System.out.println(streamReader.toString());
			} else
			{
				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String inputLine;
				StringBuffer content = new StringBuffer();
				while ((inputLine = in.readLine()) != null)
				{
					try
					{
						JSONParser parser = new JSONParser();
						Object obj = parser.parse(inputLine);
						JSONObject jsonObj = (JSONObject) obj;

						JSONArray image_info = (JSONArray) jsonObj.get("documents");
						for (int i = 0; i < image_info.size(); i++)
						{
							JSONObject tempObj = (JSONObject) image_info.get(i);
	                        System.out.println(""+(i+1)+"번째 URL : "+tempObj.get("image_url"));
	                        String fileName = path + "test_" + i + ".jpg";
	                        System.out.println(fileName);
	                        saveImage(tempObj.get("image_url").toString(), fileName);
						}
						
					} 
					catch (ParseException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					content.append(inputLine);
				}
				in.close();
			}

		} catch (MalformedURLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
			String extension = imageUrl.substring(imageUrl.lastIndexOf('.') + 1);
			System.out.println("Extension 1: " + extension);
			if (!extension.equals("jpg") && !extension.equals("png"))
			{
				if(extension.equals("gif")) {
					return;
				}
				extension = "jpg";
			}

			BufferedImage image = ImageIO.read(url);
			if(image != null) {
				File file = new File(fileName);			
				ImageIO.write(image, extension, file);
			}
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		KakaoRestApiHelper kakao = new KakaoRestApiHelper();
		kakao.kakak_API_search_web("image", "Oracle", "D:/temp/images/");
	}
}
