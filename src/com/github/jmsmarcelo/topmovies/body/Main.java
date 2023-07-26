package com.github.jmsmarcelo.topmovies.body;

import com.github.jmsmarcelo.topmovies.head.HTMLGenerator;
import com.github.jmsmarcelo.topmovies.head.TopMovies;

public class Main {
	public static void main(String[] args) {
		HTMLGenerator.Generator("content.html", TopMovies.get());
		System.out.println(TopMovies.info());
	}
}