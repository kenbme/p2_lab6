package sapo.pessoa;

import sapo.Validador;

public class ValidadorPessoa extends Validador {

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
