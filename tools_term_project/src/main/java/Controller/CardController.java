package Controller;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import Service.CardService;

@Path("/card")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CardController {

	@Inject
	CardService cardService;
	
	@PUT
	@Path("/addCard")
	public Response addCard(@QueryParam("boardName") String boardName,
							@QueryParam("listName") String listName,
							@QueryParam("cardName") String cardName) {
		
		String res = cardService.addCard(boardName, listName, cardName);
		
		if (res.startsWith("Added Card")) {
			return Response.ok(res).build();

		} else {
            return Response.status(Response.Status.BAD_REQUEST).entity(res).build();
		}
		
		
	}
}