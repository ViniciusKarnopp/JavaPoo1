package fakedb;

import java.util.ArrayList;

import dominio.ClasseFuncionario;

public class FuncionarioFakeDB extends BaseFakeDBFuncionario<ClasseFuncionario>{

    @Override
    public void preencherDados() {
        if(this.tabelaFuncionario == null){
            this.tabelaFuncionario = new ArrayList<>();
        }
        this.tabelaFuncionario.add(new ClasseFuncionario(1, "Vinicius", "Administrador", 9850.00, "viniciuskarnopp777@hotmail.com", "(67) 9 9715-9992"));
    }

    public FuncionarioFakeDB(){
        super();
    }
    
}
