package smartclick.cloud.security.config.controller;

import java.net.URI;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import smartclick.cloud.security.config.entity.User;
import smartclick.cloud.security.config.entity.payload.ApiResponse;
import smartclick.cloud.security.config.entity.payload.AuthResponse;
import smartclick.cloud.security.config.entity.payload.LoginRequest;
import smartclick.cloud.security.config.entity.payload.SignUpRequest;
import smartclick.cloud.security.config.handler.exception.BadRequestException;
import smartclick.cloud.security.config.local.service.AuthProvider;
import smartclick.cloud.security.config.local.service.TokenProvider;
import smartclick.cloud.security.config.local.service.UserRepository;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TokenProvider tokenProvider;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = tokenProvider.createToken(authentication);
        return ResponseEntity.ok(new AuthResponse(token));
    }
    
//    @SuppressWarnings({ "deprecation", "unused", "static-access" })
//	@PostMapping("/google")
//    public ResponseEntity<?> authenticateByGoogleToken(@RequestBody GoogleTokenResponse googleTokenResponse) throws IOException {
//
//    	HttpTransport transport = new NetHttpTransport();
//    	JsonFactory jsonFactory = new GsonFactory();
//    	
////    	GoogleCredential credential = new GoogleCredential.Builder().setTransport(transport)
////    	        .setJsonFactory(jsonFactory)
////    	        .setClientSecrets("4833692760-l6v8p0jnjg0b9u62s6guc3f6mfumfeoa.apps.googleusercontent.com", "mLAVUSHmtj8zsM-2tcuQaKL2")
////    	        .build().setAccessToken(accessToken);
//    	
//    	List<String> applicationScopes = Arrays.asList(
//    			"https://www.googleapis.com/auth/userinfo.email",
//    			"https://www.googleapis.com/auth/userinfo.profile"
//    	);
//
//    	GoogleAuthorizationCodeFlow flow
//    	  = new GoogleAuthorizationCodeFlow.Builder(
//    	    transport,
//    	    jsonFactory,
//    	    "4833692760-l6v8p0jnjg0b9u62s6guc3f6mfumfeoa.apps.googleusercontent.com",
//    	    "mLAVUSHmtj8zsM-2tcuQaKL2",
//    	    applicationScopes).build();
////    	TokenResponse googleTokenResponse = new TokenResponse();
////    	googleTokenResponse.setAccessToken(accessToken);
////    	googleTokenResponse.setExpiresInSeconds(Long.valueOf(authentication.getExpiresIn()));
////    	googleTokenResponse.setTokenType(authentication.getTokenType());
//
////    	GoogleTokenResponse response = new GoogleAuthorizationCodeTokenRequest(
////    		      transport, jsonFactory, CLIENT_ID, CLIENT_SECRET, code,
////    		      REDIRECT_URI).execute();
//    	
//    	
//    	String userId = googleTokenResponse.parseIdToken().getPayload().getSubject();
//    	Credential credential = flow.createAndStoreCredential(googleTokenResponse, userId);
//    	HttpRequestFactory requestFactory = transport.createRequestFactory(credential);
//
//    	GenericUrl url = new GenericUrl("https://www.googleapis.com/oauth2/v1/userinfo");
//    	HttpRequest request = requestFactory.buildGetRequest(url);
//    	String userIdentity = request.execute().parseAsString();
//    	
////    	JsonFactory jsonFactory = new GsonFactory();
////    	
////    	HttpTransport transport = new NetHttpTransport();
////    	GoogleCredential credential = new GoogleCredential.Builder()
////    			.setTransport(transport).setJsonFactory(jsonFactory)
////    			.setClientSecrets("4833692760-l6v8p0jnjg0b9u62s6guc3f6mfumfeoa.apps.googleusercontent.com", "mLAVUSHmtj8zsM-2tcuQaKL2").setRequestInitializer((new HttpRequestInitializer(){
////    			                @Override
////    			                public void initialize(HttpRequest request)
////    			                        throws IOException {
////    			                    request.getHeaders().put("Authorization", "Bearer " + accessToken);
////    			                }
////    			            })).build();
////    	System.out.println(credential.getServiceAccountId());
////    	System.out.println(claims.getIssuer());
////    	System.out.println(claims.getId());
////    	System.out.println(claims.getSubject());
//    	
////        Authentication authentication = authenticationManager.authenticate(
////                new UsernamePasswordAuthenticationToken(
////                        loginRequest.getEmail(),
////                        loginRequest.getPassword()
////                )
////        );
////
////        SecurityContextHolder.getContext().setAuthentication(authentication);
////
////        String token = tokenProvider.createToken(authentication);
//        return null; //ResponseEntity.ok(new AuthResponse(googleToken));
//    }
    
    @PostMapping("/smartapp")
    public ResponseEntity<?> authenticateApp(@RequestBody String authToken) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] encodedhash = digest.digest(authToken.getBytes());
			String password = bytesToHex(encodedhash);
			
			if ("819e440056966e933b45f06307e5bb7f43eaa8cc3957417ead0a3696a41eebc4".equals(authToken)) {
	    		
	    		Authentication authentication = authenticationManager.authenticate(
	                    new UsernamePasswordAuthenticationToken(
	                            "819e440056966e933b45f06307e5bb7f43eaa8cc3957417ead0a3696a41eebc4@gmail.com",
	                            password
	                    )
	            );

	            SecurityContextHolder.getContext().setAuthentication(authentication);

	            String token = tokenProvider.createToken(authentication);
	            return ResponseEntity.ok(new AuthResponse(token));
			}
			
		} catch (NoSuchAlgorithmException e) {
			
		}
    	
		throw new BadRequestException("Authentication Error.");
        
    }
    
    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
    
    @GetMapping("/819e440056966e933b45f06307e5bb7f43eaa8cc3957417ead0a3696a41eebc4")
    public Boolean registerMovilAppUser() {
    	try {
    		if(userRepository.existsByEmail("819e440056966e933b45f06307e5bb7f43eaa8cc3957417ead0a3696a41eebc4@gmail.com")) {
                throw new BadRequestException("Email address already in use.");
            }
            
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
    		byte[] encodedhash = digest.digest(("819e440056966e933b45f06307e5bb7f43eaa8cc3957417ead0a3696a41eebc4".getBytes()));
    		String password = bytesToHex(encodedhash);

            // Creating user's account
            User user = new User();
            user.setName("819e440056966e933b45f06307e5bb7f43eaa8cc3957417ead0a3696a41eebc4");
            user.setEmail("819e440056966e933b45f06307e5bb7f43eaa8cc3957417ead0a3696a41eebc4@gmail.com");
            user.setPassword(password);
            user.setProvider(AuthProvider.local);

            user.setPassword(passwordEncoder.encode(user.getPassword()));
            
            Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_MOBILE_APP_USER"));
            
            user.setAuthorities(grantedAuthorities);

            userRepository.save(user);

            return true;
		} catch (Exception e) {
			return false;
		}
        
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
        if(userRepository.existsByEmail(signUpRequest.getEmail())) {
            throw new BadRequestException("Email address already in use.");
        }

        // Creating user's account
        User user = new User();
        user.setName(signUpRequest.getName());
        user.setEmail(signUpRequest.getEmail());
        user.setPassword(signUpRequest.getPassword());
        user.setProvider(AuthProvider.local);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ENTRY_USER"));
        
        if (user.getEmail().equalsIgnoreCase("rbrtaraya8518@gmail.com") || user.getEmail().equalsIgnoreCase("rbrtaraya8518@hotmail.com")) {
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN_USER"));
		}
        
        if (user.getEmail().equalsIgnoreCase("rbrtaraya8518@gmail.com") || user.getEmail().equalsIgnoreCase("emilyrojascr@gmail.com")) {
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_PROPERTY_ADMIN"));
		}
        
        user.setAuthorities(grantedAuthorities);

        User result = userRepository.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/user/me")
                .buildAndExpand(result.getId()).toUri();

        return ResponseEntity.created(location)
                .body(new ApiResponse(true, "User registered successfully@"));
    }

}
