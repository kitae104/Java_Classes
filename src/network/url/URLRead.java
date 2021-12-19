package network.url;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class URLRead {

	public static void main(String[] args) {

		try {
			URL url = new URL("https://www.naver.com/");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
			
			String line = "";
			while((line = br.readLine()) != null ) {
				System.out.println(line);
			}
			br.close();
			
		} catch (MalformedURLException e) {			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
