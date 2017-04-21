package vasudev.com;

import java.util.List;
import java.util.Random;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class BookMain {


		public static void main(String[] args) {
			//Get the Spring Context
			ApplicationContext ctx = new ClassPathXmlApplicationContext("DbDetails.xml");
			
			//Get the EmployeeDAO Bean
			//EmployeeDAO employeeDAO = ctx.getBean("employeeDAO", EmployeeDAO.class);
			//To use JdbcTemplate
			BookDAO bookDAO = ctx.getBean("BookDAOJDBCTemplate", BookDAO.class);
			
			//Run some tests for JDBC CRUD operations
			Book bk = new Book();
			int rand = new Random().nextInt(1000);
			bk.setBookid(rand);
			bk.setTitle("Hello Java world");
			bk.setAuthor("vasudev ramisetti");
			bk.setStatus("Available");
			//Create
			bookDAO.save(bk);
			
			
			//Get All
			List<Book> bkList = bookDAO.getAll();
			System.out.println(bkList);
			
			
			System.out.println("DONE");
		}

	}
	

