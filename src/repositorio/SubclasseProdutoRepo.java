package repositorio;
import dominio.SubclasseProduto;
import fakedb.SubclasseProdutoFakeDB;

public class SubclasseProdutoRepo extends BaseRepositorio<SubclasseProduto> {

    private SubclasseProdutoFakeDB db;

    public SubclasseProdutoRepo(){
        this.db = new SubclasseProdutoFakeDB();
        this.dados = this.db.getTabelaSubClasse();
    }

    @Override
    public SubclasseProduto Read(int chave) {
        for (SubclasseProduto iteravel : dados) {
            if(chave == iteravel.getCodigo()){
                return iteravel;
            }
        }
        return null;
    }

    @Override
    public SubclasseProduto Edit(SubclasseProduto instancia) {
        SubclasseProduto ler = this.Read(instancia.getCodigo());
        if(ler != null){
            ler.setDescricao(instancia.getDescricao());
            return ler;
        }
        return null;
    }

    @Override
    public SubclasseProduto Add(SubclasseProduto instancia) {
        SubclasseProduto adicionar = this.dados.getLast();
        int proximo = adicionar.getCodigo() + 1;
        instancia.setCodigo(proximo);
        this.dados.add(instancia);

        return instancia;
    }

    @Override
    public SubclasseProduto Delete(int chave) {
        SubclasseProduto ler = this.Read(chave);
        if(ler != null){
            this.dados.remove(ler);
            return ler;
        }

        return null;
    }

}
