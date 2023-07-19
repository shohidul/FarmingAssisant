package com.example.fassistant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.fassistant.models.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

	@Query(value = "SELECT * FROM TASK t WHERE t.status = ?1 ORDER BY t.due_date ASC", nativeQuery = true)
	List<Task> fatchAllTaskByStatus(String status);

}
