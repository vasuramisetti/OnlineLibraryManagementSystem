package vasudev.com;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcBookDAOimp implements BookDAO {

	
	
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public void save(Book book) {
		String query = "insert into Book (Id, Title, Author,Status) values (?,?,?,?)";
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		Object[] args = new Object[] {book.getBookid(), book.getTitle(), book.getAuthor(),book.getStatus()};
		
		int out = jdbcTemplate.update(query, args);
		
		if(out !=0){
			System.out.println("Employee saved with id="+book.getBookid());
		}else System.out.println("Employee save failed with id="+book.getBookid());
	}
	
	
	public List<Book> getAll() {
		String query = "select Id, Title, Author,Status from books";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Book> bkList = new ArrayList<Book>();

		List<Map<String,Object>> bkRows = jdbcTemplate.queryForList(query);
		
		for(Map<String,Object> bkRow : bkRows){
			Book bk = new Book();
			bk.setBookid(Integer.parseInt(String.valueOf(bkRow.get("Id"))));
			bk.setTitle(String.valueOf(bkRow.get("Title")));
			bk.setAuthor(String.valueOf(bkRow.get("Author")));
			bk.setStatus(String.valueOf(bkRow.get("Author")));
			bkList.add(bk);
		}
		return bkList;
	}
	
	
}
