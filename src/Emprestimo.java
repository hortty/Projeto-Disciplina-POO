import java.time.LocalDate;
import java.time.Period;
import Interfaces.IEmprestimo;

public class Emprestimo implements IEmprestimo {
    private Livro livro;
    private Cliente cliente;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolução;

    public Emprestimo(Livro livro, Cliente cliente, LocalDate dataEmprestimo) {
        this.livro = livro;
        this.cliente = cliente;
        this.dataEmprestimo = dataEmprestimo;
    }

    public Livro getLivro() {
        return livro;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolução;
    }

    public void registrarDevolucao() {
        this.dataDevolução = LocalDate.now();
    }

    public double calcularMulta() {
        Period diferenca = this.dataEmprestimo.until(this.dataDevolução);
        
        return diferenca.getDays() * 5.50; 
    }
    
}
