package Principal;

import java.io.*;

public class CreaFicheroAlumno {

    public static void creaFichero(String directorio, String nombre) {
        File ruta;
        File fichero;

        try {
            ruta = new File(directorio);
            fichero = new File(nombre + ".dat");
            if (!ruta.exists() && ruta.isDirectory()) {
                if (ruta.mkdirs()) {
                    if (fichero.createNewFile()){
                        System.out.println("El fichero se ha creado correctamente");
                    }
                    else{
                        System.out.println("No pudo crearse el fichero");
                    }
                } else{
                    System.out.println("No pudo crearse el directorio");
                }
            } else {
                if (fichero.createNewFile()){
                    System.out.println("El fichero se ha creado correctamente");
                }
                else{
                    System.out.println("No pudo crearse el fichero");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}


