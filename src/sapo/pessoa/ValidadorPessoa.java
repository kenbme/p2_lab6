package sapo.pessoa;

import sapo.Validador;

import java.util.NoSuchElementException;

public class ValidadorPessoa extends Validador {

    public void validaCpf(String cpf) {
        valida(cpf);
        char[] cpfValido = "222.222.222-22".toCharArray();
        if (cpf.length() != cpfValido.length) {
            throw new NoSuchElementException("Formatação do CPF inválida");
        }
        char[] cpfSplitado = cpf.toCharArray();
        for (int i = 0; i < cpfSplitado.length; i++) {
            if (isInteger(cpfValido[i])) {
                if (!isInteger(cpfSplitado[i])) {
                    throw new NoSuchElementException("Formatação do CPF inválida");
                }
            }
            else if (cpfSplitado[i] != cpfValido[i]) {
                throw new NoSuchElementException("Formatação do CPF inválida");
            }
        }
    }

    public void validaHabilidades(String[] strings) throws IllegalArgumentException {
        if (strings == null) {
            throw new IllegalArgumentException("Strings é null.");
        }
        for (String string : strings) {
            if (string == null) {
                throw new IllegalArgumentException("String é null.");
            }
        }
    }

}
