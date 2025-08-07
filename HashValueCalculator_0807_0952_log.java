// 代码生成时间: 2025-08-07 09:52:28
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;

/**
 * ManagedBean for calculating hash values using JSF framework.
 */
@ManagedBean
@RequestScoped
public class HashValueCalculator {

    private static final Logger LOGGER = Logger.getLogger(HashValueCalculator.class.getName());

    private String input;
    private String hashValue;

    /**
     * Default constructor.
     */
    public HashValueCalculator() {
    }

    /**
     * Calculates the hash value of the input string.
     * @return The calculated hash value.
     */
    public String calculateHash() {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(input.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hash) {
                sb.append(String.format("%02x", b));
            }
            hashValue = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            LOGGER.severe("Hash algorithm not found: " + e.getMessage());
            hashValue = "Error: Hash algorithm not found.";
        }
        return hashValue;
    }

    // Getters and setters for input and hashValue fields

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getHashValue() {
        return hashValue;
    }

    public void setHashValue(String hashValue) {
        this.hashValue = hashValue;
    }
}
