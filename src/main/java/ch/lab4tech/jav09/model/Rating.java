package ch.lab4tech.jav09.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "TBLRATINGS")
public class Rating {

  @Id
  @Column(name = "RATING")
  private String rating;

  @Column(name = "DESCRIPTION")
  private String description;
}
