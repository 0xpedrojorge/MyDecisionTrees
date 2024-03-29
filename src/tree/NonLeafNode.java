package tree;

import java.util.HashMap;

public class NonLeafNode extends Node {
    private String splittigAttribute;
    private HashMap<String, Node> descendents;

    public NonLeafNode (String[][] data, int lines, int cols) {
        super(data, lines, cols);
        this.isLeaf = false;
        descendents = new HashMap<>();
    }
    public NonLeafNode (Node parent, String[][] data, int lines, int cols) {
        super(parent, data, lines, cols);
        descendents = new HashMap<>();
    }

    public void setSplittigAttribute(int col) {
        this.splittigAttribute = this.data[0][col];
    }

    String getSplittigAttribute() {
        return this.splittigAttribute;
    }

    public HashMap<String, Node> getDescendents() {
        return descendents;
    }
}
