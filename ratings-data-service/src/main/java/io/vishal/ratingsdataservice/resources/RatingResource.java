package io.vishal.ratingsdataservice.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.vishal.ratingsdataservice.dto.UserRating;
import io.vishal.ratingsdataservice.models.Rating;

@RestController
@RequestMapping("/ratings")
public class RatingResource {
	
	@GetMapping("/movies/{movieId}")
	public Rating getMovieRating(@PathVariable("movieId") String movieId) {
		return new Rating(movieId, 4);
	}
	
	@GetMapping("/users/{userId}")
	public UserRating getUserRatings(@PathVariable("userId") String userId){
		List<Rating> ratings = Arrays.asList(
				new Rating("Titanic", 4),
				new Rating("Transformers", 3)
				);
		UserRating usrRating = new UserRating(userId, ratings);
		return usrRating;
	}

}
