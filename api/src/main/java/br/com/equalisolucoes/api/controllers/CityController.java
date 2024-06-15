package br.com.equalisolucoes.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.equalisolucoes.api.models.CityModel;
import br.com.equalisolucoes.api.repositories.CityRepository;

@RestController
@RequestMapping("api/v1/cities")
public class CityController {
  @Autowired
  private CityRepository cityRepository;

  @GetMapping("list")
  public ResponseEntity<List<CityModel>> get() {
    List<CityModel> cities = cityRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    if (cities.isEmpty())
      return ResponseEntity.notFound().build();
    return new ResponseEntity<List<CityModel>>(cities, HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> delete(@PathVariable Long id) {
    Optional<CityModel> customer = cityRepository.findById(id);
    if (customer.isEmpty())
      return ResponseEntity.notFound().build();
    cityRepository.deleteById(id);
    return ResponseEntity.ok().build();
  }

  @PostMapping
  public CityModel post(@RequestBody CityModel cityModel) {
    var city = cityRepository.save(cityModel);
    return city;
  }
}