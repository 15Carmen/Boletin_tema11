package Principal;

import java.awt.*;
import java.io.Serializable;

public class Alumno implements Serializable {

    private int matricula;
    private String nombre, apellidos;
    private int[] notas= new int[4];
    private double media;

    public Alumno(int matricula, String nombre, String apellidos, int[] notas) {
        this.matricula = matricula; //4 bytes
        this.nombre=longitudMax(nombre, 30); //60 bytes
        this.apellidos=longitudMax(apellidos, 60); //120 bytes
        this.notas = notas; //16 bytes
        this.media=calcularMedia(); //8 bytes
    } // 4+60+120+16+8 = 208

    private double calcularMedia(){
        double media = 0;
        for (int i = 0; i < notas.length; i++) {
            media+=notas[i];
        }
        return media/notas.length;
    }

    private String longitudMax(String nombreApellido, int tamano){
        StringBuffer sb = new StringBuffer();
        sb.append(nombreApellido);
        sb.setLength(tamano);
        return sb.toString();
    }

    public int getMatricula() {
        return matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public int[] getNotas() {
        return notas;
    }

    public double getMedia() {
        return media;
    }

    @Override
    public String toString() {
        return "El alumno con la matricula "+this.matricula+" se llama "+this.nombre+ " "+ this.apellidos +
                ", sus notas son "+this.notas+" y su media es "+ this.media;

    }
}
