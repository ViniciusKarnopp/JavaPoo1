package fakedb;

import java.util.ArrayList;

public abstract class BaseFakeDBFuncionario<T> {
    protected ArrayList<T> tabelaFuncionario;

    //get da tabela dos funcionarios
    public ArrayList<T> getTabelaFuncionario(){
        return this.tabelaFuncionario;
    }
    //metodo que preenche os dados
    public abstract void preencherDados();

    //construtor pro metodo acima
    public BaseFakeDBFuncionario(){
        this.preencherDados();
    }
}
