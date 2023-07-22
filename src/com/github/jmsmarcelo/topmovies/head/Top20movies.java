package com.github.jmsmarcelo.topmovies.head;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Top20movies {
	private final static List<Movie> MOVIES = new ArrayList<Movie>();
	
	public static List<Movie> get() {
		set();
		return MOVIES;
	}
	public static Movie get(Integer i) {
		set();
		return MOVIES.get(i);
	}
	public static String info(Integer i) {
			return "Título:\t\t" + get(i).getTitle() +
					"\nURL do Pôster:\t" + get(i).getUrlImage() +
					"\nNota:\t\t" + get(i).getRating() +
					"\nAno:\t\t" + get(i).getYear();
		
	}
	public static String info() {
		String list = "";
		for(int i = 0; i < get().size(); i++)
			list += info(i) + "\n\n";
		return list;
	}
	private static void set() {
		try {
			if(MOVIES.size() == 0)
				for(int i = 0; i < 20; i++)
					MOVIES.add(new Movie(i));
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
}