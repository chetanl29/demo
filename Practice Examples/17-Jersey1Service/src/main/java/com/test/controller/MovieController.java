package com.test.controller;

import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.test.exception.MovieNotFoundException;

//import javax.ws.rs.Path;

import com.test.service.MovieService;
import com.test.util.Utils;

@Path("/movie")
public class MovieController {
	
	private MovieService service;
	
	private Gson gson;
	
	public MovieController() {
		System.out.println("MovieController");
		this.service = new MovieService();
		this.gson = new Gson();
	}
	
	@GET
	@Path("/list")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getMovieList() {
		List<Map<String, Object>> lMovieList =  service.getMovieList();
		String sMovie = gson.toJson(lMovieList);
		System.out.println("sMovie list ::= "+sMovie);
		return Response.status(200).entity(sMovie).build();
	}
	
	@POST
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addMovie(String sMovieContent) {
		Map<String,Object> mRes = service.addMovie(sMovieContent);
		return Response.status(201).entity(gson.toJson(mRes)).build();
	}

	@DELETE
	@Path("/delete")
	@Produces(MediaType.APPLICATION_JSON)
	//@Consumes(MediaType.TEXT_PLAIN)
	public Response deleteMovie(String sMovie) {
		Map<String,Object> mRes = service.deleteMovie(sMovie);
		return Response.status(200).entity(gson.toJson(mRes)).build();
	}
	
	@POST
	@Path("/detail")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMovieDetail(String sMovie) {
		Map<String,Object> mRes = service.getMovieDetail(sMovie);
		return Response.status(200).header("Movie Details", "Success").entity(gson.toJson(mRes)).build();
	}
	
	@PUT
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateMovieDetails(String sMovie) {
		Map<String,Object> mRes = service.updateMovieDetails(sMovie);
		mRes = null;
		if(Utils.isEmpty(mRes)) {
			throw new MovieNotFoundException("Requested movie not available");
		}
		return Response.status(200).entity(gson.toJson(mRes)).build();
	}
	
}
