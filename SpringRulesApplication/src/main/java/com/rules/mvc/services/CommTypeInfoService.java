package com.rules.mvc.services;

import java.util.List;
import java.util.Set;

import com.rules.mvc.model.mongo.CommunicationTypeInfo;

public interface CommTypeInfoService {

	public List<CommunicationTypeInfo> getAllCommunicationTypes();

	public List<CommunicationTypeInfo> getAllCommunicationTypesById(Set<Long> commTypeIdSet);

	public CommunicationTypeInfo getCommTypeInfoById(Long commTypeId);

}
