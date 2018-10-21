package com.belatrixsf.findpatternweb.service;

import com.belatrixsf.findpatternweb.model.Message;

/**
 * 
 * @author Alexander Chiran
 * paulo.alexander12@gmail.com
 * 
 *
 */
public interface IConsumingAPI {

	Message callFindPattern(Integer id);

}
