
package calculadora;

public class Conversor extends Calculadora {

    /// Atributos
    // El resultado convertido se guarda en "resultado"

    /// Constructores
    public Conversor() {
        super.setResultado("");
    }//fin constructor

    /// Validaciones

    // Convierte un caracter hexadecimal a su valor numerico
    private int valorDigito(char digito) {
        if (digito >= '0' && digito <= '9') {
            return digito - '0';
        }

        if (digito >= 'A' && digito <= 'F') {
            return digito - 'A' + 10;
        }

        if (digito >= 'a' && digito <= 'f') {
            return digito - 'a' + 10;
        }

        return -1;
    }//fin valorDigito

    // Valida que el numero pertenezca a la base indicada
    private boolean validaNumero(String numero, int base) {
        if (numero == null || numero.isBlank()) {
            return false;
        }

        if (base < 2 || base > 16) {
            return false;
        }

        numero = numero.trim();

        // Permite numeros negativos
        int inicio = numero.startsWith("-") ? 1 : 0;

        if (inicio == numero.length()) {
            return false;
        }

        for (int i = inicio; i < numero.length(); i++) {
            int digito = valorDigito(numero.charAt(i));

            if (digito < 0 || digito >= base) {
                return false;
            }
        }

        return true;
    }//fin validaNumero

    /// ================= CONVERSION A DECIMAL =================

    // Formula posicional: digito * base^posicion
    private long aDecimal(String numero, int base) {
        numero = numero.trim().toUpperCase();

        boolean negativo = numero.startsWith("-");

        if (negativo) {
            numero = numero.substring(1);
        }

        long decimal = 0;

        for (int i = 0; i < numero.length(); i++) {
            int digito = valorDigito(numero.charAt(i));

            decimal = decimal * base + digito;
        }

        return negativo ? -decimal : decimal;
    }//fin aDecimal

    /// ================= CONVERSION DESDE DECIMAL =================

    // Convierte un decimal a la base solicitada
    private String desdeDecimal(long decimal, int base) {
        if (decimal == 0) {
            return "0";
        }

        boolean negativo = decimal < 0;

        // Evita problemas al convertir Long.MIN_VALUE
        String resultado = Long.toString(decimal, base);

        return resultado.toUpperCase();
    }//fin desdeDecimal

    /// ================= CONVERSION GENERAL =================

    public void convertir(String numero, int baseOrigen, int baseDestino) {
        if (baseOrigen < 2 || baseOrigen > 16
                || baseDestino < 2 || baseDestino > 16
                || !validaNumero(numero, baseOrigen)) {
            super.setResultado("Error");
            return;
        }

        try {
            long decimal = aDecimal(numero, baseOrigen);

            String convertido = desdeDecimal(decimal, baseDestino);

            super.setResultado(convertido);

        } catch (ArithmeticException e) {
            super.setResultado("Error");
        }
    }//fin convertir

    public boolean hayError() {
        return "Error".equals(super.getResultado());
    }//fin hayError

}//fin clase
