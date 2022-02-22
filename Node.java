public class Node {
    //Declares variables
    private char name;
    private int val;
    private Node left;
    private Node center;
    private Node right;

    //Constructor
    public Node(char n, int v, Node l, Node c, Node r) {
        name = n;
        val = v;
        left = l;
        center = c;
        right = r;
    }

    //Getters
    public char getName() {
        return name;
    }
    public int getVal() {
        return val;
    }
    public Node getLeft() {
        return left;
    }
    public Node getCenter() {
        return center;
    }
    public Node getRight() {
        return right;
    }

    //Setters
    public void setName(char c) {
        name = c;
    }
    public void setVal(int v) {
        val = v;
    }
    public void setLeft(Node l) {
        left = l;
    }
    public void setCenter(Node c) {
        center = c;
    }
    public void setRight(Node r) {
        right = r;
    }
}
