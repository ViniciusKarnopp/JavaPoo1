package fakedb;
import java.time.LocalDate;
import java.util.ArrayList;

import dominio.SubclasseProduto;

public class SubclasseProdutoFakeDB extends BaseFakeDB<SubclasseProduto>{

    @Override
    public void preencherDados(){
        if(this.tabelaSubClasse == null){
            this.tabelaSubClasse = new ArrayList<>();
        }
        this.tabelaSubClasse.add(new SubclasseProduto(1, "Suíno", LocalDate.now(), 1));
        this.tabelaSubClasse.add(new SubclasseProduto(2, "Bovino", LocalDate.now(), 1));
        this.tabelaSubClasse.add(new SubclasseProduto(3, "Refrigerante", LocalDate.now(), 2));
        this.tabelaSubClasse.add(new SubclasseProduto(4, "Água", LocalDate.now(), 2));
    }

    public SubclasseProdutoFakeDB(){
        super();
    }

}
