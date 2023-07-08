package smartclick.cloud.security.config.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import smartclick.cloud.security.config.entity.CurrentUser;
import smartclick.cloud.security.config.entity.User;
import smartclick.cloud.security.config.entity.UserPrincipal;
import smartclick.cloud.security.config.handler.exception.ResourceNotFoundException;
import smartclick.cloud.security.config.local.service.UserRepository;
import smartclick.cloud.system.admin.service.MenuService;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private MenuService menuService;

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('ENTRY_USER')")
    public User getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
    	User user =  userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
    	
    	user.setJsonMenuModel(menuService.getJsonMenuByAuthorityList(user.getAuthorities()));
    	
    	return user;
    }
    
    @GetMapping("/user/propertyHunter")
    @PreAuthorize("hasRole('ENTRY_USER')")
    public User getAllowedUser(@CurrentUser UserPrincipal userPrincipal) {
    	User user =  userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));

    	return user;
    }
}
