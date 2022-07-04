package com.example.ToDoListApp.service;

import java.util.List;

import com.example.ToDoListApp.model.Task;

public interface TaskService {
	List<Task> getAllTasks();
	void saveTask(Task task);
	Task getTaskById(int id);
	void deleteTaskById(int id);
	int countAllTasks();
	List<Task> sortByDate();
}
