package smartclick.cloud.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import smartclick.cloud.security.config.local.service.CustomUserDetailsService;
import smartclick.cloud.security.config.local.service.RestAuthenticationEntryPoint;
import smartclick.cloud.security.config.local.service.TokenAuthenticationFilter;
import smartclick.cloud.security.config.oauth2.service.CustomOAuth2UserService;
import smartclick.cloud.security.config.oauth2.service.HttpCookieOAuth2AuthorizationRequestRepository;
import smartclick.cloud.security.config.oauth2.service.OAuth2AuthenticationFailureHandler;
import smartclick.cloud.security.config.oauth2.service.OAuth2AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        securedEnabled = true,
        jsr250Enabled = true,
        prePostEnabled = true
)
public class Security extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private CustomOAuth2UserService customOAuth2UserService;

    @Autowired
    private OAuth2AuthenticationSuccessHandler oAuth2AuthenticationSuccessHandler;

    @Autowired
    private OAuth2AuthenticationFailureHandler oAuth2AuthenticationFailureHandler;

    @Bean
    public TokenAuthenticationFilter tokenAuthenticationFilter() {
        return new TokenAuthenticationFilter();
    }

    @Bean
    public HttpCookieOAuth2AuthorizationRequestRepository cookieAuthorizationRequestRepository() {
        return new HttpCookieOAuth2AuthorizationRequestRepository();
    }

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder
                .userDetailsService(customUserDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .cors()
                .and()
            .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
            .csrf()
                .disable()
            .formLogin()
                .disable()
            .httpBasic()
                .disable()
            .exceptionHandling()
                .authenticationEntryPoint(new RestAuthenticationEntryPoint())
                .and()
            .authorizeRequests()
                .antMatchers("/", "/movie/**",
                    "/error",
                    "/favicon.ico",
                    "/**/*.png",
                    "/**/*.gif",
                    "/**/*.svg",
                    "/**/*.jpg",
                    "/**/*.html",
                    "/**/*.css",
                    "/**/*.js")
                    .permitAll()
                .antMatchers("/auth/**", "/oauth2/**")
                    .permitAll()
                .antMatchers("/admin/**")
                	.hasAuthority("ROLE_ADMIN_USER")
                .antMatchers("/photo/**").permitAll() //.hasAnyAuthority("ROLE_PROPERTY_ADMIN", "ROLE_ADMIN_USER")
                .antMatchers("/file/**").hasAnyAuthority("ROLE_PROPERTY_ADMIN", "ROLE_ADMIN_USER")
            	.antMatchers("/store/**").permitAll()
            	.antMatchers("/public/**").permitAll()
            	.antMatchers("/public/property/**").permitAll()
            	.antMatchers("/property/admin/**").hasAnyAuthority("ROLE_PROPERTY_ADMIN", "ROLE_ADMIN_USER")
//            	.antMatchers("/graphql/**").permitAll()
//            	.antMatchers("/graphiql/**").permitAll()
                	//.hasAuthority("ROLE_MOBILE_APP_USER")
                .anyRequest()
                    .authenticated()
                .and()
            .oauth2Login()
                .authorizationEndpoint()
                    .baseUri("/oauth2/authorize")
                    .authorizationRequestRepository(cookieAuthorizationRequestRepository())
                    .and()
                .redirectionEndpoint()
                    .baseUri("/oauth2/callback/*")
                    .and()
                .userInfoEndpoint()
                    .userService(customOAuth2UserService)
                    .and()
                .successHandler(oAuth2AuthenticationSuccessHandler)
                .failureHandler(oAuth2AuthenticationFailureHandler);

        http.addFilterBefore(tokenAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}
