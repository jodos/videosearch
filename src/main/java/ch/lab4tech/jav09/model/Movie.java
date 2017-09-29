package ch.lab4tech.jav09.model;

import lombok.Data;

@Data
public class Movie {

    private int titleNo;
    private String title;
    private String description;
    private String rating;
    private int categoryCode;
    private String retailPrice;
    private String rentalPrice;
    private int copiesPurchased;
}
