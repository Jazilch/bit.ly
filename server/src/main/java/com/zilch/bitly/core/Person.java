package com.zilch.bitly.core;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class Person {

  @NotNull
  @JsonProperty
  private Integer id;

  @NotNull
  @JsonProperty
  private String name;

  public Person() {

  }

  public Person(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public Integer getId() {
    return id;
  }

  public String getName() {
    return name;
  }
}
