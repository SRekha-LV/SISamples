package com.rules.mvc.services;

import java.util.List;
import java.util.Set;

import com.rules.mvc.model.mongo.RecipientDetails;

public interface RecipientDetailsService {

	public List<RecipientDetails> getAllRecipientDetails();

	public List<RecipientDetails> getAllRecipientDetailsBySet(Set<Long> recptIdSet);

	public RecipientDetails getRecipientDetailsById(Long recipientId);

}
