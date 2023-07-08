package smartclick.cloud.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    private final long MAX_AGE_SECS = 3600;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
        .allowedOrigins("")
        .allowedOriginPatterns("*")
        .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
        .allowedHeaders("*")//"DNT","X-CustomHeader","Keep-Alive","User-Agent","X-Requested-With","If-Modified-Since","Cache-Control","Content-Type","Content-Range","Range")
        .allowCredentials(true)
        .maxAge(MAX_AGE_SECS);
    }
}
