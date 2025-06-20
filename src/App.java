import Materia.controllers.ArbolBinario;

public class App {
    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();

        arbol.insert(50);
        arbol.insert(17);
        arbol.insert(76);
        arbol.insert(9);
        arbol.insert(23);
        arbol.insert(54);
        arbol.insert(14);
        arbol.insert(19);

        System.out.println("Nombre: Pedro Pesántez");
        System.out.println();
        System.out.println("Peso del arbol = " + arbol.peso);
        System.out.println("Altura es = " + arbol.getHeight());
        System.out.println();

        System.out.println("Arbol InOrder");
        arbol.imprimirArbolInOrder();
        System.out.println("\n");

        System.out.println("Arbol InOrder con alturas");
        arbol.imprimirArbolInOrderConHeight();
        System.out.println("\n");

        arbol.imprimirFactoresDeEquilibrioYDesbalance();
        System.out.println();

        System.out.println("Arbol esta equilibrado = " + arbol.estaEquilibrado());
        System.out.println();

        System.out.println("Agregamos valor = 15");
        arbol.insert(15);
        System.out.println();

        arbol.imprimirFactoresDeEquilibrioYDesbalance();
    }
}
