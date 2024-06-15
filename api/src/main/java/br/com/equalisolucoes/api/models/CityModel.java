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
@Table(name = "CITIES")
public class CityModel {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private Long id;
  @Column(length = 60)
  private String name;
  @Column(length = 2)
  protected String state;
}
