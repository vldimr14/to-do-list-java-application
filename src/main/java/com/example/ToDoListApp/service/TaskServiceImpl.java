package com.example.ToDoListApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.ToDoListApp.model.Task;
import com.example.ToDoListApp.repository.TaskRepository;

@Service
@Scope("singleton")
public class TaskServiceImpl implements TaskService{
	
	@Autowired
	private TaskRepository taskRepository;
	
	// Singleton pattern implementation
	public static TaskServiceImpl instance;
	
	private TaskServiceImpl() {
		
	}
	
	public static TaskServiceImpl getInstance() {
		if (instance == null) {
			instance = new TaskServiceImpl();
		}
		
		return instance;
	}
	
	@Override
	public List<Task> getAllTasks() {
		
		return taskRepository.findAll();
	}
	
	@Override 
	public void saveTask(Task task) {
		taskRepository.save(task);
	}
	
	@Override
	public Task getTaskById(int id) {
		Optional<Task> optionalTask = taskRepository.findById(id);
		
		Task task = null;
		if(optionalTask.isPresent()) {
			task = optionalTask.get();
		} else {
			throw new RuntimeException("Couldn't find a task with id = " +id);
		}
		
		return task;
	}
	
	@Override
	public void deleteTaskById(int id) {
		taskRepository.deleteById(id);
	}
	
	@Override 
	public int countAllTasks() {
		List<Task> tasks = taskRepository.findAll();
		
		return tasks.size();
	}
	
	@Override
	public List<Task> sortByDate() {
		List<Task> sortedTasks = taskRepository.findAll(Sort.by("date"));
		
		return sortedTasks;
	}
}
