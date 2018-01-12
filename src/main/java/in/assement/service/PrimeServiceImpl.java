/**
 * 
 */
package in.assement.service;

import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.assement.exception.InvalidNumbersException;
import in.assement.exception.PossitiveNumberException;
import in.assement.model.PrimeResponse;

/**
 * @author Prasad Boini
 *
 */
@Service
public class PrimeServiceImpl implements PrimeService {
	@Autowired
	private PrimeUtil primeNumberHelper;

	@Override
	public Response findPrimeNumbers(final Integer start, final Integer end) {
		final PrimeResponse model = new PrimeResponse();
		if (start < 0 || end < 0) {
			throw new PossitiveNumberException("Please Provide Positive Numbers..!", 400);
		}
		if (end < start) {
			throw new InvalidNumbersException("start:" + start + " end:" + end + " numbers are invalid..!", 400);
		}

		final List<Integer> listOfPrimeNumbers = primeNumberHelper.getPrimeNumbers(start, end);
		model.setPrimeNumbers(listOfPrimeNumbers);
		model.setMsg(generateSuccessMessage(start, end, listOfPrimeNumbers.size(), ""));
		return Response.status(Status.OK).entity(model).build();
	}

	private String generateFailureMessage(final Integer start, final Integer end, final String page) {

		final StringBuilder builder = new StringBuilder();
		builder.append("The ");

		if ("page".equalsIgnoreCase(page)) {
			builder.append("page number");
			builder.append(start);
			builder.append(" or ");
			builder.append(" no of prime numbers on the page ");
			builder.append(end);

		} else {
			builder.append(" start ");
			builder.append(start);
			builder.append(" or ");
			builder.append(" end ");
			builder.append(end);
		}
		builder.append(" are invalid..!");
		return builder.toString();
	}

	private String generateSuccessMessage(final Integer start, final Integer end, final Integer size,
			final String page) {
		final StringBuilder builder = new StringBuilder();
		builder.append("The number of Prime numbers ");
		if ("page".equalsIgnoreCase(page)) {
			builder.append(" in the Page ");
			builder.append(start);
		} else {
			builder.append(" between ");
			builder.append(start);
			builder.append(" and ");
			builder.append(end);
		}
		builder.append(" are: ");
		builder.append(size);
		return builder.toString();
	}

	@Override
	public Response getPrimeNumbers(final Integer pageNumber, final Integer noOfElementsPerpage) {
		final PrimeResponse model = new PrimeResponse();
		if (pageNumber < 1 || noOfElementsPerpage < 1) {
			model.setMsg(generateFailureMessage(pageNumber, noOfElementsPerpage, "Page"));
			return Response.status(Status.BAD_REQUEST).entity(model).build();
		}
		final List<Integer> listOfPrimeNumbers = primeNumberHelper.getPrimeNumbersWithinPage(pageNumber,
				noOfElementsPerpage);
		model.setPrimeNumbers(listOfPrimeNumbers);
		model.setMsg(generateSuccessMessage(pageNumber, noOfElementsPerpage, listOfPrimeNumbers.size(), "Page"));
		return Response.status(Status.OK).entity(model).build();
	}
}
