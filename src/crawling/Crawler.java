package crawling;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;



public class Crawler {

	public static void main(String[] args) {
		String URL = "https://www.airportal.go.kr/life/airinfo/RaSkeFrmMain.jsp";
		 
        try {
            // 2. Connection 생성
            Connection conn = Jsoup.connect(URL);
 
            // 3. HTML 파싱.
            Document html = conn.get(); // conn.post();
            Document iframeContentDoc = null;
            
            // 4. 요소 탐색
            //System.out.println(html);
            
            Elements iframe = html.select("iframe");
            
            for(Element e : iframe) {
                System.out.println(e);     
            }
            
            		
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
