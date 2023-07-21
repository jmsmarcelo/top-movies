package com.github.jmsmarcelo.topmovies.head;

import java.io.IOException;

/**
 * @author Jose Marcelo
 */
public class Movie extends Database {
	private final String title;
	private final String urlImage;
	private final String rating;
	private final String year;
	
	
	/**
	 * @param i	referencia o rank do filme
	 * utilizei apenas os 20 melhores para n�o sobrecarregar a API
	 * 
	 * Optei pelo construtor padr�o para facilitar na cria��o e adi��o do Objeto na Lista
	 */
	protected Movie(int i) throws IOException, InterruptedException {
		title = super.get(i, "title");
		urlImage = super.get(i, "poster_path");
		rating = super.get(i, "vote_average");
		year = super.get(i, "release_date").replaceAll("(\\d{4})-\\d\\d-\\d\\d", "$1");
	}
	public String getTitle() {
		return title;
	}
	public String getUrlImage() {
		return urlImage;
	}
	public String getRating() {
		return rating;
	}
	public String getYear() {
		return year;
	}
	public String toString() {
		return title + " (" + year + ")";
	}
}
