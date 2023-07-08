package smartclick.cloud.security.config;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class UserAuditing implements AuditorAware<String>{
	@Override
	public Optional<String> getCurrentAuditor() {
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		return Optional.of(name);
	}
}