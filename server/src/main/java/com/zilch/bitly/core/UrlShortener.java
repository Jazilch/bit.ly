package com.zilch.bitly.core;

import java.security.SecureRandom;

// lets shorten the URL
public class UrlShortener {
  static final String charatcerMap = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
  static SecureRandom rnd = new SecureRandom();

  // create a random string
  public static String randomString(int len) {
    StringBuilder sb = new StringBuilder(len);
    for (int i = 0; i < len; i++) {
      sb.append(charatcerMap.charAt(rnd.nextInt(charatcerMap.length()) ) );
    }
    return sb.toString();
  }

  // shorten the url
//  public static String shorten(String url, String uid) {
//    String key = randomString(6);
//    // write to database
//  }
//
//  // look up the URL in the database
//  public static String lookup(String path) {
//
//  }

}
