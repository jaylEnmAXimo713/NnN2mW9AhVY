// 代码生成时间: 2025-09-12 11:30:07
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Managed Bean for calculating hash values.
 */
@ManagedBean
@RequestScoped
public class HashValueCalculator {

    private String inputText;
    private String hashResult;

    /**
     * Default constructor.
     */
    public HashValueCalculator() {
    }

    /**
     * Getter for the input text.
     *
     * @return the input text
     */
    public String getInputText() {
        return inputText;
    }

    /**
     * Setter for the input text.
     *
     * @param inputText the input text to set
     */
    public void setInputText(String inputText) {
        this.inputText = inputText;
    }

    /**
     * Getter for the hash result.
     *
     * @return the hash result
     */
    public String getHashResult() {
        return hashResult;
    }

    /**
     * Setter for the hash result.
     *
     * @param hashResult the hash result to set
     */
    public void setHashResult(String hashResult) {
        this.hashResult = hashResult;
    }

    /**
     * Method to calculate the hash value of the input text.
     *
     * @return a boolean indicating success or failure of hash calculation
     */
    public boolean calculateHash() {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(inputText.getBytes());
            byte[] digest = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b));
            }
            hashResult = sb.toString();
            return true;
        } catch (NoSuchAlgorithmException e) {
            Logger.getLogger(HashValueCalculator.class.getName()).log(Level.SEVERE, "Hash algorithm not found", e);
            return false;
        }
    }
}
