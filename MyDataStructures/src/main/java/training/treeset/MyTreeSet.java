package training.treeset;

/**
 * @author Hurt Yevhenii
 */
public class MyTreeSet<E extends Comparable> {

    private Node<E> root;

    private class Node<E> {
        E data;
        Node<E> left;
        Node<E> right;

        Node(E data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public boolean contains(E e) {
        Node<E> result = findNodeByValue(e);
        return result != null;
    }

    public boolean add(E e) {
        if (e == null) {
            return false;
        }
        if (root == null) {
            root = new Node<E>(e);
            return true;
        }
        if (contains(e)) {
            return false;
        } else {
            Node<E> current = root;
            Node<E> newNode = new Node<E>(e);
            while (true) {
                int comp = e.compareTo(current.data);
                if (comp < 0) {
                    if (current.left == null) {
                        current.left = newNode;
                        return true;
                    } else {
                        current = current.left;
                    }
                } else {
                    if (current.right == null) {
                        current.right = newNode;
                        return true;
                    } else {
                        current = current.right;
                    }
                }
            }
        }
    }

    public boolean remove(E e) {
        if (e == null) {
            return false;
        }
        if (root.data == e && root.left == null && root.right == null) {
            root = null;
        }
        if (!contains(e)) {
            return false;
        } else {
            Node<E> parent = findParentByValue(e);
            Node<E> current = findNodeByValue(e);
            if (current.left == null && current.right == null) {
                if (parent.left == current) {
                    parent.left = null;
                    return true;
                } else {
                    parent.right = null;
                    return true;
                }
            } else if (current.left == null) {
                if (parent.left == current) {
                    parent.left = current.right;
                    return true;
                } else {
                    parent.right = current.right;
                    return true;
                }
            } else if (current.right == null) {
                if (parent.left == current) {
                    parent.left = current.left;
                    return true;
                } else {
                    parent.right = current.left;
                    return true;
                }
            } else {
                Node<E> forDelete = current;
                parent = current;
                current = current.right;
                int count = 0;
                while (current.left != null) {
                    parent = current;
                    current = current.left;
                    count++;
                }
                forDelete.data = current.data;
                if (count == 0) {
                    parent.right = current.right;
                } else {
                    parent.left = current.right;
                }
                return true;
            }
        }
    }

    Node findNodeByValue(E e) {
        if (e == null) {
            return null;
        }
        if (root == null) {
            return null;
        }
        Node<E> current = root;
        while (current != null) {
            E value = current.data;
            int comp = e.compareTo(value);
            if (comp == 0) {
                return current;
            } else if (comp < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return null;
    }

    Node<E> findParentByValue(E e) {
        Node<E> parent = null;
        Node<E> current = root;
        while (current != null) {
            E value = current.data;
            int comp = e.compareTo(value);
            if (comp == 0) {
                return parent;
            } else if (comp < 0) {
                parent = current;
                current = current.left;
            } else {
                parent = current;
                current = current.right;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        if (root == null) {
            return "";
        }
        return toString(root);
    }

    private String toString(Node node) {
        StringBuilder builder = new StringBuilder();
        if (node == null)
            return "";
        builder.append(toString(node.left));
        builder.append(node.data.toString()).append(" ").toString();
        builder.append(toString(node.right));
        return builder.toString();
    }
}