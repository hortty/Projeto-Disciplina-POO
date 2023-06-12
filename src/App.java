import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Exceptions.PessoaNaoExisteException;
import Exceptions.ValidacaoPessoaException;

public class App {
    public static void main(String[] args) throws Exception {
        List<Pessoa> pessoas = new ArrayList<>();
        Biblioteca biblioteca = new Biblioteca();

        // criado instancias de "clientes exemplo" e adicionados na lista de Pessoas
        long cpf_cliente = 11111111111L;
        for(int i=1;i<21;i++)
        {
            cpf_cliente = cpf_cliente + i;
            pessoas.add(new Cliente("cliente"+ Integer.toString(i), i+20, "endereco" + Integer.toString(i), cpf_cliente, "email@gmail.com", i));
        }

        // criado instancias de "funcionarios exemplo" e adicionados na lista de Pessoas
        long cpf_funcionario = 22222222222L;
        for(int i=1;i<11;i++)
        {
            cpf_funcionario = cpf_funcionario + i;
            pessoas.add(new Funcionario("funcionario"+ Integer.toString(i), i+20, "endereco" + Integer.toString(i), cpf_funcionario, "email@library.com.br", "vendedor", 2000));
        }

        // realizada validação dos campos, utilizando chamada polimórfica
        boolean validar_email = false;
        boolean validar_idade = false;

        List<Cliente> clientes = new ArrayList<>();
        List<Funcionario> funcionarios = new ArrayList<>();

        int cliente_index = 0;
        int funcionario_index = 0;

        for (Pessoa pessoa : pessoas) 
        {
            validar_email = false;
            validar_idade = false;
            // função de validação é diferente pro cliente e pro funcionario
            validar_email = pessoa.validarEmail();
            validar_idade = pessoa.validarIdade();
            if(validar_email && validar_idade)
            {
                if(pessoa instanceof Cliente)
                {
                    try
                    {
                        clientes.add(cliente_index, (Cliente)pessoa);
                    }
                    catch(Exception e )
                    {
                        System.out.println(e.getMessage());
                    }
                    cliente_index++;
                    System.out.println("Cliente: " + pessoa.getNome() + ", CPF: " + pessoa.getCpf() + " adicionado." );
                }
                else if(pessoa instanceof Funcionario)
                {
                    try
                    {
                        funcionarios.add(funcionario_index, (Funcionario)pessoa);
                    }
                    catch(Exception e )
                    {
                        System.out.println(e.getMessage());
                    }
                    funcionario_index++;
                    System.out.println("Funcionario: " + pessoa.getNome() + ", CPF: " + pessoa.getCpf() + " adicionado." );
                }
                else 
                {
                    throw new PessoaNaoExisteException("Essa pessoa deve ser um funcionário ou um cliente!!!");
                }
                System.out.println("\n");
            }
            else 
            {
                throw new ValidacaoPessoaException("A pessoa " + pessoa.getNome() + " não passou na validação!");
            }
        }

        // criação exemplo da entidade livro
        List<Livro> livros = new ArrayList<>();
        for(int i=1;i<6;i++)
        {
            livros.add(new Livro("livro"+ Integer.toString(i), "autor"+ Integer.toString(i), "editora" + Integer.toString(i), i*30));
        }

        // criação exemplo da entidade Emprestimo
        List<Emprestimo> emprestimos = new ArrayList<>();
        for(int i=1;i<6;i++)
        {
            try
            {
                emprestimos.add(new Emprestimo(livros.get(i-1), clientes.get(i-1), LocalDate.now()));
            }
            catch(Exception e )
            {
                System.out.println(e.getMessage());
            }
        }

        // CADASTRO DE CLIENTE, LIVRO E EMPRESTIMOS DE EXEMPLO, NO AMBIENTE DA BIBLIOTECA
        for (Cliente cliente : clientes)
        {
            biblioteca.cadastrarCliente(cliente);
        } 

        for (Livro livro : livros)
        {
            biblioteca.adicionarLivro(livro);
        } 

        for (Emprestimo emprestimo : emprestimos)
        {
            biblioteca.adicionarEmprestimo(emprestimo);
        } 

        // sistema de Menu
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 6) {
            System.out.println("\n----- Menu da Biblioteca -----\n");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Adicionar Livro");
            System.out.println("3. Realizar Emprestimo");
            System.out.println("4. Realizar Devolucao");
            System.out.println("5. Listar Livros");
            System.out.println("7. Listar Clientes");
            System.out.println("8. Listar Emprestimos");
            System.out.println("9. Gravar MidiaDigital Livro");
            System.out.println("10. Salvar/Serializar Livro no disco");
            System.out.println("11. Carregar o Livro do disco e mostrar na tela");
            System.out.println("6. Sair");
            System.out.print("\nEscolha uma opcao: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    // Cadastrar Cliente
                    System.out.print("Nome do cliente: ");
                    String nomeCliente = scanner.nextLine();
                    System.out.print("idade do cliente: ");
                    int idade = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("endereco do cliente: ");
                    String endereco = scanner.nextLine();
                    System.out.print("cpf do cliente: ");
                    long cpf = scanner.nextLong();
                    scanner.nextLine();
                    System.out.print("email do cliente: ");
                    String email = scanner.nextLine();
                    System.out.print("numeroIdentificacao do cliente: ");
                    int numeroIdentificacao = scanner.nextInt();

                    Cliente cliente = new Cliente(nomeCliente,  idade,  endereco,  cpf,  email,  numeroIdentificacao);
                    biblioteca.cadastrarCliente(cliente);
                    System.out.println("Cliente cadastrado com sucesso!");
                    break;

                case 2:
                    // Adicionar Livro
                    System.out.print("Título do livro: ");
                    String tituloLivro = scanner.nextLine();
                    System.out.print("Autor do livro: ");
                    String autorLivro = scanner.nextLine();
                    System.out.print("Editora do livro: ");
                    String editoraLivro = scanner.nextLine();
                    System.out.print("Número de páginas do livro: "); 
                    int numPaginas = scanner.nextInt();
                    scanner.nextLine();

                    Livro livro_temp = new Livro(tituloLivro, autorLivro, editoraLivro, numPaginas);
                    biblioteca.adicionarLivro(livro_temp);
                    System.out.println("Livro adicionado com sucesso!");
                    break;

                case 3:
                    // Realizar Empréstimo
                    System.out.print("Nome do cliente: ");
                    String nomeClienteEmprestimo = scanner.nextLine();
                    // Localiza o cliente na lista de clientes da biblioteca
                    Cliente clienteEmprestimo = biblioteca.localizarCliente(nomeClienteEmprestimo);
                    if (clienteEmprestimo == null) {
                        System.out.println("Cliente não encontrado.");
                        break;
                    }
                    System.out.print("Título do livro: ");
                    String tituloLivroEmprestimo = scanner.nextLine();
                    // Localiza o livro na lista de livros da biblioteca
                    Livro livroEmprestimo = biblioteca.localizarLivro(tituloLivroEmprestimo);
                    if (livroEmprestimo == null) {
                        System.out.println("Livro não encontrado.");
                        break;
                    }
                    boolean emprestimoRealizado = biblioteca.realizarEmprestimo(clienteEmprestimo, livroEmprestimo);
                    if (emprestimoRealizado) {
                        System.out.println("Empréstimo realizado com sucesso!");
                    }
                    else {
                        System.out.println("Não foi possível realizar o empréstimo!");
                    }
                    break;

                case 4:
                    // Realizar Devolução
                    System.out.print("Nome do cliente: ");
                    String nomeClienteDevolucao = scanner.nextLine();

                    Cliente clienteDevolucao = biblioteca.localizarCliente(nomeClienteDevolucao);
                    if (clienteDevolucao == null) {
                        System.out.println("Cliente não encontrado.");
                        break;
                    }
                    System.out.print("Título do livro: ");
                    String tituloLivroDevolucao = scanner.nextLine();

                    Livro livroDevolucao = biblioteca.localizarLivro(tituloLivroDevolucao);
                    if (livroDevolucao == null) {
                        System.out.println("Livro não encontrado.");
                        break;
                    }
                    biblioteca.realizarDevolucao(clienteDevolucao, livroDevolucao);
                    System.out.println("Devolução realizada com sucesso!");
                    break;

                case 5:
                    biblioteca.listarLivros();
                    break;

                case 6:
                    System.out.println("Saindo do programa...");
                    break;

                case 7:
                    biblioteca.listarClientes();
                    System.out.println("Saindo do programa...");
                    break;

                case 8:
                    biblioteca.listarEmprestimos();
                    System.out.println("Saindo do programa...");
                    break;

                case 9:
                // ler arquivo.txt
                    System.out.println("Selecione o titulo de um livro da lista para injetar conteúdo");
                    biblioteca.listarLivros();

                    System.out.print("Título do livro: ");
                    String tituloLivroTemp = scanner.nextLine();

                    Livro livroLocalizado = biblioteca.localizarLivro(tituloLivroTemp);

                    try {
                        System.out.println("Inserindo...");
                        File arquivo = new File("arquivo.txt");
                        Scanner scanner_arquivo = new Scanner(arquivo);

                        StringBuilder texto = new StringBuilder();
                        while (scanner_arquivo.hasNextLine()) {
                            String linha = scanner_arquivo.nextLine();
                            texto.append(linha).append("\n");
                        }

                        scanner_arquivo.close();
                        biblioteca.removerLivro(livroLocalizado);

                        livroLocalizado.setTextoMidiaDigital(texto.toString());

                        System.out.println("Lendo arquivo...\n");
                        System.out.println(livroLocalizado.getTextoMidiaDigital());

                        biblioteca.adicionarLivro(livroLocalizado);

                    } catch (Exception e) {
                        System.out.println("Arquivo não encontrado: " + e.getMessage());
                    }

                    break;

                case 10:
                // serializar o Livro
                    System.out.println("Selecione o titulo de um livro da lista para salva-lo!");
                    biblioteca.listarLivros();

                    System.out.print("Título do livro: ");
                    String tituloLivroTempSalvar = scanner.nextLine();

                    Livro livroSalvar = biblioteca.localizarLivro(tituloLivroTempSalvar);

                    Livro.salvarLivro(livroSalvar, "livro.ser");

                    break;

                case 11:
                // mostrar livro na tela
                    Livro livroSalvo = Livro.carregarLivro("livro.ser");
        
                    if (livroSalvo != null) {
                        System.out.println(" ## Lendo o Livro que foi Salvo ## ");
                        System.out.println("Título: " + livroSalvo.getTitulo());
                        System.out.println("Autor: " + livroSalvo.getAutor());
                        System.out.println("Editora: " + livroSalvo.getEditora());
                    }

                    break;

                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                    break;
            }
        }

        scanner.close();
    }
}
