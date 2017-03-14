package com.bourse.sessions;

import java.math.BigInteger;
import java.security.MessageDigest;
import javax.ejb.Stateless;
import javax.xml.bind.DatatypeConverter;

@Stateless
public class CommunSession implements CommunSessionLocal {

    
    @Override
    public String stringHash(String s) {
        try {
            byte[] bytesOfMessage = s.getBytes("UTF-8");

            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] thedigest = md.digest(bytesOfMessage);
            BigInteger bigInt = new BigInteger(1, thedigest);
            String hashtext = bigInt.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            System.out.println("momo  " + hashtext);
            return hashtext;
        } catch (Exception ex) {
            System.out.println("momo  ");
            System.err.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public boolean compareHashString(String s1, String s2) {
        return (stringHash(s1).equals(s2));
    }

    @Override
    public String URLEncode(String s) {
        return DatatypeConverter.printBase64Binary(s.getBytes());
    }

    @Override
    public String URLDecode(String s) {
        String decoded = new String(DatatypeConverter.parseBase64Binary(s));
        return decoded;
    }
}
