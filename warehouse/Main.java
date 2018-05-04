package warehouse;

import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import warehouse.IndexJDBCTemplate;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		IndexJDBCTemplate indexJDBCTemplate = (IndexJDBCTemplate)context.getBean("studentJDBCTemplate");
		
		System.out.println("------ Records Creation ------");
		indexJDBCTemplate.create(null, "DSK2x2.5", "Deska 2m na 2.5m", 40.5);
		indexJDBCTemplate.create(null, "ŒR10M", "Œruba 10M 1kg", 10.0);
		indexJDBCTemplate.create(null, "BL5x7", "Blacha ¿elazna 5m na 7m", 112.32);
		
		System.out.println("------ Listing all Indexes ------");
		List<Index> index = indexJDBCTemplate.listIndex();
		
		for (Index record : index){
			System.out.print("ID: " + record.getID());
			System.out.print(", Index: " + record.getIndex());
			System.out.print(", Name: " + record.getName());
			System.out.println(", Price: " + record.getPrice());
		}
		
		System.out.println("------Updating record with ID = 2 ------");
		indexJDBCTemplate.update(2, "ŒR12M", "Œruba 12M 0,75kg", 12.0);
		
		System.out.println("------Listing all again -------");
		index = indexJDBCTemplate.listIndex();
		
		for (Index record : index){
			System.out.print("ID: " + record.getID());
			System.out.print(", Index: " + record.getIndex());
			System.out.print(", Name: " + record.getName());
			System.out.println(", Price: " + record.getPrice());
		}
		
		System.out.println("------deleting everything------");
		indexJDBCTemplate.delete(1);
		indexJDBCTemplate.delete(2);
		indexJDBCTemplate.delete(3);
	}

}
