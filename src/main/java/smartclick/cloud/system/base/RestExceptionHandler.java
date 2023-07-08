package smartclick.cloud.system.base;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler{
	
	private static final Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);
	
	@SuppressWarnings("unchecked")
	@ExceptionHandler(DuplicateKeyException.class)
    public ResponseEntity<Object> handleDuplicateKeyExceptions(DuplicateKeyException ex) {
		Map<String, String> resultMap = null;
		
		String message = ex.getMessage();
		String responseMessage = message.substring(message.indexOf("{"), message.indexOf("}") + 1 );

		try {
			responseMessage = responseMessage.replace("{ ", "{ \"").replace(":", "\":");
			
			ObjectMapper mapper = new ObjectMapper();
			resultMap = mapper.readValue(responseMessage, Map.class);
			
		} catch (JsonProcessingException e) {
			logger.warn(responseMessage, e);
		}
		
		return buildResponseEntity(new RestErrorResponse(HttpStatus.CONFLICT, "Duplicate Key", resultMap, ex));
    }

    @SuppressWarnings("unchecked")
	@ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> handleIllegalArgumentExceptions(IllegalArgumentException ex) {
    	Map<String, String> resultMap = null;
		
		String message = ex.getMessage();
		String responseMessage = message.substring(message.indexOf("{"), message.indexOf("}") + 1 );
		
		try {
			responseMessage = responseMessage.replace("{ ", "{ \"").replace(":", "\":");
			
			ObjectMapper mapper = new ObjectMapper();
			resultMap = mapper.readValue(responseMessage, Map.class);
			
		} catch (JsonProcessingException e) {
			logger.warn(responseMessage, e);
		}
		
		return buildResponseEntity(new RestErrorResponse(HttpStatus.NOT_ACCEPTABLE, "Ilegal Argument", resultMap, ex));
    }
	
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		Map<String, String> resultMap = new HashMap<>();
		
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			resultMap.put(fieldName, errorMessage);
		});
		
		return buildResponseEntity(new RestErrorResponse(HttpStatus.NOT_ACCEPTABLE,"Invalid Argument", resultMap, ex));
	}
	
	
	@ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleExceptions(Exception ex) {
    	Map<String, String> resultMap = new HashMap<String, String>();
		
		String message = ex.getMessage();	
		resultMap.put("error", message);
		
		return buildResponseEntity(new RestErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Error", resultMap, ex));
    }
	
	private ResponseEntity<Object> buildResponseEntity(RestErrorResponse errorResponse) {
		return new ResponseEntity<>(errorResponse, errorResponse.getStatus());
	}
}
