package com.belatrixsf.findpatternweb.repository;

/**
 * 
 * 
 * @author Alexander Chiran
 * paulo.alexander12@gmail.com
 * 
 *
 */
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.belatrixsf.findpatternweb.model.RegexModel;


/**
 * 
 * @author Alexander Chiran
 * paulo.alexander12@gmail.com
 * 
 *
 */
@Repository
public interface RegexRepository extends MongoRepository<RegexModel,Integer> {

	
}
