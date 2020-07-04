package com.test;

import javax.ws.rs.core.Response;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class TestMovieClient {
	
	public static void main(String[] args) {
		//getMovieList();
		
		//addMovie();
		
		//deleteMovie();
		
		updateMovie();
		
	}

	private static void getMovieList() {
		Client client = new Client();
		WebResource webResource = client.resource("http://localhost:8182/17-Jersey1Service/rest/movie/list");
		ClientResponse response = webResource.get(ClientResponse.class);
		
		if(response.getStatus() == Response.Status.OK.getStatusCode()) {
			String sOutput = response.getEntity(String.class);
			System.out.println("Output ::= "+sOutput);
		}
	}
	
	private static void addMovie() {
		String sReq = "[{\"MOVIE_NAME\":\"ROBERT\",\"MOVIE_LANGUAGE\":\"KANNADA\",\"MOVIE_RELEASE_DATE\":\"Jan 29, 2020\"}]";
		
		Client client = new Client();
		WebResource webResource = client.resource("http://localhost:8182/17-Jersey1Service/rest/movie/add");
		ClientResponse response = webResource.post(ClientResponse.class, sReq);
		
		if(response.getStatus() == Response.Status.CREATED.getStatusCode()) {
			String sOutput = response.getEntity(String.class);
			System.out.println("sOutput ::= "+sOutput);
		}
	}
	
	private static void deleteMovie() {
		String sReq = "{\"MOVIE_ID\":\"19\", \"MOVIE_NAME\": \"ROBERT\"}";
		Client client = new Client();
		WebResource webResource = client.resource("http://localhost:8182/17-Jersey1Service/rest/movie/delete");
		ClientResponse response = webResource.delete(ClientResponse.class, sReq);
		if(response.getStatus() == Response.Status.OK.getStatusCode()) {
			String sOutput = response.getEntity(String.class);
			System.out.println("sOutput ::= "+sOutput);
		}
	}
	
	private static void updateMovie() {
		String sReq = "[{\"MOVIE_NAME\":\"ROBERT\",\"MOVIE_LANGUAGE\":\"KANNADA\",\"MOVIE_RELEASE_DATE\":\"Jan 29, 2020\",\"MOVIE_ID\": \"98\"}]";
		Client client = new Client();
		WebResource webResource  = client.resource("http://localhost:8182/17-Jersey1Service/rest/movie/update");
		ClientResponse response = webResource.put(ClientResponse.class, sReq);
		if(response.getStatus() == Response.Status.OK.getStatusCode()) {
			String sOutput  = response.getEntity(String.class);
			System.out.println("sOutput :: "+sOutput);
		}else {
			String sOutput = response.getEntity(String.class);
			System.out.println("sOutput ::= "+sOutput);
		}
	}
}
