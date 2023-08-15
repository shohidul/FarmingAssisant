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
public class TaskMonitoring {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Long taskId;
	private Long cropId;
	private String notes;
	private Date applicationDate;
	private String fertilizerType;
	private Integer quantity;

	@Column(updatable = false)
	@CreationTimestamp
	private LocalDateTime createdDate;

	@UpdateTimestamp
	private LocalDateTime updatedDate;

	public TaskMonitoring() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	public Long getCropId() {
		return cropId;
	}

	public void setCropId(Long cropId) {
		this.cropId = cropId;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Date getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(Date applicationDate) {
		this.applicationDate = applicationDate;
	}

	public String getFertilizerType() {
		return fertilizerType;
	}

	public void setFertilizerType(String fertilizerType) {
		this.fertilizerType = fertilizerType;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
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
		return "TaskMonitoring [id=" + id + ", taskId=" + taskId + ", cropId=" + cropId + ", notes=" + notes
				+ ", applicationDate=" + applicationDate + ", fertilizerType=" + fertilizerType + ", quantity="
				+ quantity + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + "]";
	}
}