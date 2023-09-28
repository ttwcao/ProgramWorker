package entities;

public class Department {
	
	private String name;
	
	public Department() {
		
	}
	
	//construtor
	public Department(String name) {
		this.name = name;
	}

	//método GET	
	public String getName() {
		return name;
	}

	//método SET
	public void setName(String name) {
		this.name = name;
	}
	
	

}
