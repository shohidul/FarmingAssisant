package com.example.fassistant.service;

import java.util.List;

import com.example.fassistant.models.Task;


public interface TaskService {
	
	Task saveTask(Task task);
	
	List<Task> fatchAllTask();
	
	List<Task> fatchAllTaskByStatus(String status);
	
	Task getTaskId(Long id);

	Task updateTaskId(Long id, Task task);
	
	String deleteDepartmentById(Long id);
}
