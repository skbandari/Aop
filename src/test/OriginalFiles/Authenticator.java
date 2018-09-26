package OriginalFiles;

import java.io.FilterInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Authenticator {



	private List<User> users;
	
	public Authenticator() {
		users = new ArrayList<>();
		users.add(new User("james", "james1"));
		users.add(new User("george", "george2"));
		users.add(new User("olivia", "olivia3"));
		users.add(new User("thomas", "thomas4"));
	}

	public void authenticate() throws AuthenticationException {
		Scanner keyboard = new Scanner(new FilterInputStream(System.in) {
			@Override
			public void close() throws IOException {}

		});
		System.out.print("Username: ");
		String username = keyboard.nextLine();
		System.out.print("Password: ");
		String password = keyboard.nextLine();
		keyboard.close();
		if(!isInList(new User(username, password))) {
			throw new AuthenticationException("Invalid username and or password");
		}
	}
	
	private boolean isInList(User user) {
		boolean inList = false;
		for(User authenticatedUser : users) {
			if(user.equals(authenticatedUser)) {
				inList = true;
				break;
			}
		}
		return inList;
	}
}
