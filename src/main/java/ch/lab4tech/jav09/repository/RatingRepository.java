package ch.lab4tech.jav09.repository;

import ch.lab4tech.jav09.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends JpaRepository<Rating, String> {}
