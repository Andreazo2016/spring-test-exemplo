package com.devman.testExemplo;

import static org.junit.Assert.assertThat;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith( SpringRunner.class )
@SpringBootTest
@AutoConfigureMockMvc
public class SmokeTest {
	
	@Autowired
    private MockMvc mockMvc;
	
	@MockBean
	private GreentingService greentingService;
	
  
	@Test
	public void shouldReturnHello() {
		when(greentingService.hello()).thenReturn("Hello, boy");
	}
	



}
