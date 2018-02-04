import java.util.ArrayList;
public class BST<Key extends Comparable<Key>, Value>{
    private class Node{
        private Key key;
        private Value val;
        private Node left, right;
        private int count;
        public Node(Key key, Value val){
            this.key = key;
            this.val = val;
        }
    }
    private Node root;
    public Value get(Key key){
        Node x = root;
        while(x != null){
            int cmp = key.compareTo(x.key);
            if(cmp < 0) x = x.left;
            else if(cmp > 0) x = x.right;
            else if(cmp == 0) return x.val;
        }
        return null;
    }
    public void put(Key key, Value val){
        root = put(root, key, val);
    }
    private Node put(Node x, Key key, Value val){
        if (x == null) return new Node(key, val);
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            x.left = put(x.left, key, val);
        else if (cmp > 0)
            x.right = put(x.left, key,val);
        else if (cmp == 0)
            x.val = val;
        x.count = 1 + size(x.left) + size(x.right);
        return x;
    }
    public Key floor(Key key){
        Node x = floor(root, key);
        if(x == null) return null;
        return x.key;
    }
    private Node floor(Node x, Key key){
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp < 0) return floor(x.left, key);
        Node t = floor(x.right, key);
        if (t != null) return t;
        else return x;
    }
    public int size(){
        return size(root);
    }
    private int size(Node x){
        if(x == null) return 0;
        return x.count;
    }
    public int rank(Key key){
        return rank(key, root);
    }
    private int rank(Key key, Node x){
        if (x == null) return 0;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return rank(key, x.left);
        else if (cmp > 0) return 1 + size(x.left) + rank(key, x.right);
        else if (cmp ==0) return size(x.left);
        return 0;
    }
    public Iterable<Key> keys(){
        ArrayList<Key> q = new ArrayList<>();
        inorder(root, q);
        return q;
    }
    private void inorder(Node x, ArrayList<Key> q){
        if (x == null) return;
        inorder(x.left, q);
        q.add(x.key);
        inorder(x.right,q);
    }

}
