package io.vishal.moviecatalogservice.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.vishal.moviecatalogservice.dto.UserCatalog;
import io.vishal.moviecatalogservice.dto.UserRating;
import io.vishal.moviecatalogservice.models.CatalogItem;
import io.vishal.moviecatalogservice.models.Movie;

@RestController
@RequestMapping("/catalog")
public class CatalogResource {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/{userId}")
	public UserCatalog getcatalog(@PathVariable("userId") String userId){
		
		UserRating ratings = restTemplate.getForObject("http://localhost:8087/ratings/users/"+userId, UserRating.class);
		
		List<CatalogItem> catalogItem = ratings.getUserRatings().stream()
				.map(rating -> {
					Movie movie = restTemplate.getForObject("http://localhost:8086/movies/"+rating.getMovieId(), Movie.class);
					return new CatalogItem(movie.getName(), movie.getDesc(), rating.getRating());
				})
				.collect(Collectors.toList());
		
		UserCatalog userCatalog = new UserCatalog(userId, catalogItem);
		return userCatalog;
	}

}
