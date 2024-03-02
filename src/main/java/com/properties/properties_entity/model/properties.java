package com.properties.properties_entity.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;   //same name of class
import lombok.Getter;    //for value get
import lombok.NoArgsConstructor;
import lombok.Setter;     // for value set
import lombok.ToString;


@Entity
@Table(name="properties")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class properties {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String tittle;

    private String author;

}
