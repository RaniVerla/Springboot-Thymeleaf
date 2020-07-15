package org.o7plannng.sbshoppingcart.service;

import java.util.ArrayList;
import java.util.List;

import org.o7plannng.sbshoppingcart.bean.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	List<Student> list = new ArrayList<>();
	{
		list.add(new Student(1, "Ram"));
		list.add(new Student(2, "Shyam"));
		list.add(new Student(3, "Rahim"));
	}
	public List<Student> getStudents() {
		return list;
	}
} 
