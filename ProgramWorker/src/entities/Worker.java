package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {

	//definições dos atributos da classe
	private String name;
	private WorkerLevel level;
	private Double baseSalary;
	
	//associações com as demais classes do diagrama por listas
	//composição de objetos
	private Department department;
	private List<HourContract> contracts = new ArrayList<>();
	
	//trabalhador possui uma lista de contratos que começa vazia
	//serão adicionados ou removidos contratos
	//a lista não pode ser trocada, por isso remover o setContract
	
	public Worker(){
		
	}

	//construtores
	public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<HourContract> getContracts() {
		return contracts;
	}
	
	public void addContract(HourContract contract) {
		contracts.add(contract);
	}
	
	public void removeContract(HourContract contract) {
		contracts.remove(contract);
	}
	
	public double income(int year, int month){
		
		//soma valores do contrato do trabalhador
		double sum = baseSalary;
		
		//obtendo o calendário do java
		Calendar cal = Calendar.getInstance();
		 		
		for (HourContract c : contracts) {
			
			//teste para verificar se o contrato é do mês e do ano em questão
			//extração do mes e ano usando callendar pra testar
			
			cal.setTime(c.getDate());
			int c_year = cal.get(Calendar.YEAR);
			int c_month = 1 + cal.get(Calendar.MONTH);
			
			//condição para que o contrato do mes e ano entre na soma
			if(year == c_year && month == c_month){
				sum += c.totalValue();
			}
		}
		
		return sum;
	}
	
	
}
