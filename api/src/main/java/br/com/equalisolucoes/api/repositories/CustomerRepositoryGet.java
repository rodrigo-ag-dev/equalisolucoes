package br.com.equalisolucoes.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.equalisolucoes.api.models.CustomerModelGet;

public interface CustomerRepositoryGet extends JpaRepository<CustomerModelGet, Long> {
  @Query(value = "select * from customers c where c.name ilike concat('%', ?1,'%')", nativeQuery = true)
  List<CustomerModelGet> findByName(String name);

  @Query(value = "select * from customers c where c.address ilike concat('%', ?1,'%')", nativeQuery = true)
  List<CustomerModelGet> findByAddress(String address);
}