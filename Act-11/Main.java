package calculadora;
import static calculadora.Metodos.*;//tengo entendido que importa los metodos de otra clase a esta.
/**
 *
 * @author SI
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Menu("============================");
        Menu("**CALCULADORA 64**");
        Menu("============================");
        Menu("\n-1.Usar Calculadora Aritmetica");
        Menu("-2.Usar Calculadora de convertidor(m,kg,l,ml)");
        Menu("-3.Usar Calculadora de bases numericas");
        Menu("-4.Salir de la aplicacion");
        
       int opcion1=ValidMain(1, 4);
       switch(opcion1){
           case 1:
               //Calculadora aritmetica
               Menu("============================");
               Menu("**CALCULADORA ARITMETICA 64**");
               Menu("============================");
               Menu("\n-1.Realizar una suma");
               Menu("-2.Realizar una resta");
               Menu("-3.Realizar una multiplicacion");
               Menu("-4.Realizar una division");
               Menu("-5.Regresar al menu principal");
               
               int opcion2=ValidMain(1, 5);
               //Realizar una suma,resta,multiplicacion,division
               
               break;
           case 2:
               //Calculadora Convertidora
               Menu("============================");
               Menu("**CALCULADORA CONVERTIDORA DE UNIDADES 64**");
               Menu("============================");
               Menu("\n-1.Realizar una suma");
               Menu("-2.Realizar una resta");
               Menu("-3.Realizar una multiplicacion");
               Menu("-4.Realizar una division");
               Menu("-5.Regresar al menu principal");
               break;
           case 3:
               //Calculadora de Bases
               Menu("============================");
               Menu("**CALCULADORA CONVERTIDORA DE BASES NUMERICAS 64**");
               Menu("============================");
               Menu("\n-1.Realizar una suma");
               Menu("-2.Realizar una resta");
               Menu("-3.Realizar una multiplicacion");
               Menu("-4.Realizar una division");
               Menu("-5.Regresar al menu principal");
               break;
           case 4:
               
               break;
       }
       
       
       
       
       
       
       
    //pruebas:    
    }//fin de main
    
    
    
}
