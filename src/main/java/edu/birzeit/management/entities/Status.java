package edu.birzeit.management.entities;

/**
 * @author arouri
 *
 */
public class Status {

	public enum StatusCode{
		SUCCESS,
		FAILURE
	};
	
	private String status;

	/**
	 * @return
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param statusCode
	 */
	public void setStatus(StatusCode statusCode) {
		this.status = statusCode.name();
	}
}
