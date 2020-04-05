package io.vishal.moviecatalogservice.dto;

import java.util.List;

import io.vishal.moviecatalogservice.models.CatalogItem;

public class UserCatalog {
	private String userId;
	private List<CatalogItem> userCatalog;
	
	public UserCatalog() {
	}
	public UserCatalog(String userId, List<CatalogItem> userCatalog) {
		this.userId = userId;
		this.userCatalog = userCatalog;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public List<CatalogItem> getUserCatalog() {
		return userCatalog;
	}
	public void setUserCatalog(List<CatalogItem> userCatalog) {
		this.userCatalog = userCatalog;
	}
	
	
	

}
