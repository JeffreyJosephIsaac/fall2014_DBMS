package webServices;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import model.ProjectManager;

import com.google.gson.Gson;

import dto.FeedObjects;

@Path("/WebService")
public class FeedService {

	@GET
	@Path("/GetFeeds")
	@Produces("application/json")
	public String feed()
	{
		System.out.println("first");
		String feeds = null;
		try 
		{
			ArrayList<FeedObjects> feedData = null;
			ProjectManager projectManager= new ProjectManager();
			feedData = projectManager.GetFeeds();
			Gson gson = new Gson();
			System.out.println("Checking");
			System.out.println(gson.toJson(feedData));
			feeds = gson.toJson(feedData);
		}
		
		catch (Exception e)
		{
			System.out.println("Exception Error"+e); //Console 
		}
		return feeds;
	}

}