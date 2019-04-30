package tree;

public class LeafNode extends Node {
    private String classification;

    public LeafNode (String[][] data, int lines, int cols) {
        super(data, lines, cols);
        this.classification = this.data[1][this.cols-1];
    }

    public String getClassification() {
        return classification;
    }

}
