package io.vishal.moviecatalogservice.resources;

import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.vishal.moviecatalogservice.models.CatalogItem;

@RestController
@RequestMapping("/catalog")
public class CatalogResource {
	
	@GetMapping("/{userId}")
	public List<CatalogItem> getcatalog(@PathVariable("userId") String userId){
		return Collections.singletonList(
				new CatalogItem("Titanic", "Description", 4)
				);
	}

}
