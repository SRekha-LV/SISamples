package com.rules.mvc.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import com.rules.mvc.model.mongo.CommunicationTypeInfo;

@Component
public interface CommTypeInfoRepository extends MongoRepository<CommunicationTypeInfo, String> {

	public CommunicationTypeInfo findByCommunicationType (String communicationType);
	public CommunicationTypeInfo findById (Long id);
}
