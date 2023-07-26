package com.github.jmsmarcelo.topmovies.head;
/**
 * @author Jose Marcelo
 */
public class Movie {
	private final String title;
	private final String urlImage;
	private final String rating;
	private final String year;
	/**
	 * @param i	referencia o rank do filme (Os 20 melhores, 0-19)
	 * utilizei apenas os 20 melhores para não sobrecarregar a API
	 * 
	 * Optei pelo construtor padrão para facilitar na criação e adição do Objeto na Lista
	 */
	protected Movie(Database data, Integer i) {
		title = data.get(i, "title");
		urlImage = data.get(i, "poster_path");
		rating = data.get(i, "vote_average");
		year = data.get(i, "release_date").replaceAll("^(\\d{4}).*", "$1");
	}
	public String getTitle() {
		return title;
	}
	public String getUrlImage() {
		return Api.urlImg + urlImage;
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