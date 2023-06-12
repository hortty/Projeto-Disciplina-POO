import Interfaces.IPessoa;

public abstract class Pessoa implements IPessoa {
    private String nome;
    private int idade;
    private String endereco;
    private long cpf;
    private String email;
    
    public Pessoa(String nome, int idade, String endereco, long cpf, String email) {
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
        this.cpf = cpf;
        this.email = email;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public int getIdade() {
        return idade;
    }
    
    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    public String getEndereco() {
        return endereco;
    }
    
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    public long getCpf() {
        return cpf;
    }
    
    public void setCpf(long cpf) {
        this.cpf = cpf;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public boolean validarIdade() {
        if(this.idade >= 18)
            return true; 

        return false;
    }
    
    public boolean validarEmail() {
        if(this.email.contains("@") && this.email.contains(".com")) {
            return true;
        }
        
        return false;
    }
    
    public abstract void mostrarPessoaInfo();
}
