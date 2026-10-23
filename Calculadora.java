package calculator;

/**
 *
 * @author 225994426
 */
public abstract class Calculadora {

    //atributos
    private String resultado = "0";
    private String error = "";

    //metodos para acceder al acumulador
    /**
     * Asigna el valor del acumulador.
     *
     * @param resultado
     */
    public void setResultado(String resultado) {
        this.resultado = resultado;
    }//fin setResultado

    /**
     * Devuelve el valor del acumulador.
     *
     * @return
     */
    public String getResultado() {
        return this.resultado;
    }//fin getResultado

    /**
     * Devuelve el mensaje de error actual.
     *
     * @return
     */
    public String getError() {
        return this.error;
    }//fin getError

    /**
     * Asigna el mensaje de error.
     *
     * @param error
     */
    protected void setError(String error) {
        this.error = error;
    }//fin setError
}
