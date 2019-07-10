package com.zilch.bitly;

import com.zilch.bitly.data.PersonDAO;
import com.zilch.bitly.health.TemplateHealthCheck;
import com.zilch.bitly.resources.BitlyResource;
import com.zilch.bitly.resources.PersonResource;
import com.zilch.bitly.resources.ShortenURlResource;
import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;

public class BitlyApplication extends Application<BitlyConfiguration> {

  public static void main(String[] args) throws Exception {
    new BitlyApplication().run(args);
  }

  @Override
  public String getName() {
    return "bitly";
  }

  @Override
  public void initialize(Bootstrap<BitlyConfiguration> bootstrap) {
    // nothing to do yet
  }

  @Override
  public void run(BitlyConfiguration configuration, Environment environment) throws ClassNotFoundException {
    // db connection
    final DBIFactory factory = new DBIFactory();
    final DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "mysql");
    final PersonDAO personDAO = jdbi.onDemand(PersonDAO.class);
    final PersonResource personResource = new PersonResource(personDAO);
    final BitlyResource resource = new BitlyResource(
        configuration.getTemplate(),
        configuration.getDefaultName()
    );
    final ShortenURlResource shorten = new ShortenURlResource();
    final TemplateHealthCheck healthCheck =
        new TemplateHealthCheck(configuration.getTemplate());
    environment.jersey().register(personResource);
    environment.jersey().register(resource);
    environment.jersey().register(shorten);
    environment.healthChecks().register("template", healthCheck);
  }
}
