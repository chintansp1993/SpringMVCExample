package com.webapp.java;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.webapp.java.TodoService;
import com.webapp.java.Todo;

//import com.webapp.login.LoginService;

@Controller
@SessionAttributes("name")
public class TodoController {
	
	@Autowired
	private TodoService service;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
		
	}

	@RequestMapping(value="/todo-list", method = RequestMethod.GET)
	public String todoList(ModelMap model) {
		String user = (String) model.get("name");
		System.out.println("todo-list"+user);
		model.addAttribute("todos", service.fetchTodos(user));
		return "todo-list";
	}
	@RequestMapping(value="/todo-add", method = RequestMethod.GET)
	public String displayTodo(ModelMap model) {
		//String usr = (String) model.get("name");
		//System.out.println("Todo-add"+usr);
		model.addAttribute("todo", new Todo());
		return "todo";
	}
	
	@RequestMapping(value="/todo-add", method = RequestMethod.POST)
	public String addTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		//model.get("name");
		if(result.hasErrors())
			return "todo";
		String user = (String) model.get("name");
		
		service.addTodo(user, todo.getDescription(), new Date(), false);
		model.clear();
		
		return "redirect:/todo-list";
	}
	
	@RequestMapping(value="/todo-edit", method = RequestMethod.GET)
	public String editedTodoList(ModelMap model, @RequestParam int id) {
		Todo todo = service.fetchTodo(id);
		model.addAttribute("todo", todo);
	//	model.clear();
		return "todo";
	}
	
	@RequestMapping(value="/todo-edit", method = RequestMethod.POST)
	public String editTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		
		if(result.hasErrors())
			return "todo";
		//String user = (String) model.get("name");
		todo.setUsername("admin1");
		service.editTodo(todo);
		model.clear();
		return "redirect:todo-list";
	}
	

	
	@RequestMapping(value="/todo-remove", method = RequestMethod.GET)
	public String removeTodo(ModelMap model, @RequestParam int id) {
		service.removeTodo(id);
		//model.clear();
		return "redirect:todo-list";
	}
}

