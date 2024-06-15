package br.com.equalisolucoes.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "USERS")
public class UserModel {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private Long id;
  @Column(length = 100)
  private String name;
  @Column(length = 200)
  private String email;
  @Column(length = 50)
  private String password;
}
