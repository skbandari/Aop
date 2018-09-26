package OriginalFiles;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Auditor {
	
	private String filename;
	
	public Auditor(String filename) {
		this.filename = filename;
	}

	public void log(String action, Object...args) {
		try(PrintWriter writer = new PrintWriter(new FileWriter(filename, true))) {
			String dateTime = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
			StringBuilder argsString = new StringBuilder();
			for(Object arg : args) {
				argsString.append(arg);
				argsString.append(" ");
			}
			writer.println(dateTime + ": " + action + "; arg=" + argsString);
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
