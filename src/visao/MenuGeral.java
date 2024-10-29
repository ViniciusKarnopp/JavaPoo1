package visao;

import java.util.Scanner;

public class MenuGeral {
    
    private ClasseProdutoMenu classeProduto;
    private SubclasseProdutoMenu subClasseProduto;
    private ProdutoMenu produto;
    private MenuFuncionario funcionario;
    
    private Scanner scanner = new Scanner(System.in);
    
    public MenuGeral(){
        this.classeProduto = new ClasseProdutoMenu();
        this.subClasseProduto = new SubclasseProdutoMenu();
        this.produto = new ProdutoMenu();
        this.funcionario = new MenuFuncionario();
    }

    public void ExibirMenu(){
        String opcao = "";

        while(!opcao.equals("9")){
            Util.LimparConsole();
            System.out.println("MENU DE OPÇÕES");
            System.out.println("""
                1 - Classe de Produto
                2 - Sub Classe de Produto
                3 - Produto
                4 - Funcionário
                9 - Sair
                """);
            System.out.print("Selecione uma opção: ");
            opcao = this.scanner.nextLine();

            switch (opcao) {
                case "1":
                    this.classeProduto.ExibirMenu();
                    break;
                    
                case "2":
                    this.subClasseProduto.ExibirMenu();
                    break;

                case "3":
                    this.produto.ExibirMenu();
                    break;

                case "4":
                    this.funcionario.ExibirMenu();
                    break;

                case "9":
                    System.out.println("Saindo...");
                    break;
            
                default:
                    System.out.println("Opção Inválida. Tente novamente.");
                    break;
            }
        }
    }
}