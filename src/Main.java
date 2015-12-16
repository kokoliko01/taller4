/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *Referencias: 
 *      http://www2.cs.tum.edu/projekte/cup/examples.php
 *      http://stackoverflow.com/questions/17008139/setting-up-cup-jlex-parsing-properly
 *      http://www.cs.princeton.edu/~appel/modern/java/CUP/manual.html
 *      http://www.avajava.com/tutorials/lessons/how-do-i-read-a-string-from-a-file-line-by-line.html
 *      https://netbeans.org/kb/docs/java/gui-filechooser.html
 *      http://jc-mouse.blogspot.cl/2010/01/jfilechooser-en-java-y-netbeans.html
 *      http://personales.unican.es/corcuerp/java/Slides/GUIs_Netbeans.pdf
 * 
 */
import Symbols.Token;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java_cup.runtime.Symbol;

import parser.Parser;
import parser.sym;
import scanner.Scanner;

/**
 *
 * @author heave
 */
public class Main {
    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        /*
        String directorio = System.getProperty("user.dir");
        File archivo = new File(directorio + File.separator + "src" + File.separator + "ejemplosResultados" + File.separator + "ejemplo4.ks");
        FileReader fr = new FileReader(archivo);
        
        Scanner s = new Scanner(fr);
        
        Parser p = new Parser(s);
        p.parse();
        */
        ventanaCompilador ventana = new ventanaCompilador();
        ventana.setLocationRelativeTo(null);
        ventana.show();     
    }
}
