package ch.lab4tech.jav09.repository;

import ch.lab4tech.jav09.model.Movie;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
	@Query("SELECT m FROM Movie m WHERE m.categoryCode IN :categoryCodes AND m.rating IN :ratings")
	List<Movie> findByCategoriesAndRatings(
		@Param("categoryCodes") List<Integer> categoryCodes,
		@Param("ratings") List<String> ratings
	);
}
