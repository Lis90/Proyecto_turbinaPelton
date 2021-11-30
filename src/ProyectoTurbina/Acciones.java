package ProyectoTurbina;

import java.text.Normalizer.Form;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Acciones {

    public static Scanner scan = new Scanner(System.in);
    public static double pi = 3.141516;
    public static boolean band_cifras = false;
    public static double radioc = 0, velocidadc = 0, masac = 0, masaelice = 0, nelices = 0;
    public static int tiempoc = 0, vueltasc = 0;
    public static double frecuenciac = 0, periodoc = 0;
    public static double wc = 0, acelangularc = 0;
    public static double acpc = 0, atanc = 0, acelec = 0;
    public static double inerciac = 0, energiac = 0, torquec = 0;
    public static boolean bandf = false, bandp = false, bandva = false, bandaa = false;
    public static boolean bandac = false, bandat = false, banda = false, bandv = false;
    public static boolean bandi = false, bande = false, bandt = false;

    static void acciones(int opc) {
        switch (opc) {
            case 1:
                System.out.println("Eleccian: Periodo (T)");
                System.out.print("-------------------------------------------------------\n");
                Formulas.periodo();
                Menus.ask_menu(1);
                break;
            case 2:
                System.out.println("Eleccion: Frecuencia (f)");
                System.out.print("-------------------------------------------------------\n");
                Formulas.frecuencia();
                Menus.ask_menu(1);
                break;
            case 3:
                System.out.println("Eleccion: Velocidad angular (w)");
                System.out.print("-------------------------------------------------------\n");
                Formulas.velocidad_angular(true);
                Menus.ask_menu(1);
                break;
            case 4:
                System.out.println("Eleccion: Velocidad (v)");
                System.out.print("-------------------------------------------------------\n");
                Formulas.velocidad(true);
                Menus.ask_menu(1);
            case 5:
                System.out.println("Eleccion: Aceleracion Angular (α)");
                System.out.print("-------------------------------------------------------\n");
                Formulas.aceleracion_angular(true);
                Menus.ask_menu(1);
                break;
            case 6:
                System.out.println("Eleccion: Aceleracion centripeta (a cp)");
                System.out.print("-------------------------------------------------------\n");
                Formulas.aceleracion_centripeta(true);
                Menus.ask_menu(1);
                break;
            case 7:
                System.out.println("Eleccion: Aceleracion tangencial (a tan)");
                System.out.print("-------------------------------------------------------\n");
                Formulas.aceleracion_tangencial(true);
                Menus.ask_menu(1);
                break;
            case 8:
                System.out.println("Eleccion: Aceleracion (a)");
                System.out.print("-------------------------------------------------------\n");
                Formulas.aceleracion(true);
                Menus.ask_menu(1);
                break;
            case 9:
                System.out.println("Eleccion: Inercia (I)");
                System.out.print("-------------------------------------------------------\n");
                Formulas.inercia();
                Menus.ask_menu(1);
                break;
            case 10:
                System.out.println("Eleccion: Torque (t)");
                System.out.print("-------------------------------------------------------\n");
                Formulas.torque(true);
                Menus.ask_menu(1);
                break;
            case 11:
                System.out.println("Eleccion: Energia Mecanica (E)");
                System.out.print("-------------------------------------------------------\n");
                Formulas.energia(true);
                Menus.ask_menu(1);
                break;
            case 12:
                clearscreen();
                Menus.band_cifras = false;
                Menus.menu();
                break;
        }
    }

    static void acciones2(int opc) {
        switch (opc) {
            case 1:
                System.out.println("Eleccion: Periodo (T)");
                System.out.print("-------------------------------------------------------\n");
                System.out.println("\nDatos necesarios:");
                if (tiempoc == 0) { //si los datos estan vacios
                    datos_acciones2(1);
                }
                System.out.println("\nDatos: ");
                System.out.println("Tiempo: " + tiempoc + "\tVueltas: " + vueltasc);
                System.out.println("\nAplicando formula...");
                System.out.println("T = tiempo / vueltas");
                System.out.println("T = " + tiempoc + " / " + vueltasc);
                periodoc = (double)tiempoc / vueltasc;
                System.out.println("\nEl periodo es: " + Formulas.df.format(periodoc) + " s");
                bandp = true;
                Menus.ask_menu(2);
                break;
            case 2:
                System.out.println("Eleccion: Frecuencia (f)");
                System.out.print("-------------------------------------------------------\n");
                System.out.println("\nDatos necesarios:");
                if (tiempoc == 0) { //si los datos estan vacios
                    datos_acciones2(1); //pedir datos
                }
                System.out.println("\nDatos: ");
                System.out.println("Segundos: " + tiempoc + "\tn Vueltas: " + vueltasc);
                System.out.println("\nAplicando formula...");
                System.out.println("f = vueltas / tiempo");
                System.out.println("f = " + vueltasc + " / " + tiempoc);
                frecuenciac = (double)vueltasc / tiempoc;
                System.out.println("\nLa frecuencia es: " + Formulas.df.format(frecuenciac) + " hz");
                bandf = true;
                Menus.ask_menu(2);
                break;
            case 3:
                if (frecuenciac == 0) {
                    System.out.println("Por favor, primero calcule la frecuencia...");
                    Menus.menu1(2);
                } else {
                    System.out.println("Eleccion: Velocidad angular (w)");
                    System.out.print("-------------------------------------------------------\n");
                    System.out.println("\nDatos necesarios: ");
                    System.out.println("\nFrecuencia: " + Formulas.df.format(frecuenciac) + " hz");
                    System.out.println("\nAplicando formula para hallar la velocidad angular...");
                    System.out.println("w = 2π x frecuencia");
                    System.out.println("w = " + "2π" + " x " + Formulas.df.format(frecuenciac));
                    wc = (double)frecuenciac * 2 * pi;
                    System.out.println("\nLa velocidad angular es: " + Formulas.df.format(wc) + " rad/s");
                    bandva = true;
                    Menus.ask_menu(2);
                }
                break;
            case 4:
                if (frecuenciac == 0) {
                    System.out.println("Por favor, primero calcule la frecuencia...");
                    Menus.menu1(2);
                } else if (wc == 0) {
                    System.out.println("Por favor, primero calcule la velocidad angular...");
                    Menus.menu1(2);
                } else {
                    System.out.println("Eleccion: Velocidad (v)");
                    System.out.print("-------------------------------------------------------\n");
                    System.out.println("\nDatos necesarios:");
                    if (radioc == 0) {
                        datos_acciones2(2);
                    }
                    System.out.println("Datos: ");
                    System.out.println("\nRadio: " + Formulas.df.format(radioc) + " m");
                    System.out.println("Velocidad angular: " + Formulas.df.format(wc) + " rad/s");
                    System.out.println("\nAplicando formula para hallar la velocidad...");
                    System.out.println("v = w x radio");
                    System.out.println("v = " + Formulas.df.format(wc) + " x " + Formulas.df.format(radioc));
                    velocidadc = (double)wc * radioc;
                    System.out.println("\nLa velocidad es: " + Formulas.df.format(velocidadc) + " m/s");
                    bandv = true;
                    Menus.ask_menu(2);
                }
                break;
            case 5:
                if (wc == 0) {
                    System.out.println("Por favor, primero calcule la velocidad angular...");
                    Menus.menu1(2);
                } else {
                    System.out.println("Eleccion: Aceleracion angular (α)");
                    System.out.print("-------------------------------------------------------\n");
                    System.out.println("\nDatos necesarios:");
                    if (tiempoc == 0) {
                        datos_acciones2(1);
                    }
                    System.out.println("Datos: ");
                    System.out.println("Tiempo: " + tiempoc);
                    System.out.println("Velocidad angular: " + Formulas.df.format(wc) + " rad/s");
                    System.out.println("\nAplicando formula para hallar la aceleracion angular...");
                    System.out.println("α = w / tiempo");
                    System.out.println("α = " + Formulas.df.format(wc) + " / " + Formulas.df.format(tiempoc));
                    acelangularc = (double)wc / tiempoc;
                    System.out.println("\nLa aceleracion angular es: " + Formulas.df.format(acelangularc) + " rad/s²");
                    bandaa = true;
                    Menus.ask_menu(2);
                }
                break;
            case 6:
                if (wc == 0) {
                    System.out.println("Por favor, primero calcule la velocidad angular...");
                    Menus.menu1(2);
                } else {
                    System.out.println("Eleccion: Aceleracion centripeta (acen)");
                    System.out.print("-------------------------------------------------------\n");
                    System.out.println("\nDatos necesarios:");
                    if (radioc == 0) {
                        datos_acciones2(2);
                    }
                    System.out.println("Datos: ");
                    System.out.println("\nRadio: " + Formulas.df.format(radioc) + " m");
                    System.out.println("Velocidad angular: " + Formulas.df.format(wc) + " rad/s");
                    System.out.println("\nAplicando formula para hallar la aceleracion centripeta...");
                    System.out.println("acp = w² x radio");
                    System.out.println("acp = " + Formulas.df.format(wc) + "² x " + Formulas.df.format(radioc));
                    acpc = Math.pow(wc, 2) * radioc;
                    System.out.println("\nLa aceleracion centripeta es: " + Formulas.df.format(acpc) + " m/s²");
                    bandac = true;
                    Menus.ask_menu(2);
                }
                break;
            case 7:
                if (acelangularc == 0) {
                    System.out.println("Por favor, primero calcule la aceleracion angular...");
                    Menus.menu1(2);
                } else {
                    System.out.println("Eleccion: Aceleracion tangencial (atan)");
                    System.out.print("-------------------------------------------------------\n");
                    System.out.println("\nDatos necesarios:");
                    if (radioc == 0) {
                        datos_acciones2(2);
                    }
                    System.out.println("Datos: ");
                    System.out.println("\nRadio: " + Formulas.df.format(radioc) + " m");
                    System.out.println("Aceleracion angular: " + Formulas.df.format(acelangularc) + " rad/s²");
                    System.out.println("\nAplicando formula para hallar la aceleracion tangencial...");
                    System.out.println("atan = α x radio");
                    System.out.println("atan = " + Formulas.df.format(acelangularc) + " x " + Formulas.df.format(radioc));
                    atanc = (double)acelangularc * radioc;
                    System.out.println("\nLa aceleracion tangencial es: " + Formulas.df.format(atanc) + " m/s²");
                    bandat = true;
                    Menus.ask_menu(2);
                }
                break;
            case 8:
                if (acpc == 0) {
                    System.out.println("Por favor, primero calcule la aceleracion centripeta");
                    Menus.menu1(2);
                } else if (atanc == 0) {
                    System.out.println("Por favor, primero calcule la aceleracion tangencial");
                    Menus.menu1(2);
                } else {
                    System.out.println("Eleccion: Aceleracion (a)");
                    System.out.print("-------------------------------------------------------\n");
                    System.out.println("\nDatos necesarios:");
                    System.out.println("\nAceleracion centripeta: " + Formulas.df.format(acpc) + " m/s²");
                    System.out.println("Aceleracion tangencial: " + Formulas.df.format(atanc) + " m/s²");
                    System.out.println("\nAplicando formula para hallar la aceleracion...");
                    System.out.println("a = √(acp² + atan²)");
                    System.out.println("a = √(" + Formulas.df.format(acpc) + "² + " + Formulas.df.format(atanc) + "²)");
                    acelec = Math.sqrt(Math.pow(acpc, 2) + Math.pow(atanc, 2));
                    System.out.println("\nLa aceleracion es: " + Formulas.df.format(acelec) + " m/s²");
                    banda = true;
                    Menus.ask_menu(2);
                }
                break;
            case 9:
                System.out.println("Eleccion: Inercia (I)");
                System.out.print("-------------------------------------------------------\n");
                System.out.println("\nDatos necesarios:");
                if (radioc == 0) {
                    datos_acciones2(2);
                }
                if (masac == 0) {
                    datos_acciones2(3);
                } 
                System.out.println("\nDatos: ");
                System.out.println("\nRadio: " + Formulas.df.format(radioc) + " m");
                System.out.println("Masa: " + Formulas.df.format(masac) + " kg");
                System.out.println("\nAplicando formula...");
                System.out.println("I = (1/2)Mr²");
                System.out.println("I = (1/2)" + Formulas.df.format(masac) + " x " + Formulas.df.format(radioc) + "²");
                inerciac = (double)(masac * Math.pow(radioc, 2))/2;
                System.out.println("\nEl momento de inercia es: " + Formulas.df.format(inerciac) + " kg x m");
                bandi = true;
                Menus.ask_menu(2);
                break;
            case 10:
                if (acelangularc == 0) {
                    System.out.println("Por favor, primero calcule la aceleracion angular");
                    Menus.menu1(2);
                } else if (inerciac == 0) {
                    System.out.println("Por favor, primero calcule la inercia");
                    Menus.menu1(2);
                } else {
                    System.out.println("Eleccion: Torque (t)");
                    System.out.print("-------------------------------------------------------\n");
                    System.out.println("\nDatos necesarios:");
                    System.out.println("\nAceleracion angular: " + Formulas.df.format(acelangularc) + " rad/s²");
                    System.out.println("Inercia: " + Formulas.df.format(inerciac) + " kg x m");
                    System.out.println("\nAplicando formula para hallar el momento de torque...");
                    System.out.println("T = I x α");
                    System.out.println("T = " + Formulas.df.format(inerciac) + " x " + Formulas.df.format(acelangularc));
                    torquec = inerciac * acelangularc;
                    System.out.println("\nEl momento de torque es: " + Formulas.df.format(torquec) + " N x m");
                    bandt = true;
                    Menus.ask_menu(2);
                }
                break;
            case 11:
                if (wc == 0) {
                    System.out.println("Por favor, primero calcule la velocidad angular...");
                    Menus.menu1(2);
                } else if (velocidadc == 0) {
                    System.out.println("Por favor, primero calcule la velocidad...");
                    Menus.menu1(2);
                } else if (inerciac == 0) {
                    System.out.println("Por favor, primero calcule la inercia...");
                    Menus.menu1(2);
                } else {
                    System.out.println("Eleccion: Energia Mecanica (E) ");
                    System.out.print("-------------------------------------------------------\n");
                    System.out.println("\nDatos necesarios: ");
                    if (masaelice == 0) {
                        Acciones.datos_acciones2(4);
                    }
                    System.out.println("\nDatos: ");
                    System.out.println("\nMasa elice: " + masaelice + " kg");
                    System.out.println("Numero de elices: " + nelices);
                    System.out.println("Velocidad angular: " + Formulas.df.format(wc) + " rad/s");
                    System.out.println("Inercia: " + Formulas.df.format(inerciac) + " kg x m");
                    System.out.println("\nAplicando formula para hallar la Energia Mecanica...");
                    System.out.println("Ec = Ecr(disco) + Ec(elices)");
                    System.out.println("Ec = (1/2)Iw² + n((1/2)mv²)");
                    System.out.println("Ec = (1/2)" + Formulas.df.format(inerciac) + " x " + Formulas.df.format(wc) + "² " + nelices + "((1/2)" + Formulas.df.format(masaelice) + " x " + Formulas.df.format(velocidadc) +"²)");
                    energiac = (double)((inerciac * Math.pow(wc, 2))/2 + nelices * ((masaelice * Math.pow(velocidadc, 2))/2));
                    System.out.println("\nLa Energia Mecanica es: " + Formulas.df.format(energiac) + " J");
                    bande = true;
                    Menus.ask_menu(2);
                }
                break;
            case 12:
                clearscreen();
                Menus.band_cifras = false;
                Menus.menu();
                break;
        }

    }

    public static void datos_acciones2(int n) {
        boolean error = false;
        switch (n) {
            case 1:
                do {
                    error = false;
                    try{
                        System.out.print("\nDigite el tiempo en el que hizo su calculo (s): ");
                        tiempoc = scan.nextInt();
                        System.out.print("Digite las vueltas que registro en " + tiempoc + " s: ");
                        vueltasc = scan.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Error, la variable debe ser un numero entero!");
                        System.out.println("Por favor, ingrese los datos denuevo...");
                        scan.nextLine();
                        error = true;
                    }
                } while (error);
                break;
            case 2:
                do {
                    error = false;
                    try{
                        System.out.print("Digite la medida del radio (m): ");
                        radioc = scan.nextDouble();
                    } catch (InputMismatchException e) {
                        System.out.println("Error, la variable debe ser un numero!");
                        scan.nextLine();
                        error = true;
                    }
                } while (error);
                break;
            case 3:
                do {
                    error = false;
                    try{
                        System.out.print("Digite la masa del disco (kg): ");
                        masac = scan.nextDouble();
                    } catch (InputMismatchException e) {
                        System.out.println("Error, la variable debe ser un numero!");
                        System.out.println("Por favor, ingrese los datos denuevo...");
                        scan.nextLine();
                        error = true;
                    }
                } while (error);
                break;
            case 4:
                do {
                    error = false;
                    try{
                        System.out.print("Digite la masa de una elice (kg): ");
                        masaelice = scan.nextDouble();
                        System.out.print("Digite el numero de elices: ");
                        nelices = scan.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Error, la variable debe ser un numero!");
                        System.out.println("Por favor, ingrese los datos denuevo...");
                        scan.nextLine();
                        error = true;
                    }
                } while (error);
                break;
        }
    }

    public static void resultados() {
        System.out.println("TURBINA PELTON: \n");
        if (Formulas.bandp == true) {
            System.out.println("PERIODO: " + Formulas.df.format(Formulas.periodo) + " s");
        }
        if (Formulas.bandf == true) {
            System.out.println("FRECUENCIA: " + Formulas.df.format(Formulas.frecuencia) + " hz");
        }
        if (Formulas.bandva == true) {
            System.out.println("VELOCIDAD ANGULAR: " + Formulas.df.format(Formulas.w) + " rad/s");
        }
        if (Formulas.bandaa == true) {
            System.out.println("ACELERACION ANGULAR: " + Formulas.df.format(Formulas.acelangular) + " rad/s²");
        }
        if (Formulas.bandac == true) {
            System.out.println("ACELERACION CENTRIPETA: " + Formulas.df.format(Formulas.acp) + " m/s²");
        }
        if (Formulas.bandat == true) {
            System.out.println("ACELERACION TANGENCIAL: " + Formulas.df.format(Formulas.atan) + " m/s²");
        }
        if (Formulas.banda == true) {
            System.out.println("ACELERACION: " + Formulas.df.format(Formulas.acele)+ " m/s²");
        }
        if (Formulas.bandi == true) {
            System.out.println("INERCIA: " + Formulas.inercia + " kg x m");
        }
        if (Formulas.bandt == true) {
            System.out.println("TORQUE: " + Formulas.torque + " N x m");
        }
        if (Formulas.bande == true) {
            System.out.println("ENERGIA CINETICA: " + Formulas.df.format(Formulas.energia) + " J");
        }
        System.out.print("\n-------------------------------------\n");
        System.out.println("TURBINA CUSTOM: \n");
        if (banda == true) {
            System.out.println("PERIODO: " + Formulas.df.format(periodoc) + " s");
        }
        if (bandf == true) {
            System.out.println("FRECUENCIA: " + Formulas.df.format(frecuenciac) + " hz");
        }
        if (bandva == true) {
            System.out.println("VELOCIDAD ANGULAR: " + Formulas.df.format(wc) + " rad/s");
        }
        if (bandaa == true) {
            System.out.println("ACELERACION ANGULAR: " + Formulas.df.format(acelangularc) + " rad/s²");
        }
        if (bandac == true) {
            System.out.println("ACELERACION CENTRIPETA: " + Formulas.df.format(acpc) + " m/s²");
        }
        if (bandat == true) {
            System.out.println("ACELERACION TANGENCIAL: " + Formulas.df.format(atanc) + " m/s²");
        }
        if (banda == true) {
            System.out.println("ACELERACION: " + Formulas.df.format(acelec)+ " m/s²");
        }
        if (bandi == true) {
            System.out.println("INERCIA: " + Formulas.df.format(inerciac) + " kg x m");
        }
        if (bandt == true) {
            System.out.println("TORQUE: " + Formulas.df.format(torquec) + " N x m");
        }
        if (bande == true) {
            System.out.println("ENERGIA CINETICA: " + Formulas.df.format(energiac) + " J");
        }
    }

    public static void clearscreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static String cifras(int opc) {
        String cant = "";
        switch (opc) {
            case 1: cant = "0.0"; break;
            case 2: cant = "0.00"; break;
            case 3: cant = "0.000"; break;
            case 4: cant = "0.0000"; break;
            case 5: cant = "0.00000"; break;
            case 6: cant = "0.000000"; break;
        }
        return cant;
    }
}
