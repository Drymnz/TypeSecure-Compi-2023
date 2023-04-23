package com.cunoc.Logic.File_Manger;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileWriteManager implements Runnable {

    private FileOutputStream salida;
    private File archivoHilo;
    private String contenidoHilo;

    public boolean waitText(File archivo, String contenido) {
        try {
            salida = new FileOutputStream(archivo);
            byte[] bytes = contenido.getBytes();
            salida.write(bytes);
            salida.close();
            return true;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileWriteManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileWriteManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public void run() {
        waitText(archivoHilo, contenidoHilo);
    }

    public void setArchivoHilo(File archivoHilo) {
        this.archivoHilo = archivoHilo;
    }

    public void setContenidoHilo(String contenidoHilo) {
        this.contenidoHilo = contenidoHilo;
    }

}