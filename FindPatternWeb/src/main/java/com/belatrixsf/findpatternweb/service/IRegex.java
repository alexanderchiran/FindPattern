package com.belatrixsf.findpatternweb.service;

import java.util.List;

import com.belatrixsf.findpatternweb.model.RegexModel;

public interface IRegex {

	List<RegexModel> findAll();

	RegexModel getRegexModelById(Integer id);

	void saveRegexModel(RegexModel regexModel);

	void deleteRegexModel(Integer id);

}
