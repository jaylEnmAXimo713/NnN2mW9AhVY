// 代码生成时间: 2025-09-09 05:11:49
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 * Managed Bean for Web Content Crawler
 */
@ManagedBean
@SessionScoped
public class WebContentCrawler {

    /**
     * Grabs the content of a webpage specified by the URL provided.
     * 
     * @param urlString The URL of the webpage to grab content from.
     * @return The content of the webpage as a string.
     */
    public String crawlWebpage(String urlString) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Read the input stream (webpage content) and convert to string
                Scanner scanner = new Scanner(url.openStream(), StandardCharsets.UTF_8.name());
                scanner.useDelimiter("\A");
                String content = scanner.hasNext() ? scanner.next() : "";
                scanner.close();
                return content;
            } else {
                throw new IOException("Server returned HTTP response code: " + responseCode);
            }
        } catch (Exception e) {
            // Log and handle exceptions such as MalformedURLException and IOException
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

    /**
     * Exposes the crawlWebpage method to be called from JSF page.
     * 
     * @param urlString The URL to crawl.
     * @return A string representing the webpage content or an error message.
     */
    public String getCrawledContent(String urlString) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getRequestMap().put("crawledContent", crawlWebpage(urlString));
        return "crawledContent";
    }
}
