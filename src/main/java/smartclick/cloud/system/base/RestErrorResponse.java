package smartclick.cloud.system.base;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

public class RestErrorResponse {
	private HttpStatus status;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime timestamp;
	private String message;
	private Map<String, String> errors;

	private RestErrorResponse() {
		timestamp = LocalDateTime.now();
	}

	RestErrorResponse(HttpStatus status) {
		this();
		this.status = status;
	}

	RestErrorResponse(HttpStatus status, Throwable ex) {
		this();
		this.status = status;
		this.message = "Unexpected error";
	}

	RestErrorResponse(HttpStatus status, String message, Throwable ex) {
		this();
		this.status = status;
		this.message = message;
	}
	
	RestErrorResponse(HttpStatus status, String message, Map<String, String> errors, Throwable ex) {
		this();
		this.status = status;
		this.message = message;
		this.errors = errors;
	}

	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public Map<String, String> getErrors() {
		return errors;
	}
	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}
	
}
