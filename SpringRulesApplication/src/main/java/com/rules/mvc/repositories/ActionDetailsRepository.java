package com.rules.mvc.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import com.rules.mvc.model.mongo.ActionDetails;

@Component
public interface ActionDetailsRepository extends MongoRepository<ActionDetails, String> {

	public ActionDetails findByDisplayNameAndFieldTypeAndFieldValue (String displayName, String fieldType, String fieldValue);
	public ActionDetails findById (Long id);
}
