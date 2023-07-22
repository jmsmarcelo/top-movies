package com.github.jmsmarcelo.topmovies.head;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class HTMLGenerator {
	public static void Generator() {
		try (PrintWriter fileHTML = new PrintWriter("index.html")) {
			fileHTML.println("<!DOCTYPE html>");
			fileHTML.println("<html lang=\"pt-BR\">");
			fileHTML.println("<head>");
			fileHTML.println("\t<meta charset=\"UTF-8\">");
			fileHTML.println("\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
			fileHTML.println("\t<style>");
			fileHTML.println("\t\tbody {"
					+ "\n\t\t\ttext-align: center;"
					+ "\n\t\t\tbackground-color: gray;\n\t\t}");
			fileHTML.println("\t\tp {\n"
					+ "\t\t\tmargin-top: 0;\n\t\t}");
			fileHTML.println("\t\tsection>h1 {\n"
					+ "\t\t\tmargin-bottom: 0;\n\t\t}");
			fileHTML.println("\t\tsection>h1>span {\n"
					+ "\t\t\tfont-size: 50%;\n\t\t}");
			fileHTML.println("\t</style>");
			fileHTML.println("\t<title>Top 20 Movies</title>");
			fileHTML.println("</head>");
			fileHTML.println("<body>");
			int rank = 0;
			for(Movie m: Top20movies.get()) {
				fileHTML.println("\t<section>");
				fileHTML.println("\t\t<h1><span>#" + ++rank + ".</span> " + m.getTitle() + "</h1>");
				fileHTML.println("\t\t<img src=\"" + m.getUrlImage() + "\">");
				fileHTML.println("\t\t<p>Nota: " + m.getRating() +
						" - Ano: " +  m.getYear() + "</p>");
				fileHTML.println("\t</section>");
			}
			fileHTML.println("</body>");
			fileHTML.print("</html>");
			fileHTML.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
