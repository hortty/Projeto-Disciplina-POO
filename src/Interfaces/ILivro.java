package Interfaces;

public interface ILivro {
    String getTitulo();
    
    String getAutor();
    
    String getEditora();
    
    int getNumeroPaginas();
    
    void setTitulo(String titulo);
    
    void setAutor(String autor);
    
    void setEditora(String editora);
    
    void setNumeroPaginas(int numeroPaginas);

    public String getTextoMidiaDigital();
}
