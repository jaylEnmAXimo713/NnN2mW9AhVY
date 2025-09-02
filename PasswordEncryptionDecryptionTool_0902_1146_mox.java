// 代码生成时间: 2025-09-02 11:46:11
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

/**
 * 密码加密解密工具类
 * 提供基于AES算法的密码加密和解密功能
 */
public class PasswordEncryptionDecryptionTool {

    private static final String ALGORITHM = "AES";
    private static final int AES_KEY_SIZE = 128;

    /**
     * 生成密钥
     * @return AES密钥
     */
    public static SecretKey generateKey() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM);
        keyGenerator.init(AES_KEY_SIZE);
        return keyGenerator.generateKey();
    }

    /**
     * 加密密码
     * @param password 待加密的密码
     * @param key 密钥
     * @return 加密后的密码
     * @throws Exception 加密过程中的异常
     */
    public static String encryptPassword(String password, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = cipher.doFinal(password.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    /**
     * 解密密码
     * @param encryptedPassword 加密后的密码
     * @param key 密钥
     * @return 解密后的密码
     * @throws Exception 解密过程中的异常
     */
    public static String decryptPassword(String encryptedPassword, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decodedBytes = Base64.getDecoder().decode(encryptedPassword);
        byte[] decryptedBytes = cipher.doFinal(decodedBytes);
        return new String(decryptedBytes);
    }

    // 示例用法
    public static void main(String[] args) {
        try {
            SecretKey key = generateKey();
            String password = "myPassword123";
            String encryptedPassword = encryptPassword(password, key);
            System.out.println("加密后的密码: " + encryptedPassword);

            String decryptedPassword = decryptPassword(encryptedPassword, key);
            System.out.println("解密后的密码: " + decryptedPassword);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
