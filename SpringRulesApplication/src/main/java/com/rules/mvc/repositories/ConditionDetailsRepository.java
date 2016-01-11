package com.rules.mvc.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import com.rules.mvc.model.mongo.ConditionDetails;

@Component
public interface ConditionDetailsRepository extends MongoRepository<ConditionDetails, String> {

	 public ConditionDetails findByDisplayNameAndFieldTypeAndFieldValue (String displayName, String fieldType, String fieldValue);
	 public ConditionDetails findById (Long id);
}
