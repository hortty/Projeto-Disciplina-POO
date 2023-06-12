import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import Interfaces.ICliente;
import Interfaces.ILivro;

public class Cliente extends Pessoa implements ICliente {
    private int numeroIdentificacao;
    private List<ILivro> historicoEmprestimos;
    
    public Cliente(String nome, int idade, String endereco, long cpf, String email, int numeroIdentificacao) {
        super(nome, idade, endereco, cpf, email);
        this.numeroIdentificacao = numeroIdentificacao;
        this.historicoEmprestimos = new ArrayList<ILivro>();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Cliente cliente = (Cliente) obj;

        return Objects.equals(getNome(), cliente.getNome()) &&
               Objects.equals(numeroIdentificacao, cliente.numeroIdentificacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome(), numeroIdentificacao);
    }
    
    public int getNumeroIdentificacao() {
        return numeroIdentificacao;
    }
    
    public void setNumeroIdentificacao(int numeroIdentificacao) {
        this.numeroIdentificacao = numeroIdentificacao;
    }
    
    public List<ILivro> getHistoricoEmprestimos() {
        return historicoEmprestimos;
    }
    
    public void emprestarLivro(ILivro livro) {
        historicoEmprestimos.add(livro);
    }
    
    public void devolverLivro(ILivro livro) {
        historicoEmprestimos.remove(livro);
    }

    @Override
    public void mostrarPessoaInfo() {
        System.out.println("------  $$  CLIENTE  $$  ------");
        System.out.println("Nome: " + getNome());
        System.out.println("Idade: " + getIdade());
        System.out.println("Endereço: " + getEndereco());
        System.out.println("Número de Identificacao: " + getNumeroIdentificacao());
        System.out.println("------");
    }
    
    @Override
    public boolean validarEmail() {
                                                                                                            // somente é aceito domínios do gmail
        if(this.getEmail().contains("@") && this.getEmail().contains(".com") && this.getEmail().contains("gmail")) {
            return true;
        }

        return false;
    }
}
