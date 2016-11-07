package com.ironyard.movies.services;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import static org.junit.Assert.*;

/**
 * Created by jasonskipper on 10/11/16.
 */
@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.ironyard.movies.data"})
@EnableJpaRepositories(basePackages = {"com.ironyard.movies.repositories"})
@EnableTransactionManagement
public class RepositoryConfigurationTest {

}