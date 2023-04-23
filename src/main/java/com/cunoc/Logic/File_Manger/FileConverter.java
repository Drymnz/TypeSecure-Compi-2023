package com.cunoc.Logic.File_Manger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileConverter {
    
    private FileInputStream entry;

    

    public FileConverter() {
    }

    public String upLoadTextFile(File file) {
        String extract = "";
        try {
            entry = new FileInputStream(file);
            int valor;
            while ((valor = entry.read()) != -1) {
                char caracter = (char) valor;
                extract += caracter;
            }
            entry.close();
        } catch (FileNotFoundException ex) {
            System.out.println( "error en lectura");
        } catch (IOException ex) {
            System.out.println("error en lectura");
        }
        return extract;
    }

    public File addressExists(File check) {
        if (check!=null) {
            return check;
        } else {
            try {
                if (check.createNewFile()) {
                    System.out.println("FUE CREADO " + check.getName());
                    return check;
                } else {
                    System.out.println("NO SE PUDO CREAR " + check.getName());
                }
            } catch (Exception e) {
               e.printStackTrace();
               System.out.println("NO SE PUDO CREAR " + check.getName());
            }
        }
        return null;
    }

    public boolean isFileexists(File check){
        try {
            if (check.createNewFile()) {
                System.out.println("FUE CREADO " + check.getName());
                return true;
            } else {
                System.out.println("NO SE PUDO CREAR " + check.getName());
                return false;
            }
        } catch (Exception e) {
           e.printStackTrace();
           return false;
        }
    }
}