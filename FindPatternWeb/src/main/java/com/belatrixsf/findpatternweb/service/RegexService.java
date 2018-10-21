package com.belatrixsf.findpatternweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.belatrixsf.findpatternweb.model.RegexModel;
import com.belatrixsf.findpatternweb.repository.RegexRepository;

@Service
public class RegexService implements IRegex {
	
	@Autowired
	private RegexRepository regexRepository;

	@Override
	public List<RegexModel> findAll() {
		return regexRepository.findAll();
	}

}
