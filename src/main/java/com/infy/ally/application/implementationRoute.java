package com.infy.ally.application;

import java.util.concurrent.atomic.AtomicLong;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.infy.ally.Entity.Student;
import com.infy.ally.Service.HandsOnnDelegator;

@Component
public class implementationRoute extends RouteBuilder {
	
	
	@Override
	public void configure() throws Exception {
		restConfiguration()
		.component("servlet")
		.bindingMode(RestBindingMode.json);

		rest("/student").produces("application/json")
		.get("/hello/{name}")
		.route().transform().simple("Hello ${header.name}, Welcome to JavaOutOfBounds.com")
		.endRest()
		.get("/records/{name}").to("direct:records");

		from("direct:records").bean(HandsOnnDelegator.class, "fetchStudent");
	
	}

}

