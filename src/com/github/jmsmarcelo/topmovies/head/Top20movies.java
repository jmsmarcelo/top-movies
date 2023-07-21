package com.github.jmsmarcelo.topmovies.head;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Top20movies {
	public static final List<Movie> MOVIES = new ArrayList<Movie>();
	
	public Top20movies() throws IOException, InterruptedException {
		for(int i = 0; i < 20; i++)
			MOVIES.add(new Movie(i));
	}
}
