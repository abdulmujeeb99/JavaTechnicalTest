package com.telecom.axiom.service;

import java.util.List;
import java.util.Map;

import com.telecom.axiom.model.Mobile;

public interface MobileService {
	public List<Mobile> findByCriteria(Map<String, String> search) ;
}
