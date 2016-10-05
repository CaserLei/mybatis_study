package day66.app03.entity;

public class Student {
	private Integer id;
	private String name;
	private Double sal;
	
	public Student(){}

	public Student(Integer id, String name, Double sal) {
		this.id = id;
		this.name = name;
		this.sal = sal;
	}

	public Integer getId() {
		System.out.println("getId()");
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		System.out.println("getName()");
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSal() {
		System.out.println("getSal()");
		return sal;
	}

	public void setSal(Double sal) {
		this.sal = sal;
	}

	@Override
	public String toString() {
		return "id=" + id + ", name=" + name + ", sal=" + sal;
	}
	
	

}
