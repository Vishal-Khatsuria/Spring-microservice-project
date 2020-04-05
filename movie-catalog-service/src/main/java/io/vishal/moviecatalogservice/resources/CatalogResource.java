package io.vishal.moviecatalogservice.resources;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.vishal.moviecatalogservice.models.CatalogItem;
import io.vishal.moviecatalogservice.models.Movie;
import io.vishal.moviecatalogservice.models.Rating;

@RestController
@RequestMapping("/catalog")
public class CatalogResource {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/{userId}")
	public List<CatalogItem> getcatalog(@PathVariable("userId") String userId){
		
		List<Rating> ratings = Arrays.asList(
				new Rating("Titanic", 4),
				new Rating("Transformers", 3)
				);
		
		return ratings.stream()
				.map(rating -> {
					Movie movie = restTemplate.getForObject("http://localhost:8086/movies/"+rating.getMovieId(), Movie.class);
					return new CatalogItem(movie.getName(), movie.getDesc(), rating.getRating());
				})
				.collect(Collectors.toList());
	}

}
