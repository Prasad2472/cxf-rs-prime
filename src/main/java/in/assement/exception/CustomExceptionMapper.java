/**
 * 
 */
package in.assement.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

/**
 * @author Prasad Boini
 *
 */
public class CustomExceptionMapper implements ExceptionMapper<RuntimeException> {

	@Override
	public Response toResponse(RuntimeException exception) {

		Exception exception2 = new Exception(exception.getMessage(), 400);
		return Response.status(Status.BAD_REQUEST).type(MediaType.APPLICATION_JSON).entity(exception2).build();
	}

}
