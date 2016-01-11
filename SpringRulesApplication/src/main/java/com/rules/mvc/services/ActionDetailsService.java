package com.rules.mvc.services;

import java.util.List;
import java.util.Set;

import com.rules.mvc.model.mongo.ActionDetails;

public interface ActionDetailsService {

	public List<ActionDetails> getAllActions();

	public List<ActionDetails> getAllActionsByIdSet(Set<Long> actionDetailsIdSet);

	public ActionDetails getActionDetailsById(Long actionDetId);

}
