package com.zilch.bitly.resources;

import com.zilch.bitly.core.Person;
import com.zilch.bitly.data.PersonDAO;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/person")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PersonResource {

  PersonDAO personDAO;

  public PersonResource(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  @GET
  public List<Person> getAll() {
    return personDAO.getAll();
  }
}
