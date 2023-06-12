package Exceptions;

public class ValidacaoPessoaException extends Exception {

    public ValidacaoPessoaException() {
        super();
    }

    public ValidacaoPessoaException(String mensagem) {
        super(mensagem);
    }
}