package com.example.fassistant.controllers;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.fassistant.models.TaskMonitoring;
import com.example.fassistant.service.TaskMonitoringService;

@CrossOrigin
@RestController
public class TaskMonitoringController {

	@Autowired
	private TaskMonitoringService taskMonitoringService;

	@PostMapping("/taskMonitoring")
	public TaskMonitoring saveTaskMonitoring(@RequestBody TaskMonitoring taskMonitoring) {

		System.out.println("saveTask " + taskMonitoring);
		return taskMonitoringService.saveTaskMonitoring(taskMonitoring);
	}

	@GetMapping("/taskMonitoring")
	public List<TaskMonitoring> getAllTaskMonitoring() {
		return taskMonitoringService.fatchAllTaskMonitoring();
	}
	
	@GetMapping("/taskMonitoringByTask/{taskId}")
	public List<TaskMonitoring> getAllTaskMonitoringByTaskId(@PathVariable("taskId") Long taskId) {
		return taskMonitoringService.getAllTaskMonitoringByTaskId(taskId);
	}

	@CrossOrigin
	@GetMapping("/taskMonitoring/{id}")
	public ResponseEntity<TaskMonitoring> getTaskMonitoringById(@PathVariable("id") Long id) {
		return ResponseEntity.ok(taskMonitoringService.getTaskMonitoringId(id));
	}

	@PutMapping("/taskMonitoring/{id}")
	public TaskMonitoring updateTaskMonitoring(@PathVariable("id") Long id, @RequestBody TaskMonitoring taskMonitoring) {
		System.out.println("updateTaskMonitoring " + taskMonitoring);
		return taskMonitoringService.updateTaskMonitoringId(id, taskMonitoring);
	}
	@DeleteMapping("/taskMonitoring/{id}")
	@ResponseBody
	public String deleteTaskMonitoring(@PathVariable("id")Long id){
		return taskMonitoringService.deleteTaskMonitoring(id);
	}

}
