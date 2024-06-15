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

import br.com.equalisolucoes.api.models.UserModel;
import br.com.equalisolucoes.api.repositories.UserRepository;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
  @Autowired
  private UserRepository userRepository;

  @GetMapping("list")
  public ResponseEntity<List<UserModel>> get() {
    List<UserModel> cities = userRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    if (cities.isEmpty())
      return ResponseEntity.notFound().build();
    return new ResponseEntity<List<UserModel>>(cities, HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> delete(@PathVariable Long id) {
    Optional<UserModel> customer = userRepository.findById(id);
    if (customer.isEmpty())
      return ResponseEntity.notFound().build();
    userRepository.deleteById(id);
    return ResponseEntity.ok().build();
  }

  @PostMapping
  public UserModel post(@RequestBody UserModel userModel) {
    var user = userRepository.save(userModel);
    return user;
  }

}
