import java.util.*;

public class Tree<V> implements Map {

    private Node<V> root;
    private int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (root == null){
            return true;
        }else return false;
    }

    @Override
    public boolean containsKey(Object key) {
        Node<V> current = root;
        Node<V> parent;
        int searchKey = (int) key;

        if (current == null) {
            return false;
        }
        while (true) {

            if (current.getKey() == searchKey){
                return true;
            }else if (current.getKey() > searchKey) {
                current = current.getLeftChild();
            }else if (current.getKey() < searchKey){
                current = current.getRightChild();
            }
            if (current == null){
                return false;
            }
        }
    }

    @Override
    public boolean containsValue(Object value) {

        V searchValue = (V) value;
        Node<V> current = root;
        Node<V> parent = root;

        boolean checkLeft = false;
        boolean checkRight = false;
        int level= 1;
        int amoundChildForOneParent = 2;
        int []parentKey = new int[level];

        if (current != null){
            parentKey[0] = current.getKey();
        }else return false;

        while (true){

            int index = 0;
            int position = 0;
            int []childKey = new int[parentKey.length*amoundChildForOneParent];
            while (index < parentKey.length){

                if (current.getValue().equals(searchValue)) {
                    return true;
                } else if (parent.getLeftChild() != null && !checkLeft) {
                    current = parent.getLeftChild();
                    checkLeft = true;
                    childKey[position] = current.getKey();
                    position++;
                } else if (parent.getRightChild() != null && !checkRight) {
                    current = parent.getRightChild();
                    checkRight = true;
                    childKey[position] = current.getKey();
                    position++;
                }else {
                    checkLeft = false;
                    checkRight = false;
                    index++;
                    if (index >= parentKey.length){
                        if (position == 0){
                            return false;
                        }
                    }else parent = get(parentKey[index]);
                }
            }
            parentKey = new int[position];
            for (int i = 0; i < position; i++){
                parentKey[i] = childKey[i];
            }
            parent = get(parentKey[0]);
        }
    }

    @Override
    public Node get(Object key) {
        int nodeKey = (int) key;
        Node<V> current = root;
        while (current.getKey() != nodeKey){
            if (current.getKey() > nodeKey){
                current = current.getLeftChild();
            }else if (current.getKey() < nodeKey){
                current = current.getRightChild();
            }else if (current == null){
                return null;
            }
        }
        return current;
    }

    @Override
    public Node put(Object key, Object value) {

        size++;

        Node<V> node = new Node<>();
        node.setKey((int) key);
        node.setValue((V) value);

        if (root == null) {
            root = node;
        } else {
            Node<V> current = root;
            Node<V> parent;
        while (true) {
            parent = current;
            if (node.getKey() < current.getKey()) {
                current = current.getLeftChild();
                if (current == null){
                    parent.setLeftChild(node);
                    return parent.getLeftChild();
                }
            } else {
                current = current.getRightChild();
                if (current == null){
                    parent.setRightChild(node);
                    return parent.getRightChild();
                }
            }
        }
    }
        return node;
    }


    @Override
    public Node remove(Object key) {

        Node replecementHelper = replecementForRemovedObject(key);
        Node current = get(key);

        while (true) {

            Node parentCurrent = getParent(current.getKey());
            Node replecement = replecementForRemovedObject(current.getKey());
            Node parentReplecemet = getParent(replecement.getKey());;

                if (current.equals(replecement)) {

                if (current.getLeftChild() == null) {
                    parentCurrent.setLeftChild(null);
                    return current;
                } else if (current.getRightChild() == null) {
                    parentCurrent.setRightChild(null);
                    return current;
                }

            } else if (current.equals(parentReplecemet)) {

                if (parentCurrent.getLeftChild().equals(current)) {
                    parentCurrent.setLeftChild(replecement);
                } else if (parentCurrent.getRightChild().equals(current)) {
                    parentCurrent.setRightChild(replecement);
                }
                replecement.setLeftChild(current.getLeftChild());
                replecement.setRightChild(current.getRightChild());
                current = replecementHelper;

            } else {

                if (parentCurrent.getLeftChild().equals(current)) {
                    parentCurrent.setLeftChild(replecement);
                } else if (parentCurrent.getRightChild().equals(current)) {
                    parentCurrent.setRightChild(replecement);
                }
                replecement.setLeftChild(current.getLeftChild());
                replecement.setRightChild(current.getRightChild());
                current = replecement;
            }
        }
    }

    @Override
    public void putAll(Map m) {

    }


    @Override
    public void clear() {

    }

    @Override
    public Set keySet() {
        return null;
    }


    @Override
    public Collection values() {
        return null;
    }


    @Override
    public Set<Entry> entrySet() {
        return null;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tree<?> tree = (Tree<?>) o;
        return size == tree.size &&
                Objects.equals(root, tree.root);
    }

    @Override
    public int hashCode() {
        return Objects.hash(root, size);
    }

    private Node getParent(Object key) {
        Node current = get(key);
        Node parent = root;

        while (true) {

            if (parent.getLeftChild().getKey() == current.getKey() || parent.getRightChild().getKey() == current.getKey()){
                return parent;
            }else if (parent.getKey() > current.getKey()) {
                parent = parent.getLeftChild();
            }else if (parent.getKey() < current.getKey()){
                parent = parent.getRightChild();
            }else return parent;
        }
    }

    private Node replecementForRemovedObject(Object key){
        Node<V> current = get(key);
        boolean isLeft = false;
        boolean isRight = false;

        while (true){
            if (current.getRightChild() != null && !isRight){
                current = current.getRightChild();
                isRight = true;
                isLeft = false;
            }
            if (current.getLeftChild() != null && !isLeft){
                current = current.getLeftChild();
                isLeft = false;
                isRight = true;
            }else if (isRight && !isLeft){
                isLeft = true;
            }else {
                return current;
            }
        }
    }

}
