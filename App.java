public class App{
    public static void main(String[] args) {
        Tree<Integer> bst = new Tree<>();

        // insertar valores en el Arbol
        System.out.println("Valores: 50, 30, 70, 20, 40, 60, 80");
        bst.insertar(50);
        bst.insertar(30);
        bst.insertar(70);
        bst.insertar(20);
        bst.insertar(40);
        bst.insertar(60);
        bst.insertar(80);

        // Recorrido inorder
        System.out.println("Recorrido en orden (in-order traversal):");
        bst.inOrderTraversal();
        System.out.println();

        // Buscar valor
        int searchValue = 40;
        System.out.println("Buscando el valor " + searchValue + ": " + (bst.search(searchValue) ? "Encontrado" : "No encontrado"));

        // Eliminar nodo
        int deleteValue = 30;
        System.out.println("Eliminando el nodo " + deleteValue);
        bst.delete(deleteValue);

        // Mostrar el recorrido en orden después de eliminar
        System.out.println("Recorrido en orden después de eliminar " + deleteValue + ":");
        bst.inOrderTraversal();
        System.out.println();

        // Encontrar el mínimo y el máximo
        System.out.println("Valor mínimo en el árbol: " + bst.findMin());
        System.out.println("Valor máximo en el árbol: " + bst.findMax());

        // Mostrar la altura del árbol
        System.out.println("Altura del árbol: " + bst.height());

        // Verificar si el árbol está balanceado
        System.out.println("¿El árbol está balanceado?: " + (bst.isBalanced() ? "Sí" : "No"));

        // Contar el número de nodos
        System.out.println("Número de nodos en el árbol: " + bst.countNodes());

        // Limpiar el árbol
        System.out.println("Limpiando el árbol...");
        bst.clear();

        // Verificar que el árbol está vacío
        System.out.println("Número de nodos después de limpiar: " + bst.countNodes());
    }
}
