package ch.lab4tech.jav09.dao;

import ch.lab4tech.jav09.model.Rating;

import java.util.List;

public interface RatingDAO {
    List<Rating> find();
}