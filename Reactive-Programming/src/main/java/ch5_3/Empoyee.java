package ch5_3;

public class Empoyee {
	
	private Integer id;
	private String name;
	double salary,ratting;
	
	public Empoyee(Integer id,String name, double salary, double rating) {
		this.id = id;
		this.name = name;
		this.salary=salary;
		this.ratting=rating;
	}
	
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
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public double getRatting() {
		return ratting;
	}
	public void setRatting(double ratting) {
		this.ratting = ratting;
	}

	@Override
	public String toString() {
		return "Empoyee [id=" + id + ", name=" + name + ", salary=" + salary + ", ratting=" + ratting + "]";
	}
	
	
	
	

}
