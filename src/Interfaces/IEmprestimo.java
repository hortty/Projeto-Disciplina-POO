package Interfaces;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface IEmprestimo {
    ILivro getLivro();
    ICliente getCliente();
    LocalDate getDataEmprestimo();
    LocalDate getDataDevolucao();
    void registrarDevolucao();
    double calcularMulta();

}
