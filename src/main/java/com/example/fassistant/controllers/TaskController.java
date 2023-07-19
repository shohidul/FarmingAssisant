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

import com.example.fassistant.models.Task;
import com.example.fassistant.service.TaskService;

@CrossOrigin
@RestController
public class TaskController {

	@Autowired
	private TaskService taskService;

	@PostMapping("/task")
	public Task saveTask(@RequestBody Task task) {

		System.out.println("saveTask " + task);
//		Task task = new Task();
//		task.setTitle(body.get("title"));
//		task.setDescription(body.get("description"));
//		String dueDateString = body.get("dueDate"); // Assuming "body" is the request body or parameters
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		Date dueDate = null;
//		try {
//			dueDate = new java.sql.Date(dateFormat.parse(dueDateString).getTime());
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		task.setDueDate(dueDate);
//		task.setPriprityLevel(body.get("priprityLevel"));
//		task.setAssignedTo(Long.parseLong(body.get("assignedTo")));

		return taskService.saveTask(task);

	}

	@GetMapping("/task")
	public List<Task> getAllTask() {
		return taskService.fatchAllTask();
	}
	
	@GetMapping("/taskByStatus/{status}")
	public List<Task> getAllTaskByStatus(@PathVariable("status") String status) {
		return taskService.fatchAllTaskByStatus(status);
	}

	@CrossOrigin
	@GetMapping("/task/{id}")
	public ResponseEntity<Task> getTaskById(@PathVariable("id") Long id) {
		return ResponseEntity.ok(taskService.getTaskId(id));
	}
	@PutMapping("/updateTaskStatus/{id}")
	public Task updateTaskStatus(@PathVariable("id") Long id) {
		 Task task = taskService.getTaskId(id);
		 task.setStatus("1");
		return taskService.updateTaskId(id, task);
	}
	@PutMapping("/updateTaskNotification/{id}")
	public Task updateTaskNotification(@PathVariable("id") Long id, @RequestBody Map<String, String> body) {
		Task task = taskService.getTaskId(id);
		task.setNotification(Integer.parseInt(body.get("count")));
		return taskService.updateTaskId(id, task);
	}
	@PutMapping("/task/{id}")
	public Task updateTask(@PathVariable("id") Long id, @RequestBody Task task) {
		System.out.println("updateTask " + task);
		return taskService.updateTaskId(id, task);
	}
	@DeleteMapping("/task/{id}")
	@ResponseBody
	public String deleteTask(@PathVariable("id")Long id){
		return taskService.deleteDepartmentById(id);
	}

}
