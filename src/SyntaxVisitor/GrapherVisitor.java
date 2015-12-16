/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SyntaxVisitor;

import AbstractSyntaxTree.*;
import Visitor.visitorInterface;
import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;
/**
 * Referencia: http://stackoverflow.com/questions/7080205/popup-message-boxes
 * @author heave
 */
public class GrapherVisitor implements visitorInterface {
    String codigoGrapher = "";
    int cantidadNodosVisitados = 0;
    Stack<String> stackNodosPadres = new Stack<>();
    
    public void GrapherImagenGenerator() throws IOException{
        try{
            FileWriter fw = new FileWriter("codigoDot.dot"); //se genera un nuevo archivo
            BufferedWriter bw = new BufferedWriter(fw); //necesario para escribir en el archivo

            bw.write("digraph G {\n"); //inicio de codigo .dot
            bw.write(codigoGrapher); //se escribe el codigo del grapher en el archivo
            bw.flush();
            bw.write("}"); //fin de codigo .dot
            bw.close(); //se termina la escritura del archivo

            //directorio raiz del proyecto
            String directorioGraphViz = "C:" + File.separator + "Program Files (x86)" + File.separator + "GraphViz2.38" + File.separator + "release" + File.separator + "bin" + File.separator + "dot.exe";
            String FileInputPath = System.getProperty("user.dir") + File.separator + "codigoDot.dot"; //direccion del archivo .dot generado anteriormente
            String FileOutputPath = System.getProperty("user.dir") + File.separator + "imagenCodigo.png"; //direccion de la imagen que será generada
            String tParam = "-Tpng";
            String tOparam = "-o";
            String [] cmd = new String[5]; //se crea un arreglo de strings para contener los parametros necesarios despues

            //Se asignan los parametros necesarios
            cmd[0] = directorioGraphViz; 
            cmd[1] = tParam;
            cmd[2] = FileInputPath;
            cmd[3] = tOparam;
            cmd[4] = FileOutputPath;

            Runtime rt = Runtime.getRuntime();
            rt.exec(cmd);

            //Se despliega mensaje con generacion exitosa de la imagen
            JOptionPane.showMessageDialog(null, "Imagen de GraphViz Generada exitosamente", "InfoBox: " + "GraphViz Generator", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception ex){
            System.err.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "ERROR: Imagen de GraphViz no se generó", "InfoBox: " + "GraphViz Generator", JOptionPane.INFORMATION_MESSAGE);
            ex.printStackTrace();
        }
    }

    @Override
    public void toVisit(NodeCall nodoCall) {
        String identificador = nodoCall.toGraph(this.cantidadNodosVisitados);
        this.codigoGrapher = this.codigoGrapher + identificador;
        String [] delimitador = identificador.split("\\[");
        String enlace = this.stackNodosPadres.peek()+"->"+delimitador[0]+"; \n";
        this.codigoGrapher = this.codigoGrapher + enlace;
        this.stackNodosPadres.push(delimitador[0]);
        this.cantidadNodosVisitados++;
        for(NodeTree n : nodoCall.listaNodos){
            if(n.identificador != null){
                n.accept(this);
            }
            //n.accept(this);
        }
        this.stackNodosPadres.pop();
    }

    @Override
    public void toVisit(NodeCompoundStmt nodeCompStmt) {
        String identificador = nodeCompStmt.toGraph(this.cantidadNodosVisitados);
        this.codigoGrapher = codigoGrapher + identificador;
        String [] delimitador = identificador.split("\\[");
        String enlace = this.stackNodosPadres.peek()+"->"+delimitador[0]+"; \n";
        this.codigoGrapher = this.codigoGrapher + enlace;
        this.stackNodosPadres.push(delimitador[0]);
        this.cantidadNodosVisitados++;
        for(NodeTree n : nodeCompStmt.listaLocalDecl){
            n.accept(this);
            //System.err.println(" AAAAAAAAAAAAAAAAAAAAAAAAA ");
        }
        for(NodeTree n : nodeCompStmt.listaStmtList){
            n.accept(this);
            //System.err.println(" BBBBBBBBBBBBBBBBBBBBBBBBB ");
        }
        this.stackNodosPadres.pop();
    }

    @Override
    public void toVisit(NodeExpression nodeExpression) {
        String identificador = nodeExpression.toGraph(this.cantidadNodosVisitados);
        this.codigoGrapher = this.codigoGrapher + identificador;
        String [] delimitador = identificador.split("\\[");
        String enlace = this.stackNodosPadres.peek()+"->"+delimitador[0]+"; \n";
        this.codigoGrapher = this.codigoGrapher + enlace;
        this.stackNodosPadres.push(delimitador[0]);
        this.cantidadNodosVisitados++;
        if(nodeExpression.operando1 != null){
            nodeExpression.operando1.accept(this);
        }
        if(nodeExpression.operando2 != null){
            nodeExpression.operando2.accept(this);
        }
        this.stackNodosPadres.pop();
    }

    @Override
    public void toVisit(NodeFunDeclaration nodeFunDecl) {
        String identificador = nodeFunDecl.toGraph(this.cantidadNodosVisitados);
        this.codigoGrapher = codigoGrapher + identificador;
        String [] delimitador = identificador.split("\\[");
        String enlace = this.stackNodosPadres.peek()+"->"+delimitador[0]+"; \n";
        this.codigoGrapher = this.codigoGrapher + enlace;
        this.stackNodosPadres.push(delimitador[0]);
        this.cantidadNodosVisitados++;
        for(NodeTree n : nodeFunDecl.listaParam){
            if(n.identificador != null){
                n.accept(this);
            }
            //n.accept(this);
        }
        
        nodeFunDecl.nodoCompStmt.accept(this);
        this.stackNodosPadres.pop();
    }

    @Override
    public void toVisit(NodeParam nodeParam) {
        this.codigoGrapher = this.codigoGrapher + nodeParam.toGraph(this.cantidadNodosVisitados, this.stackNodosPadres.peek());
        this.cantidadNodosVisitados++;
    }

    @Override
    public void toVisit(NodeProgram nodeProgram) {
        String identificador = nodeProgram.toGraph(this.cantidadNodosVisitados);
        this.codigoGrapher = this.codigoGrapher + identificador;
        String [] delimitador = identificador.split("\\[");
        this.stackNodosPadres.push(delimitador[0]);
        this.cantidadNodosVisitados++;
        ArrayList<NodeTree> listaNodos = nodeProgram.listaDeclarationList;
        for(NodeTree n : listaNodos ){
            n.accept(this);
        }
        this.stackNodosPadres.pop();
        try{
            this.GrapherImagenGenerator();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void toVisit(NodeStatement nodeStmt) {
        String identificador = nodeStmt.toGraph(this.cantidadNodosVisitados);
        this.codigoGrapher = this.codigoGrapher + identificador;
        String[] delimitador = identificador.split("\\[");
        String enlace = this.stackNodosPadres.peek()+"->"+delimitador[0]+"; \n";
        this.codigoGrapher = this.codigoGrapher + enlace;
        this.stackNodosPadres.push(delimitador[0]);
        this.cantidadNodosVisitados++;
        if(nodeStmt.tipoProduccion.equals("IF") && nodeStmt.nodo3 == null){
                nodeStmt.nodo1.accept(this);
                if(nodeStmt.nodo2 != null){
                    nodeStmt.nodo2.accept(this);
                }
                //nodeStmt.nodo2.accept(this);
        }else if(nodeStmt.tipoProduccion.equals("IF-ELSE") && nodeStmt.nodo3 != null){
                nodeStmt.nodo1.accept(this);
                nodeStmt.nodo2.accept(this);
                nodeStmt.nodo3.accept(this);
        }else if(nodeStmt.tipoProduccion.equals("WHILE")){
                nodeStmt.nodo1.accept(this);
                if(nodeStmt.nodo2 != null){
                    nodeStmt.nodo2.accept(this);
                }
                //nodeStmt.nodo2.accept(this);
        }else if(nodeStmt.tipoProduccion.equals("FOR")){
                nodeStmt.nodo1.accept(this);
                nodeStmt.nodo2.accept(this);
                nodeStmt.nodo3.accept(this);
                nodeStmt.nodo4.accept(this);
        }else if(nodeStmt.tipoProduccion.equals("RETURN") && nodeStmt.nodo1 != null){
                nodeStmt.nodo1.accept(this);
        }
        this.stackNodosPadres.pop();
    }

    @Override
    public void toVisit(NodeVar nodeVar) {
        String identificador = "";
        if(nodeVar.nodeTree == null){
                //El nodo contiene un terminal
                identificador = nodeVar.toGraph(this.cantidadNodosVisitados);//Se obtiene el ID del nodo Var
                this.codigoGrapher = this.codigoGrapher + identificador;// Se agrega ID al código
                String [] delimitador = identificador.split("\\[");//Separa nombre del ID del nombre asignado dentro del nodo
                String enlace = this.stackNodosPadres.peek()+"->"+delimitador[0]+"; \n";//Crea enlace del padre con el nuevo nodo
                this.codigoGrapher = this.codigoGrapher + enlace;// Guarda el enlace en el codigo
                this.cantidadNodosVisitados++;//Nodo ha sido visitado
        }else{
                //En caso de que el nodo no fuera un terminal
                identificador = nodeVar.toGraph(this.cantidadNodosVisitados);//Se obtiene el ID del nodo Var
                this.codigoGrapher = this.codigoGrapher + identificador;// Se agrega ID al código
                String [] delimitador = identificador.split("\\[");//Separa nombre del ID del nombre asignado dentro del nodo
                String enlace= this.stackNodosPadres.peek()+"->"+delimitador[0]+"; \n";//Crea enlace del padre con el nuevo nodo
                this.codigoGrapher = this.codigoGrapher + enlace;// Guarda el enlace en el codigo
                this.stackNodosPadres.push(delimitador[0]);//Guarda el nuevo nodo en la pila
                this.cantidadNodosVisitados++;//Nodo ha sido visitado
                nodeVar.nodeTree.accept(this);
        }
    }

    @Override
    public void toVisit(NodeVarDeclaration nodeVarDecl) {
        this.codigoGrapher = this.codigoGrapher + nodeVarDecl.toGraph(this.cantidadNodosVisitados, this.stackNodosPadres.peek());
        this.cantidadNodosVisitados++;
    }
}
