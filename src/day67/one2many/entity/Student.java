package day67.one2many.entity;

/**
 * 学生 (多方）
 * @author leifeng
 * 2016年10月4日
 */
public class Student {
	private Integer id;
	private String name;
	
	private Grades grades;
	
	public Grades getGrades() {
		return grades;
	}

	public void setGrades(Grades grades) {
		this.grades = grades;
	}

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

}
