package fakedb;

import java.util.ArrayList;

public abstract class BaseFakeDB<TDominio> {
    
    protected ArrayList<TDominio> tabela;
    protected ArrayList<TDominio> tabelaSubClasse;
    protected ArrayList<TDominio> tabelaProduto;
        
    public ArrayList<TDominio> getTabela(){
        return this.tabela;
    }

    public ArrayList<TDominio> getTabelaSubClasse(){
        return this.tabelaSubClasse;
    }

    public ArrayList<TDominio> getTabelaProduto(){
        return this.tabelaProduto;
    }
    

    //1 - metodos abstract nao podem ter codigo
    //2 - metodos abstract devem ser implementados (ou codificados) nas classes filhas (reais)
    //3 - este método deve ser executado toda a vez que a classe filha for instanciada
    public abstract void preencherDados();

    //construtor pro metodo acima preencherdados
    public BaseFakeDB(){
        this.preencherDados();
    }

}
