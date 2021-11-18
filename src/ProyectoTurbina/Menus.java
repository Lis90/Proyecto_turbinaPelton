package ProyectoTurbina;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Menus {

    public static Scanner scan = new Scanner(System.in);
    public static boolean band_cifras = false; //eliminar cifras significativas cuando se vuelve al menu

    static void menu() {
        scan = new Scanner(System.in);
        int opc = 0;
        boolean error = false;

        do {
            error = false;
            System.out.println("-------------------------------------");
            System.out.println("\tCALCULADORA DE FISICA");
            System.out.println("-------------------------------------");
            System.out.println("Elija una opcion...");
            System.out.println("\nHallar medidas en:");
            System.out.print("1. Turbina de Pelton \t");
            System.out.println("2. Turbina Custom");
            System.out.println("3. Salir");

            try{ //error de entrada de caracteres
                System.out.print("\nOPC: ");
                opc = scan.nextInt();
            } catch (InputMismatchException e) {
                Acciones.clearscreen();
                System.out.println("Error, la opcion debe ser un numero!\n");
                scan.nextLine(); //convertir a line, para que el bucle no sea infinito
                error = true;
            }

            if (error == false && (opc < 1 || opc > 3)) { //error de fuera de rango
                Acciones.clearscreen();
                System.out.println("Error, opcion fuera de rango [1-3]\n");
            }

        } while (opc < 1 || opc > 3 || error);

        if (opc == 3) { //saliendo del programa y mostrando resultados
            Acciones.clearscreen();
            System.out.println("\tDATOS CALCULADOS: ");
            System.out.println("-------------------------------------");
            Acciones.resultados();
            System.out.println("\nSaliendo del programa...\n");
            System.exit(0);
        }

        Acciones.clearscreen();
        menu1(opc); //enviar opcion de turbina
    }

    static void menu1(int n) {
        int opc = 0, cifras = 0;
        boolean error = false, errorc = false;

        do { //error ingresa mal la opcion (caraceter, fuera de rango)
            error = false;
            if (n == 1) {
                System.out.println("Eleccion: TURBINA DE PELTON\n");
            } else if (n == 2) {
                System.out.println("Eleccion: TURBINA CUSTOM\n");
            }

            if (band_cifras == false){
                do { 
                    errorc = false;
                    try { //error al solicitar cifras (caracter)
                        System.out.print("CIFRAS SIGNIFICATIVAS [1-6]: ");
                        cifras = scan.nextInt();
                        System.out.print("\n");
                        Formulas.df = new DecimalFormat(Acciones.cifras(cifras));
                    } catch (InputMismatchException e) {
                        Acciones.clearscreen();
                        System.out.println("Error, el valor debe ser un numero!\n");
                        scan = new Scanner(System.in);
                        errorc = true;
                    }

                    if (errorc == false && (cifras < 1 || cifras > 6)) { //error al solicitar cifras (fuera de rango)
                        Acciones.clearscreen();
                        System.out.println("Error, numero fuera de rango [1-6]\n");
                    }
                } while (cifras < 1 || cifras > 6 || errorc);
            }

            band_cifras = true; //set true para que no pregunte las cifras denuevo

            System.out.println("---------LISTA DE OPCIONES---------\n");
            System.out.println("Calcular...");
            System.out.println("1. Periodo (T)");
            System.out.println("2. Frecuencia (f)");
            System.out.println("3. Velocidad angular (w)");
            System.out.println("4. Velocidad (v)");
            System.out.println("5. Aceleracion angular (α)");
            System.out.println("6. Aceleracion centripeta (a cp)");
            System.out.println("7. Aceleracion tangencial (a tan)");
            System.out.println("8. Aceleracion (a)");
            System.out.println("9. Inercia elices (I)");
            System.out.println("10. Energia Cinetica Rotacional (Ecr)");
            System.out.println("11. Menu anterior");
            System.out.print("\nOPC [1-11]: ");

            try { //error de entrada de caracteres
                opc = scan.nextInt();
            } catch (InputMismatchException e) {
                Acciones.clearscreen();
                System.out.println("Error, recuerde que la opcion debe ser un numero!\n");
                scan = new Scanner(System.in);
                error = true;
            }

            if (error == false && (opc > 11 || opc < 1)) { //error de fuera de rango
                Acciones.clearscreen();
                System.out.println("Error, opcion fuera de rango [1-11]\n");
            }
        } while (opc > 11 || opc < 1 || error);

        Acciones.clearscreen();

        if (n == 1) {
            Acciones.acciones(opc); //envia instruccion de calculo
        }
        if (n == 2) {
            Acciones.acciones2(opc); //envia instruccion de calculo
        }
    }

    public static void ask_menu(int num) {
        char letra;
        boolean band = false;
        do{
            System.out.print("\nDesea hacer otro calculo? (y/n): ");
            letra = scan.next().charAt(0);
            if (Character.toLowerCase(letra) == 'y') {
                band = true;
            } else if (Character.toLowerCase(letra) == 'n') {
                band = true;
            }
            Acciones.clearscreen();
            System.out.println("Error, la opcion debe ser 'y' o 'n'!");
        } while (band == false);

        if (Character.toLowerCase(letra) == 'y') {
            Acciones.clearscreen();
            menu1(num);
        } else {
            Acciones.clearscreen();
            System.out.println("\tDATOS CALCULADOS: ");
            System.out.println("-------------------------------------");
            Acciones.resultados();
            System.out.println("\nSaliendo del programa...\n");
            System.exit(0);
        }
    }

    public static void ask_frecuencia() {
        char rpt;
        boolean band = false;
        do { //manejo de error
            System.out.print("\nDesea saber como fue calculado la frecuencia? (y/n): ");
            rpt = scan.next().charAt(0);
            if (Character.toLowerCase(rpt) == 'y') {
                band = true;
            } else if (Character.toLowerCase(rpt) == 'n') {
                band = true;
            }
            Acciones.clearscreen();
            System.out.println("Error, la opcion debe ser 'y' o 'n'!");
        } while (band == false);
        Acciones.clearscreen();
        if (Character.toLowerCase(rpt) == 'y') {
            System.out.println("Demostrando calculo de la frecuencia... ");
            Formulas.frecuencia();
            System.out.print("\n-------------------------------------\n");
        }
    }

    public static void ask_velocidadAngular() {
        char rpt;
        boolean band = false;
        do { //manejo de error
            System.out.print("\nDesea saber como fue calculado la velocidad angular? (y/n): ");
            rpt = scan.next().charAt(0);
            if (Character.toLowerCase(rpt) == 'y') {
                band = true;
            } else if (Character.toLowerCase(rpt) == 'n') {
                band = true;
            }
            Acciones.clearscreen();
            System.out.println("Error, la opcion debe ser 'y' o 'n'!");
        } while (band == false);
        Acciones.clearscreen();
        if (Character.toLowerCase(rpt) == 'y') {
            System.out.println("Demostrando calculo de la velocidad angular... ");
            Formulas.velocidad_angular();
            System.out.print("\n-------------------------------------\n");
        }
    }

    public static void ask_aceleracionAngular() {
        char rpt;
        boolean band = false;
        do { //manejo de error
            System.out.print("\nDesea saber como fue calculado la aceleracion angular? (y/n): ");
            rpt = scan.next().charAt(0);
            if (Character.toLowerCase(rpt) == 'y') {
                band = true;
            } else if (Character.toLowerCase(rpt) == 'n') {
                band = true;
            }
            Acciones.clearscreen();
            System.out.println("Error, la opcion debe ser 'y' o 'n'!");
        } while (band == false);
        Acciones.clearscreen();
        if (Character.toLowerCase(rpt) == 'y') {
            System.out.println("Demostrando calculo de la aceleracion angular... ");
            Formulas.aceleracion_angular();
            System.out.print("\n-------------------------------------\n");
        }
    }

    public static void ask_aceleracionTangencial() {
        char rpt;
        boolean band = false;
        do { //manejo de error
            System.out.print("\nDesea saber como fue calculado la aceleracion tangencial? (y/n): ");
            rpt = scan.next().charAt(0);
            if (Character.toLowerCase(rpt) == 'y') {
                band = true;
            } else if (Character.toLowerCase(rpt) == 'n') {
                band = true;
            }
            Acciones.clearscreen();
            System.out.println("Error, la opcion debe ser 'y' o 'n'!");
        } while (band == false);
        Acciones.clearscreen();
        if (Character.toLowerCase(rpt) == 'y') {
            System.out.println("Demostrando calculo de la aceleracion tangencial... ");
            Formulas.aceleracion_tangencial();
            System.out.print("\n-------------------------------------\n");
        }
    }

    public static void ask_aceleracionCentripeta() {
        char rpt;
        boolean band = false;
        do { //manejo de error
            System.out.print("\nDesea saber como fue calculado la aceleracion centripeta? (y/n): ");
            rpt = scan.next().charAt(0);
            if (Character.toLowerCase(rpt) == 'y') {
                band = true;
            } else if (Character.toLowerCase(rpt) == 'n') {
                band = true;
            }
            Acciones.clearscreen();
            System.out.println("Error, la opcion debe ser 'y' o 'n'!");
        } while (band == false);
        Acciones.clearscreen();
        if (Character.toLowerCase(rpt) == 'y') {
            System.out.println("Demostrando calculo de la aceleracion centripeta... ");
            Formulas.aceleracion_centripeta();
            System.out.print("\n-------------------------------------\n");
        }
    }

    public static void ask_inercia() {
        char rpt;
        boolean band = false;
        do { //manejo de error
            System.out.print("\nDesea saber como fue calculado la Inercia? (y/n): ");
            rpt = scan.next().charAt(0);
            if (Character.toLowerCase(rpt) == 'y') {
                band = true;
            } else if (Character.toLowerCase(rpt) == 'n') {
                band = true;
            }
            Acciones.clearscreen();
            System.out.println("Error, la opcion debe ser 'y' o 'n'!");
        } while (band == false);
        Acciones.clearscreen();
        if (Character.toLowerCase(rpt) == 'y') {
            System.out.println("Demostrando calculo de la Inercia... ");
            Formulas.inercia();
            System.out.print("\n-------------------------------------\n");
        }
    }
}
