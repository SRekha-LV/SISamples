package com.rules.mvc.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import com.rules.mvc.model.mongo.RecipientDetails;

@Component
public interface RecipientDetailsRepository extends MongoRepository<RecipientDetails, String> {
	
	public RecipientDetails findByRecipientTypeAndRecipientValue (String recipientType, String recipientValue);
	public RecipientDetails findById (Long id);
	
}
