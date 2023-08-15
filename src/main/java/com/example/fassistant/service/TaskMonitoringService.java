package com.example.fassistant.service;

import java.util.List;

import com.example.fassistant.models.TaskMonitoring;


public interface TaskMonitoringService {
	
	TaskMonitoring saveTaskMonitoring(TaskMonitoring task);
	
	List<TaskMonitoring> fatchAllTaskMonitoring();
		
	TaskMonitoring getTaskMonitoringId(Long id);

	TaskMonitoring updateTaskMonitoringId(Long id, TaskMonitoring task);
	
	String deleteTaskMonitoring(Long id);

	List<TaskMonitoring> getAllTaskMonitoringByTaskId(Long taskId);
}
