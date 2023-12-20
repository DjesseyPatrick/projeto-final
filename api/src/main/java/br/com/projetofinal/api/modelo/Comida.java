package br.com.projetofinal.api.modelo;

import lombok.Getter;
import lombok.Setter;
import lombok.Entity;
@Getter
@Setter
@Entity

public class Comida {
  private Long id;
private String nome;
private Double preço;
private Double quantidade;
}
