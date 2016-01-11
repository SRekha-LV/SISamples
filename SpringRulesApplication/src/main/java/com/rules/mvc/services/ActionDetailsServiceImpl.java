package com.rules.mvc.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rules.mvc.model.mongo.ActionDetails;
import com.rules.mvc.repositories.ActionDetailsRepository;

@Service
public class ActionDetailsServiceImpl implements ActionDetailsService {

	@Autowired
	ActionDetailsRepository actionDetRepository;
	
	@Override
	public List<ActionDetails> getAllActions () {
		return actionDetRepository.findAll();
	}
	
	@Override
	public List<ActionDetails> getAllActionsByIdSet (Set<Long> actionDetailsIdSet) {
		List<ActionDetails> actionDetailsList = new ArrayList<ActionDetails> ();
		if (actionDetailsIdSet != null) {
			Iterator<Long> actionDetIter = actionDetailsIdSet.iterator();
			while (actionDetIter.hasNext()) {
				actionDetailsList.add (actionDetRepository.findById(actionDetIter.next()));
			}//while
		}//if
		return actionDetailsList;
	}
	
	@Override
	public ActionDetails getActionDetailsById (Long actionDetId) {
		return actionDetRepository.findById(actionDetId);
	}
}
