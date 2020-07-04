package com.test.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class MovieExceptionMapper implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable ex) {

		if(ex instanceof MovieNotFoundException) {
			return Response.status(Status.NOT_FOUND).
					entity(new MovieError(404, ex.getMessage())).build();
		}
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(new MovieError(500, "Movie Not found")).build();
	}

}
