package payroll.security;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/**
 *
 * @author Bhagaskara
 */
public class Security {
    public static String SHA256(String password){
        String resultHash = "";
        try{
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodeHash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            resultHash = bytesToHex(encodeHash);
        }catch(Exception e){
            e.printStackTrace();
        }
        return resultHash;
    }
    
    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder();
        for (int i = 0; i < hash.length; i++) {
        String hex = Integer.toHexString(0xff & hash[i]);
        if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
