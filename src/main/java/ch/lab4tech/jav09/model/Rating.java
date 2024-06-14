package ch.lab4tech.jav09.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "TBLRATINGS")
public class Rating {

	@Id
	@Column(name = "RATING_ID")
	private String ratingId;

	@Column(name = "DESCRIPTION")
	private String description;
}
