 package vasudev.com;


public class Book {
	
	private int bookid;
	private String title;
	private String author;
	private String status;
	/**
	 * @return the bookid
	 */
	public int getBookid() {
		return this.bookid;
	}
	/**
	 * @param bookid the bookid to set
	 */
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return this.title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the author
	 */
	public String getAuthor() {
		return this.author;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return this.status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Book [bookid=" + bookid + ", title=" + title + ", author=" + author + ", status=" + status + "]";
	}
	
	
	
	
	
	
	
} 

