package smartclick.cloud.system.admin.entity;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import smartclick.cloud.system.base.AbstractBaseEntity;

@Document(collection = "menu")
public class Menu extends AbstractBaseEntity<String>{
	@Id
    private String id;
	
	@NotBlank
	@Indexed(unique = true)
    private String menuTitle;
	
	@NotBlank
    private String icon;
    
	@NotEmpty
	private List<Item> menuItems;
	
	@NotEmpty
    private List<String> authorities;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

	public String getMenuTitle() {
		return menuTitle;
	}

	public void setMenuTitle(String menuTitle) {
		this.menuTitle = menuTitle;
	}

	public List<Item> getMenuItems() {
		return menuItems;
	}

	public void setMenuItems(List<Item> menuItems) {
		this.menuItems = menuItems;
	}

	public List<String> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<String> authorities) {
		this.authorities = authorities;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}
	
}
