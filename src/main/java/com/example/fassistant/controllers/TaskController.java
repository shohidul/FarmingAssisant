package com.example.fassistant.controllers;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.fassistant.models.Task;
import com.example.fassistant.service.TaskService;

@RestController
public class TaskController {

	@Autowired
	private TaskService taskService;

	@PostMapping("/task")
	public Task saveTask(@RequestParam Map<String, String> body) {

		System.out.println("task " + body);
		Task task = new Task();
		task.setTitle(body.get("title"));
		task.setDescription(body.get("description"));
		String dueDateString = body.get("dueDate"); // Assuming "body" is the request body or parameters
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date dueDate = null;
		try {
			dueDate = new java.sql.Date(dateFormat.parse(dueDateString).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		task.setDueDate(dueDate);
		task.setPriprityLevel(body.get("priprityLevel"));
		task.setAssignedTo(Long.parseLong(body.get("assignedTo")));

		return taskService.saveTask(task);

	}

	@GetMapping("/task")
	public List<Task> getAllTask() {
		return taskService.fatchAllTask();
	}

	@CrossOrigin
	@GetMapping("/task/{id}")
	public ResponseEntity<Task> getTaskById(@PathVariable("id") Long id) {
		return ResponseEntity.ok(taskService.getTaskId(id));
	}
	@PutMapping("/task/{id}")
	public Task updateTask(@PathVariable("id") Long id, @RequestParam Map<String, String> body) {
		System.out.println("task " + body);
		Task task = new Task();
		task.setId(Long.parseLong(body.get("id")));
		task.setTitle(body.get("title"));
		task.setDescription(body.get("description"));
		String dueDateString = body.get("dueDate"); // Assuming "body" is the request body or parameters
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date dueDate = null;
		try {
			dueDate = new java.sql.Date(dateFormat.parse(dueDateString).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		task.setDueDate(dueDate);
		task.setPriprityLevel(body.get("priprityLevel"));
		task.setAssignedTo(Long.parseLong(body.get("assignedTo")));

		return taskService.updateTaskId(id, task);
	}
	@DeleteMapping("/task/{id}")
	@ResponseBody
	public String deleteTask(@PathVariable("id")Long id){
		return taskService.deleteDepartmentById(id);
	}

}
