package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {
	
	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");		
		
		System.out.print("Set sector name: ");
		String departmentName = sc.nextLine();
		
		System.out.print("Set worker name: ");
		String workerName = sc.nextLine();
		
		System.out.print("Set worker level: ");
		String workerLevel = sc.nextLine();
		
		System.out.println("Set salary base: ");
		double baseSalary = sc.nextDouble();
		
		//instanciação de um novo objeto do tipo worker com os dados informados		
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departmentName));
		
		
		//cadastrar contrato
		System.out.println("Set worker contracts number: ");
		int n = sc.nextInt();
		
		for(int i=1; i<=n; i++) {
			System.out.println("Enter contract #:" + i +" data:");
			System.out.println("Date (DD//MM/YYYY): ");
			
			//aqui é gerado uma exceção, e aí é preciso declarar na main que pode gerar throws ParseException
			Date contractDate = sdf.parse(sc.next());
			
			System.out.println("Set value per hour: ");
			double valuePerHour = sc.nextDouble();
			
			System.out.println("Duration (hours): ");
			int hours = sc.nextInt();

			//instanciar o novo contrato cadastrado ao trabalhador em cadastro
			HourContract contract = new HourContract(contractDate, valuePerHour, hours);
			worker.addContract(contract);
		}
		
		System.out.println();
		System.out.println("Enter month and year to calculate income (MM/yyyy): ");
		String monthAndYear = sc.next();
		//tratamento da data para pegar mes e ano
		int month = Integer.parseInt(monthAndYear.substring(0,2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		
		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.getDepartment().getName());
		
		System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));
		
		sc.close();
		
		
		
	}

}
