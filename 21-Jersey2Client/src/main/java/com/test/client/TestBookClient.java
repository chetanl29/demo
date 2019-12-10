package com.test.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class TestBookClient {
	
	public static void main(String[] args) {
		//getBooks();
		
		//addBook();
		
		//deleteBook();  /*Delete operation will not accept Request body*/
		
		//updateBook();
	}
	
	public static void getBooks() {
		Client client =  ClientBuilder.newClient();
		WebTarget webTarget = client.target("http://localhost:8180/20-Jersey2Service/rest/book/get");
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.TEXT_PLAIN);
		Response response = invocationBuilder.get();
		String sRes = response.readEntity(String.class);
		System.out.println("sResponse ::= "+sRes);
	}

	public static void addBook() {
		String addBook = "{\"BOOK_AUTHOR\":\"Kathy Seirra\",\"BOOK_PUBLISH_DATE\":\"Jan 1, 1993\",\"BOOK_AMOUNT\":20.0,\"BOOK_TITLE\":\"JAVA\"}";
		Client client =  ClientBuilder.newClient();
		WebTarget webTarget = client.target("http://localhost:8180/20-Jersey2Service/rest/book/add");
		Response response = webTarget.request(MediaType.APPLICATION_JSON).post(Entity.text(addBook));
		int status = response.getStatus();
		String sResponse = response.readEntity(String.class);
		System.out.println("Status ::= "+status);
		System.out.println("sResponse ::= "+sResponse);
	}
	
	/*public static void deleteBook() {
		String deleteBook = "{\"BOOK_ID\":3,\"BOOK_TITLE\":\"Phython\"}";
		Client client =  ClientBuilder.newClient();
		WebTarget webTarget = client.target("http://localhost:8180/20-Jersey2Service/rest/book/delete");
		Response response = webTarget.request(MediaType.APPLICATION_JSON).build("DELETE",Entity.entity(deleteBook, MediaType.APPLICATION_JSON)).invoke();
		
		//Response response = webTarget.request(MediaType.TEXT_PLAIN).method("DELETE", Entity.entity(deleteBook, MediaType.TEXT_PLAIN));
		int status = response.getStatus();
		String sResponse = response.readEntity(String.class);
		System.out.println("Status ::= "+status);
		System.out.println("sResponse ::= "+sResponse);
	}*/
	
	public static void updateBook() {
		String updateBook = "{\"BOOK_ID\":2,\"BOOK_AUTHOR\":\"Kathy Seirra\",\"BOOK_PUBLISH_DATE\":\"Jan 1, 1993\",\"BOOK_AMOUNT\":20.0,\"BOOK_TITLE\":\"Spring Boot\"}";
		Client client =  ClientBuilder.newClient();
		WebTarget webTarget = client.target("http://localhost:8180/20-Jersey2Service/rest/book/update");
		Response response = webTarget.request(MediaType.APPLICATION_JSON).put(Entity.text(updateBook));
		int status = response.getStatus();
		String sResponse = response.readEntity(String.class);
		System.out.println("Status ::= "+status);
		System.out.println("sResponse ::= "+sResponse);
	}
	
}
