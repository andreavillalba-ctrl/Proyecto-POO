package calculator;

/**
 *
 * @author 225994426
 */
public class Arithmetic extends Calculadora {

    //Atributos
    //Constructores
    /**
     * Constructor default de Calculadora Aritmetica
     */
    public Arithmetic() {
        super.setResultado("0");
    }//fin constructor

    //Metodos
    public void sum(String num) {
        if (!valida(num)) {
            setError("Numero no valido");
            return;
        }
        double resultado = Double.parseDouble(getResultado());
        double numero = Double.parseDouble(num);

        resultado = resultado + numero;

        setResultado(Double.toString(resultado));
        setError("");
    }//fin sum

    public void rest(String num) {
        if (!valida(num)) {
            setError("Numero no valido");
            return;
        }
        double resultado = Double.parseDouble(getResultado());
        double numero = Double.parseDouble(num);

        resultado = resultado - numero;

        setResultado(Double.toString(resultado));
        setError("");
    }//fin rest

    public void multiply(String num) {
        if (!valida(num)) {
            setError("Numero no valido");
            return;
        }
        double resultado = Double.parseDouble(getResultado());
        double numero = Double.parseDouble(num);

        resultado = resultado * numero;

        setResultado(Double.toString(resultado));
        setError("");
    }//fin multiply

    public void divide(String num) {
        if (!valida(num)) {
            setError("Numero no valido");
            return;
        }
        double numero = Double.parseDouble(num);
        if (numero == 0) {
            setError("No se puede dividir entre 0");
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
            Double.parseDouble(valor);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }//fin valida
}
