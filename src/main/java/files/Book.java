package files;

public class Book implements Cloneable {

	private int id;
	private String title;
	private String author;

	private static int NEXT_ID;
	
	public Book(String title, String author) {
		this.id = NEXT_ID++;
		this.title = title;
		this.author = author;
	}

	static {
		NEXT_ID = 1;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public String toString() {
		return "files.Book [id=" + id + ", title=" + title + ", author=" + author + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
}
