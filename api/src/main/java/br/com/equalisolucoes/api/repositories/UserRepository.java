package br.com.equalisolucoes.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.equalisolucoes.api.models.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long> {

}