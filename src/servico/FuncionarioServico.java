package servico;

import java.util.ArrayList;

import dominio.ClasseFuncionario;
import repositorio.FuncionarioRepositorio;

public class FuncionarioServico extends BaseServico<ClasseFuncionario>{

    private FuncionarioRepositorio repositorio;

    public FuncionarioServico(){
        this.repositorio = new FuncionarioRepositorio();
    }

    @Override
    public ArrayList<ClasseFuncionario> Navegar() {
        return this.repositorio.Browse();
    }

    @Override
    public ClasseFuncionario Ler(int chave) {
        return this.repositorio.Read(chave);
    }

    @Override
    public ClasseFuncionario Editar(ClasseFuncionario obj) {
        return this.repositorio.Edit(obj);
    }

    @Override
    public ClasseFuncionario Adicionar(ClasseFuncionario obj) {
        return this.repositorio.Add(obj);
    }

    @Override
    public ClasseFuncionario Deletar(int chave) {
        return this.repositorio.Delete(chave);
    }
    
}
