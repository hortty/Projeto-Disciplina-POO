package Exceptions;

public class DbException extends Exception {

    public DbException() {
        super();
    }

    public DbException(String mensagem) {
        super(mensagem);
    }
}