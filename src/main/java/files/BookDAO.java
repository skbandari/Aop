package files;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Aspect
@Component
public class BookDAO implements DAO<Book> {
	
	private List<Book> books;
	//private Authenticator authenticator;
	//private Auditor auditor;
	
	public BookDAO() {
		books = new ArrayList<>();
		books.add(new Book("Into the Water", "Paula Hawkins"));
		books.add(new Book("Eleanor Oliphant is Completely Fine", "Gail Honeyman"));
		books.add(new Book("Two Kinds of Truth", "Michael Connelly"));
		books.add(new Book("Outsider", "Stephen King"));
		books.add(new Book("The Midnight Line", "Lee Child"));
		books.add(new Book("The Tiger's Prey", "Wilbur Smith"));
		books.add(new Book("Haunted", "James Patterson"));
		books.add(new Book("The Good Daughter", "Karin Slaughter"));
		books.add(new Book("A Legacy of Spies", "John LeCarre"));
		books.add(new Book("Wild Like Me", "Louise Pentland"));
		//authenticator = new Authenticator();
		//auditor = new Auditor("audit.log");
	}

	public List<Book> getAll() {
		// not related to the class's principle concern
		// duplicated invocation

		//auditor.log("getAll");
		
		return new ArrayList<>(books);
	}

	public Book getOne(int id) {
		// not related to the class's principle concern
		// duplicated invocation
		//auditor.log("getOne", id);
		
		Book book = books.stream().filter(b -> b.getId() == id).findFirst().orElse(null);
		Book copy = null;
		try {
			copy = book != null ? (Book) book.clone() : null;
		} catch (CloneNotSupportedException e) {
			// ignore
		}
		return copy;
	}

	public void add(Book book) throws AuthenticationException {
		// not related to the class's principle concern
		// duplicated invocation

		//authenticator.authenticate();



		books.add(book);
		
		// not related to the class's principle concern
		// duplicated invocation
		//auditor.log("add", book);
	}

	public void update(Book book) throws AuthenticationException {
		// not related to the class's principle concern
		// duplicated invocation
		//authenticator.authenticate();
		
		int index = books.indexOf(book);
		books.set(index, book);
		
		// not related to the class's principle concern
		// duplicated invocation
		//auditor.log("update", book);
	}

	public void delete(Book book) throws AuthenticationException {
		// not related to the class's principle concern
		// duplicated invocation
		//authenticator.authenticate();
		
		books.remove(book);
		
		// not related to the class's principle concern
		// duplicated invocation
		//auditor.log("remove", book);
	}

	public void deleteById(int id) throws AuthenticationException {
		// not related to the class's principle concern
		// duplicated invocation
		//authenticator.authenticate();
		
		for(int i = 0; i < books.size(); i++) {
			if(books.get(i).getId() == id) {
				books.remove(i);
				break;
			}
		}
		
		// not related to the class's principle concern
		// duplicated invocation
		//auditor.log("deleteById", id);
	}
}
