package com.example.ToDoListApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.ToDoListApp.model.Task;
import com.example.ToDoListApp.service.TaskService;
import com.example.ToDoListApp.service.TaskServiceImpl;

@Controller
public class TaskController {

	@Autowired
	private TaskService taskService;
	
	// display all tasks
	@GetMapping("/")
	public String showMainPage(Model model) {
		model.addAttribute("tasks", taskService.getAllTasks());
		
		Task task = new Task("");
		model.addAttribute("task", task);
		
		model.addAttribute("counter", taskService.countAllTasks());
		
		return "index";
	}
	
	@PostMapping("addTask")
	public String saveTask(@ModelAttribute("task") Task task) {
		taskService.saveTask(task);
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String showEditForm(@PathVariable(value = "id")int id, Model model) {
		// get task
		Task task = taskService.getTaskById(id);
		
		model.addAttribute("task", task);
		
		return "update-form";
	}

	@GetMapping("/delete/{id}")
	public String deleteTask(@PathVariable(value = "id")int id) {
		taskService.deleteTaskById(id);
		
		return "redirect:/";
	}
	
	@GetMapping("/sortByDate")
	public String sortTasksByDate(Model model) {
		model.addAttribute("tasks", taskService.sortByDate());
		
		Task task = new Task("");
		model.addAttribute("task", task);
		
		model.addAttribute("counter", taskService.countAllTasks());
		
		return "index";
	}
}
