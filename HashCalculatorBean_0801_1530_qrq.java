// 代码生成时间: 2025-08-01 15:30:22
package com.example.hashcalculator;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This ManagedBean provides functionality to calculate hash values for given strings.
 */
@ManagedBean
@RequestScoped
public class HashCalculatorBean {

    private String inputString;
    private String hashValue;

    private static final Logger LOGGER = Logger.getLogger(HashCalculatorBean.class.getName());

    /**
     * Getter for the input string.
     *
     * @return the input string
     */
    public String getInputString() {
        return inputString;
    }

    /**
     * Setter for the input string.
     *
     * @param inputString the input string to set
     */
    public void setInputString(String inputString) {
        this.inputString = inputString;
    }

    /**
     * Getter for the hash value.
     *
     * @return the hash value
     */
    public String getHashValue() {
        return hashValue;
    }

    /**
     * Setter for the hash value.
     *
     * @param hashValue the hash value to set
     */
    public void setHashValue(String hashValue) {
        this.hashValue = hashValue;
    }

    /**
     * Method to calculate hash value using the SHA-256 algorithm.
     *
     * @return the calculated hash value or an error message if an exception occurs
     */
    public String calculateHash() {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(inputString.getBytes());
            hashValue = bytesToHex(hash);
        } catch (NoSuchAlgorithmException ex) {
            LOGGER.log(Level.SEVERE, "Hash algorithm not found", ex);
            hashValue = "Error: Hash algorithm not found.";
        }
        return hashValue;
    }

    /**
     * Helper method to convert byte array to hexadecimal string.
     *
     * @param bytes byte array to convert
     * @return hexadecimal string representation of the byte array
     */
    private String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
