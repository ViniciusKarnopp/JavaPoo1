import dominio.*;
import visao.*;
import java.time.LocalDate;

public class App {
    public static void main(String[] args) throws Exception {
        ClasseProdutoVisao visaoClasseProduto = new ClasseProdutoVisao();
        SubclasseProdutoVisao visaoSubClasseProduto = new SubclasseProdutoVisao();
        ProdutoVisao visaoProduto = new ProdutoVisao();

        //Classe Produto

        visaoClasseProduto.ExibirPorLinha();

        ClasseProduto editar = new ClasseProduto();
        editar.setCodigo(0);
        editar.setDescricao("Editado");
        editar.setDataDeInclusao(LocalDate.now());
        visaoClasseProduto.Editar(3, editar);

        visaoClasseProduto.Criar(editar);

        visaoClasseProduto.Remover(2);

        System.out.println();
        System.out.println();

        visaoClasseProduto.ExibirPorLinha();

        //Sub Classe Produto
        System.out.println("Sub Classes: ");

        System.out.println();
        System.out.println();

        SubclasseProduto novoSubClasseProduto = new SubclasseProduto();
        novoSubClasseProduto.setCodigoClasse(4);
        novoSubClasseProduto.setDescricao("Em cacho");
        novoSubClasseProduto.setDataDeInclusao(LocalDate.now());
        visaoSubClasseProduto.Adicionar(novoSubClasseProduto);

        visaoSubClasseProduto.Exibir();

        //Produto
        System.out.println("Produtos: ");

        System.out.println();
        System.out.println();

        visaoProduto.Exibir();
    }
}