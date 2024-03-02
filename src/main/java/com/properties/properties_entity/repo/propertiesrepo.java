package com.properties.properties_entity.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.properties.properties_entity.model.properties;

@Repository
public interface propertiesrepo extends JpaRepository<properties,Long > {

}
