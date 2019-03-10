package com.devman.testExemplo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeController.class)
public class EmployeeTest {

	@Autowired
	private MockMvc mvc;
	
	
	@Test
	public void createEmployeeAPI() throws Exception
	{
		mvc.perform( MockMvcRequestBuilders
	      .post("/employees")
	      .content(asJsonString(new Employee("Andreazo Silva Souza")))
	      .contentType(MediaType.APPLICATION_JSON)
	      .accept(MediaType.APPLICATION_JSON))
	      .andExpect(MockMvcResultMatchers.status().isCreated())
	      .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Andreazo Silva Souza"));
	}
	@Test
	public void getAllEmployeesAPI() throws Exception
	{
	  mvc.perform( MockMvcRequestBuilders
	      .get("/employees")
	      .accept(MediaType.APPLICATION_JSON))
	      .andExpect(MockMvcResultMatchers.status().isOk())
	      .andExpect(MockMvcResultMatchers.jsonPath("$.employees").exists())
	      .andExpect(MockMvcResultMatchers.jsonPath("$.employees[*].name").isNotEmpty());
	}
	 
	@Test
	public void getEmployeeByIdAPI() throws Exception
	{
	  mvc.perform( MockMvcRequestBuilders
	      .get("/employees/{id}", 1)
	      .accept(MediaType.APPLICATION_JSON))
	      .andExpect(MockMvcResultMatchers.status().isOk())
	      .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Vilão"));
	}
	@Test
	public void updateEmployeeAPI() throws Exception
	{
	  mvc.perform( MockMvcRequestBuilders
	      .put("/employees/{id}", 1)
	      .content(asJsonString(new Employee( "João")))
	      .contentType(MediaType.APPLICATION_JSON)
	      .accept(MediaType.APPLICATION_JSON))
	      .andExpect(MockMvcResultMatchers.status().isOk())
	      .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("João"));
	}
	 
	public static String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
}
