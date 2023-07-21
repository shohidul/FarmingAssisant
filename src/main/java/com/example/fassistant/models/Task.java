package com.example.fassistant.models;

import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Long cropId;
	private String title;
	private String description;
	private double yield;
	private Date dueDate;
	private Date collectionDate;
	private String soilType;
	private String climateType;
	private Long createdBy;
	private Long assignedTo;
	private String status;

	@Column(updatable = false)
	@CreationTimestamp
	private LocalDateTime createdDate;

	@UpdateTimestamp
	private LocalDateTime updatedDate;

	public Task() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCropId() {
		return cropId;
	}

	public void setCropId(Long cropId) {
		this.cropId = cropId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public double getYield() {
		return yield;
	}

	public void setYield(double yield) {
		this.yield = yield;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	
	public Date getCollectionDate() {
		return collectionDate;
	}

	public void setCollectionDate(Date collectionDate) {
		this.collectionDate = collectionDate;
	}

	public String getSoilType() {
		return soilType;
	}

	public void setSoilType(String soilType) {
		this.soilType = soilType;
	}

	public String getClimateType() {
		return climateType;
	}

	public void setClimateType(String climateType) {
		this.climateType = climateType;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Long getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(Long assignedTo) {
		this.assignedTo = assignedTo;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", cropId=" + cropId + ", title=" + title + ", description=" + description
				+ ", yield=" + yield + ", dueDate=" + dueDate + ", collectionDate=" + collectionDate + ", soilType="
				+ soilType + ", climateType=" + climateType + ", createdBy=" + createdBy + ", assignedTo=" + assignedTo
				+ ", status=" + status + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + "]";
	}

}