package Principal;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.List;

public class GestionAlumno {


    private static final String FICHERO = null;

    public void escribirAlumnos(String rutaFich, Alumno alumno) {

        int[] notas = alumno.getNotas();

        try (RandomAccessFile raf = new RandomAccessFile(FICHERO, "rw")) {

            raf.seek(raf.length());
            raf.writeInt(alumno.getMatricula());
            raf.writeBytes(alumno.getNombre()+"\n");
            raf.writeBytes(alumno.getApellidos()+"\n");
            raf.writeUTF(Arrays.toString(alumno.getNotas()));
            raf.writeDouble(alumno.getMedia());

        } catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado");
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    public void leerAlumnos(){

        try (RandomAccessFile raf = new RandomAccessFile(FICHERO, "rw")) {

            long inicio=0;

            raf.seek(inicio);
            while(raf.length() > inicio){
                System.out.println(raf.readInt());
                System.out.println(raf.readUTF());
                System.out.println(raf.readUTF());
                System.out.println(raf.readUTF());
                System.out.println(raf.readDouble());
                inicio+=208;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado");
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    public List<Alumno> buscaAlumnoPorNombre(String nombre){
        List<Alumno> listaAlumno = null;
        return listaAlumno;
    }

}
