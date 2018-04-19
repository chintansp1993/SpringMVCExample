package com.webapp.java;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
	
	private static List<Todo> todoObj = new ArrayList<Todo>();
	private static int count = 3;
	
	static {
		todoObj.add(new Todo(1, "admin1", "Learn Spring MVC", new Date(), false));
		todoObj.add(new Todo(2, "admin1", "Learn Struts", new Date(), false));
		todoObj.add(new Todo(3, "admin1", "Learn Hibernate", new Date(), false));
	}
	
	public List<Todo> fetchTodos(String user) {
		List<Todo> fetchTodos = new ArrayList<Todo>();
		for (Todo todo : todoObj) {
			System.out.println("FetchTodosUser:"+user);
			System.out.println("FetchTodosGetUsername:"+todo.getUsername());
			if (todo.getUsername().equals(user))
				fetchTodos.add(todo);
		}
		return fetchTodos;
	}

	public void addTodo(String name, String description, Date targetDate, boolean status) {
		todoObj.add(new Todo(++count, name, description, targetDate, status));
	}
	
	public void removeTodo(int id) {
		Iterator<Todo> iterator = todoObj.iterator();
		while (iterator.hasNext()) {
			Todo todo = iterator.next();
			if (todo.getId() == id) {
				iterator.remove();
			}
		}

	}
	
	public Todo fetchTodo(int id) {
		for(Todo todo : todoObj) {
			if(todo.getId() == id)
				return todo;
		}
		return null;
	}
	
	public void editTodo(Todo todo) {
		todoObj.remove(todo);
		todoObj.add(todo);
	}
}
