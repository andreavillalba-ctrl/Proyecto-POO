package calculadora;

public class Conversor extends calculadora {
    ///Atributos
    // El decimal intermedio se guarda en "resultado", heredado de calculadora

    ///Constructores
    /*
        constructor default del conversor de bases
    */
    public Conversor(){
        super.setResultado("");
    }//fin constructor

    /// Validaciones (una por base)
    private boolean validaDecimal(String valor){
        if (valor == null || valor.isBlank()) return false;
        valor = valor.trim();
        for (int i = 0; i < valor.length(); i++){
            char c = valor.charAt(i);
            if (c < '0' || c > '9') return false;
        }
        return true;
    }//fin validaDecimal

    private boolean validaBinario(String valor){
        if (valor == null || valor.isBlank()) return false;
        valor = valor.trim();
        for (int i = 0; i < valor.length(); i++){
            char c = valor.charAt(i);
            if (c != '0' && c != '1') return false;
        }
        return true;
    }//fin validaBinario

    private boolean validaOctal(String valor){
        if (valor == null || valor.isBlank()) return false;
        valor = valor.trim();
        for (int i = 0; i < valor.length(); i++){
            char c = valor.charAt(i);
            if (c < '0' || c > '7') return false;
        }
        return true;
    }//fin validaOctal

    private boolean validaHexadecimal(String valor){
        if (valor == null || valor.isBlank()) return false;
        valor = valor.trim();
        for (int i = 0; i < valor.length(); i++){
            char c = valor.charAt(i);
            boolean digito    = (c >= '0' && c <= '9');
            boolean mayuscula = (c >= 'A' && c <= 'F');
            boolean minuscula = (c >= 'a' && c <= 'f');
            if (!digito && !mayuscula && !minuscula) return false;
        }
        return true;
    }//fin validaHexadecimal

    /// Algoritmos a mano
    private int valorDigito(char c){
        if (c >= '0' && c <= '9') return c - '0';
        if (c >= 'A' && c <= 'F') return c - 'A' + 10;
        return c - 'a' + 10;
    }//fin valorDigito

    // Otra base -> decimal (multiplicación)
    private long aDecimal(String valor, int base){
        valor = valor.trim();
        long acumulador = 0;
        for (int i = 0; i < valor.length(); i++){
            acumulador = acumulador * base + valorDigito(valor.charAt(i));
        }
        return acumulador;
    }//fin aDecimal

    // Decimal (guardado en resultado) -> otra base (división)
    private String aBase(int base){
        if (hayError() || super.getResultado().isEmpty()) return "Error";

        long numero = Long.parseLong(super.getResultado());
        if (numero == 0) return "0";

        String simbolos = "0123456789ABCDEF";
        String texto = "";
        while (numero > 0){
            int residuo = (int) (numero % base);
            texto = simbolos.charAt(residuo) + texto;
            numero = numero / base;
        }
        return texto;
    }//fin aBase

    /// Metodos de entrada: cualquier base -> decimal
    public void decimalADecimal(String valor){
        if (!validaDecimal(valor)){
            super.setResultado("Error");
        } else {
            super.setResultado(Long.toString(aDecimal(valor, 10)));
        }
    }

    public void binarioADecimal(String valor){
        if (!validaBinario(valor)){
            super.setResultado("Error");
        } else {
            super.setResultado(Long.toString(aDecimal(valor, 2)));
        }
    }

    public void octalADecimal(String valor){
        if (!validaOctal(valor)){
            super.setResultado("Error");
        } else {
            super.setResultado(Long.toString(aDecimal(valor, 8)));
        }
    }

    public void hexadecimalADecimal(String valor){
        if (!validaHexadecimal(valor)){
            super.setResultado("Error");
        } else {
            super.setResultado(Long.toString(aDecimal(valor, 16)));
        }
    }

    /// Metodos de salida: decimal -> cualquier base
    public String getDecimal()   { return aBase(10); }
    public String aBinario()     { return aBase(2); }
    public String aOctal()       { return aBase(8); }
    public String aHexadecimal() { return aBase(16); }

    public boolean hayError(){
        return super.getResultado().equals("Error");
    }
}
