package br.com.equalisolucoes.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.equalisolucoes.api.models.CityModel;

public interface CityRepository extends JpaRepository<CityModel, Long> {

}
