package Materia.controllers;
import Materia.models.Node;
public class ArbolBinario {
    private Node root;

    public ArbolBinario() {
        this.root = null;
    }
    
    public void insert(int value){
        root = insertRec(root, value);

    }
    private Node insertRec(Node padre, int value){
        if(padre == null){
            return new Node(value);
        }
        if(value < padre.getValue()){
            //Me voy a la izquierda
            padre.setLeft(insertRec(padre.getLeft(),value));
        }else if(value > padre.getValue()){
            //Me voy a la derecha
            padre.setRight(insertRec(padre.getRight(),value));
        }
        return padre;
    }
    public void imprimirArbol(){
        imprimir(root);
    }
    private void imprimir(Node node){
        if(node != null){
            System.out.print(node.getValue()+", ");
            imprimir(node.getLeft());
            imprimir(node.getRight());
        }
    }(

    public boolean buscar(int value) {
    return buscarRec(root, value);
    }

    private boolean buscarRec(Node nodo, int value) {
        if (nodo == null) {
            System.out.println("No encontrado");
            return false;
        }

        int centro = nodo.getValue();

        if (value == centro) {
            System.out.println("Encontrado");
            return true;
        }

        if (value < centro) {
            System.out.println("IZQUIERDA");
            return buscarRec(nodo.getLeft(), value);
        } else {
            System.out.println("DERECHA");
            return buscarRec(nodo.getRight(), value);
        }
    }

}
