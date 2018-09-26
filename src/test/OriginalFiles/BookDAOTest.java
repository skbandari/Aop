package OriginalFiles;

import java.util.List;

public class BookDAOTest {

	public static void main(String[] args) {
		BookDAO dao = new BookDAO();
		Book book = dao.getOne(4);
		System.out.println(book);
		try {
			dao.add(new Book("A Family Recipe", "Veronica Henry"));
		} catch (AuthenticationException e) {
			System.out.println(e.getMessage());
		}
		List<Book> books = dao.getAll();
		books.stream().forEach(System.out::println);
	}
}
