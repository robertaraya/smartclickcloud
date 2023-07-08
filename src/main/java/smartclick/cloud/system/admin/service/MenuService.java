package smartclick.cloud.system.admin.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import smartclick.cloud.security.config.local.service.TokenAuthenticationFilter;
import smartclick.cloud.system.admin.entity.Menu;
import smartclick.cloud.system.admin.repository.MenuRepository;
import smartclick.cloud.system.base.AbstractBaseService;

@Service
public class MenuService extends AbstractBaseService<Menu, String, MenuRepository>{
	
	private static final Logger logger = LoggerFactory.getLogger(TokenAuthenticationFilter.class);

	public MenuService(MenuRepository repository) {
		super(repository);
	}
	
	public String getJsonMenuByAuthorityList(Collection<? extends GrantedAuthority> authorities){
		List<Menu> result = new ArrayList<Menu>();
		String jsonResult = "";
		try {
			List<String> authorityList = new ArrayList<String>();
			authorities.stream().forEach((authority) -> {
				authorityList.add(authority.getAuthority().replace("ROLE_", ""));
			});
			
			result.addAll(findAuthoritiesForMenu(authorityList));
			
			ObjectMapper objectMapper = new ObjectMapper();
			jsonResult = objectMapper.writeValueAsString(result);
		} catch (Exception e) {
			logger.error("Could not get menu", e);
		}
		
		
		return jsonResult;
	}
	
	private List<Menu> findAuthoritiesForMenu(List<String> authorities){
		List<Menu> menuList = repository.findByAuthoritiesIn(authorities);
		menuList.parallelStream().forEach(menu -> {
			menu.setId("");
			menu.setAuthorities(new ArrayList<String>());
			menu.getMenuItems().parallelStream().forEach(item -> {
				item.setAuthorities(new ArrayList<String>());
			});
		});
		return menuList;
	}

	@Override
	public boolean hasInvalidFields(Menu entity) {
		return entity.getMenuTitle().isBlank() || entity.getMenuItems().isEmpty();
	}
	
}
