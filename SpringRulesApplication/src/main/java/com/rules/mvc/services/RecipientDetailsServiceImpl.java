package com.rules.mvc.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rules.mvc.model.mongo.RecipientDetails;
import com.rules.mvc.repositories.RecipientDetailsRepository;

@Service
public class RecipientDetailsServiceImpl implements RecipientDetailsService {

	@Autowired
	RecipientDetailsRepository recipientDetRepo;
	
	@Override
	public List<RecipientDetails> getAllRecipientDetails () {
		return recipientDetRepo.findAll();
	}
	
	@Override 
	public List<RecipientDetails> getAllRecipientDetailsBySet (Set<Long> recptIdSet) {
		List<RecipientDetails> recptDetList = new ArrayList<RecipientDetails> ();
		if (recptIdSet != null) {
			Iterator<Long> recptIdIter = recptIdSet.iterator();
			while (recptIdIter.hasNext()) {
				recptDetList.add(recipientDetRepo.findById(recptIdIter.next()));
			}//while
		}//if
		return recptDetList;
	}
	
	@Override
	public RecipientDetails getRecipientDetailsById (Long recipientId) {
		return recipientDetRepo.findById(recipientId);
	}
}
