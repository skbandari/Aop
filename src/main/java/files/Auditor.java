package files;

import org.aspectj.lang.annotation.After;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class Auditor {
	
	private String filename;
	
	public Auditor(String filename) {
		this.filename = filename;
	}


	@After("execution(public void files.BookDAO.add(..)")
	public void log(String action, Object...args) {
		try(PrintWriter writer = new PrintWriter(new FileWriter(filename, true))) {
			String dateTime = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
			StringBuilder argsString = new StringBuilder();
			for(Object arg : args) {
				argsString.append(arg);
				argsString.append(" ");
			}
			writer.println(dateTime + ": " + action + "; arg=" + argsString);
			System.out.println("Auditor worked Successfully");
		} catch (IOException e) {
			// ignore
		}
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
}
