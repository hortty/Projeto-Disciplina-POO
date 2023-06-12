package Exceptions;

public class PessoaNaoExisteException extends Exception {

    public PessoaNaoExisteException() {
        super();
    }

    public PessoaNaoExisteException(String mensagem) {
        super(mensagem);
    }
}