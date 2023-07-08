package smartclick.cloud.security.config.handler.exception;

import org.springframework.security.core.AuthenticationException;

public class OAuth2AuthenticationProcessingException extends AuthenticationException {

	private static final long serialVersionUID = -3135249255905797261L;

	public OAuth2AuthenticationProcessingException(String msg, Throwable t) {
        super(msg, t);
    }

    public OAuth2AuthenticationProcessingException(String msg) {
        super(msg);
    }
}
