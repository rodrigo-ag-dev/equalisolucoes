package br.com.equalisolucoes.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class CustomerBase {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  protected Long id;
  @Column(length = 100)
  protected String name;
  @Column(length = 200)
  protected String address; 
  @Column(length = 60)
  protected String district;
  protected Integer number;
  protected Integer post_code; 
  @Column(length = 30)
  protected String document;
}