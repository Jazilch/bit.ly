package com.zilch.bitly.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ShortenedUrl {
  private String url;

  public ShortenedUrl() {}

  public ShortenedUrl(String url) {
    this.url = url;
  }

  @JsonProperty("url")
  public String getUrl() {
    return url;
  }
}
