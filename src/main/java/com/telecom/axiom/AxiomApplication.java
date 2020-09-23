package com.telecom.axiom;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.telecom.axiom.model.Mobile;
import com.telecom.axiom.repository.MobileRepository;

@SpringBootApplication
@EntityScan("com.telecom.axiom.model")
public class AxiomApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(AxiomApplication.class);
	
	@Autowired
	private MobileRepository mobRepository;
	
	@Autowired
	ResourceLoader resLoader;
	
	@Autowired
	private Gson gson;

	public static void main(String[] args) {
		SpringApplication.run(AxiomApplication.class, args);
	}
	
	@Bean
	InitializingBean initBean() {
		logger.info("Loading... Mobile Static Data");
		return () -> { loadMobileData(); };
	}
	
	private void loadMobileData() {		
	    try {
	    	Resource resource = resLoader.getResource("classpath:mobile_database.json");
			InputStream inputStream = resource.getInputStream();
			Reader reader = new InputStreamReader(inputStream);
			
			Type type = new TypeToken<List<Mobile>>() {}.getType();
			List<Mobile> mobiles = gson.fromJson(reader, type);
			mobRepository.saveAll(mobiles);
			logger.info("Successfully Loaded... Mobile Static Data");
			
		} catch (IOException e) {			
			e.printStackTrace();
			logger.info("Failed to load... Mobile Static Data");
		}

	}
	

}
