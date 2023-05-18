package com.cunoc;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.Reader;
import java.io.StringReader;

import org.junit.Test;

import com.cunoc.Logic.File_Manger.FileConverter;
import com.cunoc.Logic.Parser.Lexema;
import com.cunoc.Logic.Parser.parser;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

    private String ruta_json = "/home/drymnz/dowgit/TypeSecure-Compi-2023/src/test/java/com/cunoc/Archivos Pruevas/simple.ts";
    //private String ruta_json = "D:/Mis documentos/Proyect/Proyecto compiladores/Socket/src/test/java/com/cunoc/test.json";

    /**
     * @return
     * returnara el texto del arvhivo de pruevas
     */
    private String primerArchivoPruevas(){
        return new FileConverter().upLoadTextFile(new File(ruta_json));
    }

    private boolean lexicoParser(String prueva){
        Reader reader = new StringReader(prueva);
        Lexema lexema = new Lexema(reader);
        parser sic = new parser(lexema);
        try {
            sic.parse();
            //System.out.println(lexema.getReport());
            return true;
        } catch (Exception e) {
            return false;
            /* Symbol s = sic.getSymbol();
            e.printStackTrace();
            System.out.println(e.getMessage()); */
        } 
    }
    
    /**
     * Rigorous Test :-)
     */
    @Test
    public void pruevasParaPrimerArchivoPruevas()
    {
        assertTrue(lexicoParser(primerArchivoPruevas()) );
    }

}
