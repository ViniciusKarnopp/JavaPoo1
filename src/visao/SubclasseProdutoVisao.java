package visao;
import servico.SubclasseProdutoServico;

import java.util.ArrayList;

import dominio.SubclasseProduto;

public class SubclasseProdutoVisao {

    private SubclasseProdutoServico servico;

    public SubclasseProdutoVisao(){
        this.servico = new SubclasseProdutoServico();
    }

    public void Adicionar(SubclasseProduto add){
        this.servico.Adicionar(add);
    }

    public void Exibir(){
        ArrayList<SubclasseProduto> lista = this.servico.Navegar();
        for (SubclasseProduto imprimir : lista) {
            this.ImprimirPorLinha(imprimir);
        }
    }

    private void ImprimirPorLinha(SubclasseProduto imprimir){
        String mensagem = "";
        mensagem += "Codigo da Classe Pai: " + imprimir.getCodigoClasse() + " | ";
        mensagem += "Codigo da Sub Classe: " + imprimir.getCodigo() + " | ";
        mensagem += "Descricao: " + imprimir.getDescricao() + " | ";
        mensagem+= "Data de inclusão: " + imprimir.getDataDeInclusao();
        System.out.println(mensagem);
        System.out.println("=========================================================================================");
        System.out.println();
    }

    // private void Imprimir(SubclasseProduto imprimir){
    //     System.out.println("Código da classe pai: " + imprimir.getCodigoClasse());
    //     System.out.println("Codigo: " + imprimir.getCodigo());
    //     System.out.println("Descricao: " + imprimir.getDescricao());
    //     System.out.println("Data de inclusao: " + imprimir.getDataDeInclusao());
    //     System.out.println("=================================================================");
    //     System.out.println();
    // }

}
