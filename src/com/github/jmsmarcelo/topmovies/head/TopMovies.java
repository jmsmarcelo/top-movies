package com.github.jmsmarcelo.topmovies.head;

import java.util.ArrayList;
import java.util.List;

public class TopMovies {
	private final static List<Movie> movies = new ArrayList<Movie>();
	
	public static List<Movie> get() {
		set();
		return movies;
	}
	public static Movie get(Integer i) {
		set();
		return movies.get(i);
	}
	public static String info(Integer i) {
		try {
			return "Título:\t\t" + get(i).getTitle()
					+ "\nURL do Pôster:\t" + get(i).getUrlImage()
					+ "\nNota:\t\t" + get(i).getRating()
					+ "\nAno:\t\t" + get(i).getYear();
		} catch(Exception e) {
			return "A Lista contém apenas os " + get().size() + " melhores (0-" + (get().size() - 1) + ")";
		}
	}
	public static String info() {
		String list = "";
		for(int i = 0; i < get().size(); i++)
			list += info(i) + "\n\n";
		return list;
	}
	private static void set() {
		Database data = new Database("top-movies-tmdb");
		if(movies.size() == 0)
			for(int i = 0; i < 20; i++)
				movies.add(new Movie(data, i));
	}
}