package br.com.projetofinal.api.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetofinal.api.modelo.Comida;
import br.com.projetofinal.api.repositorio.ComidaRepositorio;
import br.com.projetofinal.api.servico.ComidaServico;

@RestController
@CrossOrigin("*")
@RequestMapping("/comida")
public class ComidaControle {
    @Autowired
    private ComidaServico servico;

    @Autowired
    private ComidaRepositorio repositorio;
    @PostMapping()
    public ResponseEntity<?> cadastrar(@RequestBody Comida comida) {
        return servico.cadastrar(comida);
    }
    
    @GetMapping()
    public Iterable<Comida> listar() {
        return repositorio.findAll();
    }
    @PutMapping()
    public Comida editar(@RequestBody Comida comida) {
        return repositorio.save(comida);    
    }
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        repositorio.deleteById(id);

    }
}
