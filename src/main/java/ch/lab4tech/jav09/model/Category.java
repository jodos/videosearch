package ch.lab4tech.jav09.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "TBLCATEGORIES")
public class Category {

  @Id
  @Column(name = "CATEGORYCODE")
  private int code;

  private String description;
}
