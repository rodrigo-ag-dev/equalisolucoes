package br.com.equalisolucoes.api.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="CUSTOMERS")
public class CustomerModelGet extends CustomerBase {
  @ManyToOne
  @JoinColumn(name = "city_id")
  protected CityModel city;
}