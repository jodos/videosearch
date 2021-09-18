package ch.lab4tech.jav09.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "TBLRATINGS")
public class Rating {

  @Id private String rating;
  private String description;
}
