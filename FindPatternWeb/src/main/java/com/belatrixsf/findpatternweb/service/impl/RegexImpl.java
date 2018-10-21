package com.belatrixsf.findpatternweb.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.belatrixsf.findpatternweb.model.RegexModel;
import com.belatrixsf.findpatternweb.repository.RegexRepository;
import com.belatrixsf.findpatternweb.service.IRegex;

/**
 * 
 * @author Alexander Chiran
 * paulo.alexander12@gmail.com
 * 
 *
 */
@Service
public class RegexImpl implements IRegex {

	@Autowired
	private RegexRepository regexRepository;

	@Override
	public List<RegexModel> findAll() {
		return regexRepository.findAll();
	}

	@Override
	public RegexModel getRegexModelById(Integer id) {
		Optional<RegexModel> op = regexRepository.findById(id);
		return op.get();
	}

	@Override
	public void saveRegexModel(RegexModel regexModel) {
		if(regexModel.getId()==null) {
			int cont =regexRepository.findAll().size();
			regexModel.setId(cont+1);
			
		}
		regexRepository.save(regexModel);

	}

	@Override
	public void deleteRegexModel(Integer id) {
		regexRepository.deleteById(id);		
	}

}
