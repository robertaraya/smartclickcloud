package smartclick.cloud.system.mdb.api;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "mdbapi")
public class MdbProperties {
	private String apiMovieUrl;
	private String apiTvUrl;
	private String apiKey;
	private String apiSearchMovieUrl;
	private String apiSearchTvUrl;
	
	public String getApiMovieUrl() {
		return apiMovieUrl;
	}
	public void setApiMovieUrl(String apiMovieUrl) {
		this.apiMovieUrl = apiMovieUrl;
	}
	
	public String getApiTvUrl() {
		return apiTvUrl;
	}
	public void setApiTvUrl(String apiTvUrl) {
		this.apiTvUrl = apiTvUrl;
	}
	
	public String getApiKey() {
		return apiKey;
	}
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}
	
	public String getApiSearchMovieUrl() {
		return apiSearchMovieUrl;
	}
	public void setApiSearchMovieUrl(String apiSearchMovieUrl) {
		this.apiSearchMovieUrl = apiSearchMovieUrl;
	}
	
	public String getApiSearchTvUrl() {
		return apiSearchTvUrl;
	}
	public void setApiSearchTvUrl(String apiSearchTvUrl) {
		this.apiSearchTvUrl = apiSearchTvUrl;
	}
	
}
