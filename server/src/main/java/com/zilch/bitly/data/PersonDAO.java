package com.zilch.bitly.data;

import com.zilch.bitly.core.Person;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

import java.util.List;

public interface PersonDAO {
  @SqlUpdate("select * from PERSON")
  List<Person> getAll();

}
