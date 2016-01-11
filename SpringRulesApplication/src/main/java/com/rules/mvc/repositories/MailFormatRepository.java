package com.rules.mvc.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import com.rules.mvc.model.mongo.MailFormat;

@Component
public interface MailFormatRepository extends MongoRepository<MailFormat, String> {

}
