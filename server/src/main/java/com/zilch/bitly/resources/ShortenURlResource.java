package com.zilch.bitly.resources;

import com.codahale.metrics.annotation.Timed;
import com.zilch.bitly.api.StatusResponse;
import com.zilch.bitly.api.ShortenedUrl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

// here we will take in the URL and shorten it
@Path("/shorten")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ShortenURlResource {
  private String url;
  private long uuid;

  @POST
  @Timed
  public StatusResponse shorten(@QueryParam("url") String url) {
    return new StatusResponse(true, new ShortenedUrl(url));
  }

}
