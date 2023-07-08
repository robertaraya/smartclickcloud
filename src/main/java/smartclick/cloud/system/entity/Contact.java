package smartclick.cloud.system.entity;

import java.util.List;

public class Contact {
	private String name;
	private List<Phone> phoneList;
	private List<String> emailList;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Phone> getPhoneList() {
		return phoneList;
	}
	public void setPhoneList(List<Phone> phoneList) {
		this.phoneList = phoneList;
	}
	
	public List<String> getEmailList() {
		return emailList;
	}
	public void setEmailList(List<String> emailList) {
		this.emailList = emailList;
	}
}
