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
	private String title;
	private String description;
	private Date dueDate;
	private String priprityLevel;
	private Long createdBy;
	private Long assignedTo;
	private String status;
	private int notification;

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

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getPriprityLevel() {
		return priprityLevel;
	}

	public void setPriprityLevel(String priprityLevel) {
		this.priprityLevel = priprityLevel;
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

	public int getNotification() {
		return notification;
	}

	public void setNotification(int notification) {
		this.notification = notification;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", title=" + title + ", description=" + description + ", dueDate=" + dueDate
				+ ", priprityLevel=" + priprityLevel + ", createdBy=" + createdBy + ", assignedTo=" + assignedTo
				+ ", status=" + status + ", notification=" + notification + ", createdDate=" + createdDate
				+ ", updatedDate=" + updatedDate + "]";
	}
}