package br.com.projetofinal.api.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.projetofinal.api.modelo.Comida;

@Repository
public interface ComidaRepositorio extends JpaRepository<Comida, Long> {
    
}
