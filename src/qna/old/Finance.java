package qna.old;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Finance {
	public String L, G;
	public Element S;
	public Elements LGF, LGA;
	
	private static String LG = "http://comp.fnguide.com/SVO2/ASP/SVD_Main.asp?pGB=1&gicode=A051910&cID=&MenuYn=Y&ReportGB=&NewMenuID=11";
 
	public static void main(String[] args) throws IOException {
	
		
		Connection.Response responseLG = Jsoup.connect(LG).method
				(Connection.Method.GET).execute();
		
		//LG화학 데이터 받아오기 document 가져오기
		Document docLG = responseLG.parse();
 
		//목록을 가져오기
		Elements elements = docLG.select("div.ul_wrap#div1");
		String G = elements.select("td.r").text();
		
		System.out.println(G);
		
	}
	
}



