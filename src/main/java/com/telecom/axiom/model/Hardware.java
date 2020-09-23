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
@Table(name = "HARDWARE")
public class Hardware implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@JsonIgnore
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "audioJack")
	private String audioJack;

	@Column(name = "gps")
	private String gps;

	@Column(name = "battery")
	private String battery;

	public String getAudioJack() {
		return audioJack;
	}

	public Hardware() {
	}

	public Hardware(String audioJack, String gps, String battery) {
		super();
		this.audioJack = audioJack;
		this.gps = gps;
		this.battery = battery;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setAudioJack(String audioJack) {
		this.audioJack = audioJack;
	}

	public String getGps() {
		return gps;
	}

	public void setGps(String gps) {
		this.gps = gps;
	}

	public String getBattery() {
		return battery;
	}

	public void setBattery(String battery) {
		this.battery = battery;
	}

}
