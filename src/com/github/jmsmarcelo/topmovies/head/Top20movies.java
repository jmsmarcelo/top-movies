package com.github.jmsmarcelo.topmovies.head;

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
		try {
			return "Título:\t\t" + get(i).getTitle()
					+ "\nURL do Pôster:\t" + get(i).getUrlImage()
					+ "\nNota:\t\t" + get(i).getRating()
					+ "\nAno:\t\t" + get(i).getYear();
		} catch(IndexOutOfBoundsException e) {
			return "Só é permitido os 20 melhores (0-19)";
		}
	}
	public static String info() {
		String list = "";
		for(int i = 0; i < get().size(); i++)
			list += info(i) + "\n\n";
		return list;
	}
	private static void set() {
		if(MOVIES.size() == 0)
			for(int i = 0; i < 20; i++)
				MOVIES.add(new Movie(i));
	}
}