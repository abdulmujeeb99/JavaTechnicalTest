package com.telecom.axiom.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.telecom.axiom.exception.EntityNotFoundException;
import com.telecom.axiom.model.Hardware;
import com.telecom.axiom.model.Mobile;
import com.telecom.axiom.model.Release;
import com.telecom.axiom.repository.MobileRepository;
import com.telecom.axiom.service.MobileService;

@Service
public class MobileServiceImpl implements MobileService{

	@Autowired
	ObjectMapper objectMapper;
	
	@Autowired
	private MobileRepository mobRepository;
	
	@Override
	public List<Mobile> findByCriteria(Map<String, String> search) {
		List<Mobile> result = new ArrayList<Mobile>();
		
		Mobile mobMap = objectMapper.convertValue(search, Mobile.class);
		mobMap.setRelease(objectMapper.convertValue(search, Release.class));
		mobMap.setHardware(objectMapper.convertValue(search, Hardware.class));

		
		Example<Mobile> mobCriteria = Example.of(mobMap, ExampleMatcher.matchingAll().withIgnoreCase().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING));		
		Iterable<Mobile> mobList = mobRepository.findAll(mobCriteria);
		mobList.forEach(result::add);
		
		if(result.isEmpty()) {
			throw new EntityNotFoundException();
		}		
		return result;
	}

}
