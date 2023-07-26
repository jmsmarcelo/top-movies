package com.github.jmsmarcelo.topmovies.head;

import java.io.File;
import java.io.FileWriter;
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
	private List<HashMap<String, String>> movies = new ArrayList<HashMap<String, String>>();
	@SuppressWarnings("resource")
	protected Database(String fname) {
		try {
			File fileJson = new File(fname + ".json");
			if(!fileJson.exists())
				jsonToFile(fname);
			for(String i: new Scanner(fileJson).nextLine()
					.replaceAll("^\\{.*:\\[\\{\"?|\\}\\].*\\}$", "").split("\"?\\},\\{\"?")) {
				HashMap<String, String> tempMap = new HashMap<String, String>();
				for(String j: i.split("\",\"|\\],\"|,\""))
					tempMap.put(j.split("\":\"|\":\\[|\":")[0], j.split("\":\"|\":\\[|\":")[1]);
				this.movies.add(tempMap);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	protected String get(Integer i, String flag) {
		return this.movies.get(i).get(flag);
	}
	private HttpResponse<String> getHttpJson() {
		try {
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder()
					.uri(URI.create(Api.url))
					.header("accept", "application/json")
					.header("Authorization", Api.auth)
					.build();
			return client.send(request, BodyHandlers.ofString());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	private void jsonToFile(String fname) {
		try {
			FileWriter fileJson;
			fileJson = new FileWriter(fname + ".json");
			fileJson.write(getHttpJson().body());
			fileJson.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}