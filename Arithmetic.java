/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculator;

/**
 *
 * @author 225994426
 */
public class Arithmetic extends Calculadora{
    //Atributos
    // Constructores
    /**
     * Constructor default de Calculadora Aritmetica
     */
    public Arithmetic(){
        super.setResultado("");
    }//fin constructor
    //Metodos
    public void sum(String num){
        if  (!valida(num)){
            setError("Numero no valido");
return;
}
double resultado = Double.parseDouble (getResultado());
double numero = Double.parseDouble (num);

resultado= resultado + numero;

setResultado (dOUBLE.TOsTRING()

    }else {
            long x;
            x = Long.parseLong(super.getResultado())+ Long.parseLong(num);
            super.setResultado(Long.toString(x));
        }
    }

PUBLIC VOID DIVIDE (sTRING NUM){
        if  (!valida(num)){
            setError("Numero no valido");
return;
}
double numero = Double.parseDouble (num);
if (numero==0){
setError(“No se puede dividir entre 0”);
return;
}
double resultado = Double.parseDouble(getResultado());
resultado = resultado / numero;

setResultado(Double.String(resultado));
setError(“”);

    private boolean valida(String valor){
        if (valor == null | | valor.isBlank()){
            return false;
}
        try{
            Double.parseDouble(valor);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }//fin valida
}
