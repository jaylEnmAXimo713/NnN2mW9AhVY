// 代码生成时间: 2025-07-31 19:22:00
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * NetworkConnectionChecker is a JSF bean used to check network connectivity.
 */
@ManagedBean
@RequestScoped
public class NetworkConnectionChecker {

    // URL to check for connectivity
    private String urlToCheck = "http://www.google.com";

    // Flag to indicate whether the network is connected
    private boolean isConnected = false;

    /**
     * Checks the network connectivity by attempting to open a HTTP connection to a predefined URL.
     *
     * @return String A message indicating the connectivity status.
     */
    public String checkConnection() {
        try {
            URL url = new URL(urlToCheck);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // Set the connection timeout to 5000 milliseconds
            conn.setConnectTimeout(5000);

            // Check the response code to determine if the connection was successful
            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                isConnected = true;
            } else {
                isConnected = false;
            }

            // Always close the connection after use
            conn.disconnect();
        } catch (IOException e) {
            isConnected = false;
        }

        return isConnected ? "Network connection is established." : "Network connection failed.";
    }

    // Getters and setters for isConnected
    public boolean getIsConnected() {
        return isConnected;
    }

    public void setIsConnected(boolean isConnected) {
        this.isConnected = isConnected;
    }

    // Getters and setters for urlToCheck
    public String getUrlToCheck() {
        return urlToCheck;
    }

    public void setUrlToCheck(String urlToCheck) {
        this.urlToCheck = urlToCheck;
    }
}
