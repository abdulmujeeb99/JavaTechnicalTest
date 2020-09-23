package com.telecom.axiom.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.telecom.axiom.model.Mobile;
import com.telecom.axiom.service.impl.MobileServiceImpl;

@RestController
@RequestMapping("/mobile")
public class SearchController {
	
	@Autowired
	MobileServiceImpl mobileServiceImpl;

	@GetMapping("/search")
	public ResponseEntity<List<Mobile>> searchMobile(HttpServletRequest request, @RequestParam Map<String, String> search)
	throws Exception{
		return new ResponseEntity<>(mobileServiceImpl.findByCriteria(search), HttpStatus.OK);
	}
}
