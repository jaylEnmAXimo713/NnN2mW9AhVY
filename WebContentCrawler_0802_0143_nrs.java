// 代码生成时间: 2025-08-02 01:43:56
 * maintainability and extensibility.
 */

import java.io.IOException;
import java.net.URL;
import java.net.HttpURLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WebContentCrawler {

    /**
     * Fetches the content of a webpage and saves it to a file.
     * 
     * @param url The URL of the webpage to fetch.
     * @param outputFilePath The file path where the content will be saved.
     * @throws IOException If an I/O error occurs.
     */
    public void fetchWebContent(String url, String outputFilePath) throws IOException {
        // Validate input parameters
        if (url == null || url.isEmpty()) {
            throw new IllegalArgumentException("URL cannot be null or empty.");
        }
        if (outputFilePath == null || outputFilePath.isEmpty()) {
            throw new IllegalArgumentException("Output file path cannot be null or empty.");
        }

        // Fetch the HTML content from the URL
        String htmlContent = fetchHtmlContent(url);

        // Save the HTML content to the specified file path
        saveContentToFile(outputFilePath, htmlContent);
    }

    /**
     * Fetches the HTML content from the specified URL.
     * 
     * @param url The URL of the webpage.
     * @return The HTML content as a String.
     * @throws IOException If an I/O error occurs.
     */
    private String fetchHtmlContent(String url) throws IOException {
        HttpURLConnection connection = null;
        try {
            URL urlObj = new URL(url);
            connection = (HttpURLConnection) urlObj.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            // Check if the response is successful
            int responseCode = connection.getResponseCode();
            if (responseCode != HttpURLConnection.HTTP_OK) {
                throw new IOException("Failed to fetch content. HTTP error code: " + responseCode);
            }

            // Read the HTML content from the input stream
            return new String(connection.getInputStream().readAllBytes());
        } finally {
            // Close the connection
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    /**
     * Saves the HTML content to the specified file path.
     * 
     * @param outputFilePath The file path to save the content.
     * @param content The content to save.
     * @throws IOException If an I/O error occurs.
     */
    private void saveContentToFile(String outputFilePath, String content) throws IOException {
        Files.write(Paths.get(outputFilePath), content.getBytes());
    }

    /**
     * The main method for testing the WebContentCrawler class.
     * 
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        WebContentCrawler crawler = new WebContentCrawler();
        try {
            crawler.fetchWebContent("https://example.com", "output.html");
            System.out.println("Web content fetched successfully.");
        } catch (IOException e) {
            System.err.println("Error fetching web content: " + e.getMessage());
        }
    }
}
