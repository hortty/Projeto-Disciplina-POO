package Exceptions;

public class FileReadException extends Exception {

    public FileReadException() {
        super();
    }

    public FileReadException(String mensagem) {
        super(mensagem);
    }
}