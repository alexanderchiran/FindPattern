package com.belatrixsf.findpatternweb.service;

import com.belatrixsf.findpatternweb.model.Message;

public interface IConsumingAPI {

	Message callFindPattern(Integer id);

}
