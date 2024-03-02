package com.properties.properties_entity.controller;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.properties.properties_entity.model.properties;
import com.properties.properties_entity.repo.propertiesrepo;

@RestController
public class propertiescontroller {
    @Autowired
private propertiesrepo propertiesrepo;

  @GetMapping("/getAllproperties")
public ResponseEntity<List<properties>> getAllproperties(){
try{

List<properties> propertiesList = new ArrayList<>();
propertiesrepo.findAll().forEach(propertiesList::add);

if (propertiesList.isEmpty()) {
    return new ResponseEntity<>(propertiesList, HttpStatus.NO_CONTENT);
}

return new ResponseEntity<>(HttpStatus.OK);
} catch(Exception ex){
return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
}
}
@GetMapping("/getpropertiesByid/{id}")
public ResponseEntity<properties> getpropertiesid(@PathVariable Long id){
Optional<properties> propertiesData = propertiesrepo.findById(id);

if(propertiesData.isPresent()){
    return new ResponseEntity<>(propertiesData.get(), HttpStatus.OK);
}

return new ResponseEntity<>(HttpStatus.NOT_FOUND);
}


@PostMapping("/addproperties")
public ResponseEntity<properties> addproperties(@RequestBody properties properties){
properties propertiesObj = propertiesrepo.save(properties);

return new ResponseEntity<>(propertiesObj, HttpStatus.OK);

}
@PostMapping("updatepropertiesByid/{id}")
public  ResponseEntity<properties>updatepropertiesByid(@PathVariable Long id, @RequestBody properties newPropertiesData){
Optional<properties> oldpropertiesData = propertiesrepo.findById(id);
if(oldpropertiesData.isPresent()){
properties updatedpropertiesData = oldpropertiesData.get();
updatedpropertiesData.setTittle(newPropertiesData.getTittle());
updatedpropertiesData.setAuthor(newPropertiesData.getAuthor());

properties propertiesObj = propertiesrepo.save(updatedpropertiesData);
return new ResponseEntity<>(propertiesObj, HttpStatus.OK);
}
return new ResponseEntity<>(HttpStatus.NOT_FOUND);
}

@DeleteMapping("/deleteBookByid/{id}")
public ResponseEntity<HttpStatus>deleteBookByid(@PathVariable long id){
propertiesrepo.deleteById(id);
return new ResponseEntity<>(HttpStatus.OK);
}
}
