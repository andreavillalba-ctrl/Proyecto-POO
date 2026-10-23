package calculadora;

public class Sistemaconversion extends calculadora {
    ///Atributos
    // El valor en la unidad pivote (metros, kg o °C) se guarda en "resultado"

    ///Constructores
    /*
        constructor default del sistema de conversion
    */
    public Sistemaconversion(){
        super.setResultado("");
    }//fin constructor

    /// Validaciones
    private boolean esNumero(String valor){
        if (valor == null || valor.isBlank()) return false;
        try {
            double d = Double.parseDouble(valor.trim());
            return !Double.isNaN(d) && !Double.isInfinite(d);
        } catch (NumberFormatException e) {
            return false;
        }
    }//fin esNumero

    // Longitud y peso: no pueden ser negativos
    private boolean validaMedida(String valor){
        return esNumero(valor) && Double.parseDouble(valor.trim()) >= 0;
    }//fin validaMedida

    // Una validación por escala de temperatura (cero absoluto)
    private boolean validaFahrenheit(String valor){
        return esNumero(valor) && Double.parseDouble(valor.trim()) >= -459.67;
    }//fin validaFahrenheit

    private boolean validaCelsius(String valor){
        return esNumero(valor) && Double.parseDouble(valor.trim()) >= -273.15;
    }//fin validaCelsius

    private boolean validaKelvin(String valor){
        return esNumero(valor) && Double.parseDouble(valor.trim()) >= 0;
    }//fin validaKelvin

    // Lee el valor guardado en resultado como número
    private double pivote(){
        return Double.parseDouble(super.getResultado());
    }//fin pivote

    /// ================= LONGITUD (pivote: metros) =================
    // Entrada imperial -> metros
    public void pulgadasAMetros(String valor){
        if (!validaMedida(valor)){
            super.setResultado("Error");
        } else {
            double x;
            x = Double.parseDouble(valor.trim()) * 0.0254;       // 1 pulgada = 0.0254 m
            super.setResultado(Double.toString(x));
        }
    }
    public void piesAMetros(String valor){
        if (!validaMedida(valor)){
            super.setResultado("Error");
        } else {
            double x;
            x = Double.parseDouble(valor.trim()) * 0.3048;       // 1 pie = 0.3048 m
            super.setResultado(Double.toString(x));
        }
    }
    public void yardasAMetros(String valor){
        if (!validaMedida(valor)){
            super.setResultado("Error");
        } else {
            double x;
            x = Double.parseDouble(valor.trim()) * 0.9144;       // 1 yarda = 0.9144 m
            super.setResultado(Double.toString(x));
        }
    }
    public void millasAMetros(String valor){
        if (!validaMedida(valor)){
            super.setResultado("Error");
        } else {
            double x;
            x = Double.parseDouble(valor.trim()) * 1609.344;     // 1 milla = 1609.344 m
            super.setResultado(Double.toString(x));
        }
    }

    // Entrada métrica -> metros
    public void milimetrosAMetros(String valor){
        if (!validaMedida(valor)){
            super.setResultado("Error");
        } else {
            double x;
            x = Double.parseDouble(valor.trim()) * 0.001;        // 1 mm = 0.001 m
            super.setResultado(Double.toString(x));
        }
    }
    public void centimetrosAMetros(String valor){
        if (!validaMedida(valor)){
            super.setResultado("Error");
        } else {
            double x;
            x = Double.parseDouble(valor.trim()) * 0.01;         // 1 cm = 0.01 m
            super.setResultado(Double.toString(x));
        }
    }
    public void metrosAMetros(String valor){
        if (!validaMedida(valor)){
            super.setResultado("Error");
        } else {
            double x;
            x = Double.parseDouble(valor.trim()) * 1;            // 1 m = 1 m
            super.setResultado(Double.toString(x));
        }
    }
    public void kilometrosAMetros(String valor){
        if (!validaMedida(valor)){
            super.setResultado("Error");
        } else {
            double x;
            x = Double.parseDouble(valor.trim()) * 1000;         // 1 km = 1000 m
            super.setResultado(Double.toString(x));
        }
    }

    // Salida: metros -> métrico
    public double aMilimetros()  { return pivote() * 1000; }
    public double aCentimetros() { return pivote() * 100; }
    public double aMetros()      { return pivote() * 1; }
    public double aKilometros()  { return pivote() * 0.001; }

    // Salida: metros -> imperial
    public double aPulgadas()    { return pivote() * 39.37007874015748; }      // 1 m en pulgadas
    public double aPies()        { return pivote() * 3.280839895013123; }      // 1 m en pies
    public double aYardas()      { return pivote() * 1.0936132983377078; }     // 1 m en yardas
    public double aMillas()      { return pivote() * 0.000621371192237334; }   // 1 m en millas

    /// ================= PESO (pivote: kilogramos) =================
    // Entrada imperial -> kilogramos
    public void onzasAKilogramos(String valor){
        if (!validaMedida(valor)){
            super.setResultado("Error");
        } else {
            double x;
            x = Double.parseDouble(valor.trim()) * 0.028349523125;   // 1 onza = 0.0283495 kg
            super.setResultado(Double.toString(x));
        }
    }
    public void librasAKilogramos(String valor){
        if (!validaMedida(valor)){
            super.setResultado("Error");
        } else {
            double x;
            x = Double.parseDouble(valor.trim()) * 0.45359237;       // 1 libra = 0.45359237 kg
            super.setResultado(Double.toString(x));
        }
    }

    // Entrada métrica -> kilogramos
    public void gramosAKilogramos(String valor){
        if (!validaMedida(valor)){
            super.setResultado("Error");
        } else {
            double x;
            x = Double.parseDouble(valor.trim()) * 0.001;            // 1 g = 0.001 kg
            super.setResultado(Double.toString(x));
        }
    }
    public void kilogramosAKilogramos(String valor){
        if (!validaMedida(valor)){
            super.setResultado("Error");
        } else {
            double x;
            x = Double.parseDouble(valor.trim()) * 1;                // 1 kg = 1 kg
            super.setResultado(Double.toString(x));
        }
    }

    // Salida: kilogramos -> métrico
    public double aGramos()      { return pivote() * 1000; }
    public double aKilogramos()  { return pivote() * 1; }

    // Salida: kilogramos -> imperial
    public double aOnzas()       { return pivote() * 35.27396194958041; }      // 1 kg en onzas
    public double aLibras()      { return pivote() * 2.2046226218487757; }     // 1 kg en libras

    /// ================= TEMPERATURA (pivote: °C) =================
    // Entrada imperial -> Celsius
    public void fahrenheitACelsius(String valor){
        if (!validaFahrenheit(valor)){
            super.setResultado("Error");
        } else {
            double c;
            c = (Double.parseDouble(valor.trim()) - 32) * 5.0 / 9.0;
            super.setResultado(Double.toString(c));
        }
    }

    // Entrada métrica -> Celsius
    public void celsiusACelsius(String valor){
        if (!validaCelsius(valor)){
            super.setResultado("Error");
        } else {
            double c;
            c = Double.parseDouble(valor.trim()) * 1;
            super.setResultado(Double.toString(c));
        }
    }
    public void kelvinACelsius(String valor){
        if (!validaKelvin(valor)){
            super.setResultado("Error");
        } else {
            double c;
            c = Double.parseDouble(valor.trim()) - 273.15;
            super.setResultado(Double.toString(c));
        }
    }

    // Salida: Celsius -> métrico
    public double aCelsius()     { return pivote() * 1; }
    public double aKelvin()      { return pivote() + 273.15; }

    // Salida: Celsius -> imperial
    public double aFahrenheit()  { return pivote() * 1.8 + 32; }

    public boolean hayError(){
        return super.getResultado().equals("Error");
    }
}
