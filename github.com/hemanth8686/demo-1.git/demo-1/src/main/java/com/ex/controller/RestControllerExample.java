package com.ex.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ex.bean.Student;

@RestController
public class RestControllerExample {
	@Autowired
	private Student student;

	@RequestMapping(value = "/view")
	public ModelAndView demo() {
		ModelAndView view = new ModelAndView();
		view.setViewName("test");
		return view;
	}
	@ResponseBody
	@RequestMapping(value = "/data" , method=RequestMethod.GET)
	public ArrayList<Student> studentdata() {
		System.out.println("jiiii");
		Student std = new Student();
		std.setName("hemanth");
		Student std1 = new Student();
		std1.setName("siva");
		ArrayList<Student> list = new ArrayList<>();
		list.add(std);
		list.add(std1);

		return list;

	}

	@RequestMapping(value = "Put/{name}", method = RequestMethod.PUT)
	@ResponseBody()
	public void student(@PathVariable(value = "name") String Name,@RequestBody Student student) {
		System.out.println(student.getName());
		student.setName("hii");
		System.out.println(student.getName());

	}

}
