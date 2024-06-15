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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.equalisolucoes.api.models.CustomerModel;
import br.com.equalisolucoes.api.models.CustomerModelGet;
import br.com.equalisolucoes.api.repositories.CustomerRepository;
import br.com.equalisolucoes.api.repositories.CustomerRepositoryGet;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {
  @Autowired
  private CustomerRepository customerRepository;
  @Autowired
  private CustomerRepositoryGet customerRepositoryGet;

  @GetMapping("/{id}")
  public ResponseEntity<Optional<CustomerModelGet>> get(@PathVariable Long id) {
    Optional<CustomerModelGet> customer = customerRepositoryGet.findById(id);
    if (customer.isEmpty())
      return ResponseEntity.notFound().build();
    return new ResponseEntity<Optional<CustomerModelGet>>(customer, HttpStatus.OK);
  }

  @GetMapping("/name/{name}")
  public ResponseEntity<List<CustomerModelGet>> getName(@PathVariable String name) {
    List<CustomerModelGet> customer = customerRepositoryGet.findByName(name);
    if (customer.isEmpty())
      return ResponseEntity.notFound().build();
    return new ResponseEntity<List<CustomerModelGet>>(customer, HttpStatus.OK);
  }

  @GetMapping("/address/{address}")
  public ResponseEntity<List<CustomerModelGet>> getAddress(@PathVariable String address) {
    List<CustomerModelGet> customer = customerRepositoryGet.findByAddress(address);
    if (customer.isEmpty())
      return ResponseEntity.notFound().build();
    return new ResponseEntity<List<CustomerModelGet>>(customer, HttpStatus.OK);
  }

  @GetMapping("/list")
  public ResponseEntity<List<CustomerModelGet>> list() {
    List<CustomerModelGet> customer = customerRepositoryGet.findAll(Sort.by(Sort.Direction.ASC, "id"));
    if (customer.isEmpty())
      return ResponseEntity.notFound().build();
    return new ResponseEntity<List<CustomerModelGet>>(customer, HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> delete(@PathVariable Long id) {
    Optional<CustomerModel> customer = customerRepository.findById(id);
    if (customer.isEmpty())
      return ResponseEntity.notFound().build();
    customerRepository.deleteById(id);
    return ResponseEntity.ok().build();
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Optional<CustomerModelGet> post(@RequestBody CustomerModel customerModel) {
    CustomerModel customer = customerRepository.save(customerModel);
    return customerRepositoryGet.findById(customer.getId());
  }
}
