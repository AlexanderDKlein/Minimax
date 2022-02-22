import java.util.LinkedList;
import java.util.Queue;

/* Author: Alexander Klein
 * Date: 9/23/21
 * Assignment: Minimax
 */
public class Main {
    //Main function.
    public static void main(String args[]) {
        //Creates the tree.
        Node v = new Node('v', 11, null, null, null);
        Node u = new Node('u', 12, null, null, null);
        Node t = new Node('t', 10, null, null, null);
        Node s = new Node('s', 9, null, null, null);
        Node r = new Node('r', 8, null, null, null);
        Node q = new Node('q', 6, null, null, null);
        Node p = new Node('p', 7, null, null, null);
        Node o = new Node('o', 4, null, null, null);
        Node n = new Node('n', 5, null, null, null);
        Node m = new Node('m', 3, null, null, null);
        Node l = new Node('l', 1, null, null, null);
        Node k = new Node('k', 2, null, null, null);

        Node j = new Node('j', Integer.MIN_VALUE, u, v, null);
        Node i = new Node('i', Integer.MIN_VALUE, s, t, null);
        Node h = new Node('h', Integer.MIN_VALUE, q, r, null);
        Node g = new Node('g', Integer.MIN_VALUE, p, null, null);
        Node f = new Node('f', Integer.MIN_VALUE, n, o, null);
        Node e = new Node('e', Integer.MIN_VALUE, k, l, m);

        Node d = new Node('d', Integer.MAX_VALUE, i, j, null);
        Node c = new Node('c', Integer.MAX_VALUE, g, h, null);
        Node b = new Node('b', Integer.MAX_VALUE, e, f, null);

        Node a = new Node('a', Integer.MIN_VALUE, b, c, d);

        //Searches for the best move and outputs the answer.
        int evaluation = minimax(a, true);
        System.out.println("State of current node, a:" + evaluation);
    }

    public static int minimax(Node position, boolean max) {
        //Checks if a node has no children, and returns the value of that node
        if (position.getLeft() == null && position.getCenter() == null && position.getRight() == null) {
            return position.getVal();
        }

        //Finds the max of the current node's children.
        if (max) {
            int evalM = Integer.MIN_VALUE;

            //Gets all children of a node.
            Queue<Node> children = new LinkedList<>();

            if (position.getLeft() != null) {
                children.add(position.getLeft());
            }
            if (position.getCenter() != null) {
                children.add(position.getCenter());
            }
            if (position.getRight() != null) {
                children.add(position.getRight());
            }

            //Finds the maximum value of the children.
            while (!(children.isEmpty())) {
                int eval = minimax(children.remove(), false);
                if (eval > evalM) {
                    evalM = eval;
                }
            }

            //Prints and then returns the maximum value and the current node.
            System.out.println("Max of node " + position.getName() + ": " + evalM);

            return evalM;
        //Finds the min of the current node's children.
        } else {
            int evalM = Integer.MAX_VALUE;

            //Gets all children of a node.
            Queue<Node> children = new LinkedList<>();

            if (position.getLeft() != null) {
                children.add(position.getLeft());
            }
            if (position.getCenter() != null) {
                children.add(position.getCenter());
            }
            if (position.getRight() != null) {
                children.add(position.getRight());
            }

            //Finds the minimum value of the children.
            while (!(children.isEmpty())) {
                int eval = minimax(children.remove(), true);

                if (eval < evalM) {
                    evalM = eval;
                }
            }

            //Prints and then returns the minimum value and the current node.
            System.out.println("Min of node " + position.getName() + ": " + evalM);

            return evalM;
        }
    }
}
