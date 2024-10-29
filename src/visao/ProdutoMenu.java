package visao;

import dominio.Produto;
import servico.ProdutoServico;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.InputMismatchException;

public class ProdutoMenu extends BaseMenu{

    private ProdutoServico srv;

    public ProdutoMenu(){
        super();
        this.srv = new ProdutoServico(); 
    }

    @Override
    public void ExibirMenu() {

        String opcao = "0";

        while (!opcao.equals("9")) {
            Util.LimparConsole();
            System.out.println("SUB CLASSES DE PRODUTO");
            System.out.println("""
                1 - Listar
                2 - Localizar
                3 - Adicionar
                4 - Atualizar
                5 - Remover
                9 - Sair
                """);
                System.out.print("Selecione uma opção: ");
            opcao = this.scanner.nextLine();

            switch (opcao) {
                case "1":
                    this.Listar();
                    break;

                case "2":
                    this.Localizar();
                    break;

                case "3":
                    this.Adicionar();
                    break;

                case "4":
                    this.Atualizar();
                    break;

                case "5":
                    this.Remover();
                    break;

                case "9":
                    System.out.println("Saindo...");
                    break;
                    
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }

    @Override
    public void Listar() {
        Util.LimparConsole();
        System.out.println("Listando");  

        ArrayList<Produto> lista = this.srv.Navegar();
        for (Produto produto : lista) {
            this.Imprimir(produto);
        }
        System.out.print("Clique ENTER para continuar. ");
        this.scanner.nextLine();
    }

    @Override
    public void Localizar() {
        Util.LimparConsole();
        
        System.out.println("Localizando");

        System.out.printf("Informe o codigo da classe do produto: ");
        int cod = this.scanner.nextInt();

        Produto cp = this.srv.Ler(cod);

        if (cp != null) {
            this.Imprimir(cp);
        }
        else{
            System.out.println("""
                    =======ERRO=======
                     Classe de Produto
                     não encontrada!!
                    ==================
                    """);
        }

        System.out.print("Clique ENTER para continuar. ");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }

    @Override
    public void Adicionar() {
        Util.LimparConsole();
        System.out.println("Adicionando");

        int codigo = 0;
        boolean codigoValido = false;

        while(!codigoValido){
            try {
                System.out.printf("Informe o código da sub classe pai: ");
                codigo = this.scanner.nextInt();
                this.scanner.nextLine();
                codigoValido = true;
            } catch (InputMismatchException e) {
                Util.LimparConsole();
                System.out.println("ERRO! Digite somente números inteiros!");
                this.scanner.nextLine();
            }
        }

        System.out.printf("Informe a descrição: ");
        String descricao = this.scanner.next();

        Produto cp = new Produto();
        cp.setCodigoSubclasse(codigo);
        cp.setDescricao(descricao);
        cp.setDataDeInclusao(LocalDate.now());

        //Produto cpnovo = this.srv.Adicionar(cp);

        if(this.srv.Adicionar(cp) != null){
            System.out.println("Classe de Produto adicionada com sucesso!");
        }
        else{
            System.out.println("""
                    =======ERRO=======
                     Classe de Produto
                     não adicionada!!
                    ==================
                    """);
        }

        System.out.println("Clique ENTER para continuar. ");
        this.scanner.nextLine();
    }

    @Override
    public void Atualizar() {
        Util.LimparConsole();
        System.out.println("Atualizando");

        System.out.printf("Informe o codigo da classe do produto: ");
        int cod = this.scanner.nextInt();

        Produto cp = this.srv.Ler(cod);

        if (cp != null) {
            System.out.println("Informe a nova descrição: ");
            String descricao = this.scanner.next();
            cp.setDescricao(descricao);

            if(this.srv.Editar(cp) != null){//se devolveu diferente de nulo é pq deu certo
                System.out.println("Alteração realizada com sucesso!");
            }
            else{
                System.out.println("""
                    =======ERRO=======
                     Classe de Produto
                       não alterada!!
                    ==================
                    """);
            }
        }
        else{
            System.out.println("""
                    =======ERRO=======
                     Classe de Produto
                     não encontrada!!
                    ==================
                    """);
        }
        System.out.print("Clique ENTER para continuar. ");
        this.scanner.nextLine();
        this.scanner.nextLine();
}

    @Override
    public void Remover() {
        Util.LimparConsole();
        System.out.println("Removendo"); 
        
        System.out.printf("Informe o codigo da classe do produto: ");
        int cod = this.scanner.nextInt();

        Produto cp = this.srv.Ler(cod);

        if(cp != null){
            if(this.srv.Deletar(cod) != null){
                System.out.println("Removido com sucesso!");
            }
            else{
                System.out.println("""
                    =======ERRO=======
                     Classe de Produto
                     não encontrada!!
                    ==================
                    """);
            }
        }

        System.out.print("Clique ENTER para continuar. ");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }
    
    private void Imprimir(Produto objeto){
        String mensagem = "";
        mensagem += "Código da Sub Classe: " + objeto.getCodigoSubclasse() + " | ";
        mensagem += "Codigo do Produto: " + objeto.getCodigo() + " | ";
        mensagem += "Descricao: " + objeto.getDescricao() + " | ";
        mensagem += "Valor: " + objeto.getValor() + " | ";
        mensagem += "Data de inclusão: " + objeto.getDataDeInclusao() + " | ";
        System.out.println(mensagem);
        System.out.println("=========================================================================================");
        System.out.println();
    }
}
