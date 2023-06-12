import Interfaces.ILivro;
import java.io.*;
import java.util.Objects;

public class Livro implements ILivro, Serializable {
    private static final long serialVersionUID = 1L;
    private String titulo;
    private String autor;
    private String editora;
    private int numeroPaginas;
    private String textoMidiaDigital;
    
    public Livro(String titulo, String autor, String editora, int numeroPaginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.numeroPaginas = numeroPaginas;
    }

     @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Livro livro = (Livro) obj;

        return Objects.equals(titulo, livro.titulo) &&
               Objects.equals(autor, livro.autor) &&
               Objects.equals(editora, livro.editora) &&
               numeroPaginas == livro.numeroPaginas;
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, autor, editora, numeroPaginas);
    }
    
    public String getTitulo() {
        return titulo;
    }

    public String getTextoMidiaDigital() {
        return this.textoMidiaDigital;
    }

    public void setTextoMidiaDigital(String textoMidiaDigital) {
        this.textoMidiaDigital = textoMidiaDigital;
    }
    
    public String getAutor() {
        return autor;
    }
    
    public String getEditora() {
        return editora;
    }
    
    public int getNumeroPaginas() {
        return numeroPaginas;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public void setAutor(String autor) {
        this.autor = autor;
    }
    
    public void setEditora(String editora) {
        this.editora = editora;
    }
    
    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }
    
    public static void salvarLivro(Livro livro, String arquivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivo))) {
            oos.writeObject(livro);
            System.out.println("Livro salvo/serializado com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar o livro: " + e.getMessage());
        }
    }

    public static Livro carregarLivro(String arquivo) {
        Livro livro = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
            livro = (Livro) ois.readObject();
            System.out.println("Livro carregado com sucesso!");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar o livro: " + e.getMessage());
        }
        return livro;
    }
    
}
