package Interfaces;

public interface IPessoa {
    String getNome();
    
    int getIdade();
    
    String getEndereco();
    
    long getCpf();
    
    String getEmail();
    
    void setNome(String nome);
    
    void setIdade(int idade);
    
    void setEndereco(String endereco);
    
    void setCpf(long cpf);
    
    void setEmail(String email);
    
    public abstract void mostrarPessoaInfo();
}
