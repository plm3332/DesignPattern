import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {

	public static void main(String[] args) {
		
		// cgv 영화 순위
		String url = "https://cgv.co.kr/movies/"; 

		Document doc = null;        

		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Elements element = doc.select("div.sect-movie-chart");    

		System.out.println("============================================================");

		//영화 순위
		Iterator<Element> ie1 = element.select("strong.rank").iterator();
		//영화 제목
		Iterator<Element> ie2 = element.select("strong.title").iterator();
				        
		while (ie1.hasNext()) {
			System.out.println(ie1.next().text()+"\t"+ie2.next().text());
		}
		
		System.out.println("============================================================");
	}

}
