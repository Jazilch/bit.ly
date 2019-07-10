package com.zilch.bitly.data;

import com.zilch.bitly.core.Person;
import org.skife.jdbi.v2.sqlobject.SqlQuery;

import java.util.List;

public interface PersonDAO {
  @SqlQuery("select * from PERSON")
  List<Person> getAll();

}
