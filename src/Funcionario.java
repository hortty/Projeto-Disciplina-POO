import Interfaces.IFuncionario;

public class Funcionario extends Pessoa implements IFuncionario {
    private String cargo;
    private double salario;

    public Funcionario(String nome, int idade, String endereco, long cpf, String email, String cargo, double salario) {
        super(nome, idade, endereco, cpf, email);
        this.cargo = cargo;
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public void mostrarPessoaInfo() {
        System.out.println(" ##  FUNCIONARIO  ## ");
        System.out.println("Nome: " + getNome());
        System.out.println("Idade: " + getIdade());
        System.out.println("Endereço: " + getEndereco());
        System.out.println("Cargo: " + getCargo());
        System.out.println("Salário: " + getSalario());
    }

    @Override
    public boolean validarEmail() {
                                                                                                        // necessita usar o email corporativo. que contém library em sua definição 
        if(this.getEmail().contains("@") && this.getEmail().contains(".com") && this.getEmail().contains("library")) {
            return true;
        }

        return false;
    }
}
