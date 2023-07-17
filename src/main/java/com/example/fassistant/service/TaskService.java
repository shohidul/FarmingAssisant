package com.example.fassistant.service;

import java.util.List;

import com.example.fassistant.models.Task;


public interface TaskService {
	
	Task saveTask(Task task);
	
	List<Task> fatchAllTask();
	
	Task getTaskId(Long id);

	Task updateTaskId(Long id, Task task);
	
	String deleteDepartmentById(Long id);
}
