package day67.many2many.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 学生
 * @author leifeng
 * 2016年10月5日
 */
public class Student {
	
	private Integer id;
	private String  name;
	private List<Courses> coursesList=new ArrayList<Courses>();//关联属性
	
	public Student(){}
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
	public List<Courses> getCoursesList() {
		return coursesList;
	}
	public void setCoursesList(List<Courses> coursesList) {
		this.coursesList = coursesList;
	}
	
	

}
