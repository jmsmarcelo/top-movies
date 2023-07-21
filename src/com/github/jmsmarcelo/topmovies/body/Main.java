package com.github.jmsmarcelo.topmovies.body;

import java.io.IOException;

import com.github.jmsmarcelo.topmovies.head.Top20movies;

public class Main {
	public static void main(String[] args) throws IOException, InterruptedException {
		new Top20movies();
		
		System.out.println(Top20movies.MOVIES);
	}
}
