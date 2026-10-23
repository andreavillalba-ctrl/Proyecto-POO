package calculadora;

/**
 *
 * @author SI
 */

////CLASE Arithmetic que procede de Calculadora
public class Arithmetic extends Calculadora {

    // Atributos
        //sin Atributos por ahora
    // Constructores
    /**
     * Constructor default de Calculadora Aritmetica
     */
    public Arithmetic() {
        super.setResultado("");//prepara la calculadora para empezar sin un resultado
    }//fin constructor

    // Metodos
    public void sum(String num) {
        if (!valida(num)) {
            setError("Numero no valido");
            return;
        }

        double resultado = 0;

        if (getResultado() != null && !getResultado().isBlank()) {
            if (!valida(getResultado())) {
                setError("Resultado anterior no valido");
                return;
            }

            resultado = Double.parseDouble(getResultado());
        }

        double numero = Double.parseDouble(num.trim());

        resultado = resultado + numero;

        setResultado(Double.toString(resultado));
        setError("");
    }//fin sum

    public void divide(String num) {
        if (!valida(num)) {
            setError("Numero no valido");
            return;
        }

        double numero = Double.parseDouble(num.trim());

        if (numero == 0) {
            setError("No se puede dividir entre 0");
            return;
        }

        if (getResultado() == null
                || getResultado().isBlank()
                || !valida(getResultado())) {
            setError("Resultado anterior no valido");
            return;
        }

        double resultado = Double.parseDouble(getResultado());

        resultado = resultado / numero;

        setResultado(Double.toString(resultado));
        setError("");
    }//fin divide

    private boolean valida(String valor) {
        if (valor == null || valor.isBlank()) {
            return false;
        }

        try {
            double numero = Double.parseDouble(valor.trim());
            return Double.isFinite(numero);
        } catch (NumberFormatException e) {
            return false;
        }
    }//fin valida

}//fin clase