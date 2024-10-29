package visao;

import java.util.ArrayList;
import java.util.InputMismatchException;

import dominio.ClasseFuncionario;
import servico.FuncionarioServico;

public class MenuFuncionario extends BaseMenu {

    private FuncionarioServico srv;

    public MenuFuncionario(){
        super();
        this.srv = new FuncionarioServico();
    }

    @Override
    public void ExibirMenu() {
        String opcao = "0";

        while(!opcao.equals("9")){
            Util.LimparConsole();
            System.out.println("FUNCIONARIOS");
            System.out.println("""
                    1 - Listar
                    2 - Localizar
                    3 - Adicionar
                    4 - Atualizar
                    5 - Remover
                    9 - Sair
                    """);
                    System.out.print("Selecione uma opção: ");
                    opcao = this.scanner.next();

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
                            
                            break;
                    
                        default:
                        System.out.println("""
                                ==============
                                    ERRO
                                ==============
                                Opção Inválida!
                                ==============
                                Pressione Enter
                                para voltar
                                ==============
                                """);
                                this.scanner.nextLine();
                                this.scanner.nextLine();
                            break;
                    }

        }
    }


    @Override
    public void Listar() {
        Util.LimparConsole();

        //verifica se a lista ta vazia
        if(this.CondicaoTamanhoLista() == 0){
            return;
        }
            
        System.out.println("Listando");

        ArrayList<ClasseFuncionario> lista = this.srv.Navegar();
        for (ClasseFuncionario i : lista) {
            this.Imprimir(i);
        }
        System.out.println("Clique ENTER para continuar.");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }

    @Override
    public void Localizar() {
        Util.LimparConsole();

        if(this.CondicaoTamanhoLista() == 0){
            return;
        }

        int codigoFuncionario = this.LerCodigo();

        System.out.println("Localizando");

        ClasseFuncionario funcionario = this.srv.Ler(codigoFuncionario);

        if(funcionario != null){
            this.Imprimir(funcionario);
        }
        else{
            System.out.println("""
                    ============
                        ERRO
                    ============
                    Funcionário não
                    encontrado!
                    """);
        }

    }

    @Override
    public void Adicionar() {
        Util.LimparConsole();
        this.scanner.nextLine();

        ClasseFuncionario novo = this.Cadastro();

        if(this.srv.Adicionar(novo) != null){
            System.out.println("Adicionado com sucesso!\n");
        }
        else{
            System.out.println("""
                    ============
                        ERRO
                    ============
                    Funcionário não
                    encontrado!
                    """);
        }
        
    }

    @Override
    public void Atualizar() {
        Util.LimparConsole();

        //verifica se a lista ta vazia
        if(this.CondicaoTamanhoLista() == 0){
            return;
        }

        int codigo = this.LerCodigo();

        ClasseFuncionario funcionario = this.srv.Ler(codigo);

        if(funcionario != null){

            funcionario = this.Cadastro();
            funcionario.setCodigo(codigo);

            if(this.srv.Editar(funcionario) != null){
                System.out.println("Alteração realizada com sucesso!\n");
            }
            else{
                System.out.println("""
                    ============
                        ERRO
                    ============
                    Registro não
                    alterado!
                    """);
            }

        }
    }

    @Override
    public void Remover() {
        Util.LimparConsole();

        //verifica se a lista ta vazia
        if(this.CondicaoTamanhoLista() == 0){
            return;
        }

        int codigo = this.LerCodigo();

        ClasseFuncionario funcionario = this.srv.Ler(codigo);

        if(funcionario != null){
            this.Imprimir(funcionario);
            //this.scanner.nextLine();
            System.out.print("Tem certeza que deseja remover? \nS - Sim\nN - Não : ");
            String opcaoRemover = this.scanner.nextLine();

            if(opcaoRemover.toLowerCase().equalsIgnoreCase("s")){
                this.srv.Deletar(codigo);
                System.out.println("Removido com sucesso!");
            }
            else{
                System.out.println("Retornando...");
            }
        }
        else{
            System.out.println("""
                    ============
                        ERRO
                    ============
                    Registro não
                    alterado!
                    """);
        }
    }


    private void Imprimir(ClasseFuncionario funcionario){
        String mensagem = "";
        mensagem += "\n======================================================\n";
        mensagem += "Codigo: " + funcionario.getCodigo() + " | ";
        mensagem += "Nome: " + funcionario.getNome() + " | ";
        mensagem += "Cargo: " + funcionario.getCargo() + " | ";
        mensagem += "Salario: " + funcionario.getSalario() + " | ";
        mensagem += "Email: " + funcionario.getEmail() + " | ";
        mensagem += "Telefone: " + funcionario.getTelefone() + " | ";
        mensagem += "\n======================================================\n";
        System.out.println(mensagem);
        System.out.println();
    }

    private int VerificarTamanhoLista(){
        int contador = 0;
        for (ClasseFuncionario i : this.srv.Navegar()) {
            contador ++;
        }
        return contador;
    }

    private int CondicaoTamanhoLista(){
        if(VerificarTamanhoLista() == 0){
            System.out.println("Lista vazia!"); //se a lista tiver vazia retorna 0
            return 0;
        }
        return 1; //se a lista retornar 1, é pq tem elemento
    }

    private double LerDouble(){
        boolean salarioValido = false;
        double salario = 0;

        while(!salarioValido){
            try {
                System.out.print("Digite o salário: ");
                salario = this.scanner.nextDouble();
                this.scanner.nextLine(); //limpar buffer
                salarioValido = true;

            } catch (InputMismatchException e) {
                Util.LimparConsole();
                System.out.println("""
                    TENTE NOVAMENTE!
                    ERRO!!
                    Formato aceito:
                    999,999
                """);
                this.scanner.nextLine();
            }
        }
        return salario;
    }
    
    private int LerCodigo(){
        boolean codigoValido = false;
        int codigo = 0;

        while(!codigoValido){
            try {
                System.out.print("Digite o código do funcionario: ");
                codigo = this.scanner.nextInt();
                this.scanner.nextLine(); //limpar buffer
                codigoValido = true;

            } catch (InputMismatchException e) {
                Util.LimparConsole();
                System.out.println("""
                    TENTE NOVAMENTE!
                    ERRO!!
                    SOMENTE NUMEROS INTEIROS!!
                """);
                this.scanner.nextLine();
            }
        }
        return codigo;
    }

    private ClasseFuncionario Cadastro(){
        ClasseFuncionario funcionario = new ClasseFuncionario();

        System.out.print("Digite o nome: ");
        String nome = this.scanner.nextLine();

        System.out.print("Digite o cargo: ");
        String cargo = this.scanner.nextLine();

        //salario
        double salario = this.LerDouble();

        System.out.print("Digite o email: ");
        String email = this.scanner.nextLine();

        System.out.print("Digite o telefone: ");
        String telefone = this.scanner.nextLine();

        funcionario.setNome(nome);
        funcionario.setCargo(cargo);
        funcionario.setSalario(salario);
        funcionario.setEmail(email);
        funcionario.setTelefone(telefone);

        return funcionario;
    }

}
