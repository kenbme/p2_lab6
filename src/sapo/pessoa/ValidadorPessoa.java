package sapo.pessoa;

import sapo.Validador;

import java.util.NoSuchElementException;

public class ValidadorPessoa extends Validador {

    public void validaCpf(String cpf) {
        valida(cpf);
        if (cpf.length() != 14) {
            throw new NoSuchElementException("Formatação do CPF inválida");
        }
        if (cpf.charAt(3) != '.' || cpf.charAt(7) != '.' || cpf.charAt(11) != '-') {
            throw new NoSuchElementException("Formatação do CPF inválida");
        }
        for(String numero : cpf.split("[.-]")) {
            try {
                Integer.parseInt(numero);
            }
            catch (NumberFormatException exception) {
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
