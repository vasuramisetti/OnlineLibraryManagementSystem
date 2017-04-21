package vasudev.com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;


public class JdbcBookDAO implements BookDAO {

	
	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	

	@Override
	public void save(Book books) {
		String query = "insert into Book (Id, Title, Author,Status) values (?,?,?,?)";
		Connection con = null;
		PreparedStatement ps = null;
		try{
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setInt(11,books.getBookid());
			ps.setString(12, books.getTitle());
			ps.setString(13, books.getAuthor());
			ps.setString(14, books.getStatus());
			int out = ps.executeUpdate();
			if(out !=0){
				System.out.println("Book saved with id="+ books.getBookid());
			}else System.out.println("Book save failed with id="+books.getBookid());
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	



	public List<Book> getAll() {
		String query = "select Id, Title, Author,Status from Book";
		List<Book> bkList = new ArrayList<Book>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()){
				Book bk = new Book();
				bk.setBookid(rs.getInt("Id"));
				bk.setTitle(rs.getString("Title"));
				bk.setAuthor(rs.getString("Author"));
				bk.setStatus(rs.getString("Status"));
				bkList.add(bk);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return bkList;
	}

}


