package day67.one2many.entity;

import java.util.ArrayList;
import java.util.List;

public class Grades {
	private Integer id;
	private String name;
	private List<Student> studentList=new ArrayList<Student>();//关联属性
	
	public Grades(){}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}
	
	
	

}
