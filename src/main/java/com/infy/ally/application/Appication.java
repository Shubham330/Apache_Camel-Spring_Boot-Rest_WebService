package com.infy.ally.application;


import java.util.concurrent.atomic.AtomicLong;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.infy.ally.Entity.Student;

@SpringBootApplication
public class Appication {

	public static void main(String[] args) {
		SpringApplication.run(Appication.class, args);
	}
}
