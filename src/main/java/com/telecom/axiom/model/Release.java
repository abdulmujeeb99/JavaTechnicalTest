package com.telecom.axiom.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Id;


@Entity
@Table(name = "RELEASE")
public class Release implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@JsonIgnore
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "announceDate")
	private String announceDate;

	@Column(name = "priceEur")
	private Double priceEur;

	public Release() {
	}

	public Release(String announceDate, Double priceEur) {
		super();
		this.announceDate = announceDate;
		this.priceEur = priceEur;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAnnounceDate() {
		return announceDate;
	}

	public void setAnnounceDate(String announceDate) {
		this.announceDate = announceDate;
	}

	public Double getPriceEur() {
		return priceEur;
	}

	public void setPriceEur(Double priceEur) {
		this.priceEur = priceEur;
	}

}
