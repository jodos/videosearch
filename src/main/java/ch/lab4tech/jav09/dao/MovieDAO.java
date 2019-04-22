package ch.lab4tech.jav09.dao;

import ch.lab4tech.jav09.model.Category;
import ch.lab4tech.jav09.model.Movie;
import ch.lab4tech.jav09.model.Rating;

import java.util.List;

public interface MovieDAO {
    List<Movie> findByCodeAndRating(List<Category> categories, List<Rating> ratings);

    String showCurrentSQLQuery();
}
