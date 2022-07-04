package com.example.ToDoListApp.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tasks")
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "date") 
	private LocalDate date;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "is_done")
	private boolean isDone;
	
	public Task() {
		date = LocalDate.now();
		description = "Untitled";
		isDone = false;
	}
	
	public Task(int id, String date, String description, boolean isDone) {
		super();
		this.id = id;
		this.date = LocalDate.parse(date);
		this.description = description;
		this.isDone = isDone;
	}
	
	public Task(String description) {
		super();
		date = LocalDate.now();
		this.description = description;
		isDone = false;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isDone() {
		return isDone;
	}
	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}
	
	
}
