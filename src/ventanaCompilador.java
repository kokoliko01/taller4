
import AbstractSyntaxTree.*;
import CodeGeneratorVisitor.CodeGenTemplates;
import CodeGeneratorVisitor.CodeGeneration;
import SyntaxVisitor.GrapherVisitor;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import static java.lang.System.exit;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.runtime.Symbol;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import parser.*;
import scanner.*;
import semantic.ScopeAnalysisVisitor;
import semantic.TypeCheckVisitor;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author heave
 */
public class ventanaCompilador extends javax.swing.JFrame {

    /**
     * Creates new form ventanaCompilador
     */
    public ventanaCompilador() {
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser2 = new javax.swing.JFileChooser();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);

        jButton1.setText("Parsear");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jButton2.setText("Buscar archivo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Ingresar código en k*");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Resultado");

        jButton3.setText("Scannear");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Limpiar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Generar Scanner");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Generar Parser");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Limpiar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Semanticar");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("Codificar");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton7))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(26, 26, 26)
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton9)
                                .addGap(26, 26, 26)
                                .addComponent(jButton4)
                                .addGap(8, 8, 8))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton6)
                                .addGap(143, 143, 143)
                                .addComponent(jButton2)))
                        .addGap(0, 21, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton6)
                    .addComponent(jButton2))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton1)
                    .addComponent(jButton4)
                    .addComponent(jButton8)
                    .addComponent(jButton9)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Metodo encargado de realizar la accion de parsear codigo k* ingresado
     * @param evt 
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //se valida el ingreso de codigo en el cuadro de codigo k*
        if(jTextArea1.getText().trim().equals("")){
            jTextArea2.setText("No se ingreso código k*");
            return;
        }
        //Se crea un nuevo archivo de texto
        File fichero = new File ("fichero.txt");
        PrintWriter writer;
        //se escribe el codigo k* ingresado en el archivo de texto
        try {
            writer = new PrintWriter(fichero);
            writer.print(jTextArea1.getText());
            writer.close();//se cierra el archivo de texto
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ventanaCompilador.class.getName()).log(Level.SEVERE, null, ex);
        }
        //se lee el fichero de texto con codigo k*
        File archivo = new File(fichero.getAbsolutePath());
        FileReader fr = null;
        try {
            fr = new FileReader(archivo);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ventanaCompilador.class.getName()).log(Level.SEVERE, null, ex);
        }
        //se inicia el scanner de k*
        Scanner s = new Scanner(fr);
        //se inicia el parser de k*
        Parser p = new Parser(s);
        try {
            //p.parse();
            NodeProgram programa = (NodeProgram) p.parse().value;
            GrapherVisitor grapher = new GrapherVisitor();
            grapher.toVisit(programa);
        } catch (Exception ex) {
            try {
                p.syntax_error(s.next_token());
            } catch (IOException ex1) {
                Logger.getLogger(ventanaCompilador.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(ventanaCompilador.class.getName()).log(Level.SEVERE, null, ex);
        }
        //se despliega el resultado en el cuadro de resultado
        jTextArea2.setText(p.cadenaProduccion);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * Metodo encargado de desplegar la ventana para buscar de archivos con codigo k*
     * @param evt 
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //se filtran los archivos k*
        FileNameExtensionFilter filter = new FileNameExtensionFilter("archivo k*","ks");
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(filter);
        fileChooser.setDialogTitle("Abriendo archivo...");
        //se obtiene la direccion del proyecto
        String directorio = System.getProperty("user.dir");
        //se abre la ventana en el directorio src/ejemplosResultados
        File archivoCodigo = new File(directorio + File.separator +"src" + File.separator + "ejemplosResultados");
        fileChooser.setCurrentDirectory(archivoCodigo);
        int resultado = fileChooser.showOpenDialog(null);
        if(resultado == JFileChooser.APPROVE_OPTION){
            File file = fileChooser.getSelectedFile();
            FileReader fr = null;
            try {
                fr = new FileReader(file);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ventanaCompilador.class.getName()).log(Level.SEVERE, null, ex);
            }
            BufferedReader reader = new BufferedReader(fr);
            //se lee el archivo de texto
            StringBuffer stringBuffer = new StringBuffer();
			String line;
            try {
                while ((line = reader.readLine()) != null) {
                    stringBuffer.append(line);
                    stringBuffer.append("\n");
                }
            } catch (IOException ex) {
                Logger.getLogger(ventanaCompilador.class.getName()).log(Level.SEVERE, null, ex);
            }
            //se muestra el codigo seleccionado en el cuadro de texto
            jTextArea1.setText(stringBuffer.toString());
        }
    }//GEN-LAST:event_jButton2ActionPerformed
    
    /**
     * Metodo encargado de realizar la accion de scannear codigo k* ingresado
     * @param evt 
     */
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //se valida el ingreso de codigo en el cuadro de codigo k*
        if(jTextArea1.getText().trim().equals("")){
            jTextArea2.setText("No se ingreso código k*");
            return;
        }
        
        //Se crea un nuevo archivo de texto
        File fichero = new File ("fichero.txt");
        PrintWriter writer;
        //se escribe el codigo k* ingresado en el archivo de texto
        try {
            writer = new PrintWriter(fichero);
            writer.print(jTextArea1.getText());
            writer.close(); //se cierra el archivo de texto
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ventanaCompilador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //se lee el fichero de texto con codigo k*
        File archivo = new File(fichero.getAbsolutePath());
        FileReader fr = null;
        try {
            fr = new FileReader(archivo);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ventanaCompilador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //se inicia el scanner de k*
        Scanner s = new Scanner(fr);
        String resultado = "";
        try {
            //Se obtiene el simbolo encontrado
            Symbol simbol = s.next_token();
            int a = simbol.left; //se obtiene la fila
            int b = simbol.right; //se obtiene la columna
            int d = simbol.sym; //se obtiene el numero de simbolo
            
            do{
                resultado += s.yytext() + "\t -> Símbolo: " + simbol.toString() + " -> Inicia en línea: " + a + " -> En columna: " + b;
                resultado += "\n";
                
                simbol = s.next_token(); //se obtiene el siguiente token
                a = simbol.left; //se obtiene la fila
                b = simbol.right; //se obtiene la columna
                d = simbol.sym; //se obtiene el numero de simbolo
            }while(d != 0);
        } catch (IOException ex) {
            Logger.getLogger(ventanaCompilador.class.getName()).log(Level.SEVERE, null, ex);
        }
        //se despliega el resultado en el cuadro de resultado
        jTextArea2.setText(resultado);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        jTextArea2.setText("");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        jflex.Main.generate(new File("src"+File.separator+"scanner" + File.separator + "Lexer.flex"));
        JOptionPane.showMessageDialog(null, "Scanner generado\nexitosamente", "InfoBox: " + "Parser Generator", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
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
        try {
            //Generar
            java_cup.Main.main(argv);
            //mensaje por pantalla, generaccion exitosa.
            JOptionPane.showMessageDialog(null, "Parser generado\nexitosamente", "InfoBox: " + "Scanner Generator", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            Logger.getLogger(ventanaCompilador.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ERROR AL GENERAR PARSER", "InfoBox: " + "Scanner Generator", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            Logger.getLogger(ventanaCompilador.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ERROR AL GENERAR PARSER", "InfoBox: " + "Scanner Generator", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        jTextArea1.setText("");
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        //se valida el ingreso de codigo en el cuadro de codigo k*
        if(jTextArea1.getText().trim().equals("")){
            jTextArea2.setText("No se ingreso código k*");
            return;
        }
        //Se crea un nuevo archivo de texto
        File fichero = new File ("fichero.txt");
        PrintWriter writer;
        //se escribe el codigo k* ingresado en el archivo de texto
        try {
            writer = new PrintWriter(fichero);
            writer.print(jTextArea1.getText());
            writer.close();//se cierra el archivo de texto
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ventanaCompilador.class.getName()).log(Level.SEVERE, null, ex);
        }
        //se lee el fichero de texto con codigo k*
        File archivo = new File(fichero.getAbsolutePath());
        FileReader fr = null;
        try {
            fr = new FileReader(archivo);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ventanaCompilador.class.getName()).log(Level.SEVERE, null, ex);
        }
        //se inicia el scanner de k*
        Scanner s = new Scanner(fr);
        //se inicia el parser de k*
        Parser p = new Parser(s);
        NodeProgram programa = null;
        try {
            programa = (NodeProgram) p.parse().value;
            GrapherVisitor grapher = new GrapherVisitor();
            grapher.toVisit(programa);
            ScopeAnalysisVisitor sav = new ScopeAnalysisVisitor();
            semantic.Symbol startSymbol = new semantic.Symbol(666,null);
            sav.toVisit(programa, startSymbol);
            //jTextArea2.setText(sav.mensajes);
            TypeCheckVisitor tcv = new TypeCheckVisitor();
            tcv.toVisit(programa, null);
            jTextArea2.setText(sav.mensajes + "\n" + tcv.mensajes);
            JOptionPane.showMessageDialog(null, "Reiniciar programa\npara otra revisión semantica", "InfoBox: " + "Revisión semantica", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            Logger.getLogger(ventanaCompilador.class.getName()).log(Level.SEVERE, null, ex);
        }

        //ScopeAnalysisVisitor sav = new ScopeAnalysisVisitor();
        //semantic.Symbol startSymbol = new semantic.Symbol(666,null);
        //sav.toVisit(programa, startSymbol);
        //jTextArea2.setText(sav.mensajes);
        //TypeCheckVisitor tcv = new TypeCheckVisitor();
        //tcv.toVisit(programa, null);
        //jTextArea2.setText(sav.mensajes + "\n" + tcv.mensajes);
        //JOptionPane.showMessageDialog(null, "Reiniciar programa\npara otra revisión semantica", "InfoBox: " + "Revisión semantica", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        //se valida el ingreso de codigo en el cuadro de codigo k*
        if(jTextArea1.getText().trim().equals("")){
            jTextArea2.setText("No se ingreso código k*");
            return;
        }
        //Se crea un nuevo archivo de texto
        File fichero = new File ("fichero.txt");
        PrintWriter writer;
        //se escribe el codigo k* ingresado en el archivo de texto
        try {
            writer = new PrintWriter(fichero);
            writer.print(jTextArea1.getText());
            writer.close();//se cierra el archivo de texto
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ventanaCompilador.class.getName()).log(Level.SEVERE, null, ex);
        }
        //se lee el fichero de texto con codigo k*
        File archivo = new File(fichero.getAbsolutePath());
        FileReader fr = null;
        try {
            fr = new FileReader(archivo);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ventanaCompilador.class.getName()).log(Level.SEVERE, null, ex);
        }
        //se inicia el scanner de k*
        Scanner s = new Scanner(fr);
        //se inicia el parser de k*
        Parser p = new Parser(s);
        NodeProgram programa = null;
        try {
            programa = (NodeProgram) p.parse().value;
            GrapherVisitor grapher = new GrapherVisitor();
            grapher.toVisit(programa);
            //ScopeAnalysisVisitor sav = new ScopeAnalysisVisitor();
            //semantic.Symbol startSymbol = new semantic.Symbol(666,null);
            //sav.toVisit(programa, startSymbol);
            //jTextArea2.setText(sav.mensajes);
            //TypeCheckVisitor tcv = new TypeCheckVisitor();
            //tcv.toVisit(programa, null);
            //jTextArea2.setText(sav.mensajes + "\n" + tcv.mensajes);
            
            CodeGeneration cgen = new CodeGeneration();
            cgen.toVisit(programa, null);
            jTextArea2.setText(CodeGenTemplates.mensajes);
            
            JOptionPane.showMessageDialog(null, "Reiniciar programa\npara otra codificación", "InfoBox: " + "Revisión semantica", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            Logger.getLogger(ventanaCompilador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ventanaCompilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ventanaCompilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ventanaCompilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ventanaCompilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ventanaCompilador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JFileChooser jFileChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    // End of variables declaration//GEN-END:variables
}
