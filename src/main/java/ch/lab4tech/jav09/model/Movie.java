package ch.lab4tech.jav09.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "TBLMOVIETITLES")
public class Movie {

  @Id
  @Column(name = "TITLENO")
  private int titleNo;

  @Column(name = "TITLE")
  private String title;

  @Column(name = "DESCRIPTION")
  private String description;

  @Column(name = "RATING")
  private String rating;

  @Column(name = "CATEGORYCODE")
  private int categoryCode;

  @Column(name = "RETAILPRICE")
  private String retailPrice;

  @Column(name = "RENTALPRICE")
  private String rentalPrice;

  @Column(name = "COPIESPURCHASED")
  private int copiesPurchased;
}
