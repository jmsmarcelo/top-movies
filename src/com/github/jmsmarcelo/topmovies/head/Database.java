package com.github.jmsmarcelo.topmovies.head;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

class Database {
	private static List<HashMap<String, String>> Movies = new ArrayList<HashMap<String, String>>();
	@SuppressWarnings("resource")
	protected Database() throws IOException, InterruptedException {
		File fileJson = new File("top-movies.json");
		if(!fileJson.exists())
			getJsonToFile();
		for(String i: new Scanner(fileJson).nextLine()
				.replaceAll("^\\{.*:\\[\\{\"?|\\}\\].*\\}$", "").split("\"?\\},\\{\"?")) {
			//System.out.println(i);
			HashMap<String, String> tempMap = new HashMap<String, String>();
			for(String j: i.split("\",\"|\\],\"|,\""))
				//System.out.println(j);
				tempMap.put(j.split("\":\"|\":\\[|\":")[0], j.split("\":\"|\":\\[|\":")[1]);
			Movies.add(tempMap);
		}
	}
	protected String get(Integer i, String flag) {
		return Movies.get(i).get(flag);
	}
	private HttpResponse<String> getHttpJson() throws IOException, InterruptedException {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(Api.url))
				.header("accept", "application/json")
				.header("Authorization", Api.auth)
				.build();
		return client.send(request, BodyHandlers.ofString());
	}
	private void getJsonToFile() throws IOException, InterruptedException {
		FileWriter fileJson = new FileWriter("top-movies.json");
		fileJson.write(getHttpJson().body());
		fileJson.close();
	}
	
}
