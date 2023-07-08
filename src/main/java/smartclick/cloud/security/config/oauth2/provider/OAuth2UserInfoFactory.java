package smartclick.cloud.security.config.oauth2.provider;

import java.util.Map;

import smartclick.cloud.security.config.entity.OAuth2UserInfo;
import smartclick.cloud.security.config.handler.exception.OAuth2AuthenticationProcessingException;
import smartclick.cloud.security.config.local.service.AuthProvider;

public class OAuth2UserInfoFactory {

    public static OAuth2UserInfo getOAuth2UserInfo(String registrationId, Map<String, Object> attributes) {
        if(registrationId.equalsIgnoreCase(AuthProvider.google.toString())) {
            return new GoogleOAuth2UserInfo(attributes);
        } else if (registrationId.equalsIgnoreCase(AuthProvider.facebook.toString())) {
            return new FacebookOAuth2UserInfo(attributes);
        } else {
            throw new OAuth2AuthenticationProcessingException("Sorry! Login with " + registrationId + " is not supported yet.");
        }
    }
}
