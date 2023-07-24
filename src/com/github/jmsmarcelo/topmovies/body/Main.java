package com.github.jmsmarcelo.topmovies.body;

import com.github.jmsmarcelo.topmovies.head.HTMLGenerator;
import com.github.jmsmarcelo.topmovies.head.Top20movies;

public class Main {
	public static void main(String[] args) {
		HTMLGenerator.Generator("content.html", Top20movies.get());
		System.out.println(Top20movies.info());
	}
}