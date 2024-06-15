package br.com.equalisolucoes.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.equalisolucoes.api.models.CustomerModel;

public interface CustomerRepository extends JpaRepository<CustomerModel, Long> {
}