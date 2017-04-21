package vasudev.com;

import java.util.List;



public interface BookDAO {
	
	public List<Book> getAll();

	public void save(Book book);

	
}
