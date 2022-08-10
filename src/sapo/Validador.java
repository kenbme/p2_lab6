package sapo;

public class Validador {

    public void valida(String string) throws IllegalArgumentException {
        if (string == null) {
            throw new IllegalArgumentException("String é null.");
        }
        if (string.isBlank()) {
            throw new IllegalArgumentException("String em branco.");
        }
    }

    public void valida(String[] strings) throws IllegalArgumentException {
        if (strings == null) {
            throw new IllegalArgumentException("Strings é null.");
        }
        for (String string : strings) {
            if (string == null) {
                throw new IllegalArgumentException("String é null.");
            }
            if (string.isBlank()) {
                throw new IllegalArgumentException("String em branco.");
            }
        }
    }

    public boolean isInteger(char caractere) {
        try {
            Integer.parseInt(String.valueOf(caractere));
            return true;
        }
        catch (NumberFormatException exception) {
            return false;
        }
    }

}
