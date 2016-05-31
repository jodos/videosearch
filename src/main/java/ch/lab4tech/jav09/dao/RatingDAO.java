package ch.lab4tech.jav09.dao;

import java.util.List;

import ch.lab4tech.jav09.model.Rating;

public interface RatingDAO {
	public List<Rating> find();
}