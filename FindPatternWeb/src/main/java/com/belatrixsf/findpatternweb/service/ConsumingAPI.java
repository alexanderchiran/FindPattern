package com.belatrixsf.findpatternweb.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.belatrixsf.findpatternweb.helpers.Utility;
import com.belatrixsf.findpatternweb.model.Message;

@Service
public class ConsumingAPI implements IConsumingAPI {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public Message callFindPattern(Integer id) {
		try {
			final String uri = Utility.ENDPONT.concat("url/").concat(id.toString());
		     
		    RestTemplate restTemplate = new RestTemplate();		     
		    HttpHeaders headers = new HttpHeaders();
		    headers.setContentType(MediaType.APPLICATION_JSON);
		    HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		     
		    ResponseEntity<Message> message = restTemplate.exchange(uri, HttpMethod.GET, entity, Message.class);
			return message.getBody();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
		
	}

}
