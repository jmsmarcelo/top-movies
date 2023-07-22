package com.github.jmsmarcelo.topmovies.body;

import java.io.FileNotFoundException;

import com.github.jmsmarcelo.topmovies.head.HTMLGenerator;
import com.github.jmsmarcelo.topmovies.head.Top20movies;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
	
		HTMLGenerator.Generator();
		System.out.println(Top20movies.info());
	}
}
