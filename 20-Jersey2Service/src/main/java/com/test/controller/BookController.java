package com.test.controller;

import java.util.List;
import java.util.Map;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.test.service.BookService;

@Path("/book")
public class BookController {
	
	private BookService service;
	
	private Gson gson;
	
	public BookController() {
		this.gson = new Gson();
		this.service = new BookService();
	}
	
	@GET
	@Path("/get")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getBooks() {
		List<Map<String,Object>> lData = service.getBooks();
		return Response.status(200).entity(gson.toJson(lData)).build();
	}
	
	@POST
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addBook(String sBook) {
		Map<String,Object> mRet = service.addBook(sBook);
		return Response.ok(gson.toJson(mRet)).build();
	}

	@PUT
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateBook(String sBook) {
		Map<String,Object> mRet = service.updateBook(sBook);
		return Response.ok(gson.toJson(mRet)).build();
	}
	
	@DELETE
	@Path("/delete")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteBook(String sBook) {
		Map<String,Object> mRet = service.deleteMovie(sBook);
		return Response.ok(gson.toJson(mRet)).header("Done", "Done").build();
	}
	
}
