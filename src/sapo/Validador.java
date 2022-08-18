package sapo;

public class Validador {

    public void valida(String string) throws IllegalArgumentException {
        if (string == null) {
            throw new IllegalArgumentException("String nula.");
        }
        if (string.isBlank()) {
            throw new IllegalArgumentException("String em branco.");
        }
    }

    public void valida(String[] strings) throws IllegalArgumentException {
        if (strings == null) {
            throw new IllegalArgumentException("Lista nula.");
        }
        for (String string : strings) {
            if (string == null) {
                throw new IllegalArgumentException("Lista possui um elemento nulo.");
            }
            if (string.isBlank()) {
                throw new IllegalArgumentException("Lista possui um elemento em branco.");
            }
        }
    }
    
    public void isPositivo(int inteiro) {
    	if (inteiro < 0) {
    		throw new IllegalArgumentException("O valor da hora não pode ser negativo.");
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
