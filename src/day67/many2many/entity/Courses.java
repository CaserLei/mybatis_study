package day67.many2many.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 课程  
 * @author leifeng
 * 2016年10月5日
 */
public class Courses {
	private Integer id;
	private String name;
	private List<Student> studentList=new ArrayList<Student>();
	
	public Courses(){}

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
