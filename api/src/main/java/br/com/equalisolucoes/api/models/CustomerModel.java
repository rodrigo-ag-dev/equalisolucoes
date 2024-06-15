package br.com.equalisolucoes.api.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="CUSTOMERS")
public class CustomerModel extends CustomerBase {
  @Column
  protected Long city_id;
}