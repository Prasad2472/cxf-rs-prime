/**
 * 
 */
package in.assement.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

/**
 * @author Prasad Boini
 *
 */
@Path("/prime")
@Service
public interface PrimeService {
	@GET
	@Path("/findAllPrimeNumbers")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	Response findPrimeNumbers(@QueryParam("start") Integer start, @QueryParam("end") Integer end);

	@GET
	@Path("/getPrimeNumbers")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.TEXT_PLAIN)
	Response getPrimeNumbers(@QueryParam("pageNumber") Integer pageNumber,
			@QueryParam("noOfElementsPerpage") Integer noOfElementsPerpage);

}
