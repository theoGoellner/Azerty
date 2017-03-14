package com.bourse.sessions;

import javax.ejb.Local;


@Local
public interface CommunSessionLocal {
    
    String stringHash(String s);

    boolean compareHashString(String s1, String s2);

    String URLEncode(String s);

    String URLDecode(String s);
    
}
