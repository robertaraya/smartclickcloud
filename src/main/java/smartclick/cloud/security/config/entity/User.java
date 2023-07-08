package smartclick.cloud.security.config.entity;
import java.util.Collection;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIgnore;

import smartclick.cloud.security.config.local.service.AuthProvider;
import smartclick.cloud.system.base.AbstractBaseEntity;

@Document(collection = "users")
public class User extends AbstractBaseEntity<String>{
    @Id
    private String id;
    
    private String name;
    
    @NotBlank
    private String email;
    
    private String imageUrl;
    
    @JsonIgnore
    private Collection<? extends GrantedAuthority> authorities;
    
    @JsonIgnore
    private Boolean emailVerified = false;

    @JsonIgnore
    private String password;

    @JsonIgnore
    private AuthProvider provider;
    
    @JsonIgnore
    private String providerId;
    
    private String jsonMenuModel;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Boolean getEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(Boolean emailVerified) {
        this.emailVerified = emailVerified;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AuthProvider getProvider() {
        return provider;
    }

    public void setProvider(AuthProvider provider) {
        this.provider = provider;
    }

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	public String getJsonMenuModel() {
		return jsonMenuModel;
	}

	public void setJsonMenuModel(String jsonMenuModel) {
		this.jsonMenuModel = jsonMenuModel;
	}
    
}
