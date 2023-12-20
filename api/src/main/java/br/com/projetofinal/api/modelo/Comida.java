package br.com.projetofinal.api.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Comidas")

public class Comida {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String nome;
private Double preco;
private Double quantidade;
}
