package com.telecom.axiom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telecom.axiom.model.Mobile;

@Repository
public interface MobileRepository  extends JpaRepository<Mobile, Long>{

}
