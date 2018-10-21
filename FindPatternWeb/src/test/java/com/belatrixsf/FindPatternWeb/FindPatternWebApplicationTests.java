package com.belatrixsf.FindPatternWeb;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.belatrixsf.findpatternweb.model.Message;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FindPatternWebApplicationTests {
	
	public static void main(String[] args) {
		System.out.println("inicia");
		final String uri = "http://localhost:8090/FindPatternAPI/process/url/1";
	     
	    RestTemplate restTemplate = new RestTemplate();
	     
	    HttpHeaders headers = new HttpHeaders();
	    //headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    //headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
	     
	    ResponseEntity<Message> result = restTemplate.exchange(uri, HttpMethod.GET, entity, Message.class);
	     
	 
	    System.out.println(result.toString());
	    System.out.println("Fin");
	/*	System.out.println("inicia");
		RestTemplate restTemplate = new RestTemplate();
		Message message = restTemplate.getForObject("http://localhost:8090/FindPatternAPI/process/url/1",
				Message.class);
	   System.out.println(message.toString());*/
		
	}

	@Test
	public void contextLoads() {
		 
	}

}
