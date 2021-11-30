package ProyectoTurbina;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Formulas {

    public static Scanner scan = new Scanner(System.in);
    public static DecimalFormat df;
    public static int tiempo = 60, vueltas = 273;
    public static double pi = 3.141516, masa = 0.1, radio = 0.1275;
    public static double frecuencia = 4.55, periodo = 0.2198;
    public static double velocidad = 3.2624445;
    public static double inercia = 0.0008128, energia = 0.502427; 
    public static double w = 28.5878, acelangular = 0.4765;
    public static double acp = 10420.0944, atan = 6.0754, acele = 10420.0962, torque = 0.0003872;
    public static boolean bandf = false, bandp = false, bandva = false, bandaa = false;
    public static boolean bandac = false, bandat = false, banda = false, bandv = false;
    public static boolean bandi = false, bande = false, bandt = false;

    public static void periodo() {
        System.out.println("\nDatos necesarios:");
        System.out.println("Segundos: " + tiempo + "\tn Vueltas: " + vueltas);
        System.out.println("\nAplicando formula...");
        System.out.println("T = tiempo / vueltas");
        System.out.println("T = " + tiempo + " / " + vueltas);
        periodo = (double)tiempo / vueltas;
        System.out.println("\nEl periodo es: " + df.format(periodo) + " s");
        bandp = true;
    }

    public static void frecuencia() {
        System.out.println("\nDatos necesarios:");
        System.out.println("Segundos: " + tiempo + "\tn Vueltas: " + vueltas);
        System.out.println("\nAplicando formula...");
        System.out.println("f = vueltas / tiempo");
        System.out.println("f = " + vueltas + " / " + tiempo);
        frecuencia = (double)vueltas / tiempo;
        System.out.println("\nLa frecuencia es: " + df.format(frecuencia) + " hz");
        bandf = true;
    }

    public static void velocidad_angular(boolean band) {
        System.out.println("\nDatos necesarios: ");
        System.out.println("Frecuencia: " + df.format(frecuencia) + " hz");
        if (band == true) {
            Menus.ask_frecuencia();
        }
        System.out.println("\nAplicando formula para hallar la velocidad angular...");
        System.out.println("w = 2π x frecuencia");
        System.out.println("w = 2π x " + frecuencia);
        w = (double)frecuencia * 2 * pi;
        System.out.println("\nLa velocidad angular es: " + df.format(w) + " rad/s");
        bandva = true;
    }

    public static void velocidad(boolean band) {
        System.out.println("\nDatos necesarios: ");
        System.out.println("Radio: " + radio + " m");
        System.out.println("Velocidad angular: " + df.format(w) + " rad/s");
        if (band == true) {
            Menus.ask_velocidadAngular();
        }
        System.out.println("\nAplicando formula para hallar la velocidad...");
        System.out.println("v = w x radio");
        System.out.println("v = " + df.format(w) + " x " + radio);
        velocidad = (double)w * radio;
        System.out.println("\nLa velocidad es: " + df.format(velocidad) + " m/s");
        bandv = true;
    }

    public static void aceleracion_angular(boolean band) {
        System.out.println("\nDatos necesarios: ");
        System.out.println("Velocidad angular: " + df.format(w) + " rad/s");
        if (band == true) {
            Menus.ask_velocidadAngular();
        }
        System.out.println("\nAplicando formula para hallar la aceleracion angular...");
        System.out.println("α = w / tiempo");
        System.out.println("α = " + w + " / " + tiempo);
        acelangular = (double)w / tiempo;
        System.out.println("\nLa aceleracion angular es: " + df.format(acelangular) + " rad/s²");
        bandaa = true;
    }

    public static void aceleracion_centripeta(boolean band) {
        System.out.println("\nDatos necesarios: ");
        System.out.println("Radio: " + radio + " m");
        System.out.println("Velocidad angular: " + df.format(w) + " rad/s");
        if (band == true) {
            Menus.ask_velocidadAngular();
        }
        System.out.println("\nAplicando formula para hallar la aceleracion centripeta...");
        System.out.println("acp = w² x radio");
        System.out.println("acp = " + w + "² x " + radio);
        acp = Math.pow(w, 2) * radio;
        System.out.println("\nLa aceleracion centripeta es: " + df.format(acp) + " m/s²");
        bandac = true;
    }

    public static void aceleracion_tangencial(boolean band) {
        System.out.println("\nDatos necesarios: ");
        System.out.println("Radio: " + radio + " m");
        System.out.println("Aceleracion angular: " + df.format(acelangular) + " rad/s");
        if (band == true) {
            Menus.ask_aceleracionAngular();
        }
        System.out.println("\nAplicando formula para hallar la aceleracion tangencial...");
        System.out.println("atan = α x radio");
        System.out.println("atan = " + df.format(acelangular) + " x " + radio);
        atan = (double)acelangular * radio;
        System.out.println("\nLa aceleracion tangencial es: " + df.format(atan) + " m/s²");
        bandat = true;
    }

    public static void aceleracion(boolean band) {
        System.out.println("\nDatos necesarios: ");
        System.out.println("Aceleracion centripeta: " + df.format(acp) + " m/s²");
        System.out.println("Aceleracion tangencial: " + df.format(atan) + " m/s²");
        if (band == true) {
            Menus.ask_aceleracionCentripeta();
            Menus.ask_aceleracionTangencial();
        }
        System.out.println("\nAplicando formula para hallar la aceleracion...");
        System.out.println("a = √(acp² + atan²)");
        System.out.println("a = √(" + df.format(acp) + "² + " + df.format(atan) + "²)");
        acele = Math.sqrt(Math.pow(acp, 2) + Math.pow(atan, 2));
        System.out.println("\nLa aceleracion es: " + df.format(acele) + " m/s²");
        banda = true;
    }

    public static void inercia() {
        System.out.println("Datos necesarios:");
        System.out.println("\nMasa: " + df.format(masa) + " kg");
        System.out.println("Radio: " + df.format(radio) + " m");
        System.out.println("\nAplicando formula para hallar la inercia...");
        System.out.println("I = (1/2)mr²");
        System.out.println("I = (1/2)" + df.format(masa) + " x " + df.format(radio) + "²");
        System.out.println("\nEl momento de inercia es: " + inercia + " kg x m");
        bandi = true;
    }

    public static void torque(boolean band) {
        System.out.println("Datos necesarios: ");
        System.out.println("\nAceleracion angular: " + df.format(acelangular) + " rad/s²");
        System.out.println("Inercia: " + inercia + " kg x m");
        if (band == true) {
            Menus.ask_aceleracionAngular();
            Menus.ask_inercia();
        }
        System.out.println("\nAplicando formula para hallar el momento de torque...");
        System.out.println("T = I x α");
        System.out.println("T = " + inercia + " x " + df.format(acelangular));
        System.out.println("\nEl momento de torque es: " + torque + " N x m");
        bandt = true;
    }

    public static void energia(boolean band) {
        System.out.println("Datos necesarios: ");
        System.out.println("\nMasa elice: 0.002 kg");
        System.out.println("Velocidad angular: " + df.format(w) + " rad/s");
        System.out.println("Velocidad: " + df.format(velocidad) + " m/s");
        System.out.println("Inercia: " + inercia + " kg x m");
        if (band == true) {
            Menus.ask_velocidadAngular();
            Menus.ask_inercia();
            Menus.ask_velocidad();
        }
        System.out.println("\nAplicando formula para hallar la energia Mecanica...");
        System.out.println("Ec = Ecr(disco) + Ec(elices)");
        System.out.println("Ec = (1/2)Iw² + n((1/2)mv²)");
        System.out.println("Ec = (1/2)" + inercia + " x " + df.format(w) + "² + 16((1/2)0.002 x " + df.format(velocidad) +"²)");
        System.out.println("\nLa Energia Mecanica de la polea es: " + df.format(energia) + " J");
        bande = true;
    }

}
