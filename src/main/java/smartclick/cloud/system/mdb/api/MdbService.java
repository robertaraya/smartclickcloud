package smartclick.cloud.system.mdb.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MdbService {
	private MdbProperties mdbProperties;

    public MdbService(MdbProperties mdbProperties) {
        this.mdbProperties = mdbProperties;
    }
    
    public ResponseEntity<Movie> getMovie(String movieId) {
		try {
	    	RestTemplate rest = new RestTemplate();
			String url = mdbProperties.getApiMovieUrl() + movieId + mdbProperties.getApiKey() + "&language=es";
			
			Movie response = rest.getForObject(url, Movie.class);
			
			return  new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return  new ResponseEntity<>(null, HttpStatus.OK);
		}
    }
    
    public ResponseEntity<Movie> getTvShow(String tvId) {
		try {
	    	RestTemplate rest = new RestTemplate();
			String url = mdbProperties.getApiTvUrl() + tvId + mdbProperties.getApiKey() + "&language=es";
			
			Movie response = rest.getForObject(url, Movie.class);
			
			return  new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return  new ResponseEntity<>(null, HttpStatus.OK);
		}
    }
    
    public ResponseEntity<List<Movies>> searchMovie(String query, String languaje) {
		try {
			RestTemplate rest = new RestTemplate();
			
			String url = mdbProperties.getApiSearchMovieUrl() + mdbProperties.getApiKey() + "&query=" + query + "&language=" + languaje + "&page=1&include_adult=false";
			
			PageResult response = rest.getForObject(url, PageResult.class);
			
			return new ResponseEntity<>(response.getResults(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK);
		}
    }
    
    public ResponseEntity<List<Movies>> searchTvShow(String query, String languaje) {
		try {
			RestTemplate rest = new RestTemplate();
			
			String url = mdbProperties.getApiSearchTvUrl() + mdbProperties.getApiKey() + "&query=" + query + "&language=" + languaje + "&page=1&include_adult=false";
			
			PageResult response = rest.getForObject(url, PageResult.class);
			
			return new ResponseEntity<>(response.getResults(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK);
		}
    }        
    
    
}
