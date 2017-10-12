package com.track.referrers.rest;

import javax.ws.rs.GET; 
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/trackService") 
public class TrackService { 

	TrackDao trackDao = new TrackDao();

	@GET 
	@Path("/track") 
	@Produces(MediaType.APPLICATION_JSON)
	public Response addUrl(@QueryParam("url") String url){ 
		trackDao.addUrl(url); 
		return Response.status(200).entity(url + "has been tracked").build();
	} 

	@GET
	@Path("getTopVisited")
	@Produces(MediaType.APPLICATION_JSON)
	public TrackRespone getTopVisited()
	{
		TrackRespone response = new TrackRespone();
		response.setTopVisitedList(trackDao.getTopVisited());
		return response;
	}
}
