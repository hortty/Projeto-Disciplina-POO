import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Interfaces.ICliente;
import Interfaces.ILivro;

public class Biblioteca {
    private List<ILivro> livros;
    private List<ICliente> clientes;
    private List<Emprestimo> listaEmprestimos;

    public Biblioteca() {
        livros = new ArrayList<>();
        clientes = new ArrayList<>();
        listaEmprestimos = new ArrayList<>();
    }

    public void adicionarEmprestimo(Emprestimo emprestimo) {
        listaEmprestimos.add(emprestimo);
    }

    public void removerEmprestimo(Emprestimo emprestimo) {
        listaEmprestimos.remove(emprestimo);
    }
    
    public void adicionarLivro(ILivro livro) {
        livros.add(livro);
    }
    
    public void removerLivro(ILivro livro) {
        livros.remove(livro);
    }
    
    public void cadastrarCliente(ICliente cliente) {
        clientes.add(cliente);
    }
    
    public boolean realizarEmprestimo(Cliente cliente, Livro livro) {
        
        // verifica se aqueles objetos pertencem a lista
        if (livros.contains(livro) && clientes.contains(cliente)) {
            // faz o emprestimo do livro para o cliente
            cliente.emprestarLivro(livro);
            listaEmprestimos.add(new Emprestimo(livro, cliente, LocalDate.now()));
            return true;

        } else {
            System.out.println("Livro ou cliente não encontrado. Não foi possível realizar o emprestimo.");
            return false;
        }
    }
    
    public void realizarDevolucao(Cliente cliente, Livro livro) {

        if (livros.contains(livro) && clientes.contains(cliente)) {
            cliente.devolverLivro(livro);

            Emprestimo emprestimo_temp = null;

            for (Emprestimo emprestimo : listaEmprestimos) 
            {
                if(emprestimo.getCliente().getNumeroIdentificacao() == cliente.getNumeroIdentificacao() 
                    && emprestimo.getLivro().getTitulo() == livro.getTitulo())
                        emprestimo_temp = emprestimo;
            }

            try 
            {
                listaEmprestimos.remove(emprestimo_temp);
            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
            }
        } 
        else {
            System.out.println("Livro ou cliente não encontrado. Não foi possível realizar a devolucão.");
        }
    }

    public void listarLivros() {
        System.out.println("\n\n------  Lista de Livros:  ------\n");
        for (ILivro livro : livros) {
            System.out.println("Título: " + livro.getTitulo());
            System.out.println("Autor: " + livro.getAutor());
            System.out.println("Editora: " + livro.getEditora());
            System.out.println("Número de Páginas: " + livro.getNumeroPaginas());
            if(livro.getTextoMidiaDigital() != null)
                System.out.println("Texto armazenado: " + livro.getTextoMidiaDigital());
            System.out.println("------");
        }
    }
    
    public void listarClientes() {
        System.out.println("\n\n------  Lista de Clientes:  ------\n");
        for (ICliente cliente : clientes) {
            cliente.mostrarPessoaInfo();
        }
    }
    
    public void listarEmprestimos() {
        System.out.println("\n\n------  Lista de Emprestimos:  ------\n");
        for (Emprestimo emprestimo : listaEmprestimos) {
            System.out.println("Cliente: " + emprestimo.getCliente().getNome());
            System.out.println("Livro emprestado: " + emprestimo.getLivro().getTitulo() + " " + emprestimo.getLivro().getAutor());
            System.out.println("Data emprestimo: " + emprestimo.getDataEmprestimo());
            System.out.println("------");
        }
    }

    public Cliente localizarCliente(String nome) {

        Cliente cliente_temp = null;

        for (ICliente cliente : clientes) {
            if(cliente.getNome().contentEquals(nome))
            {
                cliente_temp = new Cliente(cliente.getNome(), cliente.getIdade(), cliente.getEndereco(), cliente.getCpf(), cliente.getEmail(), cliente.getNumeroIdentificacao());
            }
        }

        return cliente_temp;
    }

    public Livro localizarLivro(String nome) {

        Livro livro_temp = null;

        for (ILivro livro : livros) {
            if(livro.getTitulo().contentEquals(nome))
            {
                livro_temp = new Livro(livro.getTitulo(), livro.getAutor(), livro.getEditora(), livro.getNumeroPaginas());
            }
        }

        return livro_temp;
    }
}
