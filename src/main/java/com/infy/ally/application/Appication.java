package com.infy.ally.application;


import java.util.concurrent.atomic.AtomicLong;

import javax.sql.DataSource;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;


@SpringBootApplication
public class Appication {

	public static void main(String[] args) {
		SpringApplication.run(Appication.class, args);
	}
	
}
