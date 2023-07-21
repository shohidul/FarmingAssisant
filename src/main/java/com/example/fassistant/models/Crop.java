package com.example.fassistant.models;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Crop {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String timeToMaturity;
	private String seedRequirements;
	private String suitableSeasons;
	private String suitableSoilTypes;
	private String pesticides;

	@Column(updatable = false)
	@CreationTimestamp
	private LocalDateTime createdDate;

	@UpdateTimestamp
	private LocalDateTime updatedDate;

	public Crop() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTimeToMaturity() {
		return timeToMaturity;
	}

	public void setTimeToMaturity(String timeToMaturity) {
		this.timeToMaturity = timeToMaturity;
	}

	public String getSeedRequirements() {
		return seedRequirements;
	}

	public void setSeedRequirements(String seedRequirements) {
		this.seedRequirements = seedRequirements;
	}
	
	public String getSuitableSeasons() {
		return suitableSeasons;
	}

	public void setSuitableSeasons(String suitableSeasons) {
		this.suitableSeasons = suitableSeasons;
	}

	public String getSuitableSoilTypes() {
		return suitableSoilTypes;
	}

	public void setSuitableSoilTypes(String suitableSoilTypes) {
		this.suitableSoilTypes = suitableSoilTypes;
	}

	public String getPesticides() {
		return pesticides;
	}

	public void setPesticides(String pesticides) {
		this.pesticides = pesticides;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Override
	public String toString() {
		return "Crop [id=" + id + ", name=" + name + ", timeToMaturity=" + timeToMaturity + ", seedRequirements="
				+ seedRequirements + ", suitableSeasons=" + suitableSeasons + ", suitableSoilTypes=" + suitableSoilTypes
				+ ", pesticides=" + pesticides + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + "]";
	}
}