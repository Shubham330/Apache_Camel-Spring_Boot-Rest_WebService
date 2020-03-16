package com.infy.ally.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.camel.Exchange;
import org.springframework.beans.factory.annotation.Autowired;

import com.infy.ally.Entity.Employee;
import com.infy.ally.Utility.IConstants;
import com.infy.ally.application.implementationRoute;

public class HandsOnnDelegator {

	@Autowired
	implementationRoute implementationroute;

	final AtomicLong counter = new AtomicLong();

	public void fetchEmployee(Exchange exchange) throws Exception {
		final String name = exchange.getIn().getHeader("name", String.class);
		ResultSet ob = (ResultSet) dbconnection(IConstants.SELECT_EMPLOYEE_QUERY, false);
		List<Employee> emList = new ArrayList<>();
		while (ob.next()) {
			Employee employee = new Employee();
			employee.setId(ob.getString(1));
			employee.setName(ob.getString(2));
			employee.setDob(ob.getString(3));
			employee.setSalary(ob.getInt(4));
			emList.add(employee);
		}
		exchange.getIn().setBody(emList);

	}

	public void insertEmployee(Exchange exchange) {
		Employee employee = (Employee) exchange.getIn().getBody();
		String insertEmployee= IConstants.INSERT_EMPLOYEE_QUERRY+employee.getId()+"','"+
				employee.getName()+"','"+
				employee.getDob()+"',"+
				employee.getSalary()+")";
		ResultSet ob = (ResultSet) dbconnection(insertEmployee, true);
		exchange.getIn().setBody(employee);
		}

	public Object dbconnection(String Query, Boolean update) {
		ResultSet rs = null;
		try {

			String url = "jdbc:mysql://localhost:3306/employee";

			Class.forName("com.mysql.jdbc.Driver");
			Connection c = DriverManager.getConnection(url, "root", "S#ubyy330$j");
			Statement st = c.createStatement();
			if (update)
				st.executeUpdate(Query);
			else
				rs = st.executeQuery(Query);


		} catch (Exception ee) {
			System.out.println(ee);
			System.exit(0);
		}

		return rs;
	}

}
