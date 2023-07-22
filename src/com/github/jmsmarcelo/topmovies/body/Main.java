package com.github.jmsmarcelo.topmovies.body;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import com.github.jmsmarcelo.topmovies.head.HTMLGenerator;
import com.github.jmsmarcelo.topmovies.head.Top20movies;

public class Main {
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
	
		HTMLGenerator.Generator();
		System.out.println(Top20movies.info());
	}
}
