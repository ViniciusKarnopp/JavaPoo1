package repositorio;

import dominio.ClasseFuncionario;
import fakedb.FuncionarioFakeDB;

public class FuncionarioRepositorio extends BaseRepositorio<ClasseFuncionario> {

    private FuncionarioFakeDB db;

    public FuncionarioRepositorio(){
        this.db = new FuncionarioFakeDB();
        this.dados = this.db.getTabelaFuncionario();
    }

    @Override
    public ClasseFuncionario Read(int chave) {
        for (ClasseFuncionario i : dados) {
            if(i.getCodigo() == chave){
                return i;
            }
        }
        return null;
    }

    @Override
    public ClasseFuncionario Edit(ClasseFuncionario instancia) {
        ClasseFuncionario funcionarioEdit = this.Read(instancia.getCodigo());
        if(funcionarioEdit != null){
            //editar cargo
            funcionarioEdit.setCargo(instancia.getCargo());
            funcionarioEdit.setSalario(instancia.getSalario());
            funcionarioEdit.setEmail(instancia.getEmail());
            funcionarioEdit.setTelefone(instancia.getTelefone());
            return funcionarioEdit;
        }
        return null;
    }

    @Override
    public ClasseFuncionario Add(ClasseFuncionario instancia) {
        int novoCodigo;
        //se a lista estiver vazia
        if(this.dados.size() == 0){
            novoCodigo = 1;
        }
        //se nao estiver vazia
        else{
            ClasseFuncionario pegarUltimo = this.dados.getLast();
            novoCodigo = pegarUltimo.getCodigo() + 1;
        }
        //setando o codigo 
        instancia.setCodigo(novoCodigo);
        //commit no banco
        this.dados.add(instancia);
        return instancia;
    }

    @Override
    public ClasseFuncionario Delete(int chave) {
        ClasseFuncionario remover = this.Read(chave);
        if(remover != null){
            this.dados.remove(remover);
            return remover;
        }
        return null;
    }    
}
