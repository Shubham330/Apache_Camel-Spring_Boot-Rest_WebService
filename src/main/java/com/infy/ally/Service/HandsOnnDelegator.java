package com.infy.ally.Service;

import java.util.concurrent.atomic.AtomicLong;

import org.apache.camel.Exchange;
import org.springframework.beans.factory.annotation.Autowired;

import com.infy.ally.Entity.Student;
import com.infy.ally.application.implementationRoute;

public class HandsOnnDelegator {
	
	@Autowired
	implementationRoute implementationroute;
	
	final AtomicLong counter = new AtomicLong();

	
	public void fetchStudent(Exchange exchange){
		final String name = exchange.getIn().getHeader("name",String.class);
		exchange.getIn().setBody(new Student(counter.incrementAndGet(),name,"Camel + SpringBoot"));
	}

}
