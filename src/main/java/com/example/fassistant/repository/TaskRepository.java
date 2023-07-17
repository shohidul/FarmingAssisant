package com.example.fassistant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.fassistant.models.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}
