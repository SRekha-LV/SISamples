package com.rules.mvc.services;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rules.mvc.model.mongo.CommunicationTypeInfo;
import com.rules.mvc.repositories.CommTypeInfoRepository;


@Service
public class CommTypeInfoServiceImpl implements CommTypeInfoService {

	@Autowired
	CommTypeInfoRepository commInfoRepo;
	
	@Override
	public List<CommunicationTypeInfo> getAllCommunicationTypes () {
		return commInfoRepo.findAll();
	}
	
	@Override
	public List<CommunicationTypeInfo> getAllCommunicationTypesById (Set<Long> commTypeIdSet) {
		List<CommunicationTypeInfo> commTypeDetList = new ArrayList<CommunicationTypeInfo> ();
		if (commTypeIdSet != null) {
			Iterator<Long> commTypeIdIter = commTypeIdSet.iterator();
			while (commTypeIdIter.hasNext()) {
				commTypeDetList.add(commInfoRepo.findById(commTypeIdIter.next()));
			}//while
		}//if
		
		return commTypeDetList;
	}
	
	@Override
	public CommunicationTypeInfo getCommTypeInfoById (Long commTypeId) {
		return commInfoRepo.findById(commTypeId);
	}
}
