package com.belatrixsf.findpatternweb.service;

import java.util.List;

import com.belatrixsf.findpatternweb.model.RegexModel;

/**
 * 
 * @author Alexander Chiran
 * paulo.alexander12@gmail.com
 * 
 */
public interface IRegex {

	List<RegexModel> findAll();

	RegexModel getRegexModelById(Integer id);

	void saveRegexModel(RegexModel regexModel);

	void deleteRegexModel(Integer id);

}
