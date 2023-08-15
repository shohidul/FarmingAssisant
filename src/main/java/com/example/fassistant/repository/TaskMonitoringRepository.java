package com.example.fassistant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.fassistant.models.TaskMonitoring;

@Repository
public interface TaskMonitoringRepository extends JpaRepository<TaskMonitoring, Long> {

	@Query(value = "SELECT * FROM task_monitoring t WHERE t.task_id = ?1 ORDER BY t.application_date ASC", nativeQuery = true)
	List<TaskMonitoring> getAllTaskMonitoringByTaskId(Long taskId);
}
