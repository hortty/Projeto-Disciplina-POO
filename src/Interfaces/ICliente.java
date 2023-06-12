package Interfaces;

import java.util.List;

public interface ICliente extends IPessoa {
    int getNumeroIdentificacao();
    
    List<ILivro> getHistoricoEmprestimos();
    
    void emprestarLivro(ILivro livro);
    
    void devolverLivro(ILivro livro);
    
}
