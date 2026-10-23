package calculadora;
import java.util.Scanner;
/**
 *
 * @author SI
 */
public class Metodos {
    
    public static void Menu(String mesage) {
        System.out.println(mesage);    
    }//fin de menu
    


public static int ValidMain(int minimo, int maximo) {
    Scanner entrada = new Scanner(System.in);

    while (true) {
        String texto = entrada.nextLine();

        try{
            int numero = Integer.parseInt(texto);
            if (numero >= minimo && numero <= maximo){
                return numero;
            }//fin de if 
            else {
                System.out.println("Error: el numero esta fuera del rango.");
            }//fin de else
        }//fin de try
        catch (NumberFormatException e){
            System.out.println("Error: debes ingresar un numero entero.");
        }//fin de catch
    }//fin de while
}//fin de ValidMain

}



    
    

