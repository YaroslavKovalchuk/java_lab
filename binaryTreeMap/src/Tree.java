import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class Tree implements Map {

    private Node<Integer,String> root;

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public Node get(Object key) {
        Integer nodeKey = (Integer) key;
        Node<Integer, String> current = root;
        while (!current.getKey().equals(nodeKey)){
            if (current.getKey() > nodeKey){
                current = current.getRightChild();
            }else if (current.getKey() < nodeKey){
                current = current.getLeftChild();
            }else if (current == null){
                return null;
            }
        }
        return current;
    }

    @Override
    public Node put(Object key, Object value) {

        Node<Integer, String> node = new Node<>();
        node.setKey((Integer) key);
        node.setValue((String) value);

        if (root == null) {
            root = node;
        } else {
            Node<Integer, String> current = root;
            Node<Integer, String> parent;
        while (true) {
            parent = current;
            if (node.getKey() > current.getKey()) {
                current = current.getRightChild();
                if (current == null){
                    parent.setRightChild(node);
                    return parent.getRightChild();
                }
            }
            if (node.getKey() < current.getKey()) {
                current = current.getLeftChild();
                if (current == null){
                    parent.setLeftChild(node);
                    return parent.getLeftChild();
                }
            }
        }
    }
        return node;
    }


    @Override
    public Object remove(Object key) {
        return null;
    }


    @Override
    public void putAll(Map m) {

    }


    @Override
    public void clear() {

    }

    //not done
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
        return false;
    }


    @Override
    public int hashCode() {
        return 0;
    }
}
