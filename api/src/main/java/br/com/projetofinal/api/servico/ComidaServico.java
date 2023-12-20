package br.com.projetofinal.api.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.projetofinal.api.modelo.Comida;
import br.com.projetofinal.api.modelo.Mensagem;
import br.com.projetofinal.api.repositorio.ComidaRepositorio;

@Service
public class ComidaServico {
    @Autowired
    private Mensagem msg;
    @Autowired
    private ComidaRepositorio repositorio;

    public ResponseEntity<?> cadastrar(Comida comida) {
        if (comida.getNome().isEmpty() || comida.getNome() == null) {
            msg.setMensagem("Insira o nome da comida");
            return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
        }
        if (comida.getPreco() == null || comida.getPreco() < 0) {
            msg.setMensagem("Insira um preço válido");
            return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
        }
        if (comida.getQuantidade() == null || comida.getQuantidade() < 0) {
            msg.setMensagem("Insira uma quantidade válido");
            return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
        }
        repositorio.save(comida);
        return new ResponseEntity<>(comida, HttpStatus.CREATED);
    }
}
