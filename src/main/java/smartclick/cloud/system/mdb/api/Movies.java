package smartclick.cloud.system.mdb.api;

import java.util.List;

public class Movies {

	private Boolean adult;
	private String backdrop_path;
    private List<Integer> genres;
    private Long id;
    private String original_language;
    private String original_title;
    private String overview;
    private Long popularity;
    private String poster_path;
    private String release_date;
    private String title;
    private String name;
    private Boolean video;
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private Integer vote_count;
    private Long vote_average;
    
	public Boolean getAdult() {
		return adult;
	}
	public void setAdult(Boolean adult) {
		this.adult = adult;
	}
	public String getBackdrop_path() {
		return backdrop_path;
	}
	public void setBackdrop_path(String backdrop_path) {
		this.backdrop_path = backdrop_path;
	}
	public List<Integer> getGenres() {
		return genres;
	}
	public void setGenres(List<Integer> genres) {
		this.genres = genres;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getOriginal_language() {
		return original_language;
	}
	public void setOriginal_language(String original_language) {
		this.original_language = original_language;
	}
	public String getOriginal_title() {
		return original_title;
	}
	public void setOriginal_title(String original_title) {
		this.original_title = original_title;
	}
	public String getOverview() {
		return overview;
	}
	public void setOverview(String overview) {
		this.overview = overview;
	}
	public Long getPopularity() {
		return popularity;
	}
	public void setPopularity(Long popularity) {
		this.popularity = popularity;
	}
	public String getPoster_path() {
		return poster_path;
	}
	public void setPoster_path(String poster_path) {
		this.poster_path = poster_path;
	}
	public String getRelease_date() {
		return release_date;
	}
	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Boolean getVideo() {
		return video;
	}
	public void setVideo(Boolean video) {
		this.video = video;
	}
	public Integer getVote_count() {
		return vote_count;
	}
	public void setVote_count(Integer vote_count) {
		this.vote_count = vote_count;
	}
	public Long getVote_average() {
		return vote_average;
	}
	public void setVote_average(Long vote_average) {
		this.vote_average = vote_average;
	}
	
    
}
