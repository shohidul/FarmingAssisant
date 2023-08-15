package com.example.fassistant.service;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.fassistant.models.Task;
import com.example.fassistant.models.TaskMonitoring;
import com.example.fassistant.repository.TaskMonitoringRepository;
@Service
public class TaskMonitoringServiceImpl implements TaskMonitoringService {

	@Autowired
	private TaskMonitoringRepository taskMonitoringRepository;

	@Override
	public TaskMonitoring saveTaskMonitoring(TaskMonitoring task) {
		return taskMonitoringRepository.save(task);
	}

	@Override
	public List<TaskMonitoring> fatchAllTaskMonitoring() {
		List<TaskMonitoring> allTask =taskMonitoringRepository.findAll((Sort.by(Sort.Direction.ASC, "id")));
		return allTask;
	}

	@Override
	public TaskMonitoring getTaskMonitoringId(Long id) {
		java.util.Optional<TaskMonitoring>task=taskMonitoringRepository.findById(id);
		if(task.isPresent()) {
			return task.get();
		}
		return null;
	}

	@Override
	public TaskMonitoring updateTaskMonitoringId(Long id, TaskMonitoring task) {
		java.util.Optional<TaskMonitoring>task1=taskMonitoringRepository.findById(id);
		if(task1.isPresent()) {
			TaskMonitoring originalTask=task1.get();
			if (Objects.nonNull(task.getCropId())) {
				originalTask.setCropId(task.getCropId());
			}
			if (Objects.nonNull(task.getTaskId())) {
				originalTask.setTaskId(task.getTaskId());
			}
			if (Objects.nonNull(task.getNotes()) && !"".equalsIgnoreCase(task.getNotes())) {
				originalTask.setNotes(task.getNotes());
			}
			if (Objects.nonNull(task.getApplicationDate())) {
				originalTask.setApplicationDate(task.getApplicationDate());
			}

			if (Objects.nonNull(task.getFertilizerType()) && !"".equalsIgnoreCase(task.getFertilizerType())) {
				originalTask.setFertilizerType(task.getFertilizerType());
			}
			if (Objects.nonNull(task.getCreatedDate())) {
				originalTask.setCreatedDate(task.getCreatedDate());
			}
			if (Objects.nonNull(task.getUpdatedDate())) {
				originalTask.setUpdatedDate(task.getUpdatedDate());
			}

			return taskMonitoringRepository.save(originalTask);
		}

		return null;
	}

	@Override
	public String deleteTaskMonitoring(Long id) {
		if(taskMonitoringRepository.findById(id).isPresent()){
			taskMonitoringRepository.deleteById(id);
		}
		return null;
	}

	@Override
	public List<TaskMonitoring> getAllTaskMonitoringByTaskId(Long taskId) {
		List<TaskMonitoring> list =taskMonitoringRepository.getAllTaskMonitoringByTaskId(taskId);
		return list;
	}

}
