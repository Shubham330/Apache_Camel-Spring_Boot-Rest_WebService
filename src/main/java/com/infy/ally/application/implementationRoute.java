package com.infy.ally.application;

import javax.sql.DataSource;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.apache.camel.spring.boot.CamelContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.infy.ally.Entity.Employee;
import com.infy.ally.Service.HandsOnnDelegator;
import com.sun.xml.bind.v2.schemagen.xmlschema.List;

@Component
public class implementationRoute extends RouteBuilder {

	

	@Override
	public void configure() throws Exception {
		restConfiguration().component("servlet").bindingMode(RestBindingMode.json);

		rest("/employee").produces("application/json")
		
		.get("/hello/{name}").route().transform()
				.simple("Hello ${header.name}").endRest()
				
		.get("/getallEmployee").outType(List.class)
				.to("direct:getEmployeeRecords")
				
				
		.post("/insertemployee").consumes("application/json").type(Employee.class).outType(Employee.class).to("direct:insertRecort");
		

		//from("direct:records").setBody(constant("select * from Employee")).to("jdbc:dataSource=#dataSource");

		 from("direct:getEmployeeRecords").bean(HandsOnnDelegator.class, "fetchEmployee");
		 
		 from("direct:insertRecort").bean(HandsOnnDelegator.class,"insertEmployee");

	}

}
