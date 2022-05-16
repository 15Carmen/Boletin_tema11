package Principal;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreaFicheroAlumno {

    private static final String FICHERO = "Alumnos.dat";

    public void añadirAlumnos(Alumno alumno) {

        try (RandomAccessFile raf = new RandomAccessFile(FICHERO, "rw")) {

                raf.writeInt(alumno.getMatricula());
                raf.writeUTF(alumno.getNombre());
                raf.writeUTF(alumno.getApellidos());
                raf.writeUTF(Arrays.toString(alumno.getNotas()));
                raf.writeDouble(alumno.getMedia());

        } catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado");
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    public void leerAlumnos(Alumno alumno){

        try (RandomAccessFile raf = new RandomAccessFile(FICHERO, "rw")) {

            int inicio=0;

            //Ponemos el puntero al principio del archivo
            raf.seek(inicio);
            //primer Alumno
            System.out.println(raf.readInt());
            System.out.println(raf.readUTF());
            System.out.println(raf.readUTF());
            System.out.println(raf.readUTF());
            System.out.println(raf.readDouble());
            inicio+=208;
            
        } catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado");
        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}
