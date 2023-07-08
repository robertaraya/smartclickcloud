package smartclick.cloud.system.admin.entity;

import java.util.List;

public class Item {
	private String label;
	private String icon;
	
//	@JsonIgnore
    private List<String> authorities;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public List<String> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<String> authorities) {
		this.authorities = authorities;
	}
	
}
