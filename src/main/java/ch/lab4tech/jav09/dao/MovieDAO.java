package ch.lab4tech.jav09.dao;

import java.util.List;

import ch.lab4tech.jav09.model.Category;
import ch.lab4tech.jav09.model.Movie;
import ch.lab4tech.jav09.model.Rating;

public interface MovieDAO {
	public List<Movie> findByCodeAndRating(List<Category> categories, List<Rating> ratings);

	public String showCurrentSQLQuery();
}
