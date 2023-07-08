package smartclick.cloud.security.config.oauth2.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import smartclick.cloud.security.config.entity.OAuth2UserInfo;
import smartclick.cloud.security.config.entity.User;
import smartclick.cloud.security.config.entity.UserPrincipal;
import smartclick.cloud.security.config.handler.exception.OAuth2AuthenticationProcessingException;
import smartclick.cloud.security.config.local.service.AuthProvider;
import smartclick.cloud.security.config.local.service.TokenAuthenticationFilter;
import smartclick.cloud.security.config.local.service.UserRepository;
import smartclick.cloud.security.config.oauth2.provider.OAuth2UserInfoFactory;
import smartclick.cloud.system.util.email.EmailService;

@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private EmailService emailService;
    
    private static final Logger logger = LoggerFactory.getLogger(TokenAuthenticationFilter.class);

    @Override
    public OAuth2User loadUser(OAuth2UserRequest oAuth2UserRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(oAuth2UserRequest);

        try {
            return processOAuth2User(oAuth2UserRequest, oAuth2User);
        } catch (AuthenticationException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new InternalAuthenticationServiceException(ex.getMessage(), ex.getCause());
        }
    }

    private OAuth2User processOAuth2User(OAuth2UserRequest oAuth2UserRequest, OAuth2User oAuth2User) {
        OAuth2UserInfo oAuth2UserInfo = OAuth2UserInfoFactory.getOAuth2UserInfo(oAuth2UserRequest.getClientRegistration().getRegistrationId(), oAuth2User.getAttributes());
        if(!StringUtils.hasLength(oAuth2UserInfo.getEmail())) {
            throw new OAuth2AuthenticationProcessingException("Email not found from OAuth2 provider");
        }

        Optional<User> userOptional = userRepository.findByEmail(oAuth2UserInfo.getEmail());
        User user;
        if(userOptional.isPresent()) {
            user = userOptional.get();
            if(!user.getProvider().equals(AuthProvider.valueOf(oAuth2UserRequest.getClientRegistration().getRegistrationId()))) {
                throw new OAuth2AuthenticationProcessingException("Looks like you're signed up with " +
                        user.getProvider() + " account. Please use your " + user.getProvider() +
                        " account to login.");
            }
            user = updateExistingUser(user, oAuth2UserInfo);
        } else {
            user = registerNewUser(oAuth2UserRequest, oAuth2UserInfo);
        }

        return UserPrincipal.create(user, oAuth2User.getAttributes());
    }

    private User registerNewUser(OAuth2UserRequest oAuth2UserRequest, OAuth2UserInfo oAuth2UserInfo) {
        User user = new User();

        user.setProvider(AuthProvider.valueOf(oAuth2UserRequest.getClientRegistration().getRegistrationId()));
        user.setProviderId(oAuth2UserInfo.getId());
        user.setName(oAuth2UserInfo.getName());
        user.setEmail(oAuth2UserInfo.getEmail());
        user.setImageUrl(oAuth2UserInfo.getImageUrl());
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ENTRY_USER"));
        
        if (user.getEmail().equalsIgnoreCase("rbrtaraya8518@gmail.com") || user.getEmail().equalsIgnoreCase("rbrtaraya8518@hotmail.com")) {
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN_USER"));
		}
        if (user.getEmail().equalsIgnoreCase("rbrtaraya8518@gmail.com")  || user.getEmail().equalsIgnoreCase("rbrtaraya8518@hotmail.com") || user.getEmail().equalsIgnoreCase("emilyrojas@propertyhuntercr.com")) {
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_PROPERTY_ADMIN"));
		}
        
        user.setAuthorities(grantedAuthorities);
        
        sendWelcomeEmail(user);
        
        return userRepository.save(user);
    }

    private User updateExistingUser(User existingUser, OAuth2UserInfo oAuth2UserInfo) {
    	try {
        	existingUser.setName(oAuth2UserInfo.getName());
            existingUser.setImageUrl(oAuth2UserInfo.getImageUrl());
            Collection<? extends GrantedAuthority> authorities = existingUser.getAuthorities();
            
            if( authorities == null || authorities.isEmpty()) {
            	Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
                grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ENTRY_USER"));
                
                if (existingUser.getEmail().equalsIgnoreCase("rbrtaraya8518@gmail.com") || existingUser.getEmail().equalsIgnoreCase("rbrtaraya8518@hotmail.com")) {
                    grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN_USER"));
        		}
                
                if (existingUser.getEmail().equalsIgnoreCase("rbrtaraya8518@gmail.com")  || existingUser.getEmail().equalsIgnoreCase("rbrtaraya8518@hotmail.com") || existingUser.getEmail().equalsIgnoreCase("emilyrojas@propertyhuntercr.com")) {
                    grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_PROPERTY_ADMIN"));
        		}
                
                existingUser.setAuthorities(grantedAuthorities);
                return userRepository.save(existingUser);
            }
		} catch (Exception e) {
			logger.error("Could not update user", e);
		}
    	return existingUser;
    }
    
    private void sendWelcomeEmail(User user) {
    	try {
    		emailService.sendEmail(user.getEmail(), "Bienvenido a smartclickweb", "Hola, " + user.getName() + " , te has registrado satisfactoriamente en smartclickweb.com, ya puedes acceder a nuestros servicios.");
		} catch (Exception e) {
			 logger.error("Could not send Welcome Email to user", e);
		} 	
    }

}
