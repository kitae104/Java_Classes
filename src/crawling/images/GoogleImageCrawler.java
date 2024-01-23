package crawling.images;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GoogleImageCrawler {
  
  public static void main(String[] args) throws IOException {
    String searchQuery = "cute puppies"; // the query to search for
    int maxResults = 10; // the maximum number of results to fetch
    
    List<String> imageUrls = getImageUrlsFromGoogle(searchQuery, maxResults);
    System.out.println(imageUrls); // print the list of image URLs
    
    downloadImages(imageUrls, "images");
  }
  
  public static List<String> getImageUrlsFromGoogle(String query, int numResults) throws IOException {
    String url = "https://www.google.com/search?q=" + query + "&tbm=isch&tbo=u&source=univ";
    Document doc = Jsoup.connect(url).userAgent("Mozilla/5.0").get(); // send a GET request with a user agent
    
    Elements imageElements = doc.select("div.rg_i"); // locate the elements that contain the image URLs
    List<String> imageUrls = new ArrayList<>();
    
    for (int i = 0; i < numResults && i < imageElements.size(); i++) {
      Element img = imageElements.get(i);
      String imageUrl = img.select("img").attr("data-src");
      imageUrls.add(imageUrl);
    }
    
    return imageUrls;
  }
  
  public static void downloadImages(List<String> imageUrls, String directory) throws IOException {
    Path dirPath = Paths.get(directory);
    if (!Files.exists(dirPath)) {
      Files.createDirectories(dirPath);
    }
    
    for (String imageUrl : imageUrls) {
      URL url = new URL(imageUrl);
      URLConnection conn = url.openConnection();
      conn.addRequestProperty("User-Agent", "Mozilla/5.0");
      try (InputStream in = conn.getInputStream()) {
        String fileName = getFileNameFromUrl(imageUrl);
        Path filePath = Paths.get(directory, fileName);
        Files.copy(in, filePath);
      }
    }
  }
  
  public static String getFileNameFromUrl(String url) {
    int slashIndex = url.lastIndexOf('/');
    int questionMarkIndex = url.lastIndexOf('?');
    String fileName = (questionMarkIndex == -1) ? url.substring(slashIndex + 1) : url.substring(slashIndex + 1, questionMarkIndex);
    return fileName;
  }
}
