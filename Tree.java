import java.util.Iterator;

public class Tree<T extends Comparable<T>> implements Iterable<T> {
    private Node<T> root;

    public Tree() {
        root = null;
    }

    // Insertar nodo
    public void insertar(T value) {
        root = insertarRecursivo(root, value);
    }

    private Node<T> insertarRecursivo(Node<T> root, T value) {
        if (root == null) {
            return new Node<>(value);
        }
        if (value.compareTo(root.data) < 0) {
            root.left = insertarRecursivo(root.left, value);
        } else if (value.compareTo(root.data) > 0) {
            root.right = insertarRecursivo(root.right, value);
        }
        return root;
    }

    // Buscar por un valor
    public boolean search(T value) {
        return searchRecursive(root, value) != null;
    }

    private Node<T> searchRecursive(Node<T> root, T value) {
        if (root == null || root.data.equals(value)) {
            return root;
        }
        if (value.compareTo(root.data) < 0) {
            return searchRecursive(root.left, value);
        } else {
            return searchRecursive(root.right, value);
        }
    }

    // Borrar nodo
    public void delete(T value) {
        root = deleteRecursive(root, value);
    }

    private Node<T> deleteRecursive(Node<T> root, T value) {
        if (root == null) {
            return null;
        }
        if (value.compareTo(root.data) < 0) {
            root.left = deleteRecursive(root.left, value);
        } else if (value.compareTo(root.data) > 0) {
            root.right = deleteRecursive(root.right, value);
        } else {
            // Node to be deleted found

            // Case 1: sin hijo
            if (root.left == null && root.right == null) {
                return null;
            }

            // Case 2: un hijo
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Case 3: dos hijos
            root.data = findMin(root.right);
            root.right = deleteRecursive(root.right, root.data);
        }
        return root;
    }

    // Encontrar el valor minimo
    public T findMin() {
        return findMin(root);
    }

    private T findMin(Node<T> root) {
        while (root.left != null) {
            root = root.left;
        }
        return root.data;
    }

    // Encontrar el valor maximo
    public T findMax() {
        return findMax(root);
    }

    private T findMax(Node<T> root) {
        while (root.right != null) {
            root = root.right;
        }
        return root.data;
    }

    // In-order
    public void inOrderTraversal() {
        inOrderTraversal(root);
    }

    private void inOrderTraversal(Node<T> root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.print(root.data + " ");
            inOrderTraversal(root.right);
        }
    }

    // Altura
    public int height() {
        return height(root);
    }

    private int height(Node<T> root) {
        if (root == null) {
            return 0;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    // Verificar balanceo
    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node<T> root) {
        if (root == null) {
            return true;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    // Level-order traversal (BFS)
    public void levelOrderTraversal() {
        // Could be implemented using a queue (omitted here for brevity)
    }

    // Contar numero de nodos
    public int countNodes() {
        return countNodes(root);
    }

    private int countNodes(Node<T> root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    // Limpiar arbol
    public void clear() {
        root = null;
    }

    @Override
    public Iterator<T> iterator() {
        return new InOrderIterator();
    }

    private class InOrderIterator implements Iterator<T> {
        // Stack for in-order iteration (omitted for brevity)
        
        @Override
        public boolean hasNext() {
            // Implementation for hasNext (omitted)
            return false;
        }

        @Override
        public T next() {
            // Implementation for next (omitted)
            return null;
        }
    }
}
