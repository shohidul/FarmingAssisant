package com.example.fassistant.service;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.fassistant.models.Task;
import com.example.fassistant.repository.TaskRepository;
@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskRepository taskRepository;

	@Override
	public Task saveTask(Task task) {
		return taskRepository.save(task);
	}

	@Override
	public List<Task> fatchAllTask() {
		List<Task> allTask =taskRepository.findAll((Sort.by(Sort.Direction.ASC, "id")));
		return allTask;
	}
	
	@Override
	public List<Task> fatchAllTaskByStatus(String status) {
		List<Task> allTask =taskRepository.fatchAllTaskByStatus(status);
		return allTask;
	}

	@Override
	public Task getTaskId(Long id) {
		java.util.Optional<Task>task=taskRepository.findById(id);
		if(task.isPresent()) {
			return task.get();
		}
		return null;
	}

	@Override
	public Task updateTaskId(Long id, Task task) {
		java.util.Optional<Task>task1=taskRepository.findById(id);
		if(task1.isPresent()) {
			Task originalTask=task1.get();
			if (Objects.nonNull(task.getTitle()) && !"".equalsIgnoreCase(task.getTitle())) {
				originalTask.setTitle(task.getTitle());
				System.out.println(task.getTitle() + "task");
			}
			if (Objects.nonNull(task.getDescription()) && !"".equalsIgnoreCase(task.getDescription())) {
				originalTask.setDescription(task.getDescription());
			}
			if (Objects.nonNull(task.getDueDate())) {
				originalTask.setDueDate(task.getDueDate());
			}
			if (Objects.nonNull(task.getPriprityLevel()) && !"".equalsIgnoreCase(task.getPriprityLevel())) {
				originalTask.setPriprityLevel(task.getPriprityLevel());
			}
			if (Objects.nonNull(task.getCreatedBy()) && task.getCreatedBy() != 0) {
				originalTask.setCreatedBy(task.getCreatedBy());
			}
//			if (Objects.nonNull(task.getAssignedTo()) && task.getAssignedTo() != 0) {
//				originalTask.setAssignedTo(task.getAssignedTo());
//			}
			if (Objects.nonNull(task.getCreatedDate())) {
				originalTask.setCreatedDate(task.getCreatedDate());
			}
			if (Objects.nonNull(task.getUpdatedDate())) {
				originalTask.setUpdatedDate(task.getUpdatedDate());
			}
			if (Objects.nonNull(task.getStatus())) {
				originalTask.setStatus(task.getStatus());
			}
			return taskRepository.save(originalTask);
		}

		return null;
	}

	@Override
	public String deleteDepartmentById(Long id) {
		if(taskRepository.findById(id).isPresent()){
			taskRepository.deleteById(id);
		}
		return null;
	}

}
