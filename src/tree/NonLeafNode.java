package tree;

import java.util.HashMap;

public class NonLeafNode extends Node {
    private String splittigAttribute;
    private HashMap<String, Node> descendents;

    public NonLeafNode (String[][] data, int lines, int cols) {
        super(data, lines, cols);
    }

    public void setSplittigAttribute(int col) {
        this.splittigAttribute = this.data[0][col];
    }

    public String getSplittigAttribute() {
        return this.splittigAttribute;
    }

}
