/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import java.io.File;
import java.io.IOException;
import java_cup.*;
/**
 *
 * @author heave
 */
public class ParserGenerator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, Exception {
        String[] argv = new String[7];
    	//Directorio destino: "src/parser"
    	argv[0] = "-destdir";
    	argv[1] = "src"+File.separator+"parser";
    	//Nombre del paquete: "Parser"
    	argv[2] = "-package";
    	argv[3] = "parser";
    	//Nombre de la clase: "Parser"
    	argv[4] = "-parser";
    	argv[5] = "Parser";
    	//Archivo fuente.
    	argv[6] = "src"+File.separator+"parser"+ File.separator + "Parser.cup";
    	//Generar
    	java_cup.Main.main(argv);
    }
}
