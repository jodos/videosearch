package ch.lab4tech.jav09.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "TBLCATEGORIES")
public class Category {

    @Id
    @Column(name = "CATEGORYCODE")
    private int code;

    @Column(name = "DESCRIPTION")
    private String description;
}
