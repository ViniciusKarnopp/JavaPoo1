package servico;

import java.util.ArrayList;

import dominio.SubclasseProduto;
import repositorio.SubclasseProdutoRepo;

public class SubclasseProdutoServico extends BaseServico<SubclasseProduto> {

    private SubclasseProdutoRepo repositorio;

    public SubclasseProdutoServico(){
        this.repositorio = new SubclasseProdutoRepo();
    }

    @Override
    public ArrayList<SubclasseProduto> Navegar() {
        return this.repositorio.Browse();
    }

    @Override
    public SubclasseProduto Ler(int chave) {
        return this.repositorio.Read(chave);
    }

    @Override
    public SubclasseProduto Editar(SubclasseProduto obj) {
        return this.repositorio.Edit(obj);
    }

    @Override
    public SubclasseProduto Adicionar(SubclasseProduto obj) {
        return this.repositorio.Add(obj);
    }

    @Override
    public SubclasseProduto Deletar(int chave) {
        return this.repositorio.Delete(chave);
    }

}
