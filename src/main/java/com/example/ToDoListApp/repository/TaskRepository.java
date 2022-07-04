 package com.example.ToDoListApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.ToDoListApp.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer>{
}
