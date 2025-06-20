package Materia.controllers;

import Materia.models.Node;

public class ArbolBinario {
    private Node root;
    public int peso;

    public ArbolBinario() {
        root = null;
        peso = 0;
    }

    public void insert(int value) {
        root = insertRec(root, value);
        peso++;
    }

    private Node insertRec(Node padre, int value) {
        if (padre == null)
            return new Node(value);
        if (value < padre.getValue())
            padre.setLeft(insertRec(padre.getLeft(), value));
        else if (value > padre.getValue())
            padre.setRight(insertRec(padre.getRight(), value));
        return padre;
    }

    public void imprimirArbolInOrder() {
        imprimirInOrder(root);
    }

    private void imprimirInOrder(Node node) {
        if (node != null) {
            imprimirInOrder(node.getLeft());
            System.out.print(node.getValue() + ", ");
            imprimirInOrder(node.getRight());
        }
    }

    public void imprimirArbolInOrderConHeight() {
        imprimirInOrderConHeight(root);
    }

    private void imprimirInOrderConHeight(Node node) {
        if (node != null) {
            imprimirInOrderConHeight(node.getLeft());
            System.out.print(node.getValue() + "(h=" + getHeightRec(node) + "), ");
            imprimirInOrderConHeight(node.getRight());
        }
    }

    public void imprimirFactoresDeEquilibrioYDesbalance() {
        System.out.println("Arbol InOrder con factor de equilibrio");
        imprimirYDetectarDesbalance(root);
        System.out.println();
        System.out.print("Nodos desequilibrados: ");
        imprimirNodosDesequilibrados(root);
        System.out.println();
    }

    private void imprimirYDetectarDesbalance(Node node) {
        if (node != null) {
            imprimirYDetectarDesbalance(node.getLeft());
            int bf = getHeightRec(node.getLeft()) - getHeightRec(node.getRight());
            System.out.print(node.getValue() + "(bf=" + bf + "), ");
            imprimirYDetectarDesbalance(node.getRight());
        }
    }

    private void imprimirNodosDesequilibrados(Node node) {
        if (node != null) {
            imprimirNodosDesequilibrados(node.getLeft());
            int bf = getHeightRec(node.getLeft()) - getHeightRec(node.getRight());
            if (Math.abs(bf) > 1) {
                System.out.print(node.getValue() + "(fE = " + bf + ") ");
            }
            imprimirNodosDesequilibrados(node.getRight());
        }
    }

    public void imprimirArbolPreOrder() {
        imprimirPreOrder(root);
    }

    private void imprimirPreOrder(Node node) {
        if (node != null) {
            System.out.print(node.getValue() + ", ");
            imprimirPreOrder(node.getLeft());
            imprimirPreOrder(node.getRight());
        }
    }

    public boolean buscar(int value) {
        return buscarRec(root, value);
    }

    private boolean buscarRec(Node temp, int value) {
        if (temp == null) return false;
        if (temp.getValue() == value) return true;

        if (value < temp.getValue()) {
            return buscarRec(temp.getLeft(), value);
        } else {
            return buscarRec(temp.getRight(), value);
        }
    }

    public int getHeight() {
        return getHeightRec(root);
    }

    public int getHeightRec(Node node) {
        if (node == null)
            return 0;
        int leftHeight = getHeightRec(node.getLeft());
        int rightHeight = getHeightRec(node.getRight());
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public boolean estaEquilibrado() {
        return estaEquilibradoRec(root);
    }

    private boolean estaEquilibradoRec(Node node) {
        if (node == null)
            return true;

        int bf = getHeightRec(node.getLeft()) - getHeightRec(node.getRight());

        return Math.abs(bf) <= 1 &&
               estaEquilibradoRec(node.getLeft()) &&
               estaEquilibradoRec(node.getRight());
    }
}
