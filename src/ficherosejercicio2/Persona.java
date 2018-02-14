/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficherosejercicio2;

/**
 *
 * @author DAW
 */
public class Persona {

    private String nombre;
    private String apellidos;
    private String ciudadNac;

    public Persona(String n, String a, String c) {
        this.nombre = n;
        this.apellidos = a;
        this.ciudadNac = c;
    }

    public String getName() {
        return this.nombre;
    }

    public String getSurname() {
        return this.apellidos;
    }

    public String getBirthCity() {
        return this.ciudadNac;
    }

    public void setName(String n) {
        this.nombre = n;
    }

    public void setSurname(String a) {
        this.apellidos = a;
    }

    public void setBirthCity(String c) {
        this.ciudadNac = c;
    }

    public String toString() {
        return "\n\tNombre: " + this.nombre + "\n"
                + "\tApellidos: " + this.apellidos + "\n"
                + "\tCiudad Nac: " + this.ciudadNac;
    }
}
