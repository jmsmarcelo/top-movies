package com.github.jmsmarcelo.topmovies.body;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.github.jmsmarcelo.topmovies.head.Api;

public class Main {
	public static void main(String[] args) throws IOException, InterruptedException {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(Api.url))
				.header("accept", "application/json")
				.header("Authorization", Api.auth)
				.build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		List<String> titles = new ArrayList<String>();
		List<String> urlImages = new ArrayList<String>();
		Pattern.compile("\"title\":\"([^\"]*)\",", 8)
			.matcher(response.body()).replaceAll(i -> {
					titles.add(i.group(1));
					return "";
				});
		Pattern.compile("\"poster_path\":\"([^\"]*)\",", 8)
		.matcher(response.body()).replaceAll(i -> {
				urlImages.add("https://image.tmdb.org/t/p/w500" + i.group(1));
				return "";
			});
		System.out.println(titles);
		System.out.println(urlImages);
	}
}
