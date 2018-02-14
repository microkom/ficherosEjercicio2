/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficherosejercicio2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
//import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author DAW
 */
public class Main {

    /**
     * Realiza un programa en JAVA que muestre un menú que te permita 3
     * opciones: 1. Creación de un fichero de texto (con el nombre que tú
     * quieras) en el que indiques en cada linea:  Tu Nombre.  Tus Apellidos.
     *  Tu Ciudad de Nacimiento. 2. Mostrar por pantalla el contenido del
     * fichero de texto creado. 3. Salir del Programa.
     */
    public static void main(String[] args) {
        final String RESET = "\033[0m";
        final String ROJO = "\033[31;1m";
        final String VERDE = "\033[32m";
        final String AZUL = "\033[34m";
        final String BOLD = "\033[4m";
        Scanner sc = new Scanner(System.in);
        String fileName = "text.txt";
        int choice = 0;

        boolean exit = false;
        //System.out.println("\033[31;1mHello\033[0m, \033[32;1;2mworld!\033[0m");
        System.out.println("\t" + ROJO + "...::: * M E N U * :::..." + RESET + "\n\n\t" + AZUL + "Elige una opción: " + RESET);
        do {

            System.out.println(""
                    + "\n\t1. Escribir y guardar datos"
                    + "\n\t2. Mostrar por pantalla el contenido del fichero"
                    + "\n\t3. Salir\n\t");
            boolean numeroOk=true;
            do{
            try {
                System.out.print("\t");
                choice = Integer.parseInt(sc.nextLine());
                numeroOk=true;
            } catch (NumberFormatException ex) {
                System.out.println("\t"+ex.getMessage());
                System.out.println("\tFormato de numero equivocado");
                System.out.println("\tElige una opción de nuevo: ");
                numeroOk=false;
                } 
            }while (!numeroOk);
            switch (choice) {
                case 1:

                    String name = null;
                    String surname = null;
                    String birthCity = null;

                    System.out.print("\tNombre: ");
                    name = sc.next();

                    System.out.print("\tApellido: ");
                    surname = sc.next();

                    System.out.print("\tCiudad de Nac: ");
                    birthCity = sc.next();

                    Persona persona = new Persona(name, surname, birthCity);

                    FileWriter file = null;
                    BufferedWriter buf = null;
                    try {

                        file = new FileWriter(fileName);
                        //buf = new BufferedWriter(file);
                        file.write(persona.toString());
                        file.close();

                    } catch (Exception e) {
                        e.getMessage();
                    } finally {
                        try {
                            if (buf != null) {
                                buf.close();
                            }

                            if (file != null) {
                                file.close();
                            }

                        } catch (Exception ex) {
                            ex.getMessage();
                        }
                    }

                    ;
                    break;
                case 2:
                    File fileToBeRead = null;
                    FileReader fr = null;
                    BufferedReader br = null;

                    try {

                        fileToBeRead = new File(fileName);
                        fr = new FileReader(fileToBeRead);
                        br = new BufferedReader(fr);

                        String linea;
                        while ((linea = br.readLine()) != null) {
                            System.out.println(linea);
                        }

                    } catch (Exception err) {
                        System.out.println("Mensaje: " + err.getMessage());
                    } finally {
                        // En el finally cerramos el fichero, para asegurarnos
                        // que se cierra tanto si todo va bien como si salta 
                        // una excepcion.
                        try {
                            if (null != fr) {
                                fr.close();
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                    ;
                    break;

                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("\tWrong choice\n");

            }
        } while (!exit);

    }

}/*
public static final String ANSI_RESET = "\u001B[0m";
public static final String ANSI_BLACK = "\u001B[30m";
public static final String ANSI_RED = "\u001B[31m";
public static final String ANSI_GREEN = "\u001B[32m";
public static final String ANSI_YELLOW = "\u001B[33m";
public static final String ANSI_BLUE = "\u001B[34m";
public static final String ANSI_PURPLE = "\u001B[35m";
public static final String ANSI_CYAN = "\u001B[36m";
public static final String ANSI_WHITE = "\u001B[37m";*/
