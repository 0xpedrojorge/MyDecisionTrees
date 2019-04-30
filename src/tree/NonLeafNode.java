package tree;

import java.util.HashMap;

public class NonLeafNode extends Node {
    private String splittigAttribute;
    public HashMap<String, Node> descendents;

    public NonLeafNode (String[][] data, int lines, int cols) {
        super(data, lines, cols);
    }
    public NonLeafNode (Node parent, String[][] data, int lines, int cols) {
        super(parent, data, lines, cols);
    }

    public void setSplittigAttribute(int col) {
        this.splittigAttribute = this.data[0][col];
    }

    public String getSplittigAttribute() {
        return this.splittigAttribute;
    }

}
