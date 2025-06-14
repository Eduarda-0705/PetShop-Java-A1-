package view;

import java.util.Scanner;

public class Console {

    private static Scanner scanner = new Scanner(System.in);


    public static String lerString() {
        return scanner.nextLine(); 
    }

    
    public static int lerInt() {
        int valor = 0;
        boolean valido = false;
        
        while (!valido) {
            if (scanner.hasNextInt()) {
                valor = scanner.nextInt();
                valido = true;
            } else {
                System.out.print("Entrada inválida. Digite um número inteiro: ");
                scanner.next(); 
            }
        }
        scanner.nextLine();  

        return valor;
    }

   
    public static double lerDouble() {
        double valor = 0;
        boolean valido = false;
        
        while (!valido) {
            if (scanner.hasNextDouble()) {
                valor = scanner.nextDouble();
                valido = true;
            } else {
                System.out.print("Entrada inválida. Digite um número decimal: ");
                scanner.next(); 

            }
        }
        scanner.nextLine();  
        return valor;
    }
}


    
