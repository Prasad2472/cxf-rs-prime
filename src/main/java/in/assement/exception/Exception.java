/**
 * 
 */
package in.assement.exception;

import java.io.Serializable;

/**
 * @author Prasad Boini
 *
 */
public class Exception implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String msg;
	private int errorCode;

	public Exception(String msg, int errorCode) {
		super();
		this.msg = msg;
		this.errorCode = errorCode;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
}
