package listado.clientes;



import java.util.InputMismatchException;
import java.util.Scanner;

public class Entrada {
	
	private Entrada() {
			}

    static Scanner teclado;

    static {
        teclado = new Scanner(System.in);
    }

    public static int pedirEntero(String mensaje) {
        int num = 0;
        boolean error;

        do {
            try {
                error = false;
                System.out.println(mensaje);
                num = teclado.nextInt();
            } catch (InputMismatchException e) {
                error = true;
            } finally {
                teclado.nextLine();
            }
        } while (error);
        
        return num;
    }

    public static double pedirDoble(String mensaje) {
        double num = 0;
        boolean error;

        do {
            try {
                error = false;
                System.out.println(mensaje);
                num = teclado.nextDouble();
            } catch (InputMismatchException e) {
                error = true;
            } finally {
                teclado.nextLine();
            }
        } while (error);
        
        return num;
    }
    
     public static float pedirFloat(String mensaje) {
        float num = 0;
        boolean error;

        do {
            try {
                error = false;
                System.out.println(mensaje);
                num = teclado.nextFloat();
            } catch (InputMismatchException e) {
                error = true;
            } finally {
                teclado.nextLine();
            }
        } while (error);
        
        return num;
    }
    
     public static long pedirLong(String mensaje) {
        long num = 0;
        boolean error;

        do {
            try {
                error = false;
                System.out.println(mensaje);
                num = teclado.nextLong();
            } catch (InputMismatchException e) {
                error = true;
            } finally {
                teclado.nextLine();
            }
        } while (error);
        
        return num;
    }    
    
    public static char pedirChar(String mensaje){
        char letra=' ';
        
        System.out.println(mensaje);
        letra=teclado.next().charAt(0);
        
        teclado.nextLine();
        
        return letra;
    }
    
    public static String pedirCadena(String mensaje){
        String cad="";
        
        System.out.println(mensaje);
        cad=teclado.nextLine();
        
        return cad;
    }

}
