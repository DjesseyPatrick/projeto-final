import { Component, OnInit } from '@angular/core';
import { Comida } from '../modelo/comida';
import { ComidaService } from '../servico/comida.service';

@Component({
  selector: 'app-principal',
  templateUrl: './principal.component.html',
  styleUrls: ['./principal.component.css']
})
export class PrincipalComponent  implements OnInit{
  comida = new Comida();
  comidas: Comida[] = [];
  btnCadastro: Boolean = true;
  tabela: Boolean = true;

  constructor(private servico: ComidaService) { }
  ngOnInit(): void {
      this.selecionar();
  }
  selecionar(): void {
    this.servico.selecionar().subscribe(
      resposta => this.comidas = resposta
    )
  }

  cadastrar(): void {
    this.servico.cadastrar(this.comida).subscribe(
      resposta => {
        this.comidas.push(resposta);
        this.comida = new Comida();
        alert("Comida cadastrada com sucesso");
      }
    )
  }
  selecionarComida(posicao: number): void {
    this.comida = this.comidas[posicao];
    this.btnCadastro = false;
    this.tabela = false;
  }

  editar(): void {
    this.servico.editar(this.comida).subscribe(
      resposta => {
        let posicao = this.comidas.findIndex(c => {
          return c.id == resposta.id
        });

        this.comidas[posicao] = resposta;
        this.comida = new Comida();
        this.btnCadastro = true;
        this.tabela = true;
        alert("Comida alterada com sucesso");
      }
    )
  }
  remover(): void {
    this.servico.remover(this.comida.id).subscribe(
      resposta => {
        let posicao = this.comidas.findIndex(c => {
          return c.id == this.comida.id
        });
        this.comidas.splice(posicao, 1);
        this.comida = new Comida();
        this.btnCadastro = true;
        this.tabela = true;
        alert("Comida removida com sucesso");

      }
    )

  }

  cancelar(): void {
    this.comida = new Comida();
    this.btnCadastro = true;
    this.tabela = true;

  }

}
